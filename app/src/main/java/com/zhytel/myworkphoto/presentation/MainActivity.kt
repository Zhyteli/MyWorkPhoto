package com.zhytel.myworkphoto.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.zhytel.myworkphoto.data.pojo.UrlDto
import com.zhytel.myworkphoto.databinding.ActivityMainBinding
import com.zhytel.myworkphoto.presentation.adapters.MainAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels()
    private var page = 0
    private var reviews: MutableList<UrlDto> = ArrayList()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewMain.layoutManager = GridLayoutManager(
            this,
            2
        )
        binding.recyclerViewMain.adapter = viewModel.adapter

        viewModel.loadData(viewModel.adapter, 0)

        viewModel.urlsList.observe(this) {
            reviews = it
            viewModel.adapter.setImage(reviews)
        }
        onClick()
    }

    private fun onClick() {
        binding.page1.setOnClickListener {
            if (page < 1) {
                binding.page1.visibility = View.GONE
            }
            viewModel.loadData(viewModel.adapter, --page)
        }
        binding.page3.setOnClickListener {
            viewModel.loadData(viewModel.adapter, ++page)
            if (page > 1) {
                binding.page1.visibility = View.VISIBLE
            }
        }
        viewModel.adapter.setOnPosterClickListener(object : MainAdapter.OnPosterClickListener {
            override fun onPosterClick(position: Int) {
                val urlDto: UrlDto = viewModel.adapter.getImage()[position]
                val intent = DetailActivity.newIntent(
                    this@MainActivity,
                    urlDto.urls.full
                )
                startActivity(intent)
            }
        })
    }
}