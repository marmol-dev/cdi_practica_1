import java.util.Iterator;
import java.util.Map;
import java.util.Vector;


public class Example implements Runnable{
	
	private int numHilo;
	private int modoOperacion;

	private long tiempoEjecuccion;
	
	public Example(int numHilo, int modoOperacion){

		this.numHilo = numHilo;
		this.modoOperacion = modoOperacion;
	}
	
	public long getTiempoEjecuccion() {
		return this.tiempoEjecuccion;
	}

	public boolean esPrimo(int numero){
		int contador = 2;
		boolean primo=true;
		while ((primo) && (contador!=numero)){
			if (numero % contador == 0)
				primo = false;
			contador++;
		}
		return primo;
	}

	public void generarPrimoAleatorio(){
		int aleatorio;

		do {
			aleatorio = ((int) Math.floor(Math.random()*999999)) + 2;
		} while (!esPrimo(aleatorio));
	}

	public void escribirMensaje(){
		System.out.println("Hello world from thread number " + numHilo);
	}
	
	
	public void run(){
		long inicio = System.currentTimeMillis();

		switch(this.modoOperacion){
			case 1:
				generarPrimoAleatorio();
				break;
			case 2:
				escribirMensaje();
				break;

		}

		this.tiempoEjecuccion = System.currentTimeMillis() - inicio;
	}
	
	public static void main (String args[]) throws InterruptedException{
		long inicio = System.currentTimeMillis();
		long inicio_creacion, total_creacion = 0, inicio_ejecuccion, total_ejecuccion = 0,
				inicio_sincronizacion, total_sincronizacion = 0;
		
		int numHilos = 0;
		int modoOperacion;
		
		if(args.length == 2){
			numHilos = Integer.parseInt(args[0]);
			modoOperacion = Integer.parseInt(args[1]);
			if (modoOperacion != 1 && modoOperacion != 2){
				System.out.println("El modo de operacion debe ser 1 o 2");
				return;
			}
		}else{
			System.out.print("Numero incorrecto de parametros de entrada");
			return;
		}
		
		Vector<Thread> j = new Vector<Thread>();
		Vector<Example> runnables = new Vector<Example>();

		//Creación
		//Se cuenta el tiempo de creación
		inicio_creacion = System.currentTimeMillis();
		for(int i = 0; i < numHilos; i++){
			runnables.add(new Example(i, modoOperacion));
			//Crear Thread
			j.add(new Thread(runnables.get(i)));
		}
		total_creacion = System.currentTimeMillis() - inicio_creacion;

		//Ejecucción
		//El tiempo de ejecucción es el tiempo desde el inicio de ejecucción hasta el final de sincronización menos el
		//tiempo total de sincronización
		inicio_ejecuccion = System.currentTimeMillis();
		for(int i = 0; i < numHilos; i++){
			j.get(i).start();
		}

		j.get(0).interrupt();

		//Contador de tiempo de sincronización
		inicio_sincronizacion = System.currentTimeMillis();
		for(int i = 0; i < numHilos; i++){
			j.get(i).join();
		}
		total_sincronizacion = System.currentTimeMillis() - inicio_sincronizacion;

		total_ejecuccion = (System.currentTimeMillis() - inicio_ejecuccion) - total_sincronizacion;

		long fin = System.currentTimeMillis();

		System.out.println("Tiempo de creación de hilos: " + total_creacion);
		System.out.println("Tiempo de ejecucción de hilos: " + total_ejecuccion);
		System.out.println("Tiempo de sincronización de hilos: " + total_sincronizacion);
		System.out.println("Tiempo total: " + (fin - inicio));
		
		System.out.println("Program of excercise 2.6 has terminated");


	}

}

