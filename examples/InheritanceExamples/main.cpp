// main.cpp
#include <string>
#include <iostream>
#include "critter.h"
#include "glitterCritter.h"

void changeName(std::string name){
	Critter c;
	c.name = name;
	std::cout<<"The critter friend's name is: "<<c.name<<std::endl;
}

int main(){

	Critter c;
	c.sayHi();
	changeName("Inigo Monotoya");
	Critter b = c;
	b.sayHi();
	
	GlitterCritter g;
	g.sayHi();
	g.shimmer();	
} // end main
