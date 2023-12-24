package org.example.com.fbresult

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ResultService(@Autowired private val resultRepository: ResultRepository) {

    fun insert(result: Result) {
        if (resultRepository.findById(result.id).isPresent) {
            throw IllegalArgumentException("The result is already exist.")
        }
        resultRepository.save(result)
    }

    fun delete(resultId: String) {
        resultRepository.deleteById(resultId)
    }

    fun findByTeamId(teamId: Team): List<Result> {
        return resultRepository.findByHomeTeamOrAwayTeam(teamId,teamId)
    }

    fun findAll(): Iterable<Result> {
        return resultRepository.findAll()
    }
}