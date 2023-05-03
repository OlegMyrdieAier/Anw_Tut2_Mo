import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Socket client = null;
        PrintWriter writer = null;
        Scanner in = null;
        BufferedReader reader= null;
        try {
            client=new Socket("192.168.0.4",8080);
            writer = new PrintWriter(client.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            in = new Scanner(System.in);

            String str = "";

            while (true){
                System.out.println("Enter message: ");
                str = in.nextLine();
                if(str.equals("quit") )return;
                writer.println(str);
                writer.flush();
                System.out.println("Server: "+ reader.readLine());
            }
        } catch (UnknownHostException e) {
            System.out.println("FEHLER");
        } catch (IOException exception) {
            exception.printStackTrace();
        }finally {
            try {

                //client.close();
                writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
