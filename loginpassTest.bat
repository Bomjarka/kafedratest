@echo off
kotlinc src/com/chirkin/kafedratest -include-runtime -d loginpass.jar
echo.

echo Testing no parameters (5.1)
echo Excepted: FAQ
echo Actual:
java -jar loginpass.jar
echo.

echo Testing -h parameter (5.2)
echo Excepted: FAQ
echo Actual:
java -jar loginpass.jar -h
echo.

echo Testing login: Admin password: admin (5.3)
echo Excepted: Login successeful
echo Actual:
java -jar loginpass.jar -login Admin -password admin
echo.

echo Testing login: User1 password: user (5.3)
echo Excepted: Login successeful
echo Actual:
java -jar loginpass.jar -login User1 -password user
echo.

echo Testing password: admin login: Admin (5.4)
echo Excepted: Login successeful
echo Actual:
java -jar loginpass.jar -password admin -login Admin
echo.

echo Testing password: user login: User1 (5.4)
echo Excepted: Login successeful
echo Actual:
java -jar loginpass.jar -password user -login User1
echo.

echo Testing login: u$er1 password: user (5.5)
echo Excepted: login format incorrect
echo Actual:
java -jar loginpass.jar -login u$er1 -password user
echo.

echo Testing login: @dmin password: admin (5.5)
echo Excepted: login format incorrect
echo Actual:
java -jar loginpass.jar -login @dmin -password @dmin
echo.

echo Testing login: User242 password: user (5.6)
echo Excepted: User not found
echo Actual:
java -jar loginpass.jar -login User242 -password user
echo.


echo Testing login: Admin password: 1234 (5.7)
echo Excepted: Password incorrect
echo Actual:
java -jar loginpass.jar -login Admin -password 1234
echo.

pause