package com.iago.petmatch.screens.home.commons

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.iago.petmatch.PetMatchViewModel
import com.iago.petmatch.commons.Load

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ListPets(viewModel: PetMatchViewModel, navController: NavHostController) {
    if (viewModel.loading.value)
        Load()
    else {
        if (viewModel.pets.value.isEmpty())
            EmptyList(viewModel)
        else LazyColumn() {
            items(viewModel.pets.value.size) { index ->
                PetItem(viewModel.pets.value[index], navController)
            }
        }
    }
}