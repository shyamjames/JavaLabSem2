/* Program to implement Server Client Communication.
--- Client Program ---
@Shyam James
Roll no: 54
Date: 12-01-2026
*/

import java.io.*;
import java.net.*;

class Program40Client{
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost",1234);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Hello Server - From Client!");
            dout.flush();
            dout.close();
            s.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}