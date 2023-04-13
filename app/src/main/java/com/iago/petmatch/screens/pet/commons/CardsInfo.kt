package com.iago.petmatch.screens.pet.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.iago.petmatch.R
import com.iago.petmatch.commons.InfoTitle
import com.iago.petmatch.models.Animal
import com.iago.petmatch.ui.theme.White

@Composable
fun CardsInfo(animal: Animal) {
    Row(modifier = Modifier.fillMaxWidth(.9f), horizontalArrangement = Arrangement.SpaceBetween) {
        CardInfo(Modifier.weight(1f), R.string.age, Icons.Default.Cake, listOf(animal.age))
        CardInfo(Modifier.weight(1f), R.string.coat, Icons.Default.ContentCut, listOf(animal.coat ?: ""))
        CardInfo(Modifier.weight(1f), R.string.size, Icons.Default.OpenInFull, listOf(animal.size))
        CardInfo(Modifier.weight(1f), R.string.breed, Icons.Default.Pets, listOf(animal.breeds.primary, animal.breeds.secondary))
    }
}

@Composable
fun CardInfo(modifier: Modifier, title: Int, icon: ImageVector, values: List<String?>) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, top = 20.dp, bottom = 15.dp)
            .height(100.dp)
            .background(
                MaterialTheme.colors.primary,
                MaterialTheme.shapes.small
            )
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InfoTitle(title, icon)
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(values.size) { index ->
                if (values[index] != null)
                    Text(
                        maxLines = 1,
                        color = White,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.subtitle1,
                        text = values[index]!!.ifEmpty { stringResource(id = R.string.no_info) },
                    )
            }
        }
    }
}