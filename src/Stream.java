import java.io.*;

public class Stream {


    public static void main(String[] args) {

        ////////////////////  byte Stream  ////////////////////
        /** FileInputStream in1 = null;
         FileOutputStream out1 = null;
         try {
         System.out.println("INPUT");
         in1 =new FileInputStream("C:\\Users\\Moham\\IdeaProjects\\untitled\\src\\input.txt");
         System.out.println("OUTPUT");
         out1 = new FileOutputStream("C:\\Users\\Moham\\IdeaProjects\\untitled\\src\\output.txt");
         int c;
         while ((c=in1.read()) != -1){
         System.out.println(c);
         out1.write(c);
         }
         }catch (IOException e){
         System.out.println("FEHLER");
         }  */

        ////////////////////  char Stream  ////////////////////

        /** FileReader in2 = null;
         FileWriter out2 = null;
         try {
         System.out.println("Input");
         in2=new FileReader("C:\\Users\\Moham\\IdeaProjects\\untitled\\src\\input.txt");
         System.out.println("Output");
         out2=new FileWriter("C:\\Users\\Moham\\IdeaProjects\\untitled\\src\\output.txt");

         int c;
         while ((c=in2.read()) != -1){
         System.out.println(c);
         out2.write(c);

         }

         }catch (IOException exception){
         System.out.println("FEHLER");
         }finally {
         try {
         in2.close();
         out2.close();
         } catch (IOException e) {
         e.printStackTrace();
         }
         }*/

        ////////////////////  byte-to-char Stream  ////////////////////

        /** InputStreamReader in3 = null;
         OutputStreamWriter out3 = null;
         try {
         in3 = new InputStreamReader(new FileInputStream("C:\\Users\\Moham\\IdeaProjects\\untitled\\src\\input.txt"));
         out3 = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Moham\\IdeaProjects\\untitled\\src\\output.txt"));

         int c;
         while ((c=in3.read()) != -1){
         System.out.println(c);
         out3.write(c);

         }

         }catch (IOException e){
         System.out.println("FEHLER");
         }finally {
         try {
         in3.close();
         out3.close();
         } catch (IOException e) {
         e.printStackTrace();
         }
         }*/

        ////////////////////  buffered Stream  ////////////////////

        BufferedReader buffer = null;
        PrintWriter writer = null;
        try{
            buffer = new BufferedReader(new FileReader("C:\\Users\\Moham\\IdeaProjects\\untitled\\src\\input.txt"));
            writer = new PrintWriter(new FileWriter("C:\\Users\\Moham\\IdeaProjects\\untitled\\src\\output.txt"));

            String line ="";
            while ((line = buffer.readLine())!=null){
                System.out.println(line);
                writer.println(line);
            }
        }catch(IOException e){

            System.out.println("Fehler");
        }finally {
            try {
                buffer.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
