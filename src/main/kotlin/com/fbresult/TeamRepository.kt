package org.example.com.fbresult

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface TeamRepository: CoroutineCrudRepository<Team, String>