/*
 * Guillarte, Dana Louise A.
 * So, Chrysille Grace L.
 */
import java.net.*;
import java.io.*;

public class ChatClient
{
    public static void main(String[] args)
    {
        String sServerAddress = args[0];
        int nPort = Integer.parseInt(args[1]);
        String userName = args[2];
        String message = args[3];

        try
        {
            Socket clientEndpoint = new Socket(sServerAddress, nPort);
            System.out.println("Client: Connected to server at " + clientEndpoint.getRemoteSocketAddress());

            // Send composed message
            DataOutputStream dosWriter = new DataOutputStream(clientEndpoint.getOutputStream());
            String fullMessage = "Message from " + userName + ": " + message;
            dosWriter.writeUTF(fullMessage);

            // Receive message from server
            DataInputStream disReader = new DataInputStream(clientEndpoint.getInputStream());
            System.out.println("Client: Received -> " + disReader.readUTF());

            clientEndpoint.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
		{
			System.out.println(userName + ":" +  " Connection is terminated.");
		}
    }
}
