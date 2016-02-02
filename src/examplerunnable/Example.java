package examplerunnable;

public class Example implements Runnable{
	public void run(){
		System.out.println("Hello world i am a java thread(runable)");	
	}
	
	public static void main (String args[]){
		(new Thread(new Example())).start();
	}

}
