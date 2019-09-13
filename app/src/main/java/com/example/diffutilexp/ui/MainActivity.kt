package com.example.diffutilexp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutilexp.adapters.ProductAdapter
import com.example.diffutilexp.data.ProductGenerator.generateMockDataProductList
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

   lateinit var productAdapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.diffutilexp.R.layout.activity_main)

        button ?.setOnClickListener {
            onUpdateClick()
        }

        initAdapter()
    }




    private fun initAdapter(){
        productAdapter = ProductAdapter(generateMockDataProductList(5))

        with(activity_main_rv){
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = productAdapter
        }
    }




   private fun onUpdateClick() {
       productAdapter.updateProductListItems(generateMockDataProductList(5))
   }

}
