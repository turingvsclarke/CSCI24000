// race.cpp 

#include <sstream>
#include <string>
#include <iostream>
#include "horse.h"
#include "race.h"

Race::Race(){
	for(int i=0;i<=5;i++){
		Race::horses[i]=Horse();	
	}
	
	Race::length = 10;
} // end null parametrized constructor

Race::Race(int length){
	for(int i=0;i<=5;i++){
		Race::horses[i]=Horse();
	}
	Race::length = length;
} // end length parametrized Race constructor


void Race::printLane(int horseID){
	for (int j=0;j<=Race::length;j++){
		if(j==Race::horses[horseID].getPosition())
			std::cout<<horseID;
		
		else 
			std::cout<<'.';
	} // end for
	// add a new line after the lap
	std::cout<<std::endl;
} // end printLane method

void Race::start(){

	bool keepGoing = true;
	std::string message = "";
	std::stringstream s;
	while(keepGoing){

		for(int i=0;i<sizeof(Race::horses)/sizeof(Race::horses[0]);i++){
		
			Race::horses[i].advance();
			Race::printLane(i);

			// check to see if the horse has finished the race	
			if(Race::horses[i].getPosition()==Race::length){
				keepGoing = false;
				s << "Horse " << i << " wins!";			
				message = s.str();	
				}
			} // end for loop

				std::cout<<message<<std::endl;
	}

} // end start method



