package com.example.zooapp.models

import com.example.zooapp.R

data class Animal(
    val id: Int,
    val name: String,
    val species: String,
    val imageRes: Int,
    val description: String,
    val curiosities: String,
    var isFavorite: Boolean = false
)

val animalList = listOf(
    Animal(
        id = 1,
        name = "Dog",
        species = "Canis lupus familiaris",
        imageRes = R.drawable.claudia,
        description = "O cão é um dos animais mais antigos domesticados pelo homem.",
        curiosities = "Os cães têm um olfato cerca de 40 vezes mais potente que o dos humanos."
    ),
    Animal(
        id = 2,
        name = "Cat",
        species = "Felis catus",
        imageRes = R.drawable.panda,
        description = "O gato doméstico é conhecido por sua agilidade e independência.",
        curiosities = "Gatos passam cerca de 70% do dia dormindo."
    ),
    Animal(
        id = 3,
        name = "Elefante",
        species = "Loxodonta africana",
        imageRes = R.drawable.elefante,
        description = "Os elefantes são os maiores animais terrestres vivos.",
        curiosities = "Um elefante pode reconhecer seu reflexo no espelho, demonstrando autoconsciência."
    )
)
