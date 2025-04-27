package org.example.sales.store.customer.handlers

import org.example.billing.stripe.StripeService
import org.example.iam.user.events.UserSignedUpEvent
import org.example.sales.store.customer.Customer
import org.example.sales.store.customer.CustomerRepository

class UserSignedUpEventHandler(
    private val customerRepository: CustomerRepository,
    private val stripeService: StripeService,
) {

    fun handle(event: UserSignedUpEvent) {

        // Check if the customer already exists
        val existingCustomer = customerRepository.getByUserId(event.user.id)
        if (existingCustomer != null) {
            // Customer already exists, no action needed
            return
        }

        // Create a new customer in Stripe
        val stripeCustomerId = stripeService.createCustomer(event.user.email)

        // Create a new customer in the system
        val newCustomer = Customer.create(
            stripeCustomerId = stripeCustomerId,
        )
        customerRepository.create(newCustomer)
    }
}