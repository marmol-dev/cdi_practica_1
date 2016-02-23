import java.util.Iterator;
import java.util.Map;
import java.util.Vector;


public class Example implements Runnable{

    private int numHilo;
    private long tiempoEjecuccion;

    public Example(int numHilo){
        this.numHilo = numHilo;
    }

    public long getTiempoEjecuccion() {
        return this.tiempoEjecuccion;
    }


    public void run(){
        long inicio = System.currentTimeMillis();
        System.out.println("Hello, I'm thread number " + this.numHilo);
        System.out.println("Bye, this was thread number " + this.numHilo);
        this.tiempoEjecuccion = System.currentTimeMillis() - inicio;
    }

    public static void main (String args[]) throws InterruptedException{
        long inicio = System.currentTimeMillis();

        int numHilos = 0;

        if(args.length == 1){
            numHilos = Integer.parseInt(args[0]);
        }else{
            System.out.print("Numero incorrecto de parametros de entrada");
            return;
        }

        Vector<Thread> j = new Vector<Thread>();
        Vector<Example> runnables = new Vector<Example>();

        for(int i = 0; i < numHilos; i++){
            runnables.add(new Example(i));
            j.add(new Thread(runnables.get(i)));
            j.get(i).start();
        }

        for(int i = 0; i < numHilos; i++){
            j.get(i).join();
        }

        long fin = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucción de hilos global: " + (fin - inicio));

        long tiempoSumaHilos = 0;
        for (int i = 0; i < numHilos; i++){
            tiempoSumaHilos += runnables.get(i).getTiempoEjecuccion();
        }

        System.out.println("Tiempo total de suma de hilos: " + tiempoSumaHilos);

        System.out.println("Program 2.4 has finished");

    }

}
