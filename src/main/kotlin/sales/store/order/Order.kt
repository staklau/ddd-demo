package org.example.sales.store.order

import org.example.Entity
import org.example.EntityId
import org.example.sales.store.customer.CustomerId
import org.example.sales.store.order.entities.OrderProduct
import org.example.sales.store.order.values.OrderState
import org.example.sales.store.order.values.StripeChargeId
import java.util.UUID

class Order private constructor(
    override val id: OrderId,
    val owner: CustomerId,
    val products: List<OrderProduct>,
    val state: OrderState,
    val stripeChargeId: StripeChargeId?,
) : Entity<OrderId>() {
    companion object {
        fun create(
            id: OrderId = OrderId(),
            owner: CustomerId,
            products: List<OrderProduct>,
        ): Order {
            require(products.isNotEmpty()) { "Order must contain at least one product" }
            return Order(
                id = id,
                owner = owner,
                products = products,
                state = OrderState.IN_CART,
                stripeChargeId = null,
            )
        }
    }
}

data class OrderId(override val value: UUID) : EntityId() {
    constructor() : this(UUID.randomUUID())
}