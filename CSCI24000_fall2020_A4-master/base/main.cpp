// This is the main function

#include <algorithm>
#include <string>
#include <iostream>
#include "race.h"
#include "horse.h"

const int length = 15;

int main(){

	int seed;
	std::cout<<"Please enter a seed for random number generation:";
	std::cin>>seed;
	std::srand(seed);
	
	// initialize race
	Race newRace = Race(length);

	// start the race
	newRace.start();


	return 0;

} // end main
