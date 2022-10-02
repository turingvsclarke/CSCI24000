// This blackbelt doesn't use the global horses variable but passes it as a reference parameter

#include <cstdlib>
#include <algorithm>
#include <iostream>

void getSeed();
void lap(int*);
void print(int*);
void ended(int*,bool& end);

const int SIZE=5;
const int lapSize=14;

main(){
	int horses [5] = {0,0,0,0,0};
	getSeed();
	bool keepGoing = true;
	while(keepGoing){		
		lap(horses);
		print(horses);	
		ended(horses,keepGoing);		
	} // end while loop 

} // end main

// getSeed function gets a seed from the user to use with rand
void getSeed(){
	int seed;
	std::cout<<"Please enter a random seed:";
	std::cin>>seed;
	std::srand(seed);
}



// lap function advances each horse by a random amount of 0 or 1
void lap(int* horses){
 	// begin loop through the values
	for (int i = 0; i<SIZE; i++){
        	int randInt = std::rand() % 2;
	 	*(horses+i)=*(horses+i)+randInt;
	} // end for loop
} // end lap

// print function displays the horses' places on the track
void print(int* horses){
	for (int i=0; i<SIZE; i++){
		std::cout << "\n";
		for (int j=0; j<=lapSize; j++){
			if (j==*(horses+i))
				std::cout<<i;
			else std::cout<< '.';
		}
	}
	std::cout<<std::endl;
} // end print 

// ended function determines if any of the horses have won the race
void ended(int* horses,bool &ending){
	for(int i = 0; i<SIZE; i++){
		if(*(horses+i)==lapSize){
			std::cout<<"Horse "<<i<<" wins"<<std::endl;
			ending=false;
			i=SIZE;
		}	
	}

} // end ended




