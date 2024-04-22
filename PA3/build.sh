java -classpath javacc.jar javacc prettyPrinter.jj
javac prettyPrinter.java
java prettyPrinter < PA03demo.txt > PA03_pretty_demo.txt