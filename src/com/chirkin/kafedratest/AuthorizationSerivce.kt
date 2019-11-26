package com.chirkin.kafedratest

class AuthorizationSerivce(private val userRole: List<UserRole>) {

    fun isUserRole(login: String, role: String, resource: String): Boolean {
        var isUR = false
        userRole.forEach {
            if (it.user.login == login && it.role.name == role && it.resource == resource) isUR = true
        }
        return isUR
    }
}