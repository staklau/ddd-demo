package org.example.sales.store.product.values

data class ProductPrice(val value: Double) {
    init {
        require(value >= 1) {
            "Product price cannot be negative"
        }
        require(value <= 100_000) {
            "Product price cannot exceed 100,000"
        }
    }
}


