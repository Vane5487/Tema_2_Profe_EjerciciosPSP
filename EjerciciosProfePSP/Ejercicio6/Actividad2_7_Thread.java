package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio6;

class ContadorActividad2_7 {
    int c;

    ContadorActividad2_7(int c) {
        this.c = c;
    }

    //synchronized
    public void incrementa() {
        c = c + 1;
        //System.out.println(c); -> También sincroniza
    }

    public int getContador() {
        return c;
    }
}// ContadorActividad2_7

public class Actividad2_7_Thread extends Thread {

    ContadorActividad2_7 contador;

    public Actividad2_7_Thread(ContadorActividad2_7 contador) {
        this.contador = contador;
    }

    public void run() {
        synchronized (contador) {
            for (int i = 0; i < 5000; i++)
                contador.incrementa();
        }
    }

    public static void main(String[] args) {
        ContadorActividad2_7 cont = new ContadorActividad2_7(0);

        Actividad2_7_Thread h1 = new Actividad2_7_Thread(cont);
        Actividad2_7_Thread h2 = new Actividad2_7_Thread(cont);
        Actividad2_7_Thread h3 = new Actividad2_7_Thread(cont);
        Actividad2_7_Thread h4 = new Actividad2_7_Thread(cont);
        Actividad2_7_Thread h5 = new Actividad2_7_Thread(cont);

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();

        try {
            h1.join();
            h2.join();
            h3.join();
            h4.join();
            h5.join();
        } catch (InterruptedException e) {
        }

        System.out.println("Valor del contador: " + cont.getContador());

    }

}
