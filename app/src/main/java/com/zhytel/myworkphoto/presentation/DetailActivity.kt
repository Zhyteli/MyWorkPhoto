package com.zhytel.myworkphoto.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.zhytel.myworkphoto.R
import com.zhytel.myworkphoto.data.pojo.UrlDto

class DetailActivity : AppCompatActivity() {

    private lateinit var urlDto: UrlDto
    private lateinit var detailViewModel: DetailViewModel
    private var imageView:ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datail)
        imageView = findViewById(R.id.imageDetail)
        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        if (!intent.hasExtra(ID)) {
            finish()
            return
        }
        val id = intent.getStringExtra(ID)
        Picasso.get().load(id).into(imageView)
    }
    companion object{
        private const val ID = "id"
        fun newIntent(context: Context, id: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ID, id)
            return intent
        }
    }
}