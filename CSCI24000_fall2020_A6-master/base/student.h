// student.h

#ifndef STUDENT_H_EXISTS
#define STUDENT_H_EXISTS

#include <string>
#include "address.h"
#include "date.h"

class Student{

	private:
		std::string* fname;
		std::string* lname;	
		Address* home;
		Date* grad;
		Date* birth;
		double* gpa;
		int* credits;
		
	public:
		// Student();	
		Student(std::string studentInfo);
		
		// constructor
		Student(std::string fname, std::string lname, Address home, Date grad, Date birth, double gpa, int credits);

		// destructor
		~Student();
		
		// this function will print a report of the student to a textfile
		void studentReport(std::string fileName);
		
		// this function will just print the first and last name of the student to a text file
		void smallReport(std::string fileName);
		std::string getFname();
		std::string getLname();
		Address getHome();
		Date getBirthday();
		Date getGradDate();
		double getGPA();
		int getCredits();
}; // end class definition
#endif
