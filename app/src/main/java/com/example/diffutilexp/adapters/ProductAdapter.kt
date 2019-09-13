package com.example.diffutilexp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilexp.R
import com.example.diffutilexp.models.Product
import com.example.diffutilexp.utils.ProductDiffUtilCallback
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_product_list.view.*

class ProductAdapter(private var mProductList : ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ProductAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_product_list,parent,false)
        return ProductAdapterViewHolder(view)
    }


    override fun getItemCount() = mProductList.size



    override fun onBindViewHolder(holder: ProductAdapterViewHolder, position: Int) {
        holder.bind(mProductList[position])
    }


    fun updateProductListItems(prodList : List<Product>){

        val productDiffUtilCallback =
            ProductDiffUtilCallback(this.mProductList, prodList)
        val productDiffResult = DiffUtil.calculateDiff(productDiffUtilCallback)

        this.mProductList.clear()
        this.mProductList .addAll(prodList)
        productDiffResult .dispatchUpdatesTo(this)
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