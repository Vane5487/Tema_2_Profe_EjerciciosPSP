package EjerciciosProfePSP.EjemplosLibro.Ejemplo1Libro;

public class Ejemplo1 extends Thread {
    //Constructor
    public Ejemplo1(String nombre) {
        super(nombre);
        System.out.println("Creando hilo: " + getName());
    }

    //metodo run
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hilo: " + getName() + " C = " + i);
        }
    }

    public static void main(String[] args) {
        Ejemplo1 h1 = new Ejemplo1("Hilo 1");
        Ejemplo1 h2 = new Ejemplo1("Hilo 2");
        Ejemplo1 h3 = new Ejemplo1("Hilo 3");

        h1.start();
        h2.start();
        h3.start();

        System.out.println("3 hilos iniciados...");
    }//Main
}

