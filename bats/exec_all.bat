@echo off
if [%1] == [] goto error
jjs -cp .;classes;lib\eif203.jar src\js\test_all.js -- %2 > %1
goto end
:error
echo Provide an output file as parameter
:end
