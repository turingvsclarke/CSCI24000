// address.cpp
#include "address.h"
#include <string>
#include <iostream>
#include <sstream>
		
// null constructor for not having a second address line
Address::Address(std::string line1,std::string city,std::string state,int zip){
	Address::line1 = new std::string(line1);
	Address::line2 = new std::string("");
	Address::city = new std::string(city);
	Address::state = new std::string(state);
	Address::zip = new int(zip);
}

// constructor
Address::Address(std::string line1,std::string line2,std::string city,std::string state,int zip){	
	Address::line1 = new std::string(line1);
	Address::line2 = new std::string(line2);
	Address::city = new std::string(city);
	Address::state = new std::string(state);
	Address::zip = new int(zip);
}

//no methods except getters and setters really

// destructor
Address::~Address(){
	delete line1;
	delete line2;
	delete city;
	delete state;
	delete zip;
}

std::string Address::getAddressStr(){
	std::stringstream s;
	s <<*Address::line1<<","<<*Address::line2<<","<<*Address::city<<","<<*Address::state<<","<<*Address::zip;
	return s.str();
}



		
