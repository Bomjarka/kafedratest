package com.chirkin.kafedratest

class Params(args: Array<String>) {
    val login: String
    val password: String
    val isHelp: Boolean

    init {
        if ((args.isEmpty()) || ("-h" in args)) {
            isHelp = true
            login = ""
            password = ""
        } else {
            if (args.first() == "-login") {
                login = args[1]
                password = args[3]
                isHelp = false
            } else {
                login = args[3]
                password = args[1]
                isHelp = false
            }
        }
    }
}