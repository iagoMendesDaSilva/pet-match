package com.iago.petmatch.models

data class OAuthTokenRequest(
    val grant_type: String,
    val client_id: String,
    val client_secret: String
)