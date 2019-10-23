package com.chirkin.kafedratest

import kotlin.system.exitProcess

val userList = listOf(
        User("Admin", "admin"),
        User("User1", "user")
)

//val args1 = arrayOf("-h")

fun main(args: Array<String>) {

    val validateService = ValidateService()
    val params = Params(args)

    if (!params.isHelp) {
        /*val ep = */validateService.validate(params.login, params.password)
        //exitProcess(ep)

    } else {
        printReference()
        exitProcess(1)
    }

}

fun printReference() = println("For authorization you need to print next parameters: -login <your login>, -password <your password>")

