package com.chirkin.kafedratest

class ValidateService(private val userList: List<User>) {

    fun isLoginCorrect(login: String): Boolean {
        val regex = Regex("[A-Za-z0-9]+")
        return regex.matches(login)
    }

    fun findUser(login: String): User? {
        return userList.findLast { item -> item.login == login }
    }

    fun isPassCorrect(user: User?, password: String): Boolean {
        return user != null && password == user.password
    }
}