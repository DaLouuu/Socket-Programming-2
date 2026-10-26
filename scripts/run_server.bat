@echo off
setlocal
cd /d "%~dp0\.."

if not exist "bin" mkdir "bin"

echo Compiling Java source files to bin/...
javac -d bin src\ChatServer.java src\ChatClient.java
if %ERRORLEVEL% NEQ 0 (
    echo Compilation failed.
    exit /b %ERRORLEVEL%
)

set PORT=%1
if "%PORT%"=="" set PORT=4000

echo Starting ChatServer on port %PORT%...
java -cp bin ChatServer %PORT%
endlocal
