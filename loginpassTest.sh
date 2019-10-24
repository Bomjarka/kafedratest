#!/bin/bash

kotlinc src/com/chirkin/kafedratest -include-runtime -d loginpass.jar
echo -e

echo "Testing no parameters (5.1)"
echo "Excepted: Exit code 1 (print Reference)"
echo "Actual:"
java -jar loginpass.jar
echo -e

echo "Testing -h parameter (5.2)"
echo "Excepted: Exit code 1 (print Reference)"
echo "Actual:"
java -jar loginpass.jar -h
echo -e

echo "Testing login: Admin password: admin (5.3)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual:"
java -jar loginpass.jar -login Admin -password admin
echo -e

echo "Testing login: User1 password: user (5.3)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual:"
java -jar loginpass.jar -login User1 -password user
echo -e

echo "Testing password: admin login: Admin (5.4)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual:"
java -jar loginpass.jar -password admin -login Admin
echo -e

echo "Testing password: ser login: User1 (5.4)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual:"
java -jar loginpass.jar -password user -login User1
echo -e

echo "Testing login: u\$er1 password: user (5.5)"
echo "Excepted: Exit code 2 (Login format incorrect)"
echo "Actual:"
java -jar loginpass.jar -login u'$'er1 -password user
echo -e

echo "Testing login: @dmin password: admin (5.5)"
echo "Excepted: Exit code 2 (Login format incorrect)"
echo "Actual:"
java -jar loginpass.jar -login @dmin -password @dmin
echo -e

echo "Testing login: User242 password: user (5.6)"
echo "Excepted: Exit code 3 (User not found)"
echo "Actual:"
java -jar loginpass.jar -login User242 -password user
echo -e


echo "Testing login: Admin password: 1234 (5.7)"
echo "Excepted: Exit code 4 (Password incorrect)"
echo "Actual:"
java -jar loginpass.jar -login Admin -password 1234
echo -e


echo "Testing login: Admin"
echo "Excepted: Exit code 1"
echo "Actual:"
java -jar loginpass.jar -login Admin
echo -e

echo "Testing blablablha"
echo "Excepted: Exit code 1"
echo "Actual:"
java -jar loginpass.jar -login Admin
echo -e

read