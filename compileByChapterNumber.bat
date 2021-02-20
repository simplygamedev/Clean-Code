@echo off

if "%~1"=="" (
	echo "Please Provide an Argument"
	pause
	exit /b
)

set "chapter=Chapter %1"

cd "%CD%\Code Refactoring Exercise\%chapter%\"
javac *.java
REM java Main