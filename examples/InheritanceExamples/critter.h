// critter.h
#ifndef CRITTER_H_EXISTS
#define CRITTER_H_EXISTS

#include <string>

class Critter {

	friend void changeName(std::string name);
	
	protected:
		std::string name;
	public:
		// constructor
		Critter();
		// getter, setter, and function to give the critter some personality
		void setName(std::string name);
		std::string getName();
		void sayHi();		
}; // end class def

#endif
