package org.example

import java.time.Instant

abstract class Event {
    abstract val id: EventId
    abstract val triggeredAt: Instant
}