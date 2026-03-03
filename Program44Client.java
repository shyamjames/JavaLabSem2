/* Program to implement public chatting.
--- Client Program ---
@Shyam James
Roll no: 54
Date: 17-01-2026
*/

import java.io.*;
import java.net.*;

public class Program44Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 1234);
        System.out.println("Connected to server!");
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Thread receiver = new Thread(() -> {
            try {
                while (true) {
                    String incoming = dis.readUTF();
                    System.out.println("\n" + incoming);
                }
            } catch (IOException e) {
                System.out.println("Disconnected from server.");
            }
        });
        receiver.setDaemon(true);
        receiver.start();

        String msg;
        while (true) {
            System.out.println("Enter message to send (type 'exit' to quit):");
            msg = br.readLine();
            dos.writeUTF(msg);
            dos.flush();
            if (msg.equals("exit")) {
                break;
            }
        }
        dis.close();
        dos.close();
        s.close();
    }
}