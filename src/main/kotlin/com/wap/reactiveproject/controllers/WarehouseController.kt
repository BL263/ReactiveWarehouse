package com.wap.reactiveproject.controllers

import com.wap.reactiveproject.domain.Product
import com.wap.reactiveproject.dto.ProductDto
import com.wap.reactiveproject.services.ProductService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.expression.spel.SpelEvaluationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/warehouse")
class WarehouseController {
    @Autowired
    lateinit var productService: ProductService

    @PostMapping(path = ["/products"])
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun addProduct(@RequestBody productDto: ProductDto): ResponseEntity<Any> { //Flux<Product>
        return try {
            if (productDto != null)
                productService.addProduct(productDto)
            ResponseEntity.ok(productDto.Name)

        } catch (e: SpelEvaluationException) {
            ResponseEntity.badRequest().body("Bad Request Message")
        }
    }

    @PatchMapping("/products/{productID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    suspend fun patchProduct(@PathVariable productID: Long, @RequestBody() quantity: Map<String,String>): ResponseEntity<Any> {
        return try {
            if (productID != null) {
                val quantity_long = quantity["quantity"]?.toLongOrNull()
                if (quantity_long != null) {
                   productService.patchProduct(productID, quantity_long)
                    ResponseEntity.ok(productID)

                } else {
                    ResponseEntity.badRequest().body("Bad Request Message")
                }
            } else ResponseEntity.badRequest().body("Bad Request Message")
        } catch (e: SpelEvaluationException) {
            ResponseEntity.badRequest().body("Bad Request Message")
        }
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    suspend fun getAllProducts(): Flow<Product>? {
        val allproduct = productService.getAllProducts()
        val first = allproduct?.count()
        return allproduct
    }

    @GetMapping("/products/{productID}")
    @ResponseStatus(HttpStatus.OK)
    suspend fun getProduct(@PathVariable productID: Long): Mono<Product>? {

        val product = productService.getProduct(productID)
        return product
    }

    @GetMapping("/productsByCategory")
    @ResponseStatus(HttpStatus.OK)
    suspend fun getAllProductsByCategory(@RequestParam category: String): Flow<Product>? {
        return productService.getAllProductsByCategory(category)
    }

}