package com.chirkin.kafedratest

import kotlin.system.exitProcess

private val userList = listOf(
        User("Admin", "admin"),
        User("User1", "user")
)

private val userRole = listOf(
        UserRole(userList.first(), "A.BC", Role.EXECUTE),
        UserRole(userList.first(), "A.BC", Role.WRITE),
        UserRole(userList.last(), "A.BC.D.E", Role.READ)
)

fun main(args: Array<String>) {

    val args1 = arrayOf("--login", "User1", "--password", "user", "--role", "READ", "--resource", "A.BC.D.E") //строка для проверки
    val args3 = arrayOf("--login", "User1", "--password", "user", "--role", "READ", "--resource", "A.BC.D.E",
            "-ds", "2019-11-27", "-de", "2019-11-30", "-vol", "25") //строка для проверки
    val accs = AccountingService()
    val params = Params(args3)

    when {
        params.isHelp -> {
            printReference()
            println("Exit code 1")
            exitProcess(1)
        }
        !params.isAuth -> {
            println("Exit code ${validate(params.login, params.password)}")
            exitProcess(validate(params.login, params.password))
        }
        else -> {
            println("Exit code ${validate(params.login, params.password, params.role, params.resource)}")
            exitProcess(validate(params.login, params.password, params.role, params.resource))
        }
    }
}

fun printReference() = println("For authorization you need to print next parameters: -login <your login>, -password <your password>")

fun validate(login: String, password: String, role: String, resource: String, ds: String, de: String, vol: String): Int {

    return when {
        !AuthenticationService(userList).isLoginCorrect(login) -> 2
        AuthenticationService(userList).findUser(login) == null -> 3
        !AuthenticationService(userList).isPassCorrect(AuthenticationService(userList).findUser(login), password) -> 4
        !Role.isRole(role) -> 5
        !AuthorizationSerivce(userRole).isUserRole(login, role, resource) -> 6
        else -> 0
    }
}

fun validate(login: String, password: String, role: String, resource: String): Int {

    return when {
        !AuthenticationService(userList).isLoginCorrect(login) -> 2
        AuthenticationService(userList).findUser(login) == null -> 3
        !AuthenticationService(userList).isPassCorrect(AuthenticationService(userList).findUser(login), password) -> 4
        !Role.isRole(role) -> 5
        !AuthorizationSerivce(userRole).isUserRole(login, role, resource) -> 6
        else -> 0
    }
}

fun validate(login: String, password: String): Int {

    return when {
        !AuthenticationService(userList).isLoginCorrect(login) -> 2
        AuthenticationService(userList).findUser(login) == null -> 3
        !AuthenticationService(userList).isPassCorrect(AuthenticationService(userList).findUser(login), password) -> 4
        else -> 0
    }
}