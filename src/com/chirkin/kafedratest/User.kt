package com.chirkin.kafedratest

import java.util.*

data class User(val login: String, private val password: String) {

    val salt = toRandomString()
    private val authsv = AuthenticationService
    val hash = authsv.toHash(authsv.toHash(password) + salt)

    private fun toRandomString(): String {
        val leftLimit = 97 // letter 'a'
        val rightLimit = 122 // letter 'z'
        val targetStringLength = 10
        val random = Random()
        val buffer = StringBuilder(targetStringLength)

        for (i in 0 until targetStringLength) {
            val randomLimitedInt = (leftLimit + (random.nextFloat() * (rightLimit - leftLimit + 1)).toInt())
            buffer.append(randomLimitedInt.toChar())
        }
        return "$buffer"
    }
}


