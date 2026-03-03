/* Program to display the content of a webpage given its URL.
@Shyam James
Roll no: 54
Date: 31-01-2026
*/

import java.net.*;
import java.io.*;
import java.util.Scanner;

class Program48 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a URL:");
        String urlString = sc.nextLine();
        URL url = new URL(urlString);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}