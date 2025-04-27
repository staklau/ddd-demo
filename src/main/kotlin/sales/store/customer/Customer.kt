package org.example.sales.store.customer

import org.example.Entity
import org.example.EntityId
import org.example.iam.user.UserId
import org.example.sales.store.customer.values.StripeCustomerId
import java.util.UUID

class Customer private constructor(
    override val id: CustomerId,
    val userId: UserId,
    val stripeCustomerId: StripeCustomerId,
) : Entity<CustomerId>() {
    companion object {
        fun create(
            id: CustomerId = CustomerId(),
            userId: UserId,
            stripeCustomerId: StripeCustomerId,
        ): Customer {
            return Customer(
                id = id,
                userId = userId,
                stripeCustomerId = stripeCustomerId,
            )
        }
    }
}

data class CustomerId(override val value: UUID) : EntityId() {
    constructor() : this(UUID.randomUUID())
}