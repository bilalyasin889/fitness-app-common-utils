package com.tier2.fitness.common.repository

import com.tier2.fitness.common.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository : JpaRepository<User, UUID> {
    fun findUserByEmail(email: String): User?
}