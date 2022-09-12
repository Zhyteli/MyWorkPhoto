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
import com.zhytel.myworkphoto.databinding.ActivityDatailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!intent.hasExtra(ID)) {
            finish()
            return
        }
        val id = intent.getStringExtra(ID)
        Picasso.get().load(id).into(binding.imageDetail)
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