
@echo off

set SOLUTION_HOME=.
set SOLUTION_VERSION=1.0-SNAPSHOT

java -classpath %SOLUTION_HOME%/main/target/main-%SOLUTION_VERSION%-jar-with-dependencies.jar com.rburdo.coding.rea.robot.main.Main %*

@echo on