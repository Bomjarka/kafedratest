package com.chirkin.kafedratest
import kotlin.system.exitProcess

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

//    val args1 = arrayOf("--login", "User1", "--password", "user","--role", "Read", "--resource", "A.BC.D.E") //строка для проверки
    val params = Params(args)

    if (!params.isHelp) {
        if (params.isAuth) {
            val exitCode = validate(params.login, params.password,params.role,params.resource)
            println("Exit code $exitCode")
            exitProcess(exitCode)
        }
        else {
            val exitCode = validate(params.login, params.password)
            println("Exit code $exitCode")
            exitProcess(exitCode)
        }
    } else {
        printReference()
        println("Exit code 1")
        exitProcess(1)
    }
}

fun printReference() = println("For authorization you need to print next parameters: -login <your login>, -password <your password>")

fun validate(login: String, password: String, role: String, resource: String): Int {

    return when {
        !ValidateService(userList).isLoginCorrect(login) -> 2
        ValidateService(userList).findUser(login) == null -> 3
        !ValidateService(userList).isPassCorrect(ValidateService(userList).findUser(login),password) -> 4
        !CheckUserRole(userRole).isRole(role) -> 5
        !CheckUserRole(userRole).isUserRole(login,role,resource) -> 6
        else -> 0
    }
}

fun validate(login: String, password: String): Int {

    return when {
        !ValidateService(userList).isLoginCorrect(login) -> 2
        ValidateService(userList).findUser(login) == null -> 3
        !ValidateService(userList).isPassCorrect(ValidateService(userList).findUser(login),password) -> 4
        else -> 0
    }
}