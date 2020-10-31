package com.example.myapplication

data class PopularRepos(
    val items: List<Item>
)

data class Item(
    val full_name: String
)