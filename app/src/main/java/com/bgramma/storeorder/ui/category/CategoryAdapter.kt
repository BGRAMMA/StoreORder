package com.bgramma.storeorder.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bgramma.storeorder.databinding.ItemCategoryBinding
import com.bgramma.storeorder.model.CategoryModel

class CategoryAdapter(
    private val categoryList: List<CategoryModel>,
    private val onItemClick: (Long) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val binding
        = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        position: Int
    ) {
        val item = categoryList[position]
        holder.binding.tvCategoryName.text = item.name
        holder.binding.root.setOnClickListener {
            onItemClick(item.id)
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class CategoryViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}