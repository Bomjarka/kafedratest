package com.chirkin.kafedratest


class Params(private val args: Array<String>) {

    var isHelp = false
    var login: String = ""
    var password: String = ""
    var list = listOf("")
        get() {
            if (args.isEmpty()) {
                isHelp = true
                printReference()
            } else {
                if ("-h" in this.args) {
                    printReference()
                    isHelp = true
                } else {
                    if (args.first() == "-login") {
                        login = args[1]
                        password = args[3]
                    } else {
                        login = args[3]
                        password = args[1]
                    }
                }
            }

            list = listOf(login, password)
            return field
        }
}