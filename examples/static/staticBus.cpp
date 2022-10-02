// staticBus.cpp
#include <iostream>
#include <string>

class Bus{
	private:
		
		std::string name;
		int passengers;
	public:
		static int totalPass;
		static void printTotal();
		Bus();
		Bus(std::string name);
		void printPass();
		// someone gets on the bus
		void board(int numPass);
		// someone gets off the bus
		void debark(int numPass);
}; // end class def

Bus::Bus(){
	name = "Anonymous";
	passengers = 0;
}

Bus::Bus(std::string n){
	name = n;
	passengers = 0;
}

// someone gets on the bus. 
void Bus::board(int numPass){
	passengers+=numPass;
	totalPass+=numPass;
	printPass();
}

void Bus::debark(int numPass){
	passengers-=numPass;
	if(passengers<0){
		std::cout<<"You can't have negative passengers!"<<std::endl;
		passengers+=numPass;
	}
	printPass();
}

void Bus::printPass(){
	std::cout<<"Bus "<<name<<" has "<<passengers<<" passengers"<<std::endl;
} // end printPass

// this function is going to print the total number of people riding the bus today
void Bus::printTotal(){
	std::cout<<"There were "<<totalPass<<" passengers who rode today"<<std::endl;
}
int Bus::totalPass=0;
int main(){
	Bus b1("Magic Bus");
	b1.board(5);
	b1.board(2);
	b1.debark(3);
	b1.debark(4);
	
	Bus b2("Gussy");
	Bus b3("Lime Slime");

	b2.board(13);
	b3.board(5);
	b2.debark(5);
	b2.board(9);
	b3.debark(2);
	b3.board(23);

	// at the end we want to know the total people who have ridden the bus
	Bus::printTotal();
}
