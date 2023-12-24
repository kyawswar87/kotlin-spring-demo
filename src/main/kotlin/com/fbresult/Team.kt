package org.example.com.fbresult

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


@Table("Team")
class Team(
    @Id var id: String,
    var name: String,
    val logoURL: String,
    val leagueId: String,
    val leagueName: String
) {
    constructor(id: String) : this(id,"","","","") {}
}