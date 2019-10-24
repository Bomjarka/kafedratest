package com.chirkin.kafedratest

import kotlin.system.exitProcess

private val userList = listOf(
        User("Admin", "admin"),
        User("User1", "user")
)

val validateService = ValidateService(userList)

fun main(args: Array<String>) {

    val args1 = arrayOf("-login", "Admin") //строка для проверки

    val params = Params(args)
    val exitCode: Int

    if (!params.isHelp) {
        exitCode = validate(params.login, params.password)
        println("Exit code $exitCode")
        exitProcess(exitCode)
    } else {
        printReference()
        println("Exit code 1")
        exitProcess(1)
    }
}

fun printReference() = println("For authorization you need to print next parameters: -login <your login>, -password <your password>")

fun validate(login: String, password: String): Int {

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