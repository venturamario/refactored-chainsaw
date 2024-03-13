/*
AUTOR: Mario Ventura Burgos
FECHA: 3-03-2022
ASIGNATURA: Programación II
TRABAJO: Programa de gestión de objetos película con ficheros
*/

package clases;

import java.io.FileReader;
import java.io.IOException;

//Establece un enlace de entrada con el fichero dado
public class ficheroPeliculaIn {
    //------------------------ATRIBUTOS------------------------
    private FileReader fr;              //File Reader
    private final int finalFichero = -1;//Fin del fichero
    
    
    //-------------------------MÉTODOS-------------------------
    //Constructor/es
    public ficheroPeliculaIn(String f) {
        //Usar bloque try-catch para contemplar posibles excepciones
        try {
            //Instanciar enlace con el fichero
            fr = new FileReader(f);
        } catch(Exception e) {
            System.err.println("ERROR: " +e.toString());
        }
    }
    
    //Leer película
    public void leerPeliculas(String nomFic) throws IOException {
        //Variable donde se almacena el valor leido
        int valor;
        //Leer el primer caracter
        valor = fr.read();
        
        //Bucle de lectura
        while(valor != finalFichero) {
            //Cast de numero a char (1 char = 1 byte = 1 caracter ascii)
            char c = (char) valor;
            //Imprimir caracter leído por consola
            System.out.print(c);
            //Leer siguiente caracter
            valor = fr.read();
        }
    }
    
    //Metodo para cerrar el enlace con el fichero
    public void cerrarEnlace() throws IOException {
        //Método close para cerrar enlace con el fichero dado
        fr.close();
    }
}
