/*
 * 6.Write a Java program to add and multiply two matrices
 * @Shyam James
 * Roll No:54
 * 28/11/25
 */

import java.util.*;

class Program6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter number of rows & columns for Matrix 1:");
        int r1 = s.nextInt();
        int c1 = s.nextInt();

        System.out.println("Enter number of rows & columns for Matrix 2:");
        int r2 = s.nextInt();
        int c2 = s.nextInt();

        boolean add = true, mult = true;

        if (c1 != r2) {
            System.out.println("Matrix multiplication not possible.");
            mult = false;
        }

        if (r1 != r2 || c1 != c2) {
            System.out.println("Matrix addition not possible.");
            add = false;
        }

        int[][] a = new int[r1][c1];
        int[][] b = new int[r2][c2];

        System.out.println("Enter Matrix 1:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                a[i][j] = s.nextInt();
            }
        }

        System.out.println("Enter Matrix 2:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                b[i][j] = s.nextInt();
            }
        }

        if (mult) {
            int[][] prod = new int[r1][c2];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    for (int k = 0; k < c1; k++) {
                        prod[i][j] += a[i][k] * b[k][j];
                    }
                }
            }

            System.out.println("Product Matrix:");
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    System.out.print(prod[i][j] + "\t");
                }
                System.out.println();
            }
        }

        if (add) {
            int[][] sum = new int[r1][c1];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    sum[i][j] = a[i][j] + b[i][j];
                }
            }

            System.out.println("Sum Matrix:");
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    System.out.print(sum[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
}
