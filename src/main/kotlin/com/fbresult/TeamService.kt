package org.example.com.fbresult

import org.springframework.stereotype.Service

@Service
class TeamService (private val teamRepository: TeamRepository){
    fun insertTeam(team: Team) {
        teamRepository.save(team)
    }

    fun deleteTeam(teamId: String) {
        teamRepository.deleteById(teamId)
    }

    fun findById(teamId: String)  =teamRepository.findById(teamId)


    fun findAll() : Iterable<Team> {
        return teamRepository.findAll()
    }
}