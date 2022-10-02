// student.cpp
#include "address.h"
#include "date.h"
#include "student.h"

#include <algorithm>
#include <fstream>
#include <string>
#include <sstream>
#include <iostream>

//Student();

// Constructor that is passed only a string of student information
Student::Student(std::string studentInfo){
	int itemNumber = std::count(studentInfo.begin(),studentInfo.end(),',');
	std::string items[itemNumber+1];
	// this for loop makes each string separated by commas the next attribute
	for(int i=0;i<=itemNumber;i++){
		// find the index of the first comma
		int pos = studentInfo.find(",");
		items[i]=studentInfo.substr(0,pos);
		studentInfo = studentInfo.substr(pos+1);
	} // end for
	Student::lname = new std::string(items[0]);
	Student::fname = new std::string(items[1]);
	int i;
	std::stringstream zip(items[6]);
	zip >> i;
	Student::home = new Address(items[2],items[3],items[4],items[5],i);
	Student::grad = new Date(items[7]);
	Student::birth = new Date(items[8]);
	double d;
	std::stringstream gpa(items[9]);
	gpa >> d;
	std::stringstream credits(items[10]);
	credits >> i;
	Student::gpa = new double(d);
	Student::credits = new int(i);
}

// constructor
Student::Student(std::string fname, std::string lname, Address home, Date grad, Date birth, double gpa, int credits){
	Student::fname = new std::string(fname);
	Student::lname = new std::string(lname);
	Student::home = new Address(home);
	Student::grad = new Date(grad);
	Student::birth = new Date(birth);
	Student::gpa = new double(gpa);
	Student::credits = new int(credits);
}

// destructor
Student::~Student(){
	delete fname;
	delete lname;
	delete home;
	delete grad;
	delete birth;
	delete gpa;
	delete credits;
}

void Student::studentReport(std::string fileName){
	std::stringstream s;
	s <<Student::getFname()<<","<<Student::getLname()<<","<<Student::home->getAddressStr()<<","<<Student::birth->getAmerican()<<","<<Student::grad->getAmerican()<<","<<Student::getGPA()<<","<<Student::getCredits();
	std::ofstream outFile;
	outFile.open(fileName,std::ios::app);

	if (outFile.is_open()){
		outFile << s.str() << std::endl;	
		} // end if

	else {
		std::cout << "unable to access file '" << fileName << "' to write" << std::endl;
	} // end else
	
	outFile.close();

}

void Student::smallReport(std::string fileName){
	std::ofstream outFile;
	std::stringstream s;
	outFile.open(fileName,std::ios::app);
	s << Student::getLname() << "," << Student::getFname();

	if (outFile.is_open()){
		outFile << s.str() << std::endl;	
		} // end if

	else {
		std::cout << "unable to access file '" << fileName << "' to write" << std::endl;
	} // end else
	
	outFile.close();
}

std::string Student::getFname(){
	return *fname;
}
std::string Student::getLname(){
	return *lname;
}
Address Student::getHome(){
	return *home;
}
Date Student::getBirthday(){
	return *birth;
}
Date Student::getGradDate(){
	return *grad;
}
double Student::getGPA(){
	return *gpa;
}
int Student::getCredits(){
	return *credits;
}
// this method will possibly take a string of values separated by commas and then splice it into the correct Student props
//getStudentInfo();

