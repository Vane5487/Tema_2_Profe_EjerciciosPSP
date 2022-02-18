package EjerciciosProfePSP.EjemplosLibro.Ejemplo2Libro;

class HijoEjemplo1_V2 extends Thread {
    //Constructor
    public HijoEjemplo1_V2(String nombre) {
        super(nombre);
        System.out.println("Creando hilo;" + getName());
    }//metodo run


    public class Ejemplo2 {
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hilo: " + getName() + " C = " + i);

            }
        }
    }


    public static class UsaHiloEjemplo1_V2 {
        public UsaHiloEjemplo1_V2(String s) {
        }

        public static void main(String[] args) {
            UsaHiloEjemplo1_V2 h1 = new UsaHiloEjemplo1_V2("Hilo 1");
            UsaHiloEjemplo1_V2 h2 = new UsaHiloEjemplo1_V2("Hilo 2");
            UsaHiloEjemplo1_V2 h3 = new UsaHiloEjemplo1_V2("Hilo 3");

            h1.start();
            h2.start();
            h3.start();

            System.out.println("3 Hilos iniciados");
        }

        private void start() {
        }


    }
}

