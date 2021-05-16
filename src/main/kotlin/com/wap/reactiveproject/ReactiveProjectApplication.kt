package com.wap.reactiveproject

import com.wap.reactiveproject.domain.Product
import com.wap.reactiveproject.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import reactor.core.publisher.Flux

@SpringBootApplication
class ReactiveProjectApplication 

 /*    @Bean
    fun populateDB( productRepository:ProductRepository): CommandLineRunner {
        return CommandLineRunner {
            val random = java.util.Random()

            val products = Flux.range(1, 100).map {
                Product(null, "product$it", "Food", random.toString(), "")
            }
            val productIds = productRepository.saveAll(products)
                .map { it.ID }
                .collectList()
                .block()

        }
    }*/

fun main(args: Array<String>) {
    runApplication<ReactiveProjectApplication>(*args)
}
