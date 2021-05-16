package com.wap.reactiveproject.repositories

import com.wap.reactiveproject.domain.Product
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono


@Repository
interface ProductRepository : CoroutineCrudRepository <Product, Long> {


}