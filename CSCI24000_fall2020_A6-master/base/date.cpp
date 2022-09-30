// date.cpp

#include "date.h"
#include <string>
#include <iostream>
#include <sstream>

Date::Date(std::string date){
	int dates [3];
	std::stringstream ss;
        ss << date;
	for(int i=0;i<3;i++){
		ss >> dates[i] >> date;
		ss.clear();
		ss.str("");
		ss << date.substr(date.find("/")+1);
	}	
	Date::month = new int(dates[0]);
	Date::day = new int(dates[1]);
	Date::year = new int(dates[2]);
}

// constructor
Date::Date(int month, int day, int year){
	Date::month = new int(month);
	Date::day = new int(day);
	Date::year = new int(year);
}	

// destructor 
Date::~Date(){
	delete month;
	delete day;
	delete year;
}

// these methods would convert the month integer to strings 
std::string Date::getMonthString(int month){
	std::string monthstr = "";
	// switch statement with all the months

	return monthstr;
}

// these methods would output english and british versions of the date using mm/dd/yyyy or dd/mm/yyyy
std::string Date::getAmerican(){
	std::stringstream s;
	s << *Date::month << "/" << *Date::day << "/" << *Date::year;
	return s.str(); 
}
std::string Date::getBritish(){
	std::stringstream s;
	s << *Date::day << "/" << *Date::day << "/" << *Date::year;
	return s.str();
}

int Date::getDay(){
	return *Date::day;
}

int Date::getMonth(){
	return *Date::month;
}

int Date::getYear(){
	return *Date::year;
}
