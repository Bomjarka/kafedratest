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

private val logsList: MutableList<String> = arrayListOf()


fun main(args: Array<String>) {

    val params = Params(args)
    val ls = LoggingService(logsList)

    when {
        params.isHelp -> {
            printReference()
            println("Exit code 1")
            exitProcess(1)
        }
        params.isAuthen -> {
            println("Exit code ${validate(params.login, params.password, params.role, params.resource)}")
            exitProcess(validate(params.login, params.password, params.role, params.resource))
        }
        params.isAcc -> {
            ls.createLog(params.login, params.resource, params.role, params.dateStart, params.dateEnd, params.volume)
            ls.addLog()
            println("Exit code ${validate(params.login, params.password, params.role, params.resource, params.dateStart, params.dateEnd, params.volume)}")
            exitProcess(validate(params.login, params.password, params.role, params.resource, params.dateStart, params.dateEnd, params.volume))
        }
        else -> {
            println("Exit code ${validate(params.login, params.password)}")
            exitProcess(validate(params.login, params.password))
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
        !AuthorizationService(userRole).isUserRole(login, role, resource) -> 6
        !AccountingService.isDate(ds, de) || !AccountingService.isVol(vol) -> 7
        else -> 0
    }
}

fun validate(login: String, password: String, role: String, resource: String): Int {

    return when {
        !AuthenticationService(userList).isLoginCorrect(login) -> 2
        AuthenticationService(userList).findUser(login) == null -> 3
        !AuthenticationService(userList).isPassCorrect(AuthenticationService(userList).findUser(login), password) -> 4
        !Role.isRole(role) -> 5
        !AuthorizationService(userRole).isUserRole(login, role, resource) -> 6
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