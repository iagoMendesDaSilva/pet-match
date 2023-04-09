package com.iago.petmatch.screens.pet.commons

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.iago.petmatch.R
import com.iago.petmatch.models.Animal

@Composable
fun Tags(animal: Animal) {

    val context = LocalContext.current
    var tags = getTags(animal, context)


    tags.chunked(3).forEach {
        Row(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            if (it.isNotEmpty()) Tag(it[0])
            if (it.size > 1) Tag(it[1])
            if (it.size > 2) Tag(it[2])
        }
    }
}

fun getTags(animal: Animal, context: Context): List<String> {

    val resources = context.resources
    var tags = mutableListOf<String>()

    if (animal.attributes.spayed_neutered)
        tags.add(
            if (animal.gender == "Female")
                resources.getString(R.string.spayed)
            else
                resources.getString(R.string.neutered)
        )
    if (animal.attributes.house_trained)
        tags.add(resources.getString(R.string.house_trained))
    if (animal.attributes.declawed)
        tags.add(resources.getString(R.string.declawed))
    if (!animal.attributes.special_needs)
        tags.add(resources.getString(R.string.not_special_needs))
    if (animal.environment.children)
        tags.add(resources.getString(R.string.good_with_kids))
    if (animal.environment.dogs)
        tags.add(resources.getString(R.string.good_with_dogs))
    if (animal.environment.cats)
        tags.add(resources.getString(R.string.good_with_cats))

    animal.tags.forEach {
        tags.add(it)
    }

    return tags
}

@Composable
fun Tag(text: String) {
    Box(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .background(MaterialTheme.colors.onSurface, MaterialTheme.shapes.large)
            .border(BorderStroke(1.dp, MaterialTheme.colors.secondary), MaterialTheme.shapes.large)
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h3,
        )
    }
}