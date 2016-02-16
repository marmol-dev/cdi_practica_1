package examplerunnable;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;


public class Example implements Runnable{
	
	private int numHilo;
	
	public Example(int numHilo){
		this.numHilo = numHilo;
	}
	
	
	
	public void run(){
		//long inicio = System.currentTimeMillis();
		System.out.println("Hello, I'm thread number " + this.numHilo);
		System.out.println("Bye, this was thread number " + this.numHilo);
		//long fin = System.currentTimeMillis();
		//Tiempo de ejecucción del hilo
		//System.out.println("Tiempo hilo " + this.numHilo + " : " + (fin - inicio));
	}
	
	public static void main (String args[]) throws InterruptedException{
		long inicio = System.currentTimeMillis();
		
		int numHilos = 0;
		
		if(args.length == 1){
			numHilos = Integer.parseInt(args[0]);
		}else{
			System.out.print("Numero incorrecto de parametros de entrada");
		}
		
		Vector<Thread> j = new Vector<Thread>();
		
		for(int i = 0; i < numHilos; i++){
			j.add(new Thread(new Example(i)));
			j.get(i).start();
		}
		
		for(int i = 0; i < numHilos; i++){
			j.get(i).join();
		}
		
		long fin = System.currentTimeMillis();
		System.out.println("Tiempo de ejecucción de hilos : " + (fin - inicio));
		
	}

}

