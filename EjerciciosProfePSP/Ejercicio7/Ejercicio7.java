package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio7;

/*Crea una clase para gestionar el saldo de una Cuenta. 
Debe tener m�todos para OBTENER EL SALDO actual,
 hacer un INGRESO (se incrementa al saldo), 
 hacer un REINTEGRO (se le resta al saldo), 
 controlar si hay alg�n ERROR por ejemplo si se hace un REINTEGRO y NO hay SALDO; 
 o si se hace un ingreso y el SALDO SUPERA EL M�XIMO;
 mostrar mensajes con los MOVIMIENTOS que se realicen. 
  La cuenta recibe en su constructor el saldo actual y el valor m�ximo que puede tener.
Los m�todos de ingreso y reintegro deben definirse como synchronized. 
*/
class CuentaEjercicio7 {
    private int saldo;
    private int MAX;

    CuentaEjercicio7(int s, int max) {
        saldo = s;
        MAX = max;
    }

    // obtener el saldo actual
    public int getSaldo() {
        return saldo;
    }

    public int getMax() {
        return MAX;
    }

    void restar(int cantidad) {
        saldo = saldo - cantidad;
    }

    void sumar(int cantidad) {
        saldo = saldo + cantidad;
    }

    // Reintegro
    public synchronized void Reintegro(int cant, String nom) {
        System.out.println("SE VA A RETIRAR SALDO (ACTUAL ES: " + getSaldo() + ")");
        if (getSaldo() >= cant) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            restar(cant);
            System.out.println("\t" + nom + " retira =>" + cant + " ACTUAL(" + getSaldo() + ")");
        } else {
            System.out.println(
                    "\t" + nom + " NO PUEDE RETIRAR " + cant + ", NO HAY SALDO SUFICIENTE (" + getSaldo() + ")");
        }
        if (getSaldo() < 0) {
            System.out.println("SALDO NEGATIVO => " + getSaldo());
        }
    }// Reintegro

    // Ingreso
    public synchronized void Ingreso(int cant, String nom) {
        System.out.println("SE VA A INGRESAR SALDO (ACTUAL ES: " + getSaldo() + ")");
        int supera = getSaldo() + cant;
        if (supera > MAX) {
            System.out.println("\t" + nom + " NO PUEDE INGRESAR, La cantidad " + cant + " SUPERA EL MAXIMO: " + MAX
                    + "(" + supera + ") ");
        } else {
            sumar(cant);
            System.out.println("\t" + nom + " ingresa =>" + cant + " ACTUAL(" + getSaldo() + ")");
        }

    }// Ingreso

}

/*
 * Crea despu�s la clase Persona que extienda Thread y que realice en su m�todo
 * run() 2 ingresos y 2 reintegros altern�ndolos y con alg�n sleep() en medio.
 * Para crear los movimientos de dinero generar n�meros aleatorios entre 1 y 500
 * con la funci�n random(): int aleatorio = ((int) (Math.random()*500+1). El
 * constructor de la clase debe llevar el nombre de la persona.
 */
class Persona extends Thread {
    private CuentaEjercicio7 c;

    public Persona(String n, CuentaEjercicio7 c) {
        super(n);
        this.c = c;
    }

    public void run() {
        int aleatorio = ((int) (Math.random() * 500 + 1));
        try {

            c.Ingreso(aleatorio, getName());
            sleep(200);
            aleatorio = ((int) (Math.random() * 500 + 1));
            c.Reintegro(aleatorio, getName());

            sleep(100);
            aleatorio = ((int) (Math.random() * 500 + 1));
            c.Ingreso(aleatorio, getName());

            sleep(100);
            aleatorio = ((int) (Math.random() * 500 + 1));
            c.Reintegro(aleatorio, getName());
        } catch (InterruptedException e) {
        }

    }// run
}// Persona

//Crea en el m�todo main() un objeto Cuenta compartido por varios objetos Persona
// e inicia el proceso de realizar movimientos en la cuenta.

public class Ejercicio7 {
    public static void main(String[] args) {
        CuentaEjercicio7 c = new CuentaEjercicio7(40, 700);
        System.out.println("SALDO INICIAL: " + c.getSaldo() + " SALDO MAXIMO: " + c.getMax());

        Persona p1 = new Persona("Pedro", c);
        Persona p2 = new Persona("Ana", c);

        p1.start();
        p2.start();
    }
}
