/* Implement a program where the client requests a specific filename and downloads its content from the server.
--- Client Program ---
@Shyam James
Roll no: 54
Date: 12-01-2026
*/

import java.io.*;
import java.net.*;

class Program42Client {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("localhost", 1234);
        System.out.println("Connected to server!");
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter filename to download:");
        String filename = br.readLine();
        dos.writeUTF(filename);
        dos.flush();
        
        String response = dis.readUTF();
        System.out.println(response);
        
        if (response.contains("found")) {
            FileWriter fw = new FileWriter("downloaded_" + filename);
            String line;
            while ((line = dis.readUTF()) != null && !line.isEmpty()) {
                fw.write(line);
                fw.write("\n");
            }
            fw.close();
            System.out.println("File downloaded successfully as 'downloaded_" + filename + "'");
        }
        
        dis.close();
        dos.close();
        s.close();
    }
}
