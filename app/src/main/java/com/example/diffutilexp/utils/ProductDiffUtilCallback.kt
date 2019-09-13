package com.example.diffutilexp.utils

import androidx.recyclerview.widget.DiffUtil

import com.example.diffutilexp.models.Product

class ProductDiffUtilCallback(
    private val oldList: List<Product>,
    private val newList: List<Product>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val (id) = oldList[oldItemPosition]
        val (id1) = newList[newItemPosition]
        return id == id1
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val (id, name, _) = oldList[oldItemPosition]
        val (id1, name1, _) = newList[newItemPosition]
        return id == id1 && name == name1
    }


    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}


