package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio1;

public class E01_Hilo extends Thread {

    public void run() {
        System.out.println("Hola Mundo " + Thread.currentThread().getId());
    }
}
