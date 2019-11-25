package com.chirkin.kafedratest

import java.time.LocalDateTime

data class Logs(val user: User, val resource: String, val role: Role, val ds: LocalDateTime, val de: LocalDateTime, val vol: Int) {

    fun createLog() {

    }
}
