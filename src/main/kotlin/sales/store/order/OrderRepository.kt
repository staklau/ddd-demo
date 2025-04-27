package org.example.sales.store.order

import org.example.sales.store.customer.CustomerId

interface OrderRepository {
    fun get(id: OrderId): Order?
    fun create(order: Order): Order
    fun update(order: Order): Order
    fun delete(order: Order)
    fun listOrdersByCustomerId(
        customerId: CustomerId,
    ): List<Order>
}