// main.cpp 
#include "date.h"
#include "address.h"
#include "student.h"

#include <algorithm>
#include <fstream>
#include <sstream>
#include <iostream>
#include <string>
bool sortByLname(Student* a,Student* b);
int main(){

std::ifstream inFile;
std::string currentLine;
inFile.open("students.dat");
int i = 0;
std::stringstream ss;
Student* students[50];
while(getline(inFile,currentLine)){
	ss.clear();
	ss.str("");
	ss << currentLine;
	if(i>0){
		// create a new student object for this line
		students[i-1] = new Student(ss.str());
	}
	i++;
} // end while
inFile.close();

// this section outputs all the students last and first names to a txt file called shortReport.txt
for(int i=0;i<50;i++){
	students[i]->smallReport("shortReport.txt");
	students[i]->studentReport("fullReport.txt");
}

// this section will sort them according to alphabetical order
std::sort(students,students+50,sortByLname);
for(int i=0;i<50;i++){
	students[i]->smallReport("alphaReport.txt");
}

// this section will clear the heap
for(int i=0;i<50;i++){
	delete students[i];
}


}; // end main function

bool sortByLname(Student* a, Student* b){
	return(a->getLname() < b->getLname());
}
