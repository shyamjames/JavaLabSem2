/*
 * 5. Implement a Java program to pass an array in different ways.
 * @Shyam James
 * Roll No: 54
 * 27/11/25
 */

import java.io.*;
import java.util.*;

class c1
{
    public int[] read(int a[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no. of elements:");
        int n = s.nextInt();
        a = new int[n];
        System.out.println("Enter the elements:");
        for(int i = 0; i < n; i++)
        {
            a[i] = s.nextInt();
        }
        return a;
    }

    public void disp(int a[]){
        System.out.println("The elements are:");
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + "\t");
        }
        System.out.println("");
    }
}

class Program5
{
    public static void main(String args[])
    {
        c1 obj = new c1();
        int a[] = null;
        a = obj.read(a);
        obj.disp(a);
    }
}
