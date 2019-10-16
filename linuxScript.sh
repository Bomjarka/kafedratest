#!/bin/bash
kotlinc kotlinc kafedratest/src/app.kt -include-runtime -d stringTest.jar
java -jar stringTest.jar Hello great world
java -jar stringTest.jar the quick brown fox jumps over the lazy dog
java -jar stringTest.jar Software engeneering is very interesting!
java -jar stringTest.jar 123458
echo "the quick brown fox jumps over the lazy dog" | java -jar stringTest.jar
echo "blah blah bla" | java -jar stringTest.jar
echo "Software engeneering is very interesting!" | java -jar stringTest.jar
read
