package com.vanka.swipeyc21.ui.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.vanka.swipeyc21.databinding.HomeItemBinding
import com.vanka.swipeyc21.model.HomeItemModel

class HomeItemAdapter(val list:List<HomeItemModel>):RecyclerView.Adapter<HomeItemAdapter.ViewHolder>() {
    class ViewHolder(val binding:HomeItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(HomeItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imgHome.setImageResource(list[position].img)
        holder.binding.titleHome.text = list[position].title
        holder.binding.disHome.text = list[position].dis
        holder.binding.btn.setCardBackgroundColor(ColorStateList.valueOf(list[position].color))
    }
}