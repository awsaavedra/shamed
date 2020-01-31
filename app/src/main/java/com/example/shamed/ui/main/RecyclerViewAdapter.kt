package com.example.shamed.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shamed.R
import kotlinx.android.synthetic.main.list_item_view.view.*

class RecyclerViewAdapter(private var context: Context, private var cards:ArrayList<String>):
    RecyclerView.Adapter<RecyclerViewAdapter.CardHolder>() {
    override fun getItemCount(): Int {
        return cards.size;
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        return CardHolder(LayoutInflater.from(context).inflate(R.layout.list_item_view, parent, false))
    }

    override fun onBindViewHolder(holder:CardHolder, position: Int) {
        holder.textView.text=cards.get(position);
    }

    class CardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView:TextView = itemView.title
    }
}