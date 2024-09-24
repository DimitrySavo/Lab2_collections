package com.example.lab2_collections

import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArrayAdapter(private var itemsArray: Array<String>): RecyclerView.Adapter<ArrayAdapter.> {

    class ArrayViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView: TextView =
    }
}