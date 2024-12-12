package com.example.nighteventsapp.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.nighteventsapp.R

data class Event(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val location: String,
    val isFavorite: MutableState<Boolean> = mutableStateOf(false),
    val isSubscribed: MutableState<Boolean> = mutableStateOf(false),
    val imageRes: Int
)

val eventList = listOf(
    Event(
        id = 1,
        title = "Exposição de Artes 2024",
        description = "Uma jornada pelas tendências modernas em artes visuais.",
        date = "2024-12-15",
        location = "Centro Cultural Cego Aderaldo",
        imageRes = R.drawable.img1
    ),
    Event(
        id = 2,
        title = "Workshop de Empreendedorismo",
        description = "Aprenda estratégias e ferramentas para alavancar seu negócio.",
        date = "2024-12-15",
        location = "Centro de Eventos Parque Tecnológico",
        imageRes = R.drawable.img2
    ),
    Event(
        id = 3,
        title = "Maratona de Programação 2024",
        description = "Teste suas habilidades em programação competitiva.",
        date = "2024-12-15",
        location = "Universidade Federal do Ceará (UFC)",
        imageRes = R.drawable.img3
    ),
    Event(
        id = 4,
        title = "Festival de Culinária Internacional",
        description = "Explore sabores e culturas em um evento gastronômico único.",
        date = "2024-12-15",
        location = "Parque Gastronômico",
        imageRes = R.drawable.img4
    ),
    Event(
        id = 5,
        title = "Simpósio de Medicina 2024",
        description = "Discussões sobre avanços e inovações na área da saúde.",
        date = "2024-12-15",
        location = "Hospital Universitário",
        imageRes = R.drawable.img5
    ),
    Event(
        id = 6,
        title = "Feira de Livros e Cultura",
        description = "Descubra novos títulos e participe de debates literários.",
        date = "2024-12-15",
        location = "Biblioteca Municipal",
        imageRes = R.drawable.img6
    ),
    Event(
        id = 7,
        title = "Inovações e Startups 2024",
        description = "Conheça as novas ideias que estão moldando o futuro.",
        date = "2024-12-15",
        location = "Hub de Inovação",
        imageRes = R.drawable.img7
    ),
    Event(
        id = 8,
        title = "Festival de Música 2024",
        description = "Celebre a música com artistas de diversos gêneros.",
        date = "2024-12-15",
        location = "Arena Musical",
        imageRes = R.drawable.img8
    ),
    Event(
        id = 9,
        title = "Galeria de Arte Contemporânea",
        description = "Explore obras de artistas contemporâneos renomados.",
        date = "2024-12-15",
        location = "Museu de Arte Contemporânea",
        imageRes = R.drawable.img9
    ),
    Event(
        id = 10,
        title = "Conferência de Tecnologia 2024",
        description = "Discussões e apresentações sobre as tendências tecnológicas.",
        date = "2024-12-15",
        location = "Centro de Convenções Tecnológico",
        imageRes = R.drawable.img10
    )
)

