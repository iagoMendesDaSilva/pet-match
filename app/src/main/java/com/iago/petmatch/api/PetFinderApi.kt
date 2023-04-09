package com.iago.petmatch.api

import com.iago.petmatch.models.*
import retrofit2.http.*
import javax.inject.Singleton

@Singleton
interface PetFinderApi {

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("oauth2/token")
    suspend fun getOAuthToken(
        @Field("grant_type") grant_type: String,
        @Field("client_id") client_id: String,
        @Field("client_secret") client_secret: String
    ): OAuthTokenResponse

    @GET("animals")
    suspend fun getAnimals(@Header("Authorization") token: String): Animals

    @GET("animals")
    suspend fun getAnimalsByType(
        @Header("Authorization") token: String,
        @Query("type") type: String
    ): Animals

    @GET("animals/{animalId}")
    suspend fun getAnimal(@Header("Authorization") token: String, @Path("animalId") animalId: Int): AnimalResponse


}