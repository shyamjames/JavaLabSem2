/*
7.A function takes two integer arguments and returns the maximum. Use this function
to find the maximum of three numbers
@Shyam James
Roll No: 54
28/11/25
*/

import java.util.*;

class MaxCalc{
    public int maxReturn(int a, int b){
            int max = (a > b) ? a : b;
                return max;
        }

}

class Program7{
    public static void main(String[] args) {
        MaxCalc obj;
        obj = new MaxCalc();
        
        int x,y,z;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 3 integers: ");
        x = s.nextInt();
        y = s.nextInt();
        z = s.nextInt();
        
        int large;
        large = obj.maxReturn(x, y);
        large = obj.maxReturn(large, z);
        System.out.println("Max: "+large);

    }
}
