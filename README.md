# kafedratest [![Build Status](https://travis-ci.org/Bomjarka/kafedratest.svg?branch=master)](https://travis-ci.org/Bomjarka/kafedratest)
Приложение для работы со строками.
Данное приложение анализирует получаемую на входе строку, подсчитывает количество каждого слова в данной строке,
убирает дубликате и создаёт новую строку, упорядоченную в алфавитном порядке

Приложение самостоятельно компилирует исполняемый файл и запускает серию тестов

Для запуска приложения необходимо сделать следующее

Windows 
1. Скачать архив с проектом и запустить скрипт scriptTest.bat 

Linux 
1. Скачать архив с проектом и запустить скрипт linuxScript.sh

Программа для авторизации пользователей.
Программа получает строку с параметрами на входе, разбирает данные параметры и производит следующие действия
1. Если логин и пароль верны, то пользователь проходит авторизацию
2. Если Роль пользователя и доступ к ресурсу, то пользователь проходит аутентификацию
3. Если введённые даты и объём данных верны, то пользователь проходит процедуру аккаунтинга
Приложение самостоятельно компилирует исполняемый файл и проводит серию тестов, покрывающих варианты использования

Ссылка на roadmap https://github.com/Bomjarka/kafedratest/blob/master/developmentplan
Linux 
1. Скачать архив с проектом и запустить скрипт loginpassTest.sh
2. Для запуска в ручном режиме необходимо в консоли прописать следующие команды
    
    2.1. Для компиляции программы kotlinc -cp lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar src -include-runtime -d loginpass.jar
 
    2.2. Для запуска программы java -cp $classpath com.chirkin.kafedratest.LoginpassKt, где $classpath это lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar
 
    2.3. Для запуска программы необходимо прописать java -cp $classpath com.chirkin.kafedratest.LoginpassKt и далее указать необходимые параметры через --
 
    2.4. Список параметров: --login --password --role --resource -ds -de -vol

[![Build Status](https://travis-ci.org/Bomjarka/kafedratest.svg?branch=master)](https://travis-ci.org/Bomjarka/kafedratest)
