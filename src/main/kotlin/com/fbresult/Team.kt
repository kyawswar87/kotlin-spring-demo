package org.example.com.fbresult

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Team(
    @Id var id: String,
    var name: String,
    val logoURL: String,
    val leagueId: String,
    val leagueName: String
) {
    constructor(id: String) : this(id,"","","","") {}
}