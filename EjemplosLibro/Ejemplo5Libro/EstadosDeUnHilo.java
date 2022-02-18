package EjerciciosProfePSP.EjemplosLibro.Ejemplo5Libro;

public class EstadosDeUnHilo extends Thread {
    private boolean stopHilos = false;

    public void pararHilo() {
        stopHilos = true;
    }

    public void run() {
        while (!stopHilos) {
            System.out.println("En el hilo");
        }
    }

    public static void main(String[] args) {
        EstadosDeUnHilo h = new EstadosDeUnHilo();
        h.start();
        for (int i = 0; i < 100000; i++) {//No hago nada
            h.pararHilo(); //Parar el hiolo
        }
    }
}
