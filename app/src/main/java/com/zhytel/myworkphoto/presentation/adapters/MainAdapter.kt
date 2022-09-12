package com.zhytel.myworkphoto.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.zhytel.myworkphoto.R
import com.zhytel.myworkphoto.data.pojo.UrlDto

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private lateinit var imageList: MutableList<UrlDto>

    private var onPosterClickListener: OnPosterClickListener? = null

    interface OnPosterClickListener {
        fun onPosterClick(position: Int)
    }

    fun setImage(urls: MutableList<UrlDto>) {
        this.imageList = urls
        dwdw(urls)
        notifyDataSetChanged()
    }
    fun getImage():MutableList<UrlDto>{
        return imageList
    }
    fun dwdw(v: MutableList<UrlDto>){
        imageList.addAll(v)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
    fun setOnPosterClickListener(onPosterClickListener: OnPosterClickListener?) {
        this.onPosterClickListener = onPosterClickListener
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val url: UrlDto = imageList[position]
        Picasso.get().load(url.urls.small).into(holder.image)
        holder.textContent.text = url.user.name

        holder.itemView.setOnClickListener{
            onPosterClickListener?.onPosterClick(position)
        }
    }



}