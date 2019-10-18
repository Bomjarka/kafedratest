package com.chirkin.kafedratest

class Params(private val args: Array<String>) {

    private var login: String = ""
    private var password: String = ""
    var list = listOf("")
        get() {
            if (args.first() == "-login") {
                login = args[1]
                password = args[3]
            } else {
                login = args[3]
                password = args[1]
            }
            list = listOf(login, password)
            return field
        }
}