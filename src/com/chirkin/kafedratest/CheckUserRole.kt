package com.chirkin.kafedratest

class CheckUserRole (private val userList: List<User>, val userRole: List<UserRole>) {


    fun getUser(login: String): User? {
        return userList.findLast { item -> item.login == login }
    }

    fun isRole(role: Role): Boolean {
        val roles = listOf(Role.Execute,Role.Read,Role.Write)
        return role in roles
    }

//    Проверка совпадения логина и роли, но получается дичь, до этого ещё пытался сделать через цикл в цикле, не коммитил и не могу откатить до той попытки
//    fun isURole(user: User, role: Role): Boolean {
//        var isF = false
//        if (userList.findLast { item: User -> item.login == user.login } != null && userRole.findLast { item: UserRole -> item.role == role } != null )
//            println("found")
//        else println("not found")
//
//        return isF
//    }
}