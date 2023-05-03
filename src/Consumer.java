import java.io.IOException;
import java.util.ArrayList;

public class Consumer extends Thread {

    ArrayList<Integer> queue;


    Consumer(ArrayList<Integer> queue){
        this.queue=queue;
    }

    public void run()  {
        for (int i=0;i<100;i++){
            synchronized (queue){
                while (queue.isEmpty()){
                    System.out.println("WAITING CONSUMER");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(queue.remove(0) + " Wird entfernt");
                queue.notifyAll();
            }


        }
    }
}
