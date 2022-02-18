package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio6;

class ContadorActividad2_7_Runnable {
    int c;

    ContadorActividad2_7_Runnable(int c) {
        this.c = c;
    }

    // synchronized
    public void incrementa() {
        c = c + 1;
    }

    public int getContador() {
        return c;
    }
}// ContadorEjercicio7

class Actividad2_7_Runnable_hilo implements Runnable {
    ContadorActividad2_7_Runnable contador;

    public Actividad2_7_Runnable_hilo(ContadorActividad2_7_Runnable contador) {
        this.contador = contador;
    }

    public void run() {
        synchronized (contador) {
            for (int i = 0; i < 5000; i++)
                contador.incrementa();
        }
    }
}// Ejercicio7_Runnable_hilo

public class Actividad2_7_Runnable {

    public static void main(String[] args) {
        ContadorActividad2_7_Runnable cont = new ContadorActividad2_7_Runnable(0);

        Actividad2_7_Runnable_hilo hilo = new Actividad2_7_Runnable_hilo(cont);

        Thread h1 = new Thread(hilo);
        Thread h2 = new Thread(hilo);
        Thread h3 = new Thread(hilo);
        Thread h4 = new Thread(hilo);
        Thread h5 = new Thread(hilo);

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();

        try {
            h1.join();
            h2.join();
            h3.join();
            h4.join();
            h5.join();
        } catch (InterruptedException e) {
        }

        System.out.println("Valor del contador: " + cont.getContador());

    }

}// Actividad2_7_Runnable
