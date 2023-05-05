package com.iago.petmatch.screens.pet.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
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
import com.iago.petmatch.models.Animal
import com.iago.petmatch.ui.theme.White

@Composable
fun CardsInfo(animal: Animal) {
    Row(modifier = Modifier.fillMaxWidth(.9f), horizontalArrangement = Arrangement.SpaceBetween) {
        CardInfo(Modifier.weight(1f), R.string.age, Icons.Default.Cake, animal.age ?: "")
        CardInfo(Modifier.weight(1f), R.string.coat, Icons.Default.ContentCut, animal.coat ?: "")
        CardInfo(Modifier.weight(1f), R.string.size, Icons.Default.OpenInFull, animal.size ?: "")
        CardInfo(
            Modifier.weight(1f),
            R.string.color,
            Icons.Default.Pets,
            animal.colors.primary ?: ""
        )
    }
}

@Composable
fun CardInfo(modifier: Modifier, label: Int, icon: ImageVector, text: String?) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, top = 20.dp, bottom = 15.dp)
            .aspectRatio(1f)
            .background(
                MaterialTheme.colors.primary,
                MaterialTheme.shapes.small
            )
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                tint = White,
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .padding(bottom = 5.dp),
            )
            Text(
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                text = stringResource(id = label),
                style = MaterialTheme.typography.body2,
            )
            Text(
                maxLines = 1,
                color = White,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1,
                text = text!!.ifEmpty { stringResource(id = R.string.no_info) },
            )
        }
    }
}