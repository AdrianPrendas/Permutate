call clean
javac -cp .;lib\* -d classes src\*.java src\java\*.java
echo Building jar
jar cf eif203.jar -C classes .
jar tf eif203.jar
echo copying jar
move eif203.jar lib\eif203.jar