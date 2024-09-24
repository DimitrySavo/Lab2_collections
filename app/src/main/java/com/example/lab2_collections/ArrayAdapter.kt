package com.example.lab2_collections

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArrayAdapter(private var itemsArray: Array<String>)
    : RecyclerView.Adapter<ArrayAdapter.ArrayViewHolder>() {

    class ArrayViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.list_item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArrayViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ArrayViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArrayViewHolder, position: Int) {
        val item = itemsArray[position]
        holder.textView.text = item
    }

    override fun getItemCount(): Int {
        return itemsArray.size
    }

    fun updateArray(newArray: Array<String>) {
        itemsArray = newArray
        notifyDataSetChanged()
    }
}