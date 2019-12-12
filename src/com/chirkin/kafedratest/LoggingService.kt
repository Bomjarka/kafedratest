package com.chirkin.kafedratest

import org.apache.logging.log4j.LogManager;

data class LoggingService(private val logsList: MutableList<String>) {
    var log: String = ""
    private val logger = LogManager.getLogger()

    fun createLog(login: String, resource: String, role: String, ds: String, de: String, vol: String): String {
        log = "-login $login -resource $resource -role $role -date of start $ds -date of end $de -volume $vol"
        return log
    }

    fun addLog() {
        logger.info(log)
    }

}
