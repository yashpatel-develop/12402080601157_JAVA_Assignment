import java.io.*;
import java.net.*;

public class EchoServer {

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is running...");

            Socket socket = server.accept();
            System.out.println("Client connected");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String message = input.readLine();

            System.out.println("Client says: " + message);

            // Echo back to client
            output.println("Echo: " + message);

            socket.close();
            server.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}