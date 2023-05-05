package com.iago.petmatch.screens.pet.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.iago.petmatch.R

@Composable
fun ButtonAdoptMe(url: String) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth(.9f)
            .height(45.dp)
            .background(MaterialTheme.colors.primary, MaterialTheme.shapes.large)
            .clickable {
                openLink(context, url)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.adopt_me),
            style = MaterialTheme.typography.body1,
        )
    }
}