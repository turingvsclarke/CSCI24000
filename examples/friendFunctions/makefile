complex: complex.o main.o
	g++ -g complex.o main.o -o complex

complex.o: complex.cpp
	g++ -g -c complex.cpp

main.o: complex.cpp main.cpp

run: complex
	./complex

debug: complex
	gdb complex

clean:
	rm *.o

