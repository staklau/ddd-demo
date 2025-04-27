package org.example.sales.store.order.event

import org.example.Event
import org.example.EventId
import org.example.sales.store.order.Order
import java.time.Instant

class OrderCreatedEvent private constructor(
    override val id: EventId,
    override val triggeredAt: Instant,
    val order: Order
) : Event() {
    companion object {
        fun create(
            id: EventId = EventId(),
            triggeredAt: Instant = Instant.now(),
            order: Order,
        ): OrderCreatedEvent {
            return OrderCreatedEvent(
                id = id,
                triggeredAt = triggeredAt,
                order
            )
        }
    }
}