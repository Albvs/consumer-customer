public class Producer implements Runnable{
    Container container;
    private String color;

    public Producer (Container container, String color) {
        this.container = container;
        this.color = color;
    }

    public void run(){
        while (true){
            try{
                Thread.sleep((int)(2000 * Math.random()));
            } catch (InterruptedException e){}
            container.add(color);
        }
    }
}