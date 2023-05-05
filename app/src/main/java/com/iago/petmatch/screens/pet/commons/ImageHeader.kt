package com.iago.petmatch.screens.pet.commons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.iago.petmatch.R
import com.iago.petmatch.models.Animal

@Composable
fun ImageHeader(animal: Animal) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(0.dp, 0.dp, 50.dp, 50.dp)),
            model = ImageRequest.Builder(LocalContext.current).data(
                if (animal.photos.isEmpty()) R.drawable.no_image
                else animal.photos[0].large
            ).crossfade(true).build(),
            placeholder = painterResource(R.drawable.no_image),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
    }
}