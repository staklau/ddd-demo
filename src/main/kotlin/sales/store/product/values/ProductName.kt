package org.example.sales.store.product.values

data class ProductName(val value: String) {
    init {
        require(value.isNotBlank()) { "Product name cannot be blank" }
    }
}