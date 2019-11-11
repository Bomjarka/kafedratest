package com.chirkin.kafedratest

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required


class Params(args: Array<String>) {

    val login: String
    val password: String
    val role: String
    val resource: String
    val isHelp: Boolean

    private val parser = ArgParser("Input string")
    private val uLogin by parser.option(ArgType.String, fullName = "login", shortName = "log", description = "User login").required()
    private val uPassword by parser.option(ArgType.String, fullName = "password", shortName = "pwd", description = "user password").required()
    private val uRole by parser.option(ArgType.String, fullName = "role", shortName = "ro", description = "User login").required()
    private val uResource by parser.option(ArgType.String, fullName = "resource", shortName = "rs", description = "user password").required()

    init {
        parser.parse(args)
        if ((args.isEmpty()) || ("-h" in args) || (args.size < 6)) {
            isHelp = true
            login = ""
            password = ""
            role = ""
            resource = ""
        } else if (uLogin != "" && uPassword != "" && uRole != "" && uResource != "") {
            login = uLogin
            password = uPassword
            role = uRole
            resource = uResource
            isHelp = false
        } else {
            isHelp = false
            login = ""
            password = ""
            role = ""
            resource = ""
        }
    }
}