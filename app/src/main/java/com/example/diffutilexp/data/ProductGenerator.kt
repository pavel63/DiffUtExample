package com.example.diffutilexp.data

import com.example.diffutilexp.models.Product
import com.example.diffutilexp.utils.RandomTypesGenerator.getRandomInt
import com.example.diffutilexp.utils.RandomTypesGenerator.getRandomString

object ProductGenerator {


    fun generateMockDataProductList(itemsLengthListSize : Int):ArrayList<Product>{
        val productList = arrayListOf<Product>()
        repeat(itemsLengthListSize) {
            productList.add(generateProductObject())
        }
        return productList
    }


      private fun generateProductObject() = Product(getRandomInt(),getRandomString(10),getRandomInt())
}