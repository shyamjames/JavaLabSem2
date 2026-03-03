/* Program to Upload the content from client to server.
--- Client Program ---
@Shyam James
Roll no: 54
Date: 12-01-2026
*/

import java.io.*;
import java.net.*;

class Program43Client {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("localhost", 1234);
        System.out.println("Connected to server!");
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter filename to upload:");
        String filename = br.readLine();
        File file = new File(filename);
        
        if (file.exists()) {
            dos.writeUTF(filename);
            dos.flush();
            
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = fileReader.readLine()) != null) {
                dos.writeUTF(line);
                dos.flush();
            }
            dos.writeUTF("EOF_MARKER");
            dos.flush();
            
            fileReader.close();
            
            String response = dis.readUTF();
            System.out.println(response);
        } else {
            System.out.println("File not found!");
        }
        
        dis.close();
        dos.close();
        s.close();
    }
}
