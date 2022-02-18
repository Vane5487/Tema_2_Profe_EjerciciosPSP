package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio11;

class Arbitro {
    private int totalJugadores; // n�m. de jugadores
    private int turno; // a qui�n le toca
    private int numero; // n�mero a adivinar
    private boolean acabo; // true cuando se haya terminado el juego

    public Arbitro(int nJugadores) {// constructora
        totalJugadores = nJugadores;
        turno = 1;// + (int) (totalJugadores * Math.random());
        numero = 1 + (int) (10 * Math.random()); // n�mero entre 1 y 10
        System.out.println("NUMERO A ADIVINAR: " + numero);
        acabo = false;
    }

    public int toca() {
        return turno;
    }

    public boolean seAcabo() {
        return acabo;
    }

    public synchronized void nuevaJugada(int jugador, int suNumero) {

        if (jugador == toca()) { // ha acertado
            System.out.println("Jugador" + jugador + " dice: " + suNumero);
            if (suNumero == numero) {
                System.out.println("Jugador " + jugador + " gana, adivin� el n�mero!!!");
                acabo = true;
            } else // ha fallado. ver a quien le toca ahora
                if (turno == totalJugadores)
                    turno = 1;
                else
                    turno++;
        } else
            System.out.println(jugador + " trata de hacer trampa!");

        if (!acabo)
            System.out.println("\tLe toca a Jug" + turno);
    }
}