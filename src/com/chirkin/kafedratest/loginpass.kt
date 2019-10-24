package com.chirkin.kafedratest

import kotlin.system.exitProcess

private val userList = listOf(
        User("Admin", "admin"),
        User("User1", "user")
)


fun main(args: Array<String>) {

    //val args1 = arrayOf("-login", "Admin") //строка для проверки
    val params = Params(args)
    val exitCode: Int

    if (!params.isHelp) {
        exitCode = validate(params.login, params.password)
        println("Exit code $exitCode")
        exitProcess(exitCode)
    } else {
        printReference()
        exitCode = 1
        println("Exit code $exitCode")
        exitProcess(exitCode)
    }
}

fun printReference() = println("For authorization you need to print next parameters: -login <your login>, -password <your password>")

fun validate(login: String, password: String): Int {

    val validateService = ValidateService(userList)
    return when (validateService.isLoginCorrect(login)) {
        true -> {
            val user = validateService.findUser(login)
            when {
                user != null -> when {
                    validateService.isPassCorrect(user, password) -> 0
                    else -> 4
                }
                else -> 3
            }
        }
        else -> 2
    }

    /*if (validateService.isLoginCorrect(login)) {
        val user = validateService.findUser(login)
        if (user != null) {
            if (validateService.isPassCorrect(user, password)) {
                return 0
            } else {
                return 4
            }
        } else {
            return 3
        }
    } else {
        return 2
    }*/
}