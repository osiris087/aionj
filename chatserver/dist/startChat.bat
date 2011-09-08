@echo off
title Aion Java Free Chat Server Console
:start
echo Starting Aion Java Free Chat Server.
echo.
REM -------------------------------------
REM Default parameters for a basic server.
java -Xms8m -Xmx32m -ea -cp ./libs/*;aj-chat.jar chatserver.ChatServer
REM
REM -------------------------------------

SET CLASSPATH=%OLDCLASSPATH%


if ERRORLEVEL 1 goto error
goto end
:error
echo.
echo Chat Server Terminated Abnormaly, Please Verify Your Files.
echo.
:end
echo.
echo Chat Server Terminated.
echo.
pause