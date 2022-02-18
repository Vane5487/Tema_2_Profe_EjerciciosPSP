package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio1;

public class E01_Main extends Thread {
    public static void main(String[] args) {
        E01_Hilo h1 = new E01_Hilo();
        E01_Hilo h2 = new E01_Hilo();
        E01_Hilo h3 = new E01_Hilo();
        E01_Hilo h4 = new E01_Hilo();
        E01_Hilo h5 = new E01_Hilo();

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();

    }
}
