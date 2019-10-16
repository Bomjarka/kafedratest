@echo off
kotlinc src/app.kt -include-runtime -d stringTest.jar
echo "Project has been compiled"
echo.
echo "Checking string Hello great world; Await: great-1 Hello-1 world-1"
java -jar stringTest.jar Hello great world
echo.
echo "Checking string the quick brown fox jumps over the lazy dog; Await: brown-1 dog-1 fox-1 jumps-1 lazy-1 over-1 quick-1 the-2"
java -jar stringTest.jar the quick brown fox jumps over the lazy dog
echo.
echo "Checking string software engineering is very interesting!; Await: engineering-1 interesting-1 is-1 software-1 very-1"
java -jar stringTest.jar software engineering is very interesting!
echo.
echo "Checking string the quick brown fox jumps over the lazy dog; Await: brown-1 dog-1 fox-1 jumps-1 lazy-1 over-1 quick-1 the-2"
echo "the quick brown fox jumps over the lazy dog" | java -jar stringTest.jar
echo.
echo "Checking string blah blah bla; Await: bla-1 blah-2"
echo "blah blah bla" | java -jar stringTest.jar
echo "Software engineering is very interesting!" | java -jar stringTest.jar
pause