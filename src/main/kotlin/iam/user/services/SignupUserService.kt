package org.example.iam.user.services

import org.example.EventService
import org.example.iam.cognito.CognitoService
import org.example.iam.user.User
import org.example.iam.user.UserRepository
import org.example.iam.user.events.UserSignedUpEvent
import org.example.iam.user.values.Email
import org.example.iam.user.values.Password

class SignupUserService(
    private val userRepository: UserRepository,
    private val cognitoService: CognitoService,
    private val eventService: EventService,
) {
    fun signup(
        email: Email,
        password: Password,
    ): User {
        val cognitoUserId = cognitoService.createUser(email, password)

        val user = User.create(
            email = email,
            cognitoUserId = cognitoUserId,
        )

        userRepository.create(user)

        eventService.publish(
            event = UserSignedUpEvent.create(
                user = user,
            ),
        )

        return user
    }
}

