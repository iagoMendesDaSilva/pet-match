package com.iago.petmatch.screens.home

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.iago.petmatch.PetMatchViewModel
import com.iago.petmatch.TypePet
import com.iago.petmatch.screens.home.commons.Categories
import com.iago.petmatch.screens.home.commons.ListPets

@Composable
fun HomeScreen(navController: NavHostController, viewModel: PetMatchViewModel) {

    val context = LocalContext.current
    var typeSelected = remember { mutableStateOf(TypePet.ALL) }

    LaunchedEffect(key1 = viewModel.error.value, block = {
        if (viewModel.error.value != null) {
            val message = context.getString(viewModel.error.value!!)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    })

    LaunchedEffect(key1 = true, block = {
        viewModel.getToken()
    })

    LaunchedEffect(key1 = viewModel.token.value, key2 = typeSelected.value, block = {
        if (viewModel.token.value.isNotEmpty()) {
            if (typeSelected.value == TypePet.ALL)
                viewModel.getAnimals()
            else
                viewModel.getAnimalsByType(typeSelected.value)
        }
    })

    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.surface
    ) {
        Column() {
            Categories(typeSelected)
            ListPets(viewModel, navController)
        }
    }
}