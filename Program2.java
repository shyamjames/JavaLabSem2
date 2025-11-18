/*
 * Write a program to perform the mathematical operations using switch case.
 * @Shyam James
 * Roll No 54
 * 17/11/2025
 */
import java.io.*;

class SwitchCalc{
	public static void main(String args[]){
		int n1,n2,op,fin;

		if(args.length != 3){
			System.out.println("Argument length should be 3!");
			System.out.println("0: Additon 1: Subtraction 2: Multiplication 3: Division");
		}
		n1 = Integer.parseInt(args[0]);
		n2 = Integer.parseInt(args[1]);
		op = Integer.parseInt(args[2]);
		
		switch(op){
			case 0:
			fin = n1+n2;
			System.out.println(fin);
			break;
			case 1:
			fin = n1-n2;
			System.out.println(fin);
			break;
			case 2:
			fin = n1*n2;
			System.out.println(fin);
			break;
			case 3:{
			if(n2==0){
				System.out.println("Error! Division by zero");
				return;
			}
			fin = n1/n2;
			System.out.println(fin);
			break;
			}
			default:
			System.out.println("Enter between 0-3");
			break;
		}
	}	
}
