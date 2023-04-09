package com.iago.petmatch.repository

import com.iago.petmatch.BuildConfig
import com.iago.petmatch.api.PetFinderApi
import com.iago.petmatch.R
import com.iago.petmatch.models.*
import retrofit2.HttpException
import javax.inject.Inject

class PetsRepository @Inject constructor(private val api: PetFinderApi) {

    suspend fun getAnimals(token: String): Resource<Animals> {
        val response = try {
            api.getAnimals(token)
        } catch (e: HttpException) {
            return Resource.Error(R.string.error_request)
        } catch (e: Exception) {
            return Resource.Error(R.string.error_request)
        }
        return Resource.Success(response)
    }

    suspend fun getAnimalsByType(token: String, type: String): Resource<Animals> {
        val response = try {
            api.getAnimalsByType(token, type)
        } catch (e: HttpException) {
            return Resource.Error(R.string.error_request)
        } catch (e: Exception) {
            return Resource.Error(R.string.error_request)
        }
        return Resource.Success(response)
    }

    suspend fun getAnimal(token: String, id: Int): Resource<AnimalResponse> {
        val response = try {
            api.getAnimal(token, id)
        } catch (e: HttpException) {
            return Resource.Error(R.string.error_request)
        } catch (e: Exception) {
            return Resource.Error(R.string.error_request)
        }
        return Resource.Success(response)
    }

    suspend fun getToken(): Resource<OAuthTokenResponse> {
        val response = try {
            api.getOAuthToken(
                "client_credentials",
                BuildConfig.CLIENT_ID,
                BuildConfig.CLIENT_SECRET
            )
        } catch (e: HttpException) {
            return Resource.Error(R.string.error_request)
        } catch (e: Exception) {
            return Resource.Error(R.string.error_request)
        }
        return Resource.Success(response)
    }

}