public class Example2 extends Thread {
    public void run(){
        System.out.println("Hello world i am a java thread (thread)");
        System.out.println("Program 1.2 has finished");
    }
    public static void main(String args[]){
        (new Example2()).start();

    }
}