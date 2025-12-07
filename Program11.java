/* 11. Program for adding, subtracting, multiplying and dividing two numbers using object-oriented concepts.
@Jubin Joy
Roll no: 54
Date: 30-11-2025
*/

import java.io.*;
import java.util.*;

class A
{
    int n;
    public void read()
    {
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
    }
    public void display()
    {
        System.out.println(n);
    }
    public void add(A obj)
    {
        System.out.println(n+"+"+obj.n+"=");
        n = n + obj.n;
        display();
    }
    public void subtract(A obj)
    {
        System.out.println(n+"-"+obj.n+"=");
        n = n - obj.n;
        display();
    }
    public void multiply(A obj)
    {
        System.out.println(n+"*"+obj.n+"=");
        n = n * obj.n;
        display();
    }
    public void divide(A obj)
    {
        if(obj.n==0)
        {
            System.out.println("Can't Divide by Zero");
        }
        else
        {
            System.out.println(n+"/"+obj.n+"=");
            n = n / obj.n;
            display();
        }
    }
}

public class Program11
{
    public static void main(String args[])
    {
        A a=new A();
        A b=new A();
        int ch;
        Scanner s=new Scanner(System.in);
        do{
            System.out.println("Enter two numbers:");
            a.read();
            b.read();
            System.out.println("1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.Exit");
            System.out.println("Enter your choice:");
            ch=s.nextInt();
            switch(ch)
            {
                case 1:a.add(b);
                       break;
                case 2:a.subtract(b);
                       break;
                case 3:a.multiply(b);
                       break;
                case 4:a.divide(b);
                       break;
                case 5:System.out.println("Exiting!!");
                       break;
                default:System.out.println("Invalid Choice");
            }
        }while(ch!=5);
    }
}
