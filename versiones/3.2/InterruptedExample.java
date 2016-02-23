package Ej3_2;

/**
 * Clase de prueba para el ejercicio 3.2
 */
public class InterruptedExample implements Runnable {
    private String name;
    private boolean usarIsInterrupted;
    public InterruptedExample(String name, boolean usarIsInterrupted){
        this.name = name;
        this.usarIsInterrupted = usarIsInterrupted;
    }

    public void run(){
        System.out.println("run() - Before work");
        try {
            work();
        } catch (InterruptedException e){
            System.out.println("run() - Exception in work");
            return;
        }
        //Solo se llega hasta aquí con Thread.interrupted()
        System.out.println("run() - After work");
    }

    /**
     * Llama a Thread.interrupted() o Thread.currentThread().isInterrupted() dependiendo del segundo argumento
     */
    private boolean estaInterrumpido(){
        return this.usarIsInterrupted ? Thread.currentThread().isInterrupted() : Thread.interrupted();
    }

    /**
     * Hace un bucle infinito mientras alguien no lo despierta
     * @throws InterruptedException
     */
    private void work() throws InterruptedException {
        while(true){
            if(estaInterrumpido()){
                System.out.println("work() - State A");
                //Puede lanzar excepcion
                //Si el flag de interrupcion está activado se lanza una InterruptedException
                Thread.sleep(2000);
                //Solo se llega hasta aquí si no se ha lanzado InterruptedException, es decir, se ha usado
                //Thread.interrupted() en el método estaInterrumpido()
                System.out.println("work() - State B (Thread.interrupted())");
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{

        //Instanciamos el objeto que implementa Runnable con la opción de usar isInterrupted()
        InterruptedExample r = new InterruptedExample("thread-isinterrupted", true);
        Thread t = new Thread(r);

        t.start();

        try {
           Thread.sleep(2000);
        } catch (InterruptedException e){}

        t.interrupt();

        System.out.println("main() finished with isInterrupted()");

        //Instanciamos el objeto que implementa Runnable con la opción de usar interrupted()
        r = new InterruptedExample("thread-isinterrupted", false);
        t = new Thread(r);

        t.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){}

        t.interrupt();

        System.out.println("main() finished with isInterrupted()");
        t.join();
        System.out.println("Program of excercise 3.2 has terminated");
    }
}
