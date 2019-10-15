kotlinc src/app.kt -include-runtime -d out/stringTest.jar
java -jar out/stringTest.jar Hello great world
java -jar out/stringTest.jar the quick brown fox jumps over the lazy dog
java -jar out/stringTest.jar Software engineering is very interesting!
echo "the quick brown fox jumps over the lazy dog" | java -jar out/stringTest.jar
echo "blah blah bla" | java -jar out/stringTest.jar
echo "Software engineering is very interesting!" | java -jar out/stringTest.jar
pause