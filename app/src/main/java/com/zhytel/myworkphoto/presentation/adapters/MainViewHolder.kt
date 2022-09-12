package com.zhytel.myworkphoto.presentation.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhytel.myworkphoto.R

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val image: ImageView = itemView.findViewById(R.id.imageViewSmallPoster)
    val textContent: TextView = itemView.findViewById(R.id.textViewContent)
}