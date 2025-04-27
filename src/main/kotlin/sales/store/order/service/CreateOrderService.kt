package org.example.sales.store.order.service

import org.example.sales.store.customer.CustomerId
import org.example.sales.store.customer.CustomerRepository
import org.example.sales.store.order.Order
import org.example.sales.store.order.OrderRepository
import org.example.sales.store.order.entities.OrderProduct
import org.example.sales.store.product.ProductId
import org.example.sales.store.product.ProductRepository

class CreateOrderService(
    private val orderRepository: OrderRepository,
    private val productRepository: ProductRepository,
    private val customerRepository: CustomerRepository,
) {
    fun createOrder(
        customerId: CustomerId,
        selectedProducts: Map<ProductId, Int>,
    ): Order {
        // Check that Customer exists
        val customer = customerRepository.get(customerId)
            ?: throw IllegalArgumentException("Customer not found")

        // Retrieve all relevant Products
        val allProducts = productRepository.listByIds(selectedProducts.keys.toList())

        // Create Child Entities (OrderProduct)
        val orderProducts = selectedProducts.map { (productId, count) ->
            val product = allProducts.find { it.id == productId }
                ?: throw IllegalArgumentException("Product not found")

            OrderProduct.create(
                productId = product.id,
                count = count,
                price = product.price,
            )
        }

        // Create Order Aggregate
        val newOrder = Order.create(
            owner = customer.id,
            products = orderProducts,
        )

        // Persist order and return it
        return orderRepository.create(newOrder)
    }
}