package com.chirkin.kafedratest

class CheckUserRole (private val userList: List<User>, val userRole: List<UserRole>) {

    fun getUser(login: String): User? {
        return userList.findLast { item -> item.login == login }
    }

    fun isRole(role: Role): Boolean {
        val roles = listOf(Role.execute,Role.read,Role.write)
        return role in roles
    }




}