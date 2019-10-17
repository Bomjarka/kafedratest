#!/bin/bash

kotlinc src/loginpass.kt -include-runtime -d loginpass.jar
echo -e

echo "Testing no parameters (5.1)"
echo "Excepted: FAQ"
echo "Actual:"
java -jar loginpass.jar
echo -e

echo "Testing -h parameter (5.2)"
echo "Excepted: FAQ"
echo "Actual:"
java -jar loginpass.jar -h
echo -e

echo "Testing login: admin password: admin (5.3)"
echo "Excepted: Login successeful"
echo "Actual:"
java -jar loginpass.jar -login admin -password admin
echo -e

echo "Testing login: user1 password: user (5.3)"
echo "Excepted: Login successeful"
echo "Actual:"
java -jar loginpass.jar -login user1 -password user
echo -e

echo "Testing password: admin login: admin (5.4)"
echo "Excepted: Login successeful"
echo "Actual:"
java -jar loginpass.jar -password admin -login admin
echo -e

echo "Testing password: user login: user1 (5.4)"
echo "Excepted: Login successeful"
echo "Actual:"
java -jar loginpass.jar -password user -login user1
echo -e

echo "Testing login: u$er1 password: user (5.5)"
echo "Excepted: Special symbols found"
echo "Actual:"
java -jar loginpass.jar -login u$er1 -password user
echo -e

echo "Testing login: @dmin password: admin (5.5)"
echo "Excepted: Special symbols found"
echo "Actual:"
java -jar loginpass.jar -login @dmin -password @dmin
echo -e

echo "Testing login: user242 password: user (5.6)"
echo "Excepted: User not found"
echo "Actual:"
java -jar loginpass.jar -login user242 -password user
echo -e


echo "Testing login: admin password: 1234 (5.7)"
echo "Excepted: Password incorrect"
echo "Actual:"
java -jar loginpass.jar -login admin -password 1234
echo -e

read