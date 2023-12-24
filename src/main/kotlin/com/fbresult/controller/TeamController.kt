package org.example.com.fbresult.controller

import org.example.com.fbresult.ResultService
import org.example.com.fbresult.Team
import org.example.com.fbresult.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/team")
class TeamController(
    @Autowired
    val teamService: TeamService
) {

    @GetMapping
    suspend fun getAllTeam() = teamService.findAll()

    @GetMapping("/{id}")
    suspend fun getTeamById(@PathVariable teamId: String) = teamService.findById(teamId)

    @PostMapping()
    suspend fun createTeam(team: Team) = teamService.insertTeam(team)

}