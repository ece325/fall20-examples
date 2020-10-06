# JUnit4
## To Compile:
javac Calculator.java
javac -cp .:libs/junit-4.13-beta-3.jar:libs/hamcrest-core-1.3.jar CalculatorTest.java

## To Execute:
java -cp .:libs/junit-4.13-beta-3.jar:libs/hamcrest-core-1.3.jar org.junit.runner.JUnitCore CalculatorTest


# JUnit5

## To Compile:
javac Calculator.java
javac -cp .:libs/junit-jupiter-5.5.2.jar:libs/junit-jupiter-api-5.5.2.jar:libs/junit-jupiter-engine-5.5.2.jar:libs/junit-jupiter-params-5.5.2.jar CalculatorTest.java

## To Execute:
java -jar libs/junit-platform-console-standalone-1.5.2.jar -cp . --select-class CalculatorTest