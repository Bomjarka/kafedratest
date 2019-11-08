package com.chirkin.kafedratest
import kotlin.system.exitProcess

import kotlinx.cli.*

private val userList = listOf(
        User("Admin", "admin"),
        User("User1", "user")
)

private val userRole = listOf(
        UserRole(userList.first(),"A.BC",Role.Execute),
        UserRole(userList.first(),"A.BC",Role.Write),
        UserRole(userList.last(),"A.BC.D.E",Role.Read)
)


fun main(args: Array<String>) {

//  Попытки поработать с парсером, не понял как возвращать результат
    val parser = ArgParser("Input string")
    val login by parser.option(ArgType.String, fullName = "login", shortName = "l", description = "User login").required()
    val password by parser.option(ArgType.String, fullName = "password", shortName = "p", description = "user password").required()

    val args1 = arrayOf("--login", "Admin", "--password", "admin") //строка для проверки
    parser.parse(args1)

    val params = Params(args1)

    if (!params.isHelp) {
        val exitCode = validate(params.login, params.password)
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

    val validateService = ValidateService(userList)

    return when {
        !validateService.isLoginCorrect(login) -> 2
        validateService.findUser(login) == null -> 3
        validateService.isPassCorrect(validateService.findUser(login), password) -> 0
        else -> 4
    }
}