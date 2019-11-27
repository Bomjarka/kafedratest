package com.chirkin.kafedratest

data class LoggingService(private val logsList: MutableList<String>) {
    var log: String = ""

    fun createLog(login: String, resource: String, role: String, ds: String, de: String, vol: String): String {
        log = "-login $login -resource $resource -role $role -date of start $ds -date of end $de -volume $vol"
        return log
    }

    fun addLog() {
        logsList.add(log)
    }

    fun printLogs() {
        logsList.forEach {
            println(it)
        }
    }
}
