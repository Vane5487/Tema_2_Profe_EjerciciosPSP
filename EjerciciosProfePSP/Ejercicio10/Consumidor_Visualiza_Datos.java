package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio10;

public class Consumidor_Visualiza_Datos extends Thread {
    private Cola cola;
    private int n;

    public Consumidor_Visualiza_Datos(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        int i = cola.get();
        while (i != -1) {
            System.out.printf("%c [%d] %n", (char) i, n);
            i = cola.get(); //recoge el valor
        }
        System.out.println("\nFin consumidor " + n);
    }
}
