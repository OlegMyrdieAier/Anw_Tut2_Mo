import java.util.ArrayList;
import java.util.List;

public class ProCon {


    public static void main(String[] args) {
        int max=20;
        ArrayList<Integer> list = new ArrayList<>();
        Producer producer = new Producer(list,max);
        Consumer consumer = new Consumer(list);

        producer.start();
        consumer.start();


    }
}
