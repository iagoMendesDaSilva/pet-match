package com.iago.petmatch.commons

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.iago.petmatch.ui.theme.White

@Composable
fun InfoTitle(value: Int, icon: ImageVector) {
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
        text = stringResource(id = value),
        style = MaterialTheme.typography.body2,
    )
}