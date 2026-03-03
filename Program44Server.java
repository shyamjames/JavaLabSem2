/* Program to implement public chatting.
--- Server Program ---
@Shyam James
Roll no: 54
Date: 17-01-2026
*/

import java.io.*;
import java.net.*;
import java.util.*;

public class Program44Server{
    private static final List<DataOutputStream> clients = Collections.synchronizedList(new ArrayList<>());

    private static void broadcast(String message, DataOutputStream sender) {
        synchronized (clients) {
            for (DataOutputStream client : clients) {
                if (client != sender) {
                    try {
                        client.writeUTF(message);
                        client.flush();
                    } catch (IOException e) {
                        // Ignore failed client write; disconnected clients are removed on close
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Server Started!");

        while (true) {
            Socket s = ss.accept();
            System.out.println("Client Connected: " + s.getInetAddress());

            // Handle client in a new thread
            new Thread(() -> {
                DataInputStream dis = null;
                DataOutputStream dos = null;
                try {
                    dis = new DataInputStream(s.getInputStream());
                    dos = new DataOutputStream(s.getOutputStream());
                    clients.add(dos);
                    broadcast("A new client joined the chat.", dos);
                    String msg;

                    while (true) {
                        msg = dis.readUTF();
                        if (msg.equals("exit")) {
                            break;
                        }
                        String out = s.getInetAddress() + ": " + msg;
                        System.out.println("Broadcasting: " + out);
                        broadcast(out, dos);
                    }
                } catch (IOException e) {
                    System.out.println("Client disconnected: " + s.getInetAddress());
                } finally {
                    if (dos != null) {
                        clients.remove(dos);
                        broadcast("A client left the chat.", dos);
                    }
                    try {
                        if (dis != null) dis.close();
                        if (dos != null) dos.close();
                        s.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }).start();
        }
    }
}