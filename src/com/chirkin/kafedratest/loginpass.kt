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

    return when {
        !validateService.isLoginCorrect(login) -> 2
        validateService.findUser(login) == null -> 3
        validateService.isPassCorrect(validateService.findUser(login), password) -> 0
        else -> 4
    }
}