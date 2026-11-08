package com.bgramma.storeorder.ui.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bgramma.storeorder.R
import com.bgramma.storeorder.databinding.ItemMenuBinding
import com.bgramma.storeorder.model.MenuModel

class MenuAdapter(private var menuList : List<MenuModel>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MenuViewHolder,
        position: Int
    ) {
        holder.binding.tvMenuName.text = menuList[position].name
        holder.binding.tvMenuPrice.text = menuList[position].price.toString()
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    class MenuViewHolder(val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    fun updateMenuList(newList : List<MenuModel>) {
        menuList = newList
        notifyDataSetChanged()
    }

}