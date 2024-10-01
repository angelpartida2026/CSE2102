#Lab 1

CodeSpace> wget https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar
CodeSpace> wget https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar

CodeSpace> javac -cp "junit-4.13.2.jar:." ./src/u/*.java

CodeSpace> javac -cp "junit-4.13.2.jar:." ./src/c/*.java

CodeSpace> java -cp "hamcrest-core-1.3.jar:junit-4.13.2.jar:." org.junit.runner.JUnitCore src.u.HybridTests
