/* Write a program to create a menu driven program for performing the following
operations.
a. Length of a given string
b. Compare for equality
c. Extract a substring from a string.
d. Convert to uppercase and lowercase
e. Reverse a string
@Shyam James
Roll no: 54
Date: 05-01-2026
*/

import java.util.*;

class stringOps{
    public int stringLen(String st){
        int length = st.length();
        return length;
    }

    Scanner s = new Scanner(System.in);
    public void stringCmp(){
        String a,b;
        System.out.println("Enter the String 1:");
        a = s.nextLine();
        System.out.println("Enter the String 2:");
        b = s.nextLine();
        if(a.equals(b)){
            System.out.println(a+" and "+b+" are equal");
        }else{
            System.out.println(a+" and "+b+" are not equal");
        }
    }

    public String subStr(String str, int begin){
        String result = str.substring(begin);
        return result;
    }

    public void caseChange(String str){
        String lower = str.toLowerCase();
        String upper = str.toUpperCase();
        System.out.println("Lower Case: "+lower);
        System.out.println("Upper Case: "+upper);
    }

    public void strRev(String str){
        StringBuilder rev = new StringBuilder(str).reverse();
        System.out.println("Reversed String: "+ rev);
    }
}

class Program38{
    public static void main(String[] args) {
        stringOps obj = new stringOps();
        int ch;
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("Enter your Choice:");
            System.out.println("1. Length of a given string");
            System.out.println("2. Compare for equality");
            System.out.println("3. Extract a substring from a string");
            System.out.println("4. Convert to uppercase and lowercase");
            System.out.println("5. Reverse a string");
            System.out.println("6. Exit");
            ch = s.nextInt();
            s.nextLine();
            switch(ch){
                case 1:
                    System.out.println("Enter the String:");
                    String str = s.nextLine();
                    System.out.println("String length: "+obj.stringLen(str));
                    break;
                case 2:
                    obj.stringCmp();
                    break;
                case 3:
                    System.out.println("Enter the String");
                    String str1 = s.nextLine();
                    System.out.println("Enter begin index:");
                    int bi = s.nextInt();
                    System.out.println(obj.subStr(str1, bi));
                    break;
                case 4:
                    System.out.println("Enter the String:");
                    String str2 = s.nextLine();
                    obj.caseChange(str2);
                    break;
                case 5:
                    System.out.println("Enter the String:");
                    String str3 = s.nextLine();
                    obj.strRev(str3);
                    break;
                case 6:
                    System.out.println("Exiting!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice; Try Again");
            }
        }while(ch!=6);
    }
}