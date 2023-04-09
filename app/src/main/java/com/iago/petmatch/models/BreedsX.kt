package com.iago.petmatch.models

data class BreedsX(
    val mixed: Boolean,
    val primary: String,
    val secondary: String?,
    val unknown: Boolean
)