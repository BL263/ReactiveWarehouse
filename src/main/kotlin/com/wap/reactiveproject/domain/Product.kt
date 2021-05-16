package com.wap.reactiveproject.domain


import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.annotation.Id

@Table("product")
class Product (
    @Id
    var ID: Long? = null,

    var Name: String? = null,
    var Category: String? = null,
    var Price: String? = null,
    var Quantity: String? = null,

)

