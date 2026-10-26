@echo off
setlocal
cd /d "%~dp0\.."

set PORT=%1
if "%PORT%"=="" set PORT=4000

echo Starting Client A (Alice)...
start "Client A - Alice" cmd /k "java -cp bin ChatClient localhost %PORT% Alice \"Wait, it's all sockets?\""

timeout /t 1 /nobreak >nul

echo Starting Client B (Bob)...
start "Client B - Bob" cmd /k "java -cp bin ChatClient localhost %PORT% Bob \"Always has been.\""
endlocal
