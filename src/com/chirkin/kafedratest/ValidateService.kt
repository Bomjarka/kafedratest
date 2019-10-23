package com.chirkin.kafedratest

class ValidateService {
    fun validate(login: String, password: String): Int {
        return if (isLoginCorrect(login)) {
            val user = findUser(login)
            if (user != null) {
                if (isPassCorrect(user, password)) {
                    0
                } else {
                    4
                }
            } else {
                3
            }
        } else {
            2
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