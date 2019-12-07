#!/bin/bash
checkExitCode(){
  if [ "$1" -ne "$2" ]; then
  let fails=fails+1
fi
}

printResult(){
  if [ "$fails" -ne "$success" ]; then
    echo "Some tests have been failed"
  else
    echo "All test have been passed successful"
fi
}

classpath="lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar:loginpass.jar"
fails=0
success=0

echo -e "Starting compilation"
kotlinc -cp lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar src -include-runtime -d loginpass.jar
echo -e
echo -e "Starting tests"


echo "Testing no parameters (5.1)"
echo "Excepted: Exit code 1 (print Reference)"
echo "Actual: "
java -cp $classpath com.chirkin.kafedratest.LoginpassKt
actual=$?
expected=1
checkExitCode $actual $expected
echo -e

echo "Testing -h parameter (5.2)"
echo "Excepted: Exit code 0 (print Reference)"
echo "Actual: "
java -cp $classpath com.chirkin.kafedratest.LoginpassKt -h
actual=$?
expected=0
echo -e

echo "Testing login: Admin password: admin (5.3)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual:"
checkExitCode $actual $expected
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --login Admin --password admin
actual=$?
expected=0
checkExitCode $actual $expected
echo -e

echo "Testing login: User1 password: user (5.3)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual: "
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --login User1 --password user
actual=$?
expected=0
checkExitCode $actual $expected
echo -e

echo "Testing password: admin login: Admin (5.4)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual: "
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --password admin --login Admin
actual=$?
expected=0
checkExitCode $actual $expected
echo -e

echo "Testing password: ser login: User1 (5.4)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual: "
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --password user --login User1
actual=$?
expected=0
checkExitCode $actual $expected
echo -e

echo "Testing login: u\$er1 password: user (5.5)"
echo "Excepted: Exit code 2 (Login format incorrect)"
echo "Actual: "
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --login u\$er1 --password user
actual=$?
expected=2
checkExitCode $actual $expected
echo -e

echo "Testing login: @dmin password: admin (5.5)"
echo "Excepted: Exit code 2 (Login format incorrect)"
echo "Actual: "
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --login @dmin --password @dmin
actual=$?
expected=2
checkExitCode $actual $expected
echo -e

echo "Testing login: User242 password: user (5.6)"
echo "Excepted: Exit code 3 (User not found)"
echo "Actual: "
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --login User242 --password user
actual=$?
expected=3
checkExitCode $actual $expected
echo -e


echo "Testing login: Admin password: 1234 (5.7)"
echo "Excepted: Exit code 4 (Password incorrect)"
echo "Actual: "
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --login Admin --password 1234
actual=$?
expected=4
checkExitCode $actual $expected
echo -e

echo "Testing login: Admin"
echo "Excepted: Exit code 1"
echo "Actual: "
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --login Admin
actual=$?
expected=1
checkExitCode $actual $expected
echo -e

echo "Testing blablablha"
echo "Excepted: Exit code 1"
echo "Actual: "
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --login Admin
actual=$?
expected=1
checkExitCode $actual $expected
echo -e


echo "Testing login: Admin password: admin role: EXECUTE resource: A.BC (5.8)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual: "
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --login Admin --password admin --role EXECUTE --resource A.BC
actual=$?
expected=0
checkExitCode $actual $expected
echo -e

echo "Testing login: User1 password: user role: READ resource: A.BC.D.E (5.8)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual":
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --login User1 --password user --role READ --resource A.BC.D.E
actual=$?
expected=0
checkExitCode $actual $expected
echo -e

echo "Testing  password: admin role: EXECUTE login: Admin resource: A.BC (5.9)"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual":
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --password admin --role EXECUTE --login Admin  --resource A.BC
actual=$?
expected=0
checkExitCode $actual $expected
echo -e

echo "Testing login: Admin password: admin role: DELETE resource: A.BC (5.10)"
echo "Excepted: Exit code 5 (Role unknown)"
echo "Actual":
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --login Admin --password admin --role DELETE --resource A.BC
actual=$?
expected=5
checkExitCode $actual $expected
echo -e

echo "Testing login: Admin password: admin role: EXECUTE resource: A.BC.EF (5.10)"
echo "Excepted: Exit code 6 (Success do this resource is denied)"
echo "Actual":
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --login Admin --password admin --role EXECUTE --resource A.BC.EF
actual=$?
expected=6
checkExitCode $actual $expected
echo -e

echo "Testing  password: admin role: EXECUTE login: Admin resource: A.BC (5.9) -ds 2019-11-26, -de 2019-11-27, -vol 25"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual":
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --password admin --role EXECUTE --login Admin  --resource A.BC -ds 2019-11-26 -de 2019-11-27 -vol 25
actual=$?
expected=0
checkExitCode $actual $expected
echo -e

echo "Testing  password: admin role: EXECUTE login: Admin resource: A.BC (5.9) -ds 2019-11-261, -de 2019-11-27, -vol 25"
echo "Excepted: Exit code 7 (Invalid Date or Volume)"
echo "Actual":
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --password admin --role EXECUTE --login Admin  --resource A.BC -ds 2019-11-261 -de 2019-11-27 -vol 25
actual=$?
expected=7
checkExitCode $actual $expected
echo -e

echo "Testing  password: admin role: EXECUTE login: Admin resource: A.BC (5.9) -ds 2019-11-26, -de 2019-11-57, -vol 25"
echo "Excepted: Exit code 7 (Invalid Date or Volume)"
echo "Actual":
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --password admin --role EXECUTE --login Admin  --resource A.BC -ds 2019-11-26 -de 2019-11-57 -vol 25
actual=$?
expected=7
checkExitCode $actual $expected
echo -e

echo "Testing  password: admin role: EXECUTE login: Admin resource: A.BC (5.9) -ds 2019-11-26, -de 2019-11-27, -vol ten"
echo "Excepted: Exit code 7 (Invalid Date or Volume)"
echo "Actual":
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --password admin --role EXECUTE --login Admin  --resource A.BC -ds 2019-11-26 -de 2019-11-27 -vol ten
actual=$?
expected=7
checkExitCode $actual $expected
echo -e

echo "Testing  password: admin role: EXECUTE login: Admin resource: A.BC (5.9) -ds 2019-11-26,  -vol 25, -de 2019-11-27"
echo "Excepted: Exit code 0 (Login successful)"
echo "Actual":
java -cp $classpath com.chirkin.kafedratest.LoginpassKt --password admin --role EXECUTE --login Admin  --resource A.BC -ds 2019-11-26 -vol 25 -de 2019-11-27
actual=$?
expected=0
checkExitCode $actual $expected
echo -e

printResult

