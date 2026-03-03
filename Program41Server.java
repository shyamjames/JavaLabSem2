/* Program to implement one to one chatting.
--- Server Program ---
@Shyam James
Roll no: 54
Date: 12-01-2026
*/

import java.io.*;
import java.net.*;

class Program41Server{
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Server waiting for client...");

            Socket s = ss.accept();
            System.out.println("Client Connected!");

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String msg = "", reply = "";

            while (!msg.equals("exit")) {
                // Receive from client
                msg = dis.readUTF();
                System.out.println("Client: " + msg);
                if (msg.equals("exit"))
                    break;
                // Send reply
                System.out.print("You: ");
                reply = br.readLine();
                dos.writeUTF(reply);
            }
            dis.close();
            dos.close();
            s.close();
            ss.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}