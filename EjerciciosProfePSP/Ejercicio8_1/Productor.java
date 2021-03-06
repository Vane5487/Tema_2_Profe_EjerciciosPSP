package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio8_1;

public class Productor extends Thread {
    private Cola cola;
    private int n;

    public Productor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            cola.put(i); //pone el n?mero
            System.out.println(i + "=>" + " Productor: " + n + ", produce " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Fin productor...");
    }
}


