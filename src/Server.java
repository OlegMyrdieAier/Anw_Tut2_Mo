import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerError;

public class Server {
    public static void main(String[] args){
        ServerSocket server=null;
        Socket client = null;
        PrintWriter writer = null;
        BufferedReader reader = null;
        try {
            server=new ServerSocket(8080);
            client= server.accept();

            reader= new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer = new PrintWriter(client.getOutputStream());

            String str="";

            while ((str=reader.readLine()) != null){
                System.out.println(client.getInetAddress()+" : " + str);
                writer.println(str);
                writer.flush();
            }
            System.out.println("Ende");
        } catch (IOException exception) {
            exception.printStackTrace();
        }finally {
            try {
                server.close();
                client.close();
                writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
