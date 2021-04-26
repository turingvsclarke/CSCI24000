// Recursion.java
import java.io.*;
import java.util.*;

public class Recursion{
	public static void main(String[] args){
		Recursion myRecursion = new Recursion();
		System.out.println("Enter a number for Collatz:");
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		int n = Integer.parseInt(inputString);
		myRecursion.collatz(n);
	}

	public void collatz(int n){
		System.out.println(n);
		if(n==1){
			System.out.println("We're done");
		}
		else if((n%2)==0){
			collatz(n/2);
		}
		else{
			collatz((3*n)+1);
		}
		

	} // end collatz


} // end class def
