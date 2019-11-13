package com.chirkin.kafedratest

enum class Role {
    READ, WRITE, EXECUTE;

    companion object {
        fun isRole(role: String): Boolean {
            val roles = listOf(Role.EXECUTE.name, Role.READ.name, Role.WRITE.name)
            return role in roles
        }
    }
}