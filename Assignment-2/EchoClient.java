import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 6000);

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter message: ");
            String message = sc.nextLine();

            output.println(message);

            String response = input.readLine();

            System.out.println("Server replied: " + response);

            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}