import org.example.sales.store.product.Product
import org.example.sales.store.product.ProductId
import org.example.sales.store.product.ProductRepository
import org.example.sales.store.product.values.ProductPrice

class AppServiceDemo(
    private val productRepository: ProductRepository,
) {

    fun changeProductPrice(
        id: String,
        newPrice: Double,
    ): Product {
        val productId = ProductId(id)
        val productPrice = ProductPrice(newPrice)

        val product = productRepository.get(productId)
            ?: throw IllegalArgumentException("Product with id $id not found")

        val updatedProduct = product.changePrice(productPrice)

        productRepository.update(updatedProduct)

        return updatedProduct
    }
}

