package com.nabula.test

import com.nabula.model.User
import io.kotlintest.specs.BehaviorSpec

/**
 * Created by harihar on 15/07/16.
 */
class LoginSpec : BehaviorSpec() {
    init {
        given("Username ") {
            var user = User()
            user.firstName = "Harihar"
            user.lastName = "Das"
            `when`("names are checked") {
                then("The names should not be empty") {
                    user.firstName.length shouldBe 7
                    user.lastName.length shouldBe 3
                }
            }
        }
    }
}