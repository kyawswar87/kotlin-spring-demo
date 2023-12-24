package org.example.com.fbresult

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("result")
data class Result(
    @Id var id: String,
    var homeTeam: String,
    var awayTeam: String,
    var homeTeamGoals: Int,
    var awayTeamGoals: Int,
    var fixtureId: String,
    var fixtureName: String,
    var dateTime: LocalDateTime
)