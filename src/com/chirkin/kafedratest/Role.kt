package com.chirkin.kafedratest

enum class Role {
    READ, WRITE, EXECUTE;

    companion object {
        fun isRole(role: String) = values().any { it.name == role }
    }

}