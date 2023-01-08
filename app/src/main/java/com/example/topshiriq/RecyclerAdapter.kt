package com.example.topshiriq

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.topshiriq.databinding.RecyclerItemBinding

class RecyclerAdapter: ListAdapter<post,RecyclerAdapter.MyViewHolder>(diffUtil){

   class MyViewHolder(val binding: RecyclerItemBinding):RecyclerView.ViewHolder(binding.root)

    companion object{
        val diffUtil=object:DiffUtil.ItemCallback<post>(){
            override fun areItemsTheSame(oldItem: post, newItem: post): Boolean {
                return oldItem==newItem
            }

            override fun areContentsTheSame(oldItem: post, newItem: post): Boolean {
                return oldItem==newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RecyclerItemBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val item=getItem(position)
        holder.binding.userid.text=item.userId
        holder.binding.id.text=item.id
        holder.binding.title.text=item.title
        holder.binding.body.text=item.body
    }
}