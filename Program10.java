/*
 * 10. Display from n - 1 and 1-n using recursive functions.
 * @Shyam James
 * Roll No: 54
 * 30/11/25
 */

import java.util.*;

class C{
    public void nToOne(int n){
        if(n>0){
            System.out.print(n+" ");
            nToOne(n-1);
        }
    }

    public void oneToN(int n){
        if(n>0){
            oneToN(n-1);
            System.out.print(n+" ");
        }
       
    }
}

class Program10{
    public static void main(String[] args) {
        C obj = new C();
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a value of n: ");
        n = s.nextInt();
        System.out.println("N to 1");
        obj.nToOne(n);
        System.out.println("");
        System.out.println("1 to N");
        obj.oneToN(n);
    }
}
