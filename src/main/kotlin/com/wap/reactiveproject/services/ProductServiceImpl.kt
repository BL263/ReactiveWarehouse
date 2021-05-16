package com.wap.reactiveproject.services

import com.wap.reactiveproject.domain.Product
import com.wap.reactiveproject.dto.ProductDto
import com.wap.reactiveproject.repositories.ProductRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
@Transactional
class ProductServiceImpl:ProductService {
    lateinit var productRepository: ProductRepository

    override suspend fun getAllProducts(): Flow<Product> {
        return try {
            productRepository.findAll()
        } catch(ex: Exception) {
            throw ex
        }
    }
    override suspend fun getAllProductsByCategory(category: String): Flow<Product> {
        return try {
            productRepository.getProductsByCategory(category)
        } catch(ex: Exception) {
            throw ex
        }
    }
    override suspend fun getProduct(id:Long): Mono<Product> {
        return try {
            productRepository.getProductsByID(id)
        } catch(ex: Exception) {
            throw ex
        }
    }
    override suspend fun patchProduct(id :Long,value:   Long)  {
          productRepository.updateQuantityOfProduct(id, value)
    }
    override suspend fun addProduct(product: ProductDto){
         productRepository.save(Product(null, product.Name,product.Category,
            product.Price,product.Quantity))
    }


}