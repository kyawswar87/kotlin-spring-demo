package org.example.com.fbresult

import org.springframework.data.repository.CrudRepository

interface ResultRepository: CrudRepository<Result, String> {
    fun findByHomeTeamOrAwayTeam(homeTeam: Team, awayTeam: Team): List<Result>
}