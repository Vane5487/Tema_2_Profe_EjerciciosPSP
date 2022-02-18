package EjerciciosProfePSP.EjemplosLibro.Ejemplo4Libro;

public class PrimerHiloR implements Runnable {

    public void run() {
        System.out.println("Hola desde el Hilo!: " + Thread.currentThread().getId());
    }

}



