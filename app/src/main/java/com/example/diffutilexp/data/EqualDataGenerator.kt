package com.example.diffutilexp.data

import com.example.diffutilexp.models.Product

object EqualDataGenerator {

    fun returnEqualProductList(): ArrayList<Product>{
        val productList = arrayListOf<Product>()
        repeat(5){
            productList .add(Product(1,"one", 100))
        }
        return productList
    }
}