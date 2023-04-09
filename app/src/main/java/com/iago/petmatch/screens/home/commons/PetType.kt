package com.iago.petmatch.screens.home.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.iago.petmatch.Type
import com.iago.petmatch.TypePet

@Composable
fun PetType(type: Type, typeSelected: MutableState<TypePet>, modifier: Modifier) {

    val selected = typeSelected.value == type.type

    Row(
        modifier = modifier
            .background(
                if (selected)
                    MaterialTheme.colors.primary
                else
                    MaterialTheme.colors.background,
                MaterialTheme.shapes.large
            )
            .clickable {
                typeSelected.value = type.type
            }
            .padding(horizontal = 5.dp, vertical = 7.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            contentScale = ContentScale.Fit,
            painter = painterResource(type.icon),
            modifier = Modifier
                .size(40.dp)
                .padding(end = 5.dp),
            colorFilter = ColorFilter.tint(
                if (selected)
                    MaterialTheme.colors.onSurface
                else
                    MaterialTheme.colors.onBackground
            ),
            contentDescription = stringResource(id = type.title),
        )
        Text(
            text = stringResource(id = type.title),
            style = MaterialTheme.typography.subtitle1,
            color = if (selected) MaterialTheme.colors.onSurface
            else MaterialTheme.colors.onBackground,
        )
    }
}