@echo off
kotlinc src/loginpass.kt -include-runtime -d loginpass.jar
echo "Project has been compiled"
pause