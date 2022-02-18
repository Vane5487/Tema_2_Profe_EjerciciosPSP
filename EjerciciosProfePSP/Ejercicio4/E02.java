package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio4;

class Cajero {
    int localidades = 0;
    String nombre;

    public Cajero(String n) {
        nombre = n;
    }

    public synchronized void sumarLocalidades() {
        localidades++;
    }

    public int mostrarLocalidades() {
        return localidades;
    }
}

class Terminal extends Thread {
    String nombre;
    Cajero obj;
    int loc = 0;

    public Terminal(String nombre, Cajero c) {
        this.nombre = nombre;
        obj = c;
    }

    public void run() {
        for (int i = 0; i < 20000; i++) {
            obj.sumarLocalidades();
            loc++;
        }
        System.out.println("Terminal: " + this.nombre + " vendió " + loc);
    }

}

public class E02 {
    public static void main(String[] args) {
        int total;
        Cajero compartido = new Cajero("Cajero Alameda");

        Terminal t1 = new Terminal("terminal1", compartido);
        Terminal t2 = new Terminal("terminal2", compartido);
        Terminal t3 = new Terminal("terminal3", compartido);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            System.out.println("Interrupción");
        }

        total = compartido.mostrarLocalidades();

        System.out.println("En total se vendieron " + total + " localidades.");
    }
}
