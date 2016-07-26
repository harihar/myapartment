package com.nabula.test

import com.nabula.model.User
import com.nabula.repo.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/secure")
class UserController @Autowired constructor(val userReo: UserRepository) {

    val logger = LoggerFactory.getLogger(UserController::class.java)

    @RequestMapping("/user")
    fun findAll(): MutableList<User>? {
        val list = userReo.findAll()
        return list
    }

    @RequestMapping(value = "/user", method = arrayOf(RequestMethod.POST))
    fun createUser(@RequestBody user: User) {
        userReo.save(user)
    }

}
