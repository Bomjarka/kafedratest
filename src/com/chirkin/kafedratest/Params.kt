package com.chirkin.kafedratest
import kotlinx.cli.*


class Params(args: Array<String>) {
    val login: String
    val password: String
    val isHelp: Boolean

    init {
        if ((args.isEmpty()) || ("-h" in args) || (args.size < 4)) {
            isHelp = true
            login = ""
            password = ""
        } else if (args.first() == "-login") {
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