#!/bin/bash

echo -e "Starting compilation"
kotlinc -cp lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar src/com/chirkin/kafedratest  -include-runtime -d loginpass.jar
echo -e
echo -e "Starting tests"

echo "Testing no parameters (5.1)"
echo "Excepted: Exit code 1 (print Reference)"
echo "Actual: "
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt
echo -e


echo "Testing -h parameter (5.2)"
echo "Excepted: Exit code 1 (print Reference)"
echo "Actual: "
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt -h
echo -e

echo "Testing login: Admin password: admin (5.3)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual:"
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --login Admin --password admin
echo -e



echo "Testing login: User1 password: user (5.3)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual: "
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --login User1 --password user
echo -e

echo "Testing password: admin login: Admin (5.4)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual: "
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --password admin --login Admin
echo -e

echo "Testing password: ser login: User1 (5.4)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual: "
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --password user --login User1
echo -e

echo "Testing login: u\$er1 password: user (5.5)"
echo "Excepted: Exit code 2 (Login format incorrect)"
echo "Actual: "
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --login u$er1 --password user
echo -e

echo "Testing login: @dmin password: admin (5.5)"
echo "Excepted: Exit code 2 (Login format incorrect)"
echo "Actual: "
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --login @dmin --password @dmin
echo -e

echo "Testing login: User242 password: user (5.6)"
echo "Excepted: Exit code 3 (User not found)"
echo "Actual: "
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --login User242 --password user
echo -e


echo "Testing login: Admin password: 1234 (5.7)"
echo "Excepted: Exit code 4 (Password incorrect)"
echo "Actual: "
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --login Admin --password 1234
echo -e

echo "Testing login: Admin"
echo "Excepted: Exit code 1"
echo "Actual: "
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --login Admin
echo -e

echo "Testing blablablha"
echo "Excepted: Exit code 1"
echo "Actual: "
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --login Admin
echo -e


echo "Testing login: Admin password: admin role: EXECUTE resource: A.BC (5.8)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual: "
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --login Admin --password admin --role EXECUTE --resource A.BC
echo -e

echo "Testing login: User1 password: user role: READ resource: A.BC.D.E (5.8)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual":
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --login User1 --password user --role READ --resource A.BC.D.E
echo -e

echo "Testing  password: admin role: EXECUTE login: Admin resource: A.BC (5.9)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual":
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --password admin --role EXECUTE --login Admin  --resource A.BC
echo -e

echo "Testing login: Admin password: admin role: DELETE resource: A.BC (5.10)"
echo "Excepted: Exit code 5 (Role unknown)"
echo "Actual":
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --login Admin --password admin --role DELETE --resource A.BC
echo -e

echo "Testing login: Admin password: admin role: EXECUTE resource: A.BC.EF (5.10)"
echo "Excepted: Exit code 6 (Success do this resource is denied)"
echo "Actual":
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar" com.chirkin.kafedratest.LoginpassKt --login Admin --password admin --role EXECUTE --resource A.BC.EF
echo -e
read