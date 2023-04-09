package com.iago.petmatch.navigation

enum class Screens {
    HomeScreen,
    PetScreen;

    companion object {
        fun fromRoute(route: String?): Screens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            PetScreen.name -> PetScreen
            null -> HomeScreen
            else -> throw  IllegalArgumentException("Route $route is not recognized")
        }
    }

}