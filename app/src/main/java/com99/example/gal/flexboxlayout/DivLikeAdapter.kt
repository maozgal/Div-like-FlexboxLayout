package com99.example.gal.flexboxlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.util.ArrayList
import androidx.recyclerview.widget.RecyclerView

class DivLikeAdapter(private val mItems: ArrayList<String>) : RecyclerView.Adapter<DivLikeAdapter.DivItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DivLikeAdapter.DivItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        return DivItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: DivItemViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }


    inner class DivItemViewHolder constructor(itemView: View) : RecyclerView.ViewHolder
    (itemView) {
        private val text: TextView = itemView.findViewById(R.id.text)

        fun onBind(position: Int) {
            text.text = mItems[position]
        }
    }
}