package com.iago.petmatch.screens.pet

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.iago.petmatch.PetMatchViewModel
import com.iago.petmatch.commons.Load
import com.iago.petmatch.screens.pet.commons.*

@Composable
fun PetScreen(navController: NavHostController, viewModel: PetMatchViewModel, id: String) {

    val context = LocalContext.current

    LaunchedEffect(key1 = viewModel.error.value, block = {
        if (viewModel.error.value != null) {
            val message = context.getString(viewModel.error.value!!)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    })

    LaunchedEffect(key1 = true, block = {
        viewModel.getAnimal(id.toInt())
    })

    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.surface
    ) {
        if (viewModel.loadingPet.value)
            Load()
        else if (viewModel.pet.value != null)
            PetInfo(viewModel, navController)
    }
}

@Composable
fun PetInfo(viewModel: PetMatchViewModel, navController: NavHostController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ImageHeader(viewModel.pet.value!!.animal)
        Spacer(modifier = Modifier.height(10.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HeaderInfo(viewModel.pet.value!!.animal)
            CardsInfo(viewModel.pet.value!!.animal)
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(bottom = 10.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                ButtonAdoptMe(viewModel.pet.value!!.animal.url)
            }
        }
    }
    BackButton(navController)
}