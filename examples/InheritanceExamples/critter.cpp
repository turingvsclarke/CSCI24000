// critter.cpp
#include <string>
#include <iostream>
#include "critter.h"


Critter::Critter(){
	Critter::name = "anonymous";
}

void Critter::setName(std::string name){
	Critter::name = name;
}

std::string Critter::getName(){
	return name;
}

void Critter::sayHi(){
	std::cout<< "Hi. My name is " << name << std::endl;
}
