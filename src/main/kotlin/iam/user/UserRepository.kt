package org.example.iam.user

interface UserRepository {
    fun get(id: UserId): User?
    fun create(user: User): User
}