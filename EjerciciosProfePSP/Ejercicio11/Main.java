package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio11;
/* Ejercicio sacado de:
   http://gpd.sip.ucm.es/rafa/docencia/programacion/tema4/hebras.pdf
*/

public class Main {
    public static void main(String[] args) {
        // creamos el �rbitro y los jugadores
        Arbitro arbitro = new Arbitro(3); // 3 jugadores

        Jugador j1 = new Jugador(1, arbitro);
        Jugador j2 = new Jugador(2, arbitro);
        Jugador j3 = new Jugador(3, arbitro);
		/*Jugador j4 = new Jugador(4, arbitro);
		Jugador j5 = new Jugador(5, arbitro);
		Jugador j6 = new Jugador(6, arbitro);
		Jugador j7 = new Jugador(7, arbitro);*/
        // ponemos a los jugadores en marcha

        j1.start();
        j2.start();
        j3.start();
		/*j4.start();
		j5.start();
		j6.start();
		j7.start();*/
    }
}

