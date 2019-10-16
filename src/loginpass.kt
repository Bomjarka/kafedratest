fun main(args: Array<String>) {
    if (args[0] == "-h") {
        throwFAQ()
    } else {
        val admin = Users("admin", "admin")
        println("${admin.login} ${admin.password}")
    }


}

data class Users(val login: String, val password: String)

fun throwFAQ() = println("Это справка по работе с программой")

