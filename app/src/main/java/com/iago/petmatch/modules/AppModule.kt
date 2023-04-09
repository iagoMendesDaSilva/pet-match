package com.iago.petmatch.modules

import com.iago.petmatch.api.PetFinderApi
import com.iago.petmatch.repository.PetsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun providePetRepository(api: PetFinderApi) = PetsRepository(api)

    @Singleton
    @Provides
    fun provideApi(): PetFinderApi = Retrofit.Builder()
        .addConverterFactory((GsonConverterFactory.create()))
        .baseUrl("https://api.petfinder.com/v2/")
        .build()
        .create(PetFinderApi::class.java)

}