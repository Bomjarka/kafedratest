@echo off
kotlinc src/loginpass.kt -include-runtime -d loginpass.jar
echo.
java -jar loginpass.jar -h
echo.

echo Testing login: admin password: admin
echo Excepted: Login successeful
echo Actual:
java -jar loginpass.jar 1 admin 2 admin
echo.

echo Testing login: admin password: 1234
echo Excepted: Something goes wrong
echo Actual:
java -jar loginpass.jar 1 admin 2 1234

echo.
echo Testing login: user1 password: user
echo Excepted: Login successeful
echo Actual:
java -jar loginpass.jar 1 user1 2 user
echo.

echo Testing login: user1 password: admin
echo Excepted: Something goes wrong
echo Actual:
java -jar loginpass.jar 1 user1 2 admin

pause