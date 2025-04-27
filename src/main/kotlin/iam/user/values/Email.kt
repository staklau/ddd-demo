package org.example.iam.user.values

data class Email(val value: String) {
    init {
        require(value.isNotBlank()) { "Email cannot be blank" }
    }
}