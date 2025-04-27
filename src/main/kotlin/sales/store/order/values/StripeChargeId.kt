package org.example.sales.store.order.values

data class StripeChargeId(val value: String) {
    init {
        require(value.isNotBlank()) { "Stripe charge ID cannot be blank" }
        require(value.startsWith("ch_")) { "Stripe charge ID must start with 'ch_'" }
    }
}