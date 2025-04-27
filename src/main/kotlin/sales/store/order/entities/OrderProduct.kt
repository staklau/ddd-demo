package org.example.sales.store.order.entities

import org.example.Entity
import org.example.EntityId
import org.example.sales.store.product.ProductId
import org.example.sales.store.product.values.ProductPrice
import java.util.UUID

class OrderProduct(
    override val id: OrderProductId,
    val count: Int,
    val price: ProductPrice,
    val productId: ProductId,
) : Entity<OrderProductId>() {
    companion object {
        fun create(
            id: OrderProductId = OrderProductId(),
            count: Int,
            price: ProductPrice,
            productId: ProductId,
        ): OrderProduct {
            require(count > 0) { "OrderProduct count must be greater than 0" }
            return OrderProduct(
                id = id,
                count = count,
                price = price,
                productId = productId,
            )
        }
    }
}

data class OrderProductId(override val value: UUID) : EntityId() {
    constructor() : this(UUID.randomUUID())
}