package com.chirkin.kafedratest

data class Users(val login: String, val password: String)

val usersList = listOf(
        Users("admin", "admin"),
        Users("user1", "user")
)