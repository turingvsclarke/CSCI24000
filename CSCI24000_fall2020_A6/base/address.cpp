// address.h

#ifndef ADDRESS_H_EXISTS
#define ADDRESS_H_EXISTS

#include <string>

class Address {
	
	private:
		std::string line1	
		std::string line2;
		std::string city;
		std::string state;
		int zip;
	public:
	
		// constructor
		//no methods except getters and setters really
		//
		// destructor

		// note that address 2 is unneeded. So we won't set it to a default value
