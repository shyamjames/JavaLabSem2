/* Program to implement connection less communication.
--- Server Program ---
@Shyam James
Roll no: 54
Date: 19-01-2026
*/

import java.net.*;

class Program45Server {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        DatagramPacket dp = null,reply;
        try{
            ds = new DatagramSocket(1234);
            byte[] buffer = new byte[1000];
            String meg = "Message Received";
            dp = new DatagramPacket(buffer,buffer.length);
            ds.receive(dp);
            System.out.println("From Client: "+ (new String(dp.getData()).trim()));
            System.out.println("Client PORT: " + dp.getPort());
            reply = new DatagramPacket(meg.getBytes(),meg.length(),dp.getAddress(),dp.getPort());
            ds.send(reply);
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
        ds.close();
    }
}