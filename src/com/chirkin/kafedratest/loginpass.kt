package com.chirkin.kafedratest

val usersList = listOf(
        User("admin", "admin"),
        User("user1", "user")
)

fun main(args: Array<String>) {

    //var args1 = arrayOf("-login", "admin", "-password", "admin")

    val validateService = ValidateService()
    val params = Params(args)

    if (params.list.isNotEmpty() && !params.isHelp) {
        validateService.validate(params.login, params.password)
    }
}

fun printReference() = println("1 - For authorization you need to print next parameters: -login <your login>, -password <your password>")

