/*
3. Keep a secret number between 20 and 30 in your program. Ask the user to
predict a number between 20 and 30. Use a do-while loop until the user predicts
your secret number and displays the count of attempts.
@Shyam James
Roll No: 54
27/11/25
*/

import java.util.*;

class Program3{
    public static void main(String args[]){
        System.out.println("--- Predict the secret number ---");
            int secretNum = 22;
            int pred, flag;
            Scanner s = new Scanner(System.in);
            do{
                System.out.println("Enter the prediction");
                pred = s.nextInt();
                if(pred==secretNum){
                    System.out.println("Success!");
                    flag = 1;
                    return;
                }else{
                    System.out.println("Wrong Prediction! Try again!");
                    flag = 0;
                }
            }while(flag!=1);
    }
}