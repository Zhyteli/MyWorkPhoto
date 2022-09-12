package com.zhytel.myworkphoto.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.zhytel.myworkphoto.data.pojo.UrlDto
import com.zhytel.myworkphoto.databinding.ActivityMainBinding
import com.zhytel.myworkphoto.presentation.adapters.MainAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var mainAdapter: MainAdapter
    private var page = 0
    private var reviews: MutableList<UrlDto> = ArrayList()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainAdapter = MainAdapter()
        binding.recyclerViewMain.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerViewMain.adapter = mainAdapter

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.loadData(mainAdapter, 0)

        viewModel.urlsList.observe(this) {
            reviews = it
            mainAdapter.setImage(reviews)
            Log.d("toPage", page.toString())
            Toast.makeText(this,"fsfw", Toast.LENGTH_LONG).show()
        }
        onClick()
    }
    private fun onClick(){
        binding.page1.setOnClickListener{
            if (page < 1){
                binding.page1.visibility = View.GONE
            }
            viewModel.loadData(mainAdapter,--page)
        }
        binding.page3.setOnClickListener{
            viewModel.loadData(mainAdapter,++page)
            if (page > 1){
                binding.page1.visibility = View.VISIBLE
            }
        }
        mainAdapter.setOnPosterClickListener(object : MainAdapter.OnPosterClickListener {
            override fun onPosterClick(position: Int) {
                val urlDto:UrlDto = mainAdapter.getImage()[position]
                val intent = DetailActivity.newIntent(this@MainActivity,urlDto.urls.full)
                startActivity(intent)
            }
        })
    }
}