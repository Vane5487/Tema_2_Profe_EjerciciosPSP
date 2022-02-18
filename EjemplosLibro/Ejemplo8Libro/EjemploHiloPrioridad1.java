package EjerciciosProfePSP.EjemplosLibro.Ejemplo8Libro;

public class EjemploHiloPrioridad1 {
    public static void main(String[] args) {
        HiloPrioridad1 h1 = new HiloPrioridad1("Hilo1");
        HiloPrioridad1 h2 = new HiloPrioridad1("Hilo2");
        HiloPrioridad1 h3 = new HiloPrioridad1("Hilo3");

        h1.setPriority(Thread.NORM_PRIORITY);
        h2.setPriority(Thread.MAX_PRIORITY);
        h3.setPriority(Thread.MIN_PRIORITY);

        h1.start();
        h2.start();
        h3.start();

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }

        h1.paraHilo();
        h2.paraHilo();
        h3.paraHilo();

        System.out.println("h2 (Prioridad Máxima): " + h2.getContador());
        System.out.println("h1 (Prioridad Normal): " + h1.getContador());
        System.out.println("h3 (Prioridad Mínima): " + h3.getContador());
    }
}
