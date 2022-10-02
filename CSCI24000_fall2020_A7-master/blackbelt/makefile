bank: admin.o user.o account.o main.o
	g++ -g admin.o user.o account.o main.o -o bank

account.o: account.cpp
	g++ -g -c account.cpp

user.o: user.cpp account.h
	g++ -g -c user.cpp

admin.o: admin.cpp user.h account.h
	g++ -g -c admin.cpp

main.o: main.cpp user.h account.h admin.h
	g++ -g -c main.cpp
clean:
	rm -f *.o
	rm bank
run: bank
	./bank

debug: bank
	gdb bank

valgrind: bank
	valgrind --leak-check=yes ./bank

