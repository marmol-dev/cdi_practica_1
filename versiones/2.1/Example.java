
import java.util.Iterator;
import java.util.Map;


public class Example implements Runnable{

    private int numHilo;

    public Example(int numHilo){
        this.numHilo = numHilo;
    }



    public void run(){
        System.out.println("Hello, I'm thread number " + this.numHilo);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            return;
        }
        System.out.println("Bye, this was thread number " + this.numHilo);
    }

    public static void main (String args[]) throws InterruptedException{
        int numHilos = 0;

        if(args.length == 1){
            numHilos = Integer.parseInt(args[0]);
        }else{
            System.out.print("Numero incorrecto de parametros de entrada");
        }

        for(int i = 0; i < numHilos; i++){
            new Thread(new Example(i)).start();
        }

        //El programa no termina aquí ya que puede que queden hilos sin ejecutar
        //Se necesitaría usar t.join() para sincronizarlos pero no entra dentro del propósito de este ejercicio
        System.out.println("Program 2.1 has finished");
    }

}