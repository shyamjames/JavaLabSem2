/* Program to Upload the content from client to server.
--- Server Program ---
@Shyam James
Roll no: 54
Date: 17-01-2026
*/

import java.io.*;
import java.net.*;

class Program43Server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Server waiting for client...");
        Socket s = ss.accept();
        System.out.println("Client Connected!");
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        
        String filename = dis.readUTF();
        File file = new File("uploaded_" + filename);
        FileWriter fw = new FileWriter(file);
        
        String line;
        while ((line = dis.readUTF()) != null) {
            if (line.equals("EOF_MARKER")) {
                break;
            }
            fw.write(line);
            fw.write("\n");
        }
        
        dos.writeUTF("File uploaded successfully as '" + file.getName() + "'");
        dos.flush();
        
        fw.close();
        dis.close();
        dos.close();
        s.close();
        ss.close();
    }
}
