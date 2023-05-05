package com.iago.petmatch.screens.home.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.iago.petmatch.R
import com.iago.petmatch.models.Animal
import com.iago.petmatch.navigation.Screens

@Composable
fun PetItem(animal: Animal, navController: NavHostController) {
    LaunchedEffect(key1 = Unit, block ={} )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate(Screens.PetScreen.name + "/${animal.id}")
            }
            .padding(horizontal = 25.dp, vertical = 15.dp)
            .background(MaterialTheme.colors.onSurface, MaterialTheme.shapes.medium),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .padding(12.dp),
        ) {
            AsyncImage(
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(LocalContext.current).data(
                    if (animal.photos.isEmpty()) R.drawable.no_image
                    else animal.photos[0].medium
                ).crossfade(false).build(),
                placeholder = painterResource(R.drawable.no_image),
                contentScale = ContentScale.FillBounds,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            PetShortInfo(animal)
            ContactInfo(animal.contact)
        }
    }
}