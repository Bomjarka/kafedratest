// file app.kt

fun main(args: Array<String>) {
    var sent = ""
    for (arg in args) {
        sent += "$arg "
    }
    if (sent != "")
        fourthLevel(sent)
    else {
        sent = generateSequence(::readLine).joinToString(" \n").replace("\"".toRegex(), "")
        fourthLevel(sent)
    }
}

fun fourthLevel(sent: String) //Функция 4го задания
{
    val words = sent.split(" ").sorted().drop(1) /* Разбиваем строку и сортируем по порядку */
    val words1 = words /* Создаём дубликат строки для поиска повторений */
    var count = 0 /* Перемнная с количеством повторений */
    var currentSent = "" /* Создаём пустую строку для записи новой строки */

    for (word in words) { /* Проходим по всем словам 1й строки */
        for (word1 in words1) { /* Проходим по всем словам 2й строки */
            if (word == word1) {
                count++
            }
        }
        currentSent += ("$word-$count ") /* Добавляем новое содержимое */
        count = 0
    }
    val sent1 = currentSent.split(" ").sorted()
    val sent2 = sent1.union(sent1)
    for (word in sent2) {
        println(word)
    }
}

