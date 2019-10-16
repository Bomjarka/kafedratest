#!/bin/bash
kotlinc src/app.kt -include-runtime -d stringTest.jar
echo "Project has been compiled"
echo -e
echo "Checking string hello great world; Await: great-1 hello-1 world-1"
java -jar stringTest.jar hello great world
echo -e
echo "Checking string the quick brown fox jumps over the lazy dog; Await: brown-1 dog-1 fox-1 jumps-1 lazy-1 over-1 quick-1 the-2"
java -jar stringTest.jar the quick brown fox jumps over the lazy dog
echo -e
echo "Checking string software engineering is very interesting!; Await: engineering-1 interesting-1 is-1 software-1 very-1"
java -jar stringTest.jar software engineering is very interesting!
echo -e
echo "Checking string the quick brown fox jumps over the lazy dog; Await: brown-1 dog-1 fox-1 jumps-1 lazy-1 over-1 quick-1 the-2"
echo -e
echo "the quick brown fox jumps over the lazy dog" | java -jar stringTest.jar
echo -e
echo "Checking string blah blah bla; Await: bla-1 blah-2"
echo -e
echo "blah blah bla" | java -jar stringTest.jar
echo -e
echo "Checking string software engineering is very interesting!; Await: engineering-1 interesting-1 is-1 software-1 very-1"
echo "Software engineering is very interesting!" | java -jar stringTest.jar
read
