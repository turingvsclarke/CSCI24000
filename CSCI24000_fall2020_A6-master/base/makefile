studentIO: date.o address.o student.o main.o
	g++ -g date.o address.o student.o main.o -o studentIO

date.o: date.cpp date.h
	g++ -g -c date.cpp

address.o: address.cpp address.h
	g++ -g -c address.cpp

student.o: student.cpp student.h address.h date.h
	g++ -g -c student.cpp

main.o: main.cpp date.h address.h student.h
	g++ -g -c main.cpp

clean: 
	rm -f *.o
	rm -f *.txt
	rm studentIO
	
run: studentIO
	./studentIO

debug: studentIO
	gdb studentIO

valgrind: studentIO
	valgrind --leak-check=yes ./studentIO
