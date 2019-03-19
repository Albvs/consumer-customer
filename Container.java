import java.util.List;

public class Container {
    private int redBallsQuantity, blueBallsQuantity;

    public boolean thereIsEnoughBalls(){ return (redBallsQuantity==0 || blueBallsQuantity==0) ? false : true; }

    private void showQuantity(){ System.out.println("( red balls: " + redBallsQuantity + ". blue balls: " + blueBallsQuantity + " )"); }

    synchronized  public void notifyThread(){ notifyAll(); }

    synchronized public void extract(List<Integer> queue){
        if(queue.isEmpty() || !thereIsEnoughBalls())
            try {
                wait();
            } catch (InterruptedException e) { }
        else {
            System.out.print("Consumer nr " + queue.get(0) + " gets ordered balls. ");
            queue.remove(0);
            redBallsQuantity--;
            blueBallsQuantity--;
            showQuantity();
        }
    }
    synchronized public void add(String color){
        if(color.equals("red")) redBallsQuantity++;
        if(color.equals("blue")) blueBallsQuantity++;
        System.out.print(color + " ball is being added to the container");
        showQuantity();
        notifyThread();
    }
}