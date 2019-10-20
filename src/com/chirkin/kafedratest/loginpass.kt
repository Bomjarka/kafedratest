package com.chirkin.kafedratest

fun main(args: Array<String>) {

    val validateService = ValidateService()
    val params = Params(args)

    if (params.list.isNotEmpty() && !params.isHelp) {
        validateService.validate(params.login, params.password)
    }
}

fun printReference() = println("1 - For authorization you need to print next parameters: -login <your login>, -password <your password>")

