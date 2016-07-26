package com.nabula.test

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by harihar on 20/07/16.
 */
@RestController
class TestController {
    val logger = LoggerFactory.getLogger(TestController::class.java)

    @RequestMapping("/open/{message}")
    fun printMessage(@PathVariable message: String): String {
        print(message)
        return "You said ${message}"
    }
}