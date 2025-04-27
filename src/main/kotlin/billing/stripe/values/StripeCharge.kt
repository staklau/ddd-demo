package org.example.billing.stripe.values

import org.example.sales.store.order.values.StripeChargeId

data class StripeCharge(
    val id: StripeChargeId,
    val amount: Long,
)