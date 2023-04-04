package com.ubaya.week4_160420064_c.util

import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Picasso
import com.ubaya.week4_160420064_c.R

fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get().load(url).resize(400, 400).centerCrop().error(R.drawable.ic_baseline_error_24).into(this)
}