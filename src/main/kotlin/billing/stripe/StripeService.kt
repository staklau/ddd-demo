package org.example.billing.stripe

import org.example.billing.stripe.values.StripeCharge
import org.example.iam.user.values.Email
import org.example.sales.store.customer.values.StripeCustomerId
import org.example.sales.store.product.values.StripeProductId

interface StripeService {
    fun createProduct(
        email: Email,
    ): StripeProductId

    fun createCustomer(
        email: Email,
    ): StripeCustomerId

    fun createCharge(
        customerId: StripeCustomerId,
        productIds: List<StripeProductId>,
    ): StripeCharge
}