/* Implement a program where the client requests a specific filename and downloads its content from the server.
--- Server Program ---
@Shyam James
Roll no: 54
Date: 12-01-2026
*/

import java.io.*;
import java.net.*;

class Program42Server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Server waiting for client...");
        Socket s = ss.accept();
        System.out.println("Client Connected!");
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        String filename = dis.readUTF();
        File file = new File(filename);
        if (file.exists()) {
            dos.writeUTF("File found. Sending content...");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                dos.writeUTF(line);
                dos.flush();
            }
            br.close();
        } else {
            dos.writeUTF("File not found!");
        }
        dis.close();
        dos.close();
        s.close();
        ss.close();
    }
}
