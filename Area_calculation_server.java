package Simple_Client_Server;

/**
 
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Area_calculation_server {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here

        ServerSocket server_socket = new ServerSocket(6000);

        while(true){

            Socket clientSocket = server_socket.accept();
            ObjectInputStream from_client = new ObjectInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            ObjectOutputStream to_client = new ObjectOutputStream(clientSocket.getOutputStream());
            String input_string_radius = (String) from_client.readObject();

            System.out.println(input_string_radius);

            double radius = Double.parseDouble(input_string_radius);
            double area = 22 * radius * radius / 7;

            to_client.writeObject("" + area);
        }
    }

}
