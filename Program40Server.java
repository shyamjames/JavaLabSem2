/* Program to implement Server Client Communication.
--- Server Program ---
@Shyam James
Roll no: 54
Date: 12-01-2026
*/

import java.io.*;
import java.net.*;

class Program40Server{
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Server Started!");
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String)dis.readUTF();
            System.out.println("Message: "+str);
            ss.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
