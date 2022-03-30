package com.example.cat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(private val context: Context, private var ItemList:MutableList<GameResult>)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder?.score.text = ItemList[position].score
        holder?.data.text = ItemList[position].date
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var score :TextView = itemView!!.findViewById(R.id.textscore)
        var data :TextView = itemView!!.findViewById(R.id.textdata)

    }

    fun update(modelList:MutableList<GameResult>){
        ItemList = modelList
        this!!.notifyDataSetChanged()
    }
}