import java.io.Console
import java.lang.NumberFormatException

fun main (args: Array<String>){
        var sent = readText()
        println("Укажите №Задания")
        var task = readLine()
        if (task != null) {
            Tasks(task,sent)
        }
}

fun Tasks(task:String , inText:String) //Функция определяющая выбранное задание
{   
    val stdin = "the quick brown fox jumps over the lazy dog" //стандартная строка при отсутствии ввода
    if (!checkInput(inText)){ //проверяем что введено пользователем
        fourthlvl(stdin)
    }
    else{
        var curTask:Int = try {
            task.toInt()
        }
        catch (e:NumberFormatException)
        {
            println("Необходимо вводить только численные значения")
        } as Int

        when (curTask)
        {
            1->firstlvl(inText)
            2->secondlvl(inText)
            3->thirdlvl(inText)
            4->fourthlvl(inText)
            else->println("Такого задания нет!")
        }
    }

}

fun firstlvl(sent:String) //Функция 1го задания
{
    println("\nLVL1\n")
    val words = sent.split(" ") //Разделяем строку на слова
    for (word in words) //Выводим все слова строки
    {
        println(word)
    }
}

fun secondlvl(sent:String) //Функция 2го задания
{
    println("\nLVL2\n")
    val words = sent.split(" ").sorted() //Разбиваем строку и сортируем по порядку
    for (word in words) //Выводим все слова строки
        {
        println(word)
    }
}

fun thirdlvl(sent:String) //Функция 3го задания
{
    println("\nLVL3\n")
    var words = sent.split(" ").sorted()  //Разбиваем строку и сортируем по порядку
    var words1=words.union(words) //Объединяем 2 одинаковых строки для исколючения повторений
    for (word in words1) { //Выводим все слова строки
        println(word)
    }
}

fun fourthlvl(sent:String) //Функция 4го задания
{
    println("\nLVL4")
    var words = sent.split(" ").sorted() //Разбиваем строку и сортируем по порядку
    var words1=words //Создаём дубликат строки для поиска повторений
    var count=0 //Перемнная с количеством повторений
    var cursent:String="" //Создаём пустую строку для записи новой строки
    for (word in words) //Проходим по всем словам 1й строки
    {
        for (word1 in words1) //Проходим по всем словам 2й строки
        {
            if (word == word1) //Ищем совпадения
            {
                count++;
            }
        }
        cursent+=("$word-$count ") //Добавляем новое содержимое
        count=0
    }
        var sent1 = cursent.split(" ").sorted() //Разбиваем строку и сортируем по порядку
        var sent2 = sent1.union(sent1) //Объединяем 2 одинаковых строки для исколючения повторений
        for (word in sent2) //Выводим все подстроки итоговой строки
        {
            println(word)
        }
}

fun checkInput(sent:String):Boolean { //Функция проверки ввода
    var status=true //Определяет статус ввода true - что то введено
    if (sent == "") {
        println("Вы не ввели ничего")
        status=false
    } else {
        status=true
    }
    return status
}

fun readText():String //Функция чтения текста с консоли
{
    println("Введите произвольную строку")
    val text:String = readLine().toString()
    return text
}
