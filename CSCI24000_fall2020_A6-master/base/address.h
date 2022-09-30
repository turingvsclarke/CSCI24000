// address.h

#ifndef ADDRESS_H_EXISTS
#define ADDRESS_H_EXISTS

#include <string>

class Address {
	
	private:
		std::string* line1;	
		std::string* line2;
		std::string* city;
		std::string* state;
		int* zip;
	public:
	
		// null constructor for not having a second address line
		Address(std::string line1,std::string city,std::string state,int zip);

		// constructor
		Address(std::string line1,std::string line2,std::string city,std::string state,int zip);
		// destructor
		~Address();	
		
		// this method will return a string of the address in report format
		std::string getAddressStr();
		
}; // end class def
#endif
