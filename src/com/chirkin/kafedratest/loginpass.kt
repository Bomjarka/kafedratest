package com.chirkin.kafedratest

import kotlin.system.exitProcess

val userList = listOf(
        User("Admin", "admin"),
        User("User1", "user")
)

val validateService = ValidateService()

fun main(args: Array<String>) {

    val args1 = arrayOf("-login", "Admin", "-password", "admin") //строка для проверки

    val params = Params(args1)
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
    return if (validateService.isLoginCorrect(login)) {
        val user = validateService.findUser(login)
        if (user != null) {
            if (validateService.isPassCorrect(user, password)) {
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