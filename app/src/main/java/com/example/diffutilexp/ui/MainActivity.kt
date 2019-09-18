package com.example.diffutilexp.ui

import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutilexp.R
import com.example.diffutilexp.adapters.ProductAdapter
import com.example.diffutilexp.data.EqualDataGenerator.returnEqualProductList
import com.example.diffutilexp.data.ProductGenerator.generateMockDataProductList
import com.example.diffutilexp.utils.ItemTouchHelperFAdapt
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.search_view.*


class MainActivity : AppCompatActivity() {

   lateinit var productAdapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.diffutilexp.R.layout.activity_main)

        setSupportActionBar(toolbar)

        activity_main_add_diff_btn ?.setOnClickListener {
            addDiffDataClick()
        }

        activity_main_add_eq_btn ?.setOnClickListener {
            addEqDataClick()
        }

        initAdapter()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

       /* val sarchItem =menu?.findItem(R.id.search_view_sv)
        val searchView = sarchItem ?.actionView as SearchView
        searchView .queryHint = "type query" */

      /*  search_view_sv ?.setOnQueryTextFocusChangeListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        )*/

        return super.onCreateOptionsMenu(menu)
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
