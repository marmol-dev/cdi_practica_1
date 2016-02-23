public class Example implements Runnable {
    public void run() {
        System.out.println("Hello world i am a java thread(runable)");
        System.out.println("Program 1.3 has finished");
    }

    public static void main (String args[]) throws InterruptedException {
        Thread.sleep(1000);
        Thread t = new Thread(new Example());
        t.start();
    }

}