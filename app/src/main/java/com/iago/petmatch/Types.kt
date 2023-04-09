package com.iago.petmatch

enum class TypePet {
    DOGS,
    CATS,
    ALL
}

fun typePetToString(typePet: TypePet): String {
    return when (typePet) {
        TypePet.DOGS -> "Dog"
        TypePet.CATS -> "Cat"
        TypePet.ALL -> "All"
    }
}

object Types {
    val dogs =
        Type(title = R.string.dogs, icon = R.drawable.dog, type = TypePet.DOGS)
    val cats =
        Type(title = R.string.cats, icon = R.drawable.cat, type = TypePet.CATS)
    val all =
        Type(title = R.string.all, icon = R.drawable.paw, type = TypePet.ALL)
}

data class Type(
    val type: TypePet,
    val title: Int,
    val icon: Int,
)