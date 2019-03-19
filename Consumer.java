public class Consumer implements Runnable{
    Bufer bufer;
    private int id;

    public Consumer (Bufer bufer, int id) {
        this.bufer = bufer;
        this.id = id;
    }

    public void run(){
        while (true){
            try{
                Thread.sleep((int)(6000 * Math.random()));
            } catch (InterruptedException e){}
            bufer.reportDemand(id);
        }
    }
}
