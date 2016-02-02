package examplethreads;

public class Example extends Thread {
	public void run(){
		System.out.println("Hello world i am a java thread (thread)");
	}
	public static void main(String args[]){
		(new Example()).start();
		
	}
}
