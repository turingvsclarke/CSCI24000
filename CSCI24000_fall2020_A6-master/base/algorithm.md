Heap of Students Algorithm
Ryan Eades

This assignment has two components: Classes and file io, handled by the main function. The classes are built first, so are described first.

Date: The date object will have integer month, day, and year properties. It will have a constructor that accepts a string. This string is accepted to be of the form "mm/dd/yyyy" so the constructor will use a stringstream object and a loop to parse this string into integers. We also have a constructor that can just be passed three integers. It also needs a destructor, since all the integer values will use heap storage. We will include some getters, primarily for testing. Finally, it will have two methods that use stringstream objects to put the integers together and output either the American(mm/dd/yyyy) or British(dd/mm/yyyy) standard date strings. 

Address: The address object will have string paramters for line1, line2, city, state, and an int parameter for the zip code. It will have two constructors, one for all parameters, and one for all parameters except line2, since that is optional. The latter will assign line2 an empty string. It will have a deconstructor since all parameters will use heap storage. It also will have a method to put all these parameters into a string separated by commas, since that will be helpful when writing a report on the students.

Student: The student object will have the following parameters:string for a firstname, string for a last name, Address object for a home address, date objects for graduation and birth, a double for gpa, and an int for credit hours. The student object will have a constructor that takes a string, which we expect has all the parameters in order separated by commmas. We splice it up into substring of the parameters and assign them directly, or via a stringstream conversion betwen types.
	The student object will also have a constructor that takes in all the parameters, as well as a destructor since all parameters will be stored on the heap.
	The student object will handle the file output, so it will have a method that takes in a filename and appends all parameters, separated by commas, to that file. It will have a similar method to append the first and last name, separated by commas, to a file. 
	Finally, we include getters for testing and access to the class. 

Main function: The main function will initialize an empty array of type Student on the heap. It then loops through the file of students provided, creating a new Student object for each line by passing the line as the string of student information. It stores all these Students in the array. For output, it loops through the array, calling the small and full report methods for each student. Finally, it uses a sort function call on the array, ordering the students by last name, and creates another small report of the students in a different file.
