package org.example.iam.user.events

import org.example.Event
import org.example.EventId
import org.example.iam.user.User
import java.time.Instant

class UserSignedUpEvent private constructor(
    override val id: EventId,
    override val triggeredAt: Instant,
    val user: User,
) : Event() {
    companion object {
        fun create(
            id: EventId = EventId(),
            triggeredAt: Instant = Instant.now(),
            user: User,
        ): UserSignedUpEvent {
            return UserSignedUpEvent(
                id = id,
                triggeredAt = triggeredAt,
                user = user,
            )
        }
    }
}