package com.chirkin.kafedratest

import org.apache.logging.log4j.LogManager
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
    val logger = LogManager.getLogger()
    when {
        params.isHelp -> {
            printReference()
            println("Exit code 1")
            val log = "-login ${params.login} -resource ${params.resource} -role ${params.role} -ds ${params.dateStart} -de ${params.dateEnd} -vol ${params.volume}"
            logger.info(log)
            exitProcess(1)
        }
        params.isAuthen -> {
            println("Exit code ${validate(params.login, params.password, params.role, params.resource)}")
            val log = "-login ${params.login} -resource ${params.resource} -role ${params.role}"
            logger.info(log)
            exitProcess(validate(params.login, params.password, params.role, params.resource))
        }
        params.isAcc -> {
            println("Exit code ${validate(params.login, params.password, params.role, params.resource, params.dateStart, params.dateEnd, params.volume)}")
            val log = "-login ${params.login} -resource ${params.resource} -role ${params.role} -ds ${params.dateStart} -de ${params.dateEnd} -vol ${params.volume}"
            logger.info(log)
            exitProcess(validate(params.login, params.password, params.role, params.resource, params.dateStart, params.dateEnd, params.volume))
        }
        else -> {
            println("Exit code ${validate(params.login, params.password)}")
            val log = "-login ${params.login}"
            logger.info(log)
            exitProcess(validate(params.login, params.password))
        }
    }
}

fun printReference() = println("For authorization you need to print next parameters: --login <String> --password <String> " +
        "--role <String> --resource <String> " +
        "-ds <'yyyy-mm-dd'> -de <'yyyy-mm-dd'> -vol <Int>"
)

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