/*
 * Guillarte, Dana Louise A.
 * So, Chrysille Grace L.
 */
import java.net.*;
import java.io.*;

public class ChatServer
{
    public static void main(String[] args)
    {
        int nPort = Integer.parseInt(args[0]);
        System.out.println("Server: Listening on port " + args[0] + "...");
        ServerSocket serverSocket;
        Socket serverEndpointA;
        Socket serverEndpointB;

        try 
        {
            serverSocket = new ServerSocket(nPort);
            
            // Accept Client A
            serverEndpointA = serverSocket.accept();
            System.out.println("Server: New client connected: " + serverEndpointA.getRemoteSocketAddress());

            // Set up streams for Client A
            DataInputStream disA = new DataInputStream(serverEndpointA.getInputStream());
            DataOutputStream dosA = new DataOutputStream(serverEndpointA.getOutputStream());
            
            // Accept Client B
            serverEndpointB = serverSocket.accept();
            System.out.println("Server: New client connected: " + serverEndpointB.getRemoteSocketAddress());

            // Set up streams for Client B
            DataInputStream disB = new DataInputStream(serverEndpointB.getInputStream());
            DataOutputStream dosB = new DataOutputStream(serverEndpointB.getOutputStream());

            // Receive messages
            String messageFromA = disA.readUTF();
            System.out.println("Server: Received from Client A: " + messageFromA);

            String messageFromB = disB.readUTF();
            System.out.println("Server: Received from Client B: " + messageFromB);

            // Exchange messages
            dosA.writeUTF(messageFromB);
            dosB.writeUTF(messageFromA);

            // Close client sockets
            serverEndpointA.close();
            serverEndpointB.close();
            serverSocket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("Server: Connection is terminated.");
        }
    }
}
