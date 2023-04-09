package com.iago.petmatch.screens.home.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.iago.petmatch.R
import com.iago.petmatch.TypePet
import com.iago.petmatch.Types

@Composable
fun Categories(typeSelected: MutableState<TypePet>) {
    Column(Modifier.padding(vertical = 15.dp, horizontal = 25.dp)) {
        Text(
            style = MaterialTheme.typography.h1,
            text = stringResource(id = R.string.category),
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background, MaterialTheme.shapes.large)
        ) {
            PetType(
                Types.dogs,
                typeSelected,
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            PetType(
                Types.cats,
                typeSelected,
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            PetType(
                Types.all,
                typeSelected,
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
    }
}