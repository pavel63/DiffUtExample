package com.example.diffutilexp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilexp.R
import com.example.diffutilexp.models.Product
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_product_list.view.*

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductAdapterViewHolder>() {

    var items : List<Product> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_product_list,parent,false)
        return ProductAdapterViewHolder(view)
    }


    override fun getItemCount() = items.size



    override fun onBindViewHolder(holder: ProductAdapterViewHolder, position: Int) {
        holder.bind(items[position])
    }


    fun updateProductListItems(prodList : ArrayList<Product>) {

        val diffutObj = object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                items[oldItemPosition].id == items[newItemPosition].id

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                items[oldItemPosition].hashCode() == items[newItemPosition].hashCode()

            override fun getOldListSize() = items.size

            override fun getNewListSize() = prodList.size
        }

        val diffResult = DiffUtil.calculateDiff(diffutObj)
        items = prodList
        diffResult.dispatchUpdatesTo(this)

            /* val productDiffUtilCallback =
            ProductDiffUtilCallback(this.mProductList, prodList)
        val productDiffResult = DiffUtil.calculateDiff(productDiffUtilCallback)

     //   this.mProductList.clear()
        this.mProductList .addAll(prodList)

        productDiffResult .dispatchUpdatesTo(this)*/

    }



    inner class ProductAdapterViewHolder(view : View): RecyclerView.ViewHolder(view), LayoutContainer{
        override val containerView: View?
            get() = itemView

        fun bind(model : Product){
            itemView.row_product_list_id_text ?.text = model.id.toString()
            itemView.row_product_list_name_tv ?.text = model.name
        }
    }
}