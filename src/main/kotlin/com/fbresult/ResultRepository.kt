package org.example.com.fbresult

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ResultRepository: CoroutineCrudRepository<Result, String> {
    suspend fun findByHomeTeamOrAwayTeam(homeTeam: Team, awayTeam: Team): List<Result>
}