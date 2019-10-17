fun main(args: Array<String>) {
    val userscollection = mapOf("admin" to "admin", "user" to "user1")

    if (args.size == 4) {
        if (args[1] in userscollection) {
            if (args[3] == userscollection[args[1]])
                println("ALRIGHT") else println("Password is wrong")
        }
    } else if (args[0] == "-h")
        throwFAQ()
}

data class Users(val login: String, val password: String)

fun throwFAQ() = println("Это справка по работе с программой")

