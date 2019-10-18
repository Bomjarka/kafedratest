import loginpasspackage.Params
import loginpasspackage.ValidateService

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


fun throwFAQ() = println("1 - FAQ")

