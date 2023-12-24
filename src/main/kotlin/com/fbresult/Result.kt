package org.example.com.fbresult

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.time.LocalDateTime

@Entity
class Result(
    @Id var id: String,
    @OneToOne var homeTeam: Team,
    @OneToOne var awayTeam: Team,
    var homeTeamGoals: Int,
    var awayTeamGoals: Int,
    var fixtureId: String,
    var fixtureName: String,
    var dateTime: LocalDateTime
)