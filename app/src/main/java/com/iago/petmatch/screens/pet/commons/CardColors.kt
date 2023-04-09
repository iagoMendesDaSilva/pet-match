package com.iago.petmatch.screens.pet.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.iago.petmatch.R
import com.iago.petmatch.commons.InfoTitle
import com.iago.petmatch.models.Colors
import com.iago.petmatch.ui.theme.White

@Composable
fun CardColors(colors: Colors) {
    Row(
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(start = 4.dp, end = 4.dp, bottom = 10.dp)
            .height(75.dp)
            .background(
                MaterialTheme.colors.primary,
                MaterialTheme.shapes.small
            )
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(.3f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            InfoTitle(R.string.colors, Icons.Default.ColorLens)
        }
        DividerVertical()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            InfoColor(R.string.primary, colors.primary, Modifier.weight(1f))
            DividerVertical()
            InfoColor(R.string.secondary, colors.secondary, Modifier.weight(1f))
            DividerVertical()
            InfoColor(R.string.tertiary, colors.tertiary, Modifier.weight(1f))
        }
    }
}

@Composable
fun InfoColor(text: Int, color: String?, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = stringResource(id = text),
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(bottom = 5.dp),
        )
        Text(
            maxLines = 1,
            color = White,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.subtitle1,
            text = color ?: stringResource(id = R.string.no_color),
        )
    }
}

@Composable
fun DividerVertical() {
    Divider(
        color = White,
        modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
    )
}