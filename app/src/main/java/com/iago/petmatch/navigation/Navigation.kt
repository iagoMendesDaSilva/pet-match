package com.iago.petmatch.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.iago.petmatch.PetMatchViewModel
import com.iago.petmatch.screens.home.HomeScreen
import com.iago.petmatch.screens.pet.PetScreen

@Composable
fun Navigation(firebaseAnalytics: FirebaseAnalytics) {

    val navController = rememberNavController()
    val viewModel = hiltViewModel<PetMatchViewModel>()

    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.name
    ) {

        composable(Screens.HomeScreen.name) {
            HomeScreen(navController, viewModel, firebaseAnalytics)
        }

        composable(Screens.PetScreen.name+"/{id}") {
            val id = it.arguments?.getString("id")
            PetScreen(navController, viewModel, id!!)
        }
    }
}