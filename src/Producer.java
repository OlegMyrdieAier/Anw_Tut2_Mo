import java.awt.*;
import java.util.ArrayList;

public class Producer extends Thread{

    ArrayList<Integer> queue;
    int max;

    Producer(ArrayList<Integer> queue,int max){
        this.queue=queue;
        this.max=max;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            int rdm = (int)(Math.random()*20);
            synchronized (queue){
                while (!(queue.size()<max)){
                    System.out.println("WAITING Producer");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(rdm + " Wird hinzugefügt");
                queue.add(rdm);
                queue.notifyAll();
            }

        }

    }
}
