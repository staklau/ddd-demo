package org.example.sales.store.customer.values

data class StripeCustomerId(val value: String) {
    init {
        require(value.isNotBlank()) { "Stripe customer ID cannot be blank" }
        require(value.startsWith("cus_")) { "Stripe customer ID must start with 'cus_'" }
    }
}