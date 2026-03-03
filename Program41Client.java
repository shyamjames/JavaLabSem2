/* Program to implement one to one chatting.
--- Client Program ---
@Shyam James
Roll no: 54
Date: 12-01-2026
*/

import java.io.*;
import java.net.*;

public class Program41Client{
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 1234);
        System.out.println("Connected to Server!");

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String msg = "", reply = "";

        while (!msg.equals("exit")) {

            // Send message
            System.out.print("You: ");
            msg = br.readLine();
            dos.writeUTF(msg);

            if (msg.equals("exit"))
                break;

            // Receive reply
            reply = dis.readUTF();
            System.out.println("Server: " + reply);
        }

        dis.close();
        dos.close();
        s.close();
    }
}