fun main(args: Array<String>) {

    val validateService = ValidateService()

    if (args.isEmpty()) {
        throwFAQ()
    } else {
        val params = Params(args[0])
        if (args.size == 4) {
            if (params.argOrd()) validateService.validate(args[1], args[3])
            else validateService.validate(args[3], args[1])
        } else if (args[0] == "-h") throwFAQ()
    }
}

data class Users(val login: String, val password: String)

val usersList = listOf(
        Users("admin", "admin"),
        Users("user1", "user")
)

class ValidateService {
    fun validate(login: String, password: String) {
        if (isLoginCorrect(login)) {
            val user = findUser(login)
            if (user != null) {
                if (ispasscorrect1(user, password)) println("0 - SUCCESS") else println("4 - Password incorrect")
            } else println("3 - User not found")
        } else {
            println("2 - login format incorrect")
        }
    }

    private fun isLoginCorrect(login: String): Boolean {
        val invalidChars = listOf("$", "@", "!", "#", "%", "^", "&", "*")
        var i = 0
        var count = 0
        while (i < login.length) {
            if (login.contains(invalidChars[i])) {
                count++
                i++
            } else i++
        }
        return count == 0
    }

    private fun findUser(login: String): Users? {
        return usersList.findLast { item -> item.login == login }
    }

    private fun ispasscorrect1(user: Users?, password: String): Boolean {
        return user != null && password == user.password
    }
}

class Params(private val log: String?) {
    fun argOrd(): Boolean {
        return log == "-login"
    }
}

fun throwFAQ() = println("1 - FAQ")

