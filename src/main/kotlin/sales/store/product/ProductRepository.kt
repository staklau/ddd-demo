package org.example.sales.store.product

interface ProductRepository {
    fun get(id: ProductId): Product?
    fun create(product: Product): Product
    fun update(product: Product): Product
    fun listByIds(ids: List<ProductId>): List<Product>
}