package com.nexters.lettero.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.nexters.lettero.R

@BindingAdapter("app:imgUrl")
fun loadImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(imageView)
            .load(imageUrl)
            .error(R.drawable.mypage_profile)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(imageView)
    }
}