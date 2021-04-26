// complex.cpp

// demonstration of operator overloading

#include <iostream>

class complex {
	
	friend complex operator+(complex a,complex b);
	
	private:
		int re, im;
	public:
		complex(int re=0,int im=0);
		void printValue();
}; // end class def

complex::complex(int re,int im){
	complex::re = re;
	complex::im = im;
}

void complex::printValue(){
	std::cout << complex::re << " + " << complex::im << "i" << std::endl;
}

// When you just try to add two complex numbers, you get an error saying "No match for 'operator+'". So here we define operator+, a function that will return a complex number. It takes in two complex numbers and returns their sum.
// This is done by adding real parts and imaginary parts. However, those values are private, so we have to make operator+ a friend function.
complex operator+(complex a,complex b){
	int re = a.re + b.re;
	int im = a.im + b.im;
	complex result = complex(re,im);
	return result;
}


int main(){

	// normal object stuff. Declare an object and use a method
	complex z(5,3);
	complex w(3,4);
	z.printValue();
	w.printValue();
	// operator overload. Want to add two complex numbers, but haven't defined it yet
	complex sum = z + w;
	sum.printValue();
	int x = 4;
	int y = 5;
	std::cout << x+y << std::endl;
}
