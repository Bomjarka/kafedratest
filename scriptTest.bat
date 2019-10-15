kotlinc src/app.kt -include-runtime -d stringTest.jar
java -jar stringTest.jar Hello great world
java -jar stringTest.jar the quick brown fox jumps over the lazy dog
java -jar stringTest.jar Software engineering is very interesting!
echo "the quick brown fox jumps over the lazy dog" | java -jar stringTest.jar
echo "blah blah bla" | java -jar stringTest.jar
echo "Software engineering is very interesting!" | java -jar stringTest.jar
pause