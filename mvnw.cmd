@ECHO OFF
setlocal

set WRAPPER_JAR="%~dp0\.mvn\wrapper\maven-wrapper.jar"
set WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain

set DOWNLOAD_URL="https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar"

if exist %WRAPPER_JAR% (
	REM Wrapper jar exists
) else (
	mkdir "%~dp0\.mvn\wrapper" 2> NUL
	powershell -NoProfile -Command "$ProgressPreference='SilentlyContinue'; Invoke-WebRequest -UseBasicParsing -Uri %DOWNLOAD_URL% -OutFile %WRAPPER_JAR%" || (
		echo Failed to download maven-wrapper.jar
		exit /b 1
	)
)

set MAVEN_OPTS=%MAVEN_OPTS% -Dmaven.multiModuleProjectDirectory="%~dp0"

set JAVA_EXE=java.exe

"%JAVA_EXE%" %MAVEN_OPTS% -classpath %WRAPPER_JAR% %WRAPPER_LAUNCHER% %*

endlocal 