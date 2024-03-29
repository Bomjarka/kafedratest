package com.chirkin.kafedratest

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType


class Params(args: Array<String>) {

    val login: String
    val password: String
    val role: String
    val resource: String
    val isHelp: Boolean
    val isAuthen: Boolean
    val isAcc: Boolean
    val dateStart: String
    val dateEnd: String
    val volume: String

    private val parser = ArgParser("Input string")
    private val uLogin by parser.option(ArgType.String, fullName = "login", shortName = "log", description = "User login")
    private val uPassword by parser.option(ArgType.String, fullName = "password", shortName = "pwd", description = "user password")
    private val uRole by parser.option(ArgType.String, fullName = "role", shortName = "ro", description = "User role")
    private val uResource by parser.option(ArgType.String, fullName = "resource", shortName = "rs", description = "Resource")
    private val udateStart by parser.option(ArgType.String, fullName = "dateStart", shortName = "ds", description = "Date start")
    private val udateEnd by parser.option(ArgType.String, fullName = "dateEnd", shortName = "de", description = "Date end")
    private val uvolume by parser.option(ArgType.String, fullName = "vol", shortName = "vol", description = "Volume")

    init {
        parser.parse(args)
        if (args.isEmpty() || ("-h" in args)) {
            isHelp = true
            isAuthen = false
            isAcc = false
            login = ""
            password = ""
            role = ""
            resource = ""
            dateStart = ""
            dateEnd = ""
            volume = ""
        } else if (args.size == 4 && uLogin != null && uPassword != null) {
            isHelp = false
            isAuthen = false
            isAcc = false
            login = uLogin!!
            password = uPassword!!
            role = ""
            resource = ""
            dateStart = ""
            dateEnd = ""
            volume = ""
        } else if (args.size == 8 && uLogin != null && uPassword != null) {
            login = uLogin!!
            password = uPassword!!
            role = uRole!!
            resource = uResource!!
            isHelp = false
            isAuthen = true
            isAcc = false
            dateStart = ""
            dateEnd = ""
            volume = ""
        } else if (args.size == 14 && uLogin != null && uPassword != null) {
            login = uLogin!!
            password = uPassword!!
            role = uRole!!
            resource = uResource!!
            isHelp = false
            isAuthen = false
            isAcc = true
            dateStart = udateStart!!
            dateEnd = udateEnd!!
            volume = uvolume!!
        } else {
            isHelp = true
            isAuthen = false
            isAcc = false
            login = ""
            password = ""
            role = ""
            resource = ""
            dateStart = ""
            dateEnd = ""
            volume = ""
        }
    }
}