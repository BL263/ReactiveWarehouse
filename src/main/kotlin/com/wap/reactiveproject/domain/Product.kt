package com.wap.reactiveproject.domain

import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Product (
    @Id
    var ID: Long? = null,

    var Name: String? = null,
    var Category: String? = null,
    var Price: String? = null,
    var Quantity: String? = null,

)

