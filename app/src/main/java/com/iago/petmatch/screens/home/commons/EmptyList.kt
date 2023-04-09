package com.iago.petmatch.screens.home.commons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.iago.petmatch.PetMatchViewModel
import com.iago.petmatch.R

@Composable
fun EmptyList(viewModel: PetMatchViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            tint = MaterialTheme.colors.primary,
            modifier = Modifier
                .size(50.dp)
                .clickable {
                    viewModel.getAnimals()
                },
            imageVector = Icons.Rounded.Refresh,
            contentDescription = null,
        )
        Text(
            text = stringResource(R.string.no_pets),
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}