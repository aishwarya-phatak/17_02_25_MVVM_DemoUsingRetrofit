package com.bitcode.a17_02_25_mvvm_demousingretrofit.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image_url")
fun loadImage(imageView: ImageView, value : String){
    Glide.with(imageView)
        .load(value)
        .error(com.bitcode.a17_02_25_mvvm_demousingretrofit.R.drawable.ic_launcher_background)
        .placeholder(com.bitcode.a17_02_25_mvvm_demousingretrofit.R.drawable.ic_launcher_background)
        .into(imageView)
}