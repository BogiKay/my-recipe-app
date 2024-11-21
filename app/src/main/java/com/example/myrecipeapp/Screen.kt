package com.example.myrecipeapp

sealed class Screen(
    val route: String
) {
    object Recipe:Screen("recipeScreen")
    object DetailsScreen:Screen("detailsScreen")
}