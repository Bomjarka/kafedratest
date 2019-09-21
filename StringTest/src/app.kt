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

fun Tasks(task:String , inText:String)
{
    val stdin = "the quick brown fox jumps over the lazy dog"
    if (!checkInput(inText)){
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

fun firstlvl(sent:String)
{
    println("\nLVL1\n")
    val words = sent.split(" ")
    for (word in words)
    {
        println(word)
    }
}

fun secondlvl(sent:String)
{
    println("\nLVL2\n")
    val words = sent.split(" ").sorted()
    for (word in words)
    {
        println(word)
    }
}

fun thirdlvl(sent:String)
{
    println("\nLVL3\n")
    var words = sent.split(" ").sorted()
    var words1=words.union(words)
    for (word in words1) {
        println(word)
    }
}

fun fourthlvl(sent:String)
{
    println("\nLVL4")
    var words = sent.split(" ").sorted()
    var words1=words
    var count=0
    var cursent:String=""
    for (word in words)
    {
        for (word1 in words1)
        {
            if (word == word1)
            {
                count++;
            }
        }
        cursent+=("$word-$count ")
        count=0
    }
        var sent1 = cursent.split(" ").sorted()
        var sent2 = sent1.union(sent1)
        for (word in sent2)
        {
            println(word)
        }
}

fun checkInput(sent:String):Boolean {
    var status=true
    if (sent == "") {
        println("Вы не ввели ничего")
        status=false
    } else {
        status=true
    }
    return status
}

fun readText():String
{
    println("Введите произвольную строку")
    val text:String = readLine().toString()
    return text
}
