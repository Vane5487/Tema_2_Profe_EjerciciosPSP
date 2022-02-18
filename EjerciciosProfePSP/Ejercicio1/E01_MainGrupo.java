package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio1;

public class E01_MainGrupo extends Thread {
    public static void main(String[] args) {
        ThreadGroup grupo = new ThreadGroup("Grupo Hola Mundo");
        E01_Hilo h = new E01_Hilo();

        Thread h1 = new Thread(grupo, h, "Hilo 1");
        System.out.println(h1.getName());// Mirar referencias a envoltorio Thread
        Thread h2 = new Thread(grupo, h, "Hilo 2");
        Thread h3 = new Thread(grupo, h, "Hilo 3");
        Thread h4 = new Thread(grupo, h, "Hilo 4");
        Thread h5 = new Thread(grupo, h, "Hilo 5");

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();

    }

}
