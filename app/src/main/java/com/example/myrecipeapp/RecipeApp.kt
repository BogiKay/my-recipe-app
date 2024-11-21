package com.example.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(
        navController = navController,
        startDestination = Screen.Recipe.route
    ) {
        composable(route = Screen.Recipe.route) {
            RecipeScreen(
                navigateToDetail = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                    navController.navigate(Screen.DetailsScreen.route)
                },
                viewState = viewState
            )
        }
        composable(route = Screen.DetailsScreen.route) {
            val category = navController
                .previousBackStackEntry
                ?.savedStateHandle
                ?.get<Category>("cat") ?: Category("", "", "", "")

            CategoryDetailsScreen(category)
        }
    }
}
