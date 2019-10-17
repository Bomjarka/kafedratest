fun main(args: Array<String>) {


    if (args.isEmpty()) throwFAQ() else {
        if (args.size == 4) {
            if (argsOrder(args[0])) {
                if (isloginCorrect(args[1])) {
                    if (isloginExists(args[1])) {
                        if (ispasswordCorrect(args[1], args[3])) println("0 - SUCCESS") else println("4 - Password incorrect")
                    } else println("3 - User not found")
                } else println("2 - Special symbols found")
            } else {
                if (isloginCorrect(args[3])) {
                    if (isloginExists(args[3])) {
                        if (ispasswordCorrect(args[3], args[1])) println("0 - SUCCESS") else println("4 - Password incorrect")
                    } else println("3 - User not found")
                } else println("2 - Special symbols found")
            }
        } else if (args[0] == "-h") {
            throwFAQ()
        }
    }
}

data class Users(val login: String, val password: String)

val usersList = listOf(
        Users("admin", "admin"),
        Users("user1", "user")
)


fun isloginExists(login: String): Boolean {
    val res = usersList.find { item -> item.login == login }
    return res != null
}

fun isloginCorrect(login: String): Boolean {
    val invalidchars = listOf("$", "@", "!", "#", "%", "^", "&", "*")
    var i = 0
    var count = 0
    while (i < login.length) {
        if (login.contains(invalidchars[i])) {
            count++
            i++
        } else i++
    }
    return count == 0
}

fun ispasswordCorrect(login: String, password: String): Boolean {
    val res = usersList.find { (login1, password1) -> login1 == login; password1 == password }
    return res != null
}

fun throwFAQ() = println("1 - FAQ")

fun argsOrder(param: String): Boolean {
    return param == "-login"
}