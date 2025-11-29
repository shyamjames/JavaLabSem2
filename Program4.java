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
        int low=0,high=n-1,sr,mid,flg=0;
        System.out.println("");
        System.out.println("Enter an element to search: ");
        sr = s.nextInt();
        while(low<=high){
            mid = (low+high)/2;
            if(sr==a[mid]){
                System.out.println("Element found at position "+mid);
                flg=1;
                break;
            }else if(sr<a[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        if(flg==0){
            System.out.println("Element not found!");
        }
    }
}
