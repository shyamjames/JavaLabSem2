/* Program to download a file from given URL.
@Shyam James
Roll no: 54
Date: 19-01-2026
*/

import java.net.*;
import java.io.*;
import java.util.Scanner;

class Program47 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a File Link:");
        String urlString = sc.nextLine();
        URL url = new URL(urlString);
        try (InputStream in = url.openStream();
             FileOutputStream fos = new FileOutputStream("downloaded_file")) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("File downloaded successfully as 'downloaded_file'");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}