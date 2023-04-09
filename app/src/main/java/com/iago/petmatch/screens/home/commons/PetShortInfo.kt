package com.iago.petmatch.screens.home.commons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.iago.petmatch.models.Animal

@Composable
fun PetShortInfo(animal: Animal) {
    Column(modifier = Modifier.fillMaxWidth(.7f)) {
        Text(
            maxLines = 1,
            text = animal.name,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h2,
        )
        Text(
            maxLines = 1,
            text = animal.breeds.primary,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.subtitle2,
        )
    }
}