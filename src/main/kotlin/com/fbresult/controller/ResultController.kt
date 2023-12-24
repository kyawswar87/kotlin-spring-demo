package org.example.com.fbresult.controller

import org.example.com.fbresult.Result
import org.example.com.fbresult.ResultService
import org.example.com.fbresult.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/result")
class ResultController(
    @Autowired
    val resultService: ResultService
) {

    @GetMapping
    fun getAllResult() = resultService.findAll()

    @GetMapping("/{id}")
    fun getResultByTeamId(@PathVariable teamId: String) = resultService.findByTeamId(Team(teamId))

    @PostMapping
    fun createResult(@RequestBody result: Result) = resultService.insert(result)
}