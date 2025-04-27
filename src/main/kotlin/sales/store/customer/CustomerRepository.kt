package org.example.sales.store.customer

import org.example.iam.user.UserId

interface CustomerRepository {
    fun get(id: CustomerId): Customer?
    fun create(customer: Customer): Customer
    fun getByUserId(userId: UserId): Customer?
}