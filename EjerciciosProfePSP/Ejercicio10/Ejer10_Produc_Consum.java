package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio10;

public class Ejer10_Produc_Consum {
    public static void main(String[] args) {

        Cola cola = new Cola();

        Productor_leeFichero p = new Productor_leeFichero(cola, "f1.txt");
        Consumidor_Visualiza_Datos c = new Consumidor_Visualiza_Datos(cola, 1);
        Consumidor_Visualiza_Datos c2 = new Consumidor_Visualiza_Datos(cola, 2);
        Consumidor_Visualiza_Datos c3 = new Consumidor_Visualiza_Datos(cola, 3);

        p.start();
        c.start();
        c2.start();
        c3.start();

        try {
            p.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Estado Consumidor 1: " + c.getState());
        System.out.println("Estado Consumidor 2: " + c2.getState());
        System.out.println("Estado Consumidor 3: " + c3.getState());

        //cuando termina el productor hemos de finalizar los consumidores	
        if (c.isAlive()) {
            cola.put(-1);
            c.interrupt();
        }
        if (c2.isAlive()) {
            cola.put(-1);
            c2.interrupt();
        }
        if (c3.isAlive()) {
            cola.put(-1);
            c3.interrupt();
        }


    }
}