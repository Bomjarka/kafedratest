package com.chirkin.kafedratest

class ValidateService {
    fun validate(login: String, password: String): Int {
        if (isLoginCorrect(login)) {
            val user = findUser(login)
            return if (user != null) {
                if (isPassCorrect(user, password)) {
                    println("0 - Login successful")
                    0
                } else {
                    println("4 - Password incorrect")
                    4
                }
            } else {
                println("3 - User not found")
                3
            }
        } else {
            println("2 - login format incorrect")
            return 2
        }
    }

    private fun isLoginCorrect(login: String): Boolean {
        val regex = Regex("[A-Za-z0-9]+")
        return regex.matches(login)
    }

    private fun findUser(login: String): User? {
        return userList.findLast { item -> item.login == login }
    }

    private fun isPassCorrect(user: User?, password: String): Boolean {
        return user != null && password == user.password
    }
}