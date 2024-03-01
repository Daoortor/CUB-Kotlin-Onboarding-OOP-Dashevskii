package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.words
import org.springframework.stereotype.Service

@Service
class CardService {
    companion object {
        private const val WORDS_IN_CARD: Int = 4
        val cardsAmount: Int = words.size / WORDS_IN_CARD
    }

    private val identifierFactory : IdentifierFactory = IdentifierFactory()
    private val cards: List<Card> = generateCards()

    private fun generateCards(): List<Card> {
        val shuffledWords = words.shuffled()
        return (0 until cardsAmount).map { cardIndex ->
            Card(identifierFactory.uniqueIdentifier(),
                shuffledWords.subList(cardIndex * WORDS_IN_CARD, (cardIndex+1) * WORDS_IN_CARD).toWords())
        }
    }

    private fun List<String>.toWords(): List<Word> = this.map {
        Word(it)
    }

    fun getCardByIndex(index: Int): Card = cards.getOrNull(index) ?: error("index out of range")
}
