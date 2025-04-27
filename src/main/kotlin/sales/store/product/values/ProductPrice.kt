package org.example.sales.store.product.values

data class ProductPrice(val value: Double) {
    init {
        require(value >= 0) { "Product price cannot be negative" }
    }
}