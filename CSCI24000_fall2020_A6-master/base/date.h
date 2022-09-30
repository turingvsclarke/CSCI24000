// date.h

#ifndef DATE_H_EXISTS
#define DATE_H_EXISTS
#include <string>

class Date {
	private:
		int* month;
		int* day;
		int* year;
	public:
		Date(std::string date);
		
		// constructor
		Date(int month, int day, int year);		

		// destructor 
		~Date();		
		
		// these methods would convert the month integer to strings 
		std::string getMonthString(int month);
		
		// these methods would output english and british versions of the date using mm/dd/yyyy
		std::string getAmerican();
		std::string getBritish();

		// temporary use of getters and setters. Our final version may not need these
		int getDay();
		int getMonth();
		int getYear();
}; // end class definition
#endif
