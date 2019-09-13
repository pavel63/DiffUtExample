package com.example.diffutilexp.utils

import kotlin.random.Random

object RandomTypesGenerator {

     fun getRandomString(length: Int) : String {
        val allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz"
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }



     fun getRandomInt() = Random.nextInt(0,5)
}