public class Program {
    public static void main(String[] args){
        Container container = new Container();

        Bufer bufer = new Bufer(container);

        Producer producer1 = new Producer(container, "red");
        Producer producer2 = new Producer(container, "blue");

        Consumer consumer1 = new Consumer(bufer, 1);
        Consumer consumer2 = new Consumer(bufer, 2);
        Consumer consumer3 = new Consumer(bufer, 3);

        Thread producerThread1 = new Thread(producer1);
        Thread producerThread2 = new Thread(producer2);

        Thread consumerThread1 = new Thread(consumer1);
        Thread consumerThread2 = new Thread(consumer2);
        Thread consumerThread3 = new Thread(consumer3);

        Thread buferThread = new Thread(bufer);

        producerThread1.start();
        producerThread2.start();

        buferThread.start();

        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
    }
}
