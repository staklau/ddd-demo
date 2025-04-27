package org.example.sales.store.product

import org.example.Entity
import org.example.EntityId
import org.example.sales.store.product.values.ProductName
import org.example.sales.store.product.values.ProductPrice
import org.example.sales.store.product.values.StripeProductId
import java.util.UUID

class Product private constructor(
    override val id: ProductId,
    val name: ProductName,
    val price: ProductPrice,
    val stripeProductId: StripeProductId,
) : Entity<ProductId>() {

    fun changeName(newName: ProductName): Product {
        return update(name = newName)
    }

    fun changePrice(newPrice: ProductPrice): Product {
        return update(price = newPrice)
    }

    private fun update(
        name: ProductName = this.name,
        price: ProductPrice = this.price,
    ) = Product(
        id = this.id,
        name = name,
        price = price,
        stripeProductId = this.stripeProductId,
    )

    companion object {
        fun create(
            id: ProductId = ProductId(),
            name: ProductName,
            price: ProductPrice,
            stripeProductId: StripeProductId,
        ): Product {
            return Product(
                id = id,
                name = name,
                price = price,
                stripeProductId = stripeProductId,
            )
        }
    }
}

data class ProductId(override val value: UUID) : EntityId() {
    constructor() : this(UUID.randomUUID())
}