package com.wap.reactiveproject

import com.wap.reactiveproject.controllers.WarehouseController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class ReactiveProjectApplicationTests {
    @Autowired
    private val controller: WarehouseController? = null
    @Test
    fun contextLoads() {
       assert(controller!=null)
    }

}
