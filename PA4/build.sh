rm TokenMgrError.java
rm ParseException.java
rm Token.java
rm SimpleCharStream.java
java -classpath javacc.jar javacc PA4.jj
javac PA4.java
read -p "Press any key to continue" x