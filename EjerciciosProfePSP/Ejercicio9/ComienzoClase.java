package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio9;

import java.util.Scanner;

/*
 * Se trata de simular el comienzo de una clase. Los alumnos (hilos) llegar?n y
 * esperar?n hasta que llegue el profesor (hilo) y salude para que comience la clase.
 * Los alumnos y el profesor compartir?n un objeto de la clase Bienvenida,
 * con dos m?todos sincronizados, uno mediante el cual los alumnos llegan a clase y se
 * ponen en espera mientras el profesor no llega y saluda.
 * El otro m?todo es el que invoca el profesor,
 * mediante el cual da su saludo y despierta a los alumnos que se encontraban esperando
 * para comenzar la clase.
 * */
public class ComienzoClase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bienvenida b = new Bienvenida();

        System.out.println("Introduzca el n?mero de alumnos: ");
        int n_alumnos = sc.nextInt();

        for (int i = 0; i < n_alumnos; i++) {
            new Alumno(b).start();
        }

        Profesor profesor = new Profesor("Pepito P?rez", b);
        profesor.start();
    }
}
