fun main(args: Array<String>) {


    if (args.size == 4) {
        checkAuth(args[1], args[3])
    } else if (args[0] == "-h")
        throwFAQ()
}

data class Users(val login: String, val password: String)

val usersCollection = mapOf("admin" to "admin", "user1" to "user")

fun throwFAQ() = println("Это справка по работе с программой")

fun checkAuth(login: String, pass: String) {
    if (login in usersCollection) {
        if (pass == usersCollection[login])
            println("Login successful") else println("Something goes wrong")
    }
}