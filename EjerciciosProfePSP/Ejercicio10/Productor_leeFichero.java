package EjerciciosProfePSP.EjerciciosProfePSP.Ejercicio10;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Productor_leeFichero extends Thread {
    private Cola cola;
    private String nombre;


    // crear el flujo de entrada

    public Productor_leeFichero(Cola c, String nombreFichero) {
        cola = c;
        this.nombre = nombreFichero;
    }

    public void run() {
        File fichero = new File(nombre); // declarar fichero
        if (fichero.exists()) {
            try {
                FileReader fic = new FileReader(fichero);
                int i;
                while ((i = fic.read()) != -1) // se va leyendo un car�cter
                {
                    //char c= (char) i;
                    cola.put(i); // pone el car�cter

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
                cola.put(i);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
        System.out.println("\nFin Productor");
    }//run
}
