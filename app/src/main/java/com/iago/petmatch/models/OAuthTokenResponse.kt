package com.iago.petmatch.models

data class OAuthTokenResponse(
    val token_type: String,
    val expires_in: Int,
    val access_token: String
)