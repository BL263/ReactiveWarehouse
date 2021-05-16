package com.wap.reactiveproject.controllers

import com.wap.reactiveproject.domain.Product
import com.wap.reactiveproject.dto.ProductDto
import com.wap.reactiveproject.services.ProductService
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.expression.spel.SpelEvaluationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/warehouse")
class Warehouse {
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
    suspend fun patchProduct(@PathVariable productID: Long, @RequestBody quantity:  Long): ResponseEntity<Any> {
        return try {
            if (productID != null)
            {
                productService.patchProduct(productID,quantity)
                ResponseEntity.ok(productID)
            }
            else ResponseEntity.badRequest().body("Bad Request Message")
        } catch (e: SpelEvaluationException) {
            ResponseEntity.badRequest().body("Bad Request Message")
        }
    }

    @GetMapping("/products", produces = ["application/stream+json"])
    @ResponseStatus(HttpStatus.OK)
    suspend fun getAllProducts(@PathVariable productID: Long): Flow<Product> {
        return productService.getAllProducts()
    }

    @GetMapping("/products/{productID}")
    @ResponseStatus(HttpStatus.OK)
    suspend fun getProduct(@PathVariable productID: Long): Mono<Product> {

        return productService.getProduct(productID)
    }

    @GetMapping("/productsByCategory?category={category}")
    @ResponseStatus(HttpStatus.OK)
    suspend fun getAllProductsByCategory(@PathVariable category: String): Flow<Product> {
        return productService.getAllProductsByCategory(category)
    }

}