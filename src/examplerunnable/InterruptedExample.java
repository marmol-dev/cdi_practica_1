package examplerunnable;

/**
 * Clase de prueba para el ejercicio 3.2
 */
public class InterruptedExample implements Runnable {
    private String name;
    public InterruptedExample(String name){
        this.name = name;
    }

    public void run(){
        System.out.println("run() - Before work");
        try {
            work();
        } catch (InterruptedException e){
            System.out.println("run() - Exception in work");
            return;
        }
        //Nunca se llega aquí
        System.out.println("run() - After work");
    }

    private void work() throws InterruptedException {
        while(true){
            //isInterrupted() no cambia el flag de estado
            if(Thread.currentThread().isInterrupted()){
                System.out.println("work() - State A");
                //Puede lanzar excepcion
                //Cada vez que se interrumpe el thread va a lanzar excepción y salir del bucle infinito
                Thread.sleep(2000);
                //Nunca se va a llegar a este estado porque el sleep va a lanzar una InterruptedException
                //debido a que este está interrumpido
                System.out.println("work() - State B");
            }
        }
    }

    public static void main(String[] args){
        InterruptedExample r = new InterruptedExample("thread-1");
        Thread t = new Thread(r);

        t.start();

        //Bloque try-catch para el sleep
        try {
           Thread.sleep(2000);
        } catch (InterruptedException e){
            System.out.println("Somethig");
        }

        t.interrupt();

        System.out.println("main() finished");

    }
}
