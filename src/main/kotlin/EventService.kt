package org.example

interface EventService {
    fun publish(
        event: Event,
    )
}