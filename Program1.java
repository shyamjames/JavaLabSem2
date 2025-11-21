/*
 * Program to display two numbers using command line arguments, add those numbers, and display the result.
 * Roll No 54
 * 17/11/2025
 */
import java.io.*;

class Program1{
	public static void main(String args[]){
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int sum = a + b;

		System.out.println(sum);
	}	
}