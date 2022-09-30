// horse.cpp
// This file contains the horse class

#include <algorithm>
#include <iostream>
#include <string>
#include "horse.h"

// horse constructor
Horse::Horse(){
	Horse::position=0;

} // end constructor method
	
void Horse::advance(){
	// we're going to increase the horse's position by either 0 or 1
	int randInt = std::rand() % 2;
	Horse::position = Horse::position+randInt;
			
} // end advance method		
	
int Horse::getPosition(){
	return Horse::position;

} // end getPosition method








