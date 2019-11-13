package com.chirkin.kafedratest

enum class Role {
    READ, WRITE, EXECUTE;

    companion object {
        fun isRole(role: String): Boolean {
            var isR = false
            values().forEach {
                isR = it.name == role
            }
            return isR
        }
    }

}