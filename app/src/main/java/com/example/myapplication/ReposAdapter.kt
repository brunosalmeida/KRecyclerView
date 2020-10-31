package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ReposAdapter(val repos: List<Item>): RecyclerView.Adapter<ReposViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ReposViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        return holder.bind(repos[position])
    }
}

class ReposViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

    private val repoName: TextView = itemView.findViewById(R.id.repoName)


    fun bind(item: Item) {

        repoName.text = "Repo name: "+item.full_name

    }

}