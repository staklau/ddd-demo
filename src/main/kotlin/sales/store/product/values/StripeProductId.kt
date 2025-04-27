package org.example.sales.store.product.values

data class StripeProductId(val value: String) {
    init {
        require(value.isNotBlank()) { "Stripe product ID cannot be blank" }
        require(value.startsWith("prod_")) { "Stripe product ID must start with 'prod_'" }
    }
}