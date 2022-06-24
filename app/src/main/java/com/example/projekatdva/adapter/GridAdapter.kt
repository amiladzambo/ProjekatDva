package com.example.projekatdva.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.projekatdva.R

class GridAdapter(var context: Context, var imagesSrcList: ArrayList<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return  imagesSrcList.size
    }

    override fun getItem(position: Int): Any {
        return imagesSrcList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("CheckResult", "ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.grid_item, null)
        val image: ImageView = view.findViewById(R.id.gridImage)
        val currentItem = imagesSrcList[p0]
        Log.i("CURRENT", currentItem)
        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.ic_launcher_background)
        requestOptions.error(R.drawable.ic_launcher_background)
        Glide.with(context)
            .load(currentItem)
            .apply(requestOptions)
            .into(image);
        return view
    }

}