import java.util.Iterator;
import java.util.Map;


public class Example implements Runnable{
    public void run(){
        System.out.println("Hello world i am a java thread(runable)");
    }

    public static void main (String args[]) throws InterruptedException{
        Map hilos;
        Thread.sleep(1000);
        (new Thread(new Example())).start();
        hilos = Thread.getAllStackTraces();
        Iterator<Thread> it = hilos.keySet().iterator();
        Thread aux;
        while(it.hasNext()){
            aux = it.next();
            System.out.println("ID: " + aux.getId() + ", Name: " + aux.getName());
        }
        System.out.println("Program 1.4 has finished");
    }

}