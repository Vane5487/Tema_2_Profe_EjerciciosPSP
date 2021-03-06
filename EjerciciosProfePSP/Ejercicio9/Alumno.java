package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio9;

public class Alumno extends Thread {
    Bienvenida saludo;

    public Alumno(Bienvenida bienvenida) {
        this.saludo = bienvenida;
    }

    public void run() {
        System.out.println("Alumno lleg?");
        try {
            Thread.sleep(1000);
            saludo.saludaProfesor();
        } catch (InterruptedException ex) {
            System.err.println("Thread alumno interrumpido");
            System.exit(-1);
        }
    }
}
