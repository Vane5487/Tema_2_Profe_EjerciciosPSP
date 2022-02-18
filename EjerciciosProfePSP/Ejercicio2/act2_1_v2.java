package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio2;

class tictac {
    private String cadena;
    private boolean disponible = false;

    public synchronized String get() {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        disponible = false;
        notifyAll();
        return cadena;
    }

    public synchronized void put(String valor) {
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        cadena = valor;
        disponible = true;
        notifyAll();
    }
}

class Hilo1_C extends Thread {
    private tictac tictac;

    public Hilo1_C(tictac c) {
        tictac = c;
    }

    public void run() {
        String cadena = "";
        while (true) {
            cadena = tictac.get();
            System.out.println(cadena);
        }
    }
}

class Hilo2_P extends Thread {
    private tictac tictac;

    public Hilo2_P(tictac c) {
        tictac = c;
    }

    public void run() {
        int i = 0;
        String cad = "";
        while (true) {

            if (i % 2 == 0) cad = " TIC ";
            else cad = " TAC ";

            tictac.put(cad);
            i++;
        }
    }
}

public class act2_1_v2 {
    public static void main(String[] args) {
        tictac tt = new tictac();
        Hilo2_P p = new Hilo2_P(tt);
        Hilo1_C c = new Hilo1_C(tt);
        p.start();
        c.start();
    }
}
