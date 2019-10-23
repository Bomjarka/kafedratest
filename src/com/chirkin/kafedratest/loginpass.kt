package com.chirkin.kafedratest

val userList = listOf(
        User("Admin", "admin"),
        User("User1", "user")
)

fun main(args: Array<String>) {

    val validateService = ValidateService()
    val params = Params(args)

    if (!params.isHelp) {
        println("""Exit code ${validateService.validate(params.login, params.password)}""")

    } else {
        printReference()
        println("Exit code 1")
    }

}

fun printReference() = println("For authorization you need to print next parameters: -login <your login>, -password <your password>")

