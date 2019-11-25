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
    val dateStart: String
    val dateEnd: String
    val volume: Int

    private val parser = ArgParser("Input string")
    private val uLogin by parser.option(ArgType.String, fullName = "login", shortName = "log", description = "User login")
    private val uPassword by parser.option(ArgType.String, fullName = "password", shortName = "pwd", description = "user password")
    private val uRole by parser.option(ArgType.String, fullName = "role", shortName = "ro", description = "User role")
    private val uResource by parser.option(ArgType.String, fullName = "resource", shortName = "rs", description = "Resource")
    private val udateStart by parser.option(ArgType.String, fullName = "dateStart", shortName = "ds", description = "Date start")
    private val udateEnd by parser.option(ArgType.String, fullName = "dateEnd", shortName = "de", description = "Date end")
    private val uvolume by parser.option(ArgType.String, fullName = "volume", shortName = "vol", description = "Volume")

    init {
        parser.parse(args)
        if (args.isEmpty() || ("-h" in args)) {
            isHelp = true
            isAuth = false
            login = ""
            password = ""
            role = ""
            resource = ""
            dateStart = ""
            dateEnd = ""
            volume = 0
        } else if (args.size == 4 && uLogin != null && uPassword != null) {
            isHelp = false
            isAuth = false
            login = uLogin!!
            password = uPassword!!
            role = ""
            resource = ""
            dateStart = ""
            dateEnd = ""
            volume = 0
        } else if (args.size == 8) {
            login = uLogin!!
            password = uPassword!!
            role = uRole!!
            resource = uResource!!
            dateStart = udateStart!!
            dateEnd = udateEnd!!
            volume = 0
            isHelp = false
            isAuth = true
        } else {
            isHelp = true
            isAuth = false
            login = ""
            password = ""
            role = ""
            resource = ""
            dateStart = ""
            dateEnd = ""
            volume = 0
        }
    }
}