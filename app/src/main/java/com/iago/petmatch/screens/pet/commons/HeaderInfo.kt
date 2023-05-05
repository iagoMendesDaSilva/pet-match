package com.iago.petmatch.screens.pet.commons

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Female
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.iago.petmatch.models.Animal
import com.iago.petmatch.ui.theme.Blue
import com.iago.petmatch.ui.theme.Pink

@Composable
fun HeaderInfo(animal: Animal) {

    val isFemale = animal.gender == "Female"

    Column(modifier = Modifier.fillMaxWidth(.9f)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(modifier = Modifier.fillMaxWidth(.7f)) {
                NameNGender(animal, isFemale)
                Location(animal)
            }
        }
        if (!animal.description.isNullOrEmpty())
            Text(
                text = animal.description,
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.subtitle1,
            )
    }
}

@Composable
fun Location(animal: Animal) {
    Row(
        modifier = Modifier.padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
                .padding(end = 5.dp),
            tint = MaterialTheme.colors.secondary,
            imageVector = Icons.Rounded.LocationOn,
        )
        Text(
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.subtitle2,
            text = "${animal.contact.address.city}, ${animal.contact.address.state} - ${animal.contact.address.country}",
        )
    }
}

@Composable
fun NameNGender(animal: Animal, isFemale: Boolean) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            maxLines = 1,
            text = animal.name,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h1,
        )
        Icon(
            tint = if (isFemale) Pink else Blue,
            modifier = Modifier
                .size(30.dp)
                .padding(start = 5.dp),
            imageVector = if (isFemale) Icons.Rounded.Female else Icons.Rounded.Male,
            contentDescription = null,
        )
    }
}

fun openLink(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
    try {
        context.startActivity(intent)
    } catch (e: Exception) {
        Log.d("ERROR", e.toString())
    }
}