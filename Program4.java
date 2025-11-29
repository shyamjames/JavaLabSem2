/*
4. Implement searching and sorting elements in an Array 
@Shyam James
Roll No: 54
27/11/25
*/

import java.util.*;

class Program4{
    public static void main(String args[]){
        int a[];
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no. of elements in the array: ");
        int n = s.nextInt();
        a = new int[n];
        System.out.println("Enter "+n+" numbers:");
        for(int i=0;i<n;i++){
            a[i] = s.nextInt();
        }

        //Sorting
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.println("Sorted array:\n");
        for(int i=0;i<n;i++){
            System.out.print(a[i]+"\t");
        }

        //Searching
        System.err.println("");
        System.out.println("Enter and element to search: ");
        int sr = s.nextInt();
        int flag=0;
        for(int i=0;i<n;i++){
            if(a[i]==sr){
                System.out.println("Element "+sr+" found at position "+i);
                flag = 1;
                break;
            }else{
                flag = 0;
            }
        }
        if(flag == 0){
            System.out.println("Not found!");
        }
    }
}