package com.kevinrsebastian.androidex.directory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kevinrsebastian.androidex.databinding.ItemDirectoryListBinding

class DirectoryListAdapter(private val items: List<String>) : RecyclerView.Adapter<DirectoryListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemDirectoryListBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: ItemDirectoryListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(title: String) {
            binding.titleText.text = title
        }
    }
}
