package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.model.Destination
import com.example.myapplication.databinding.ItemRowDestinationBinding

class ListDestinationAdapter(private val listDestination: ArrayList<Destination>, private val onClick : (Destination) -> Unit ) : RecyclerView.Adapter<ListDestinationAdapter.ListViewHolder>() {
    private lateinit var binding: ItemRowDestinationBinding

    inner class ListViewHolder(var binding: ItemRowDestinationBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        binding = ItemRowDestinationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val destination = listDestination[position]
        Glide.with(holder.itemView.context).load(destination.photo).into(holder.binding.imgItem)
        holder.binding.tvItemDestination.text = destination.name
        holder.binding.tvItemDescription.text = destination.description
        holder.binding.aboutPage.setOnClickListener{
            onClick(destination)
        }
    }

    override fun getItemCount(): Int = listDestination.size

}