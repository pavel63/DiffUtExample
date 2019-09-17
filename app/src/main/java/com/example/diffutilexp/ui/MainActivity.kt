package com.example.diffutilexp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutilexp.adapters.ProductAdapter
import com.example.diffutilexp.data.EqualDataGenerator.returnEqualProductList
import com.example.diffutilexp.data.ProductGenerator.generateMockDataProductList
import com.example.diffutilexp.utils.ItemTouchHelperFAdapt
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

   lateinit var productAdapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.diffutilexp.R.layout.activity_main)

        activity_main_add_diff_btn ?.setOnClickListener {
            addDiffDataClick()
        }

        activity_main_add_eq_btn ?.setOnClickListener {
            addEqDataClick()
        }

        initAdapter()
    }




    private fun initAdapter(){
        productAdapter = ProductAdapter()

        val touchCallback = ItemTouchHelperFAdapt(productAdapter){
         Snackbar.make(activity_main_rv,"item number :$it ", Snackbar.LENGTH_SHORT)
        }

      val itemTochHelper = ItemTouchHelper(touchCallback)
        itemTochHelper.attachToRecyclerView(activity_main_rv)

        with(activity_main_rv){
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = productAdapter
        }
    }




   private fun addDiffDataClick() {
       productAdapter.updateProductListItems(generateMockDataProductList(5))
   }



    private fun addEqDataClick(){
        productAdapter.updateProductListItems(returnEqualProductList())

    }

}
