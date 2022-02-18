package EjerciciosProfePSP.EjemplosLibro.Ejemplo3Libro;

public class HiloEjemplo3 extends Thread {
    public void run() {
        System.out.println("Dentro del hilo: " + Thread.currentThread().getName() + "\n\t Prioridad: " + Thread.currentThread().getPriority() + "\n\t ID : " + Thread.currentThread().getId() + "\n\t Hilos activos : " + Thread.currentThread().activeCount());
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("Principal");//Nombre a main
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());

        HiloEjemplo3 h = null;

        for (int i = 0; i < 3; i++) {
            h = new HiloEjemplo3(); //Crea hilo
            h.setName("Hilo" + i); //Damos el nombre al hilo
            h.setPriority(i + 1); //Damos prioridad
            h.start();  //Inicia hilo
            System.out.println("Información del " + h.getName() + ": " + h.toString());
            System.out.println("3 hilos creados...");
            System.out.println("Hilos activos: " + Thread.activeCount());
        }
    }
}
