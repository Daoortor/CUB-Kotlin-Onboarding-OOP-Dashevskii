package jetbrains.kotlin.course.words.generator.team

import org.springframework.stereotype.Service

@Service
class TeamService {
    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> = List(teamsNumber) { Team() }.also {
        for (team in it) {
            teamsStorage.putIfAbsent(team.id, team)
        }
    }

    companion object {
        val teamsStorage: MutableMap<Identifier, Team> = mutableMapOf()
    }
}
