package org.example.com.fbresult

import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service

@Service
class TeamService (private val teamRepository: TeamRepository){
    suspend fun insertTeam(team: Team) {
        teamRepository.save(team)
    }

    suspend fun deleteTeam(teamId: String) {
        teamRepository.deleteById(teamId)
    }

    suspend fun findById(teamId: String)  =teamRepository.findById(teamId)


    suspend fun findAll() : Flow<Team> {
        return teamRepository.findAll()
    }
}