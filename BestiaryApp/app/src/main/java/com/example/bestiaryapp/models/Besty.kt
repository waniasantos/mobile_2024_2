package com.example.bestiaryapp.models

import com.example.bestiaryapp.R

data class Besty(
    val id: Int,
    val name: String,
    val description: String,
    val elements: String,
    val firstAppearanceId: List<Int>,
    val otherAppearanceIds: List<Int>,
    val imageRes: Int
)

data class Season(
    val id: Int,
    val name: String
)

val SeasonList = listOf(
    Season(id = 1, name = "Ordem Paranormal: Iniciação"),
    Season(id = 2, name = "Ordem Paranormal: O Segredo na Floresta"),
    Season(id = 3, name = "Ordem Paranormal: Desconjuração"),
    Season(id = 4, name = "Ordem Paranormal: Calamidade"),
    Season(id = 5, name = "O Segredo na Ilha (Spin-off)"),
    Season(id = 6, name = "Sinais do Outro Lado (Spin-off)"),
    Season(id = 7, name = "Quarentena (Especial)"),
    Season(id = 8, name = "Enigma do Medo (Jogo)"),
)

val BestyList = listOf(
    Besty(
        id = 1,
        name = "Degolificada",
        description = "Ela utiliza seus longos cabelos para estrangular ou esmagar a cabeça de suas vítimas. Além disso, ao romper as costuras de sua boca, ela emite um grito ensurdecedor capaz de causar surdez temporária ou permanente em quem o ouve.",
        elements = "Medo",
        firstAppearanceId = listOf(1),
        otherAppearanceIds = listOf(2, 3),
        imageRes = R.drawable.degolificada
    ),
    Besty(
        id = 2,
        name = "Succ",
        description = "Uma criatura ágil que prende seus dentes no crânio e maxilar de suas vítimas com força extrema, sugando todo o ar de seus pulmões e causando asfixia fatal.",
        elements = "Morte e Energia",
        firstAppearanceId = listOf(2),
        otherAppearanceIds = emptyList(),
        imageRes = R.drawable.succ
    ),
    Besty(
        id = 3,
        name = "Deus da Morte",
        description = "Capaz de acelerar o envelhecimento de suas vítimas, regenerar-se com lodo, controlar cadáveres e manifestar-se em múltiplos locais através do tempo.",
        elements = "Morte e Conhecimento",
        firstAppearanceId = listOf(2),
        otherAppearanceIds = listOf(4, 8),
        imageRes = R.drawable.deus_da_morte
    ),
    Besty(
        id = 4,
        name = "Zumbi de Sangue",
        description = "Uma criatura de pele gosmenta e avermelhada, dentes pontudos e numerosos, unhas transformadas em garras afiadas e alongadas.",
        elements = "Sangue",
        firstAppearanceId = listOf(1),
        otherAppearanceIds = listOf(2, 3, 4, 5, 8),
        imageRes = R.drawable.zumbi_de_sangue
    ),
    Besty(
        id = 5,
        name = "Espreitador",
        description = "Ele observa suas vítimas durante o sono, drenando sua sanidade e causando insônia. Ao estabelecer contato visual, ele esgota a energia vital de suas vítimas, enfraquecendo-as.",
        elements = "Conhecimento e Medo",
        firstAppearanceId = listOf(3),
        otherAppearanceIds = emptyList(),
        imageRes = R.drawable.espreitador
    ),
    Besty(
        id = 6,
        name = "Estrangeiro",
        description = "Uma criatura humanoide capaz de apagar memórias relacionadas a si, manipular ações de suas vítimas e incubar larvas que drenam a sanidade do hospedeiro, resultando na criação de Alheios.",
        elements = "Conhecimento, Energia e Medo",
        firstAppearanceId = listOf(6),
        otherAppearanceIds = emptyList(),
        imageRes = R.drawable.estrangeiro
    ),
    Besty(
        id = 7,
        name = "Amigo Imaginário",
        description = "Ataca suas vítimas com tentáculos, garras e uma tinta corrosiva que derrete rostos instantaneamente, podendo agarrar várias pessoas ao mesmo tempo.",
        elements = "Morte, Sangue e Medo",
        firstAppearanceId = listOf(5),
        otherAppearanceIds = emptyList(),
        imageRes = R.drawable.amigo_imaginario
    ),
)

