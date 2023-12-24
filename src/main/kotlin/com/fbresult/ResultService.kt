package org.example.com.fbresult

import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ResultService() {

    @Autowired private lateinit var resultRepository: ResultRepository

    suspend fun insert(result: Result) {
        if (resultRepository.findById(result.id) != null) {
            throw IllegalArgumentException("The result is already exist.")
        }
        resultRepository.save(result)
    }

    suspend fun delete(resultId: String) {
        resultRepository.deleteById(resultId)
    }

    suspend fun findByTeamId(teamId: Team): List<Result> {
        return resultRepository.findByHomeTeamOrAwayTeam(teamId,teamId)
    }

    suspend fun findAll(): Flow<Result> {
        return resultRepository.findAll()
    }
}