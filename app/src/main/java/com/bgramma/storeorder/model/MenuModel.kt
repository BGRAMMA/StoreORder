package com.bgramma.storeorder.model

data class MenuModel(
    val id          : Long,
    val categoryId  : Long,
    val name        : String,
    val price       : Int,
)