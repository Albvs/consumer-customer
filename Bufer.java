import java.util.LinkedList;
import java.util.List;

public class Bufer implements Runnable {
    Container container;
    List<Integer> queue = new LinkedList<Integer>();

    public Bufer(Container container){ this.container = container; }

    private void showQueue(){
        System.out.print("Actual queue state: ");
        for(Integer i : queue){ System.out.print(i + ", "); }
        System.out.println();
    }

    synchronized public void reportDemand(int id){
        queue.add(id);
        System.out.print("Demand was reported by consumer nr " + id + ". ");
        showQueue();
        container.notifyThread();
    }

    public void run(){ while(true) container.extract(queue); }
}
