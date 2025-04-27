package org.example.iam.user

import org.example.Entity
import org.example.EntityId
import org.example.iam.user.values.CognitoUserId
import org.example.iam.user.values.Email
import java.util.UUID

class User private constructor(
    override val id: UserId,
    val email: Email,
    val cognitoUserId: CognitoUserId,
) : Entity<UserId>() {
    companion object {
        fun create(
            id: UserId = UserId(),
            email: Email,
            cognitoUserId: CognitoUserId,
        ): User {
            return User(
                id = id,
                email = email,
                cognitoUserId = cognitoUserId,
            )
        }
    }
}

data class UserId(override val value: UUID) : EntityId() {
    constructor() : this(UUID.randomUUID())
}