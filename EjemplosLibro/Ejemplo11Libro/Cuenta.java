package EjerciciosProfePSP.EjemplosLibro.Ejemplo11Libro;

public class Cuenta {
    private int saldo;

    Cuenta(int s) {
        saldo = s;//Inicializa saldo actuak
    }

    int getSaldo() {//Devuelve el saldo
        return saldo;
    }

    void restar(int cantidad) {//se resta la cantidad al saldo
        saldo = saldo - cantidad;

    }

    void RetirarDinero(int cant, String nom) {
        if (getSaldo() >= cant) {
            System.out.println(nom + ": Se va a retirar saldo (El actual es: " + getSaldo() + " )");

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            restar(cant);//resta la cantidad del saldo
            System.out.println("\t" + nom + " retira => " + cant + " Actual (" + getSaldo() + ")");
        } else {
            System.out.println(nom + "No puede retirar dinero, no hay saldo (" + getSaldo() + ")");
        }
        if (getSaldo() < 0) {
            System.out.println("Saldo negativo => " + getSaldo());
        }
    }
}

