package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio11;

public class Jugador extends Thread {
    Arbitro arbitro;
    int identificador;

    public Jugador(int elId, Arbitro elArbitro) {
        arbitro = elArbitro;
        identificador = elId;
    }

    public void run() {
        while (arbitro.seAcabo() == false) { // hasta el fin del juego
            if (arbitro.toca() == identificador) { // es nuestro turno
                int jugada = 1 + (int) (10 * Math.random());
                arbitro.nuevaJugada(identificador, jugada);
            } // if
        } // while
    } // run
}
