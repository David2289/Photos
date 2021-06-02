package com.example.photos.ui.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.davidpl.photos.R
import com.example.photos.business.datasource.local.androom.entity.PictureEntity

class PhotosAdapter(private val itemList: ArrayList<PictureEntity>): RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rootView = layoutInflater.inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = itemList[position]
        holder.image.setImageURI(Uri.parse(item.pictureUri))
    }


    class PhotoViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}