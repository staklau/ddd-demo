package org.example

import java.util.UUID

data class EventId(val value: UUID) {
    constructor() : this(UUID.randomUUID())
}