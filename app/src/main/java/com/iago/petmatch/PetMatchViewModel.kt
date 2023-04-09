package com.iago.petmatch

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iago.petmatch.models.Animal
import com.iago.petmatch.models.AnimalResponse
import com.iago.petmatch.models.Resource
import com.iago.petmatch.repository.PetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetMatchViewModel @Inject constructor(
    private val repository: PetsRepository,
) : ViewModel() {

    var loading = mutableStateOf(false)
    var loadingPet = mutableStateOf(false)
    var error = mutableStateOf<Int?>(null)

    private val _pets = MutableStateFlow<List<Animal>>(emptyList())
    val pets = _pets.asStateFlow()

    var pet = mutableStateOf<AnimalResponse?>(null)

    var token = mutableStateOf<String>("")

    fun getToken() {
        viewModelScope.launch {
            loading.value = true
            error.value = null
            when (val response = repository.getToken()) {
                is Resource.Success -> {
                    if (response.data != null)
                        token.value = "Bearer ${response.data.access_token}"
                }
                is Resource.Error -> error.value = response.message
            }
        }
    }

    fun getAnimals() {
        viewModelScope.launch {
            loading.value = true
            error.value = null
            when (val response = repository.getAnimals(token.value)) {
                is Resource.Success -> _pets.value = response.data?.animals ?: emptyList()
                is Resource.Error -> error.value = response.message
            }
            loading.value = false
        }
    }

    fun getAnimalsByType(type: TypePet) {
        viewModelScope.launch {
            loading.value = true
            error.value = null
            when (val response = repository.getAnimalsByType(token.value, typePetToString(type))) {
                is Resource.Success -> _pets.value = response.data?.animals ?: emptyList()
                is Resource.Error -> error.value = response.message
            }
            loading.value = false
        }
    }

    fun getAnimal(id: Int) {
        viewModelScope.launch {
            loadingPet.value = true
            error.value = null
            when (val response = repository.getAnimal(token.value, id)) {
                is Resource.Success -> pet.value = response.data
                is Resource.Error -> error.value = response.message
            }
            loadingPet.value = false
        }
    }
}