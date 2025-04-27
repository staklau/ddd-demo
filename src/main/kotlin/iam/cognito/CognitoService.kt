package org.example.iam.cognito

import org.example.iam.user.values.CognitoUserId
import org.example.iam.user.values.Email
import org.example.iam.user.values.Password

interface CognitoService {
    fun createUser(
        email: Email,
        password: Password,
    ): CognitoUserId
}