package com.chirkin.kafedratest

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType


class Params(args: Array<String>) {

    val login: String
    val password: String
    val role: String
    val resource: String
    val isHelp: Boolean
    val isAuth: Boolean

    private val parser = ArgParser("Input string")
    private val uLogin by parser.option(ArgType.String, fullName = "login", shortName = "log", description = "User login")
    private val uPassword by parser.option(ArgType.String, fullName = "password", shortName = "pwd", description = "user password")
    private val uRole by parser.option(ArgType.String, fullName = "role", shortName = "ro", description = "User role")
    private val uResource by parser.option(ArgType.String, fullName = "resource", shortName = "rs", description = "Resource")

    init {
        parser.parse(args)
        if (args.isEmpty() || ("-h" in args)){
            isHelp = true
            isAuth = false
            login = ""
            password = ""
            role = ""
            resource = ""
        } else if (args.size == 4) {
            isHelp = false
            isAuth = false
            login = uLogin!!
            password = uPassword!!
            role = ""
            resource = ""
        } else if (args.size == 8) {
            login = uLogin!!
            password = uPassword!!
            role = uRole!!
            resource = uResource!!
            isHelp = false
            isAuth = true
        }
        else  {
            isHelp = true
            isAuth = false
            login = ""
            password = ""
            role = ""
            resource = ""
        }


      /*  if ((args.isEmpty()) || ("-h" in args) || (args.size < 6)) {
            isHelp = true
            login = ""
            password = ""
            role = ""
            resource = ""
        } else if (uLogin != "" && uPassword != "" && uRole != "" && uResource != "") {
            login = uLogin.toString()
            password = uPassword.toString()
            role = uRole.toString()
            resource = uResource.toString()
            isHelp = false
        } else {
            isHelp = false
            login = ""
            password = ""
            role = ""
            resource = ""
        }*/
    }
}