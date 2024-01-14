package com.zhytel.myworkphoto.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.zhytel.myworkphoto.databinding.ActivityDatailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        Picasso.get()
            .load(id)
            .fit()
            .centerInside()
            .into(binding.imageDetail, object : Callback {
                override fun onSuccess() {

                }

                override fun onError(e: Exception?) {
                    Toast.makeText(this@DetailActivity, e?.message.toString(), Toast.LENGTH_SHORT).show()
                }
            })


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