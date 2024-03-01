package jetbrains.kotlin.course.codenames.utils

import jetbrains.kotlin.course.codenames.keyCard.KeyCardCell
import jetbrains.kotlin.course.codenames.keyCard.KeyCardType

fun interface KeyCardGenerator {
    fun generateData(): List<KeyCardCell>
}

object Utils {
    private const val N: Int = 5
    const val TOTAL_NUMBER: Int = N * N
    const val PINK_CARDS_NUMBER: Int = 8
    const val VIOLET_CARDS_NUMBER: Int = 9
    const val GRAY_CARDS_NUMBER: Int = 7
    const val BLACK_CARDS_NUMBER: Int = 1

    private val previousAttempts: MutableList<List<KeyCardCell>> = mutableListOf()
    val uniqueKeyCardGenerator = KeyCardGenerator {
        var keyCard: List<KeyCardCell>
        do {
            keyCard = KeyCardType.values().toList().map { type ->
                List(type.number) {KeyCardCell(type)}
            }.flatten().shuffled()
        } while (previousAttempts.contains(keyCard))
        previousAttempts.add(keyCard)
        keyCard
    }

    init {
        require(PINK_CARDS_NUMBER + VIOLET_CARDS_NUMBER + GRAY_CARDS_NUMBER + BLACK_CARDS_NUMBER == TOTAL_NUMBER) {
            "The total number of cards in the game should be $TOTAL_NUMBER"
        }
    }
}
