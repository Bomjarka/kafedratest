package com.chirkin.kafedratest


class ValidateService {
    fun validate(login: String, password: String): Int {
        if (isLoginCorrect(login)) {
            val user = findUser(login)
            if (user != null) {
                if (isPassCorrect(user, password)) {
                    println("0 - Login successful")
                    return 0
                } else {
                    println("4 - Password incorrect")
                    return 4
                }
            } else {
                println("3 - User not found")
                return 3
            }
        } else {
            println("2 - login format incorrect")
            return 2
        }
    }

    private fun isLoginCorrect(login: String): Boolean {
        val invalidChars = listOf("$", "@", "!", "#", "%", "^", "&", "*")
        var i = 0
        var count = 0
        while (i < login.length) {
            if (login.contains(invalidChars[i])) {
                count++
                i++
            } else i++
        }
        return count == 0
    }

    private fun findUser(login: String): User? {
        return usersList.findLast { item -> item.login == login }
    }

    private fun isPassCorrect(user: User?, password: String): Boolean {
        return user != null && password == user.password
    }
}