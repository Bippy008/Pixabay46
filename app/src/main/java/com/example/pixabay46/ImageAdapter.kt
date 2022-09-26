package com.example.pixabay46

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.pixabay46.databinding.ActivityMainBinding
import com.example.pixabay46.databinding.ImageSearchItemBinding

class ImageAdapter(val list: List<ImageModel>): RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {


    class ImageViewHolder(private val binding: ImageSearchItemBinding) : ViewHolder(binding.root){
        fun onBind(imageModel: ImageModel) {
            binding.searchResultImage.load(imageModel.largeImageURL)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ImageSearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}