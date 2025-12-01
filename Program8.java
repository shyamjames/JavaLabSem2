/*
8.A function takes an integer argument and returns the reverse of the same. Another
function takes an integer argument and returns true or false if the number is a
palindrome, using the above function.
@Shyam James
Roll No: 54
28/11/25
*/

import java.util.*;

class C1{
    public int reverseInt(int a){
        int revNum = 0;
        while(a>0){
            revNum = revNum*10+a%10;
            a=a/10;
        }
        return revNum;
    }

    public boolean isPalindrome(int a){
        int rev = reverseInt(a);
        if(a==rev)
            return true;
        else
            return false;
    }
}

class Program8{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int n = s.nextInt();

        C1 obj;
        obj = new C1();

        int reverse = obj.reverseInt(n);
        boolean palindrome = obj.isPalindrome(n);

        System.out.println("Reverse: "+reverse);
        if(palindrome){
            System.out.println("Is palindrome");
        }else{
            System.out.println("Not palindrome");
        }
    }
}
