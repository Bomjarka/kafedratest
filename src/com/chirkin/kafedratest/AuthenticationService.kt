package com.chirkin.kafedratest

import java.security.MessageDigest

class AuthenticationService(private val userList: List<User>) {

    fun isLoginCorrect(login: String): Boolean {
        val regex = Regex("[A-Za-z0-9]+")
        return regex.matches(login)
    }

    fun findUser(login: String): User? {
        return userList.findLast { item -> item.login == login }
    }

    fun isPassCorrect(user: User?, password: String): Boolean {
        return user != null && toHash(toHash(password) + (user.salt)) == user.hash
    }

    companion object Hash {
        fun toHash(input: String): String {
            val bytes = input.toByteArray()
            val md = MessageDigest.getInstance("SHA-256")
            val digest = md.digest(bytes)
            return digest.fold("", { str, it -> str + "%02x".format(it) })
        }
    }
}