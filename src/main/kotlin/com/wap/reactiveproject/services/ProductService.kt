package com.wap.reactiveproject.services

import com.wap.reactiveproject.domain.Product
import com.wap.reactiveproject.dto.ProductDto
import kotlinx.coroutines.flow.Flow
import reactor.core.publisher.Mono

interface ProductService {
    suspend fun getAllProducts(): Flow<Product>?
    suspend fun getAllProductsByCategory(category: String): Flow<Product>?
    suspend fun getProduct(id:Long): Mono<Product>?
    suspend fun patchProduct(productID: Long, quantity: Long)
    suspend fun addProduct(product: ProductDto)

}