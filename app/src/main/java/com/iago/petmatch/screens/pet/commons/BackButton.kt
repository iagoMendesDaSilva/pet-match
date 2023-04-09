package com.iago.petmatch.screens.pet.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BackButton(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp), contentAlignment = Alignment.TopStart) {
        Box(
            modifier = Modifier
                .size(55.dp)
                .background(MaterialTheme.colors.surface, MaterialTheme.shapes.large),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                tint = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        navController.popBackStack()
                    },
                imageVector = Icons.Rounded.ArrowBackIos,
                contentDescription = null,
            )
        }
    }
}