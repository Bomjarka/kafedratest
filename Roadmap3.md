1. Для логгирования данных используем библиотеку Log4j
    1. Подключим библиотеку
    2. Настроим конфиг файл
2. Для хранения данных подключим СУБД H2
    1. Установить H2
    2. Установить API Flyway для инициализации схемы данных
3. Создать таблицы с данными
    1. Таблица User: id - int (ai), login - string, password - string
    2. Таблица Role: id - int(ai), role - string
    3. Таблица UserRole: id - int(ai), user_id, role_id, resource_id
    4. Таблица Resource: id - int(ai), resource - string
4. Для работы с данными использовать PreparedStatement (http://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
5. Проверить код приложения на соответствие SOLID

    
