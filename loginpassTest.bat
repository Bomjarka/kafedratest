@echo off
kotlinc src/loginpass.kt -include-runtime -d loginpass.jar
echo.
echo "Project has been compiled"
echo.
java -jar loginpass.jar -h
echo.
java -jar loginpass.jar 1 admin 2 admin
echo.
java -jar loginpass.jar 1 admin 2 1234
echo.
java -jar loginpass.jar 1 user 2 user1
echo.
java -jar loginpass.jar 1 user 2 admin
echo.
java -jar loginpass.jar 
echo.
pause