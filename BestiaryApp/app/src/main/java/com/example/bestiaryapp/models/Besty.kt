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
        description = "Fisicamente tem a aparência de uma criança ou adolescente com cabelos pretos, lisos e longos, que cobrem o seu rosto e percorrem seu corpo até o chão. Sua coluna é retorcida e magra e se inverte na área do abdômen deixando ele fino. Os braços e as pernas parecem pendurar de seu corpo enquanto ela flutua lentamente alguns centímetros acima do chão.",
        elements = "Medo",
        firstAppearanceId = listOf(1),
        otherAppearanceIds = listOf(2, 3),
        imageRes = R.drawable.degolificada
    ),
    Besty(
        id = 2,
        name = "Succ",
        description = "Uma criatura ágil e pouco resistente, e tende a atacar um único alvo. Seu único objetivo é sugar o oxigênio de outros seres. Por isso, o Succ prende seus dentes no crânio e maxilar de sua vítima com força extrema, depois começa a sugar o ar da pessoa para si. ",
        elements = "Morte e Energia",
        firstAppearanceId = listOf(2),
        otherAppearanceIds = emptyList(),
        imageRes = R.drawable.succ
    ),
    Besty(
        id = 3,
        name = "Deus da Morte",
        description = "O Parasita de Dimensões, vulgo Deus da Morte. Seu corpo é completamente formado por Lodo, com tendões que simulam a anatomia muscular humana, e no seu peito, os tendões de Lodo se retorcem em uma espiral. O rosto do corpo original foi completamente arrancado, tendo agora apenas seu crânio exposto.",
        elements = "Morte e Conhecimento",
        firstAppearanceId = listOf(2),
        otherAppearanceIds = listOf(4, 8),
        imageRes = R.drawable.deus_da_morte
    ),
    Besty(
        id = 4,
        name = "Zumbi de Sangue",
        description = "Uma criatura de pele gosmenta e avermelhada, dentes pontudos e numerosos, unhas transformadas em garras afiadas e alongadas. Cego, com órbitas vazias, sente a posição de seus alvos pela sensibilidade extrema de sua pele exposta ao movimento do ar",
        elements = "Sangue",
        firstAppearanceId = listOf(1),
        otherAppearanceIds = listOf(2, 3, 4, 5, 8),
        imageRes = R.drawable.zumbi_de_sangue
    ),
    Besty(
        id = 5,
        name = "Espreitador",
        description = "O Espreitador, por sua natureza tímida e observadora, nunca se mostra imediatamente. Ele revela sua aparência aos poucos ao longo do tempo à medida que ele chega mais e mais perto de seus alvos, mas sempre fazendo isso escondido, tentando passar despercebido. ",
        elements = "Conhecimento e Medo",
        firstAppearanceId = listOf(3),
        otherAppearanceIds = emptyList(),
        imageRes = R.drawable.espreitador
    ),
    Besty(
        id = 6,
        name = "Estrangeiro",
        description = "Uma criatura humanoide magra, de 2,5 metros, com uma máscara cinza que lembra uma cabeça humana, grandes olhos verdes e fios conectados ao corpo. Veste uma capa esverdeada, uma roupa metálica detalhada no torso, e um manto que cobre suas pernas. Seus longos braços magros possuem cinco garras afiadas em cada mão, adornados com braceletes.",
        elements = "Conhecimento, Energia e Medo",
        firstAppearanceId = listOf(6),
        otherAppearanceIds = emptyList(),
        imageRes = R.drawable.estrangeiro
    ),
    Besty(
        id = 7,
        name = "Amigo Imaginário",
        description = "Uma criatura curvada de dois metros, com coluna retorcida e espinhos nas costas. Coberta por um capuz rasgado que se funde ao corpo, revela tentáculos negros e braços secos. Sem rosto, possui apenas um buraco que verte líquido marrom usado como tinta nos quadros da ilha.",
        elements = "Morte, Sangue e Medo",
        firstAppearanceId = listOf(5),
        otherAppearanceIds = emptyList(),
        imageRes = R.drawable.amigo_imaginario
    ),
)

