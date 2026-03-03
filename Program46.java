/* Program to get protocol, file name, host, path and port of a given URL.
@Shyam James
Roll no: 54
Date: 19-01-2026
*/

import java.net.*;
import java.util.Scanner;
class Program46 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a URL:");
        String urlString = sc.nextLine();
        URL url = new URL(urlString);
        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Host: " + url.getHost());
        System.out.println("Port: " + url.getPort());
        System.out.println("Path: " + url.getPath());
    }
}