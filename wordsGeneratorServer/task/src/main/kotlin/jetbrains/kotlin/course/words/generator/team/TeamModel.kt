package jetbrains.kotlin.course.words.generator.team

typealias Identifier = Int

data class Team(val id: Identifier = idCounter++, var points: Int = 0) {
    val name: String = "Team#${id + 1}"

    companion object {
        var idCounter: Identifier = -1
    }
}
