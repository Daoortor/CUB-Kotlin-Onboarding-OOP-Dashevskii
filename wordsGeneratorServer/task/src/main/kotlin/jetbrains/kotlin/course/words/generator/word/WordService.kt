package jetbrains.kotlin.course.words.generator.word

import jetbrains.kotlin.course.words.generator.util.words
import org.springframework.stereotype.Service

@Service
class WordService {
    companion object {
        val numberOfWords = words.size
        val previousWords = mutableMapOf<String, MutableList<String>>()
    }

    fun generateNextWord(): Word {
        if (words.isEmpty()) error("")
        return Word(words.removeFirst())
    }

    fun isValidWord(keyWord: String, newWord: String): Boolean {
        if (newWord.isEmpty()) {
            return false
        }
        val groupedKeyWord = keyWord.groupingBy { it }.eachCount()
        val groupedNewWord = newWord.groupingBy { it }.eachCount()

        return groupedNewWord.all { (c, count) ->
            groupedKeyWord[c] != null && groupedKeyWord[c]!! >= count
        }
    }

    fun isNewWord(keyWord: String, newWord: String): Boolean = TODO("Not implemented yet")
}
