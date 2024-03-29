package jetbrains.kotlin.course.codenames.card

import jetbrains.kotlin.course.codenames.utils.Utils.TOTAL_NUMBER
import jetbrains.kotlin.course.codenames.utils.words
import org.springframework.stereotype.Service

@Service
class CardService {
    fun generateWordsCards(): List<Card> {
        require(words.size >= TOTAL_NUMBER)
        val shuffledWords = words.shuffled()
        return shuffledWords.take(TOTAL_NUMBER).map { word ->
            Card(WordCardData(word), CardState.Front)
        }.also {
            words = shuffledWords.drop(TOTAL_NUMBER)
        }
    }
}
