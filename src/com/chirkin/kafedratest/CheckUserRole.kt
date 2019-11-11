package com.chirkin.kafedratest

class CheckUserRole(private val userList: List<User>, private val userRole: List<UserRole>) {

    fun isRole(role: String): Boolean {
        val roles = listOf(Role.Execute.role, Role.Read.role, Role.Write.role)
        return role in roles
    }

    fun isUserRole(login: String, role: String, resource: String): Boolean {
        var isUR = false
        userRole.forEach {
            if (it.user.login == login && it.role.role == role && it.resource == resource) isUR = true
        }
        return isUR
    }
}