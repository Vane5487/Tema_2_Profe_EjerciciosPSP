package EjerciciosProfePSP.EjemplosLibro.Ejemplo9Libro;

class HiloA extends Thread {
    private Contador contador;

    public HiloA(String n, Contador c) {
        setName(n);
        contador = c;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            contador.incrementa();//incrementa el contador
            try {
                sleep(100);
            } catch (InterruptedException e) {

            }
        }
        System.out.println(getName() + " contador vale " + contador.valor());
    }
}


