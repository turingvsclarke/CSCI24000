Ryan Eades
The Object of Horses

Intro: This project is the same as the last, but it will use objects instead of procedural programming. The main classes are the horse and the race class. Both will be their own files. They will both need constructors.

Race object:It has a private length integer and a private array of horse objects. It has two constructors, one null parametrized and one for the instance being passed a length value. Other methods are printLane() and start().

	1. Race():No input or output. Loops five times, assigning the ith index of the horse array a horse object. It assigns the length integer a value of 10. 
	2. Race(int length): The length is inputted. No output. Does the same thing as the null parameter case, except it assigns the length property the passed length.
	3. printLane(int horseID): Passed the id of the horse whose lane we want to print. This function does the same thing as the print function in the procedural program. It loops length times, printing either period or the index of the horse object.
	4. start(): This function has no input and outputs a celebratory message. It handles the entire race. It is a while loop that continues as long as none of the horse objects in the array have a postion equal to the length of the race. With that loop is a loop that prints each horses lane and calls the advance method on each horse. When a horse does have such a position, the loop ends and a congratulatory message is printed.

Horse object:It has a private length integer. It only has a null parameter constructor. It also has getPosition and advance methods.

	1. Horse(): Sets the position property to 0.
	2. getPosition(): A typical getter, it just returns the position property.
	3. advance(): Generates a random integer(either 0 or 1) and adds it to the position property.

Main function: The main function asks the user for a random seed and then performs srand() with that seed to seed the random generator function. It then initiates a Race object with a length of 15, then calls the start method of the Race function.


