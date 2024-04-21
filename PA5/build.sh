#!/usr/bin/bash
java -classpath javacc.jar javacc PA5.jj
javac PA5.java
javac CodeGen_Visitor.java
echo "compiled java files"
echo "don't do this: cp tests/test.c tests/demo.c"
cd tests; gcc -c -S print.c
echo "print.c gcced"
cd ..
java PA5 < tests/demo_while.c > tests/demo_while.s
echo "written to tests/demo.s"
cd tests; gcc demo_while.s print.s -o demo_while; ./demo_while

cd ..
java PA5 < tests/demo_array.minic #> tests/demo_array.s
#echo "written to tests/demo_array.s"
#cd tests; gcc demo_array.s print.s -o demo_array; ./demo_array

