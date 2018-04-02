package Simple_Client_Server;

/**
 * Created by Umang on 06-11-2017.
 */
import java.io.*;
import java.net.Socket;
/**
 
 */
public class Area_Calculation {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here

        String radius;

        BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 6000);

        ObjectOutputStream to_server = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream from_server = new ObjectInputStream(new BufferedInputStream(clientSocket.getInputStream()));

        System.out.print("Enter radius: ");
        radius = user_input.readLine();
        to_server.writeObject(radius);

        String area = (String) from_server.readObject();

        System.out.println("Area is: " + area);

        clientSocket.close();
    }
}