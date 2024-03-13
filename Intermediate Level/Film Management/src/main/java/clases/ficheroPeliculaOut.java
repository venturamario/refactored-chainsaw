/*
AUTOR: Mario Ventura Burgos
FECHA: 3-03-2022
ASIGNATURA: Programación II
TRABAJO: Programa de gestión de objetos película con ficheros
*/

package clases;

import java.io.FileWriter;
import java.io.IOException;

//Establece un enlace de salida con el fichero dado
public class ficheroPeliculaOut {
    //------------------------ATRIBUTOS------------------------
    private FileWriter fw;              //Enlace para escribir en un fichero
    
    
    //-------------------------MÉTODOS-------------------------
    //Constructor/es
    public ficheroPeliculaOut(String f) {
        //Bloque try-catch para contemplar posibles excepciones
        try {
            //Instanciar enlace con el fichero
            fw = new FileWriter(f);
        } catch (Exception e) {
            System.err.println("ERROR: " +e.toString());
        }
    }
    
    //Método para escribir una pelicula en un fichero
    public void escribirPelicula(Pelicula p) throws IOException {  
        //Escribir datos de la pelicula en el fichero
        fw.write("TITULO: "+p.getTitulo());
        fw.write("\n");
        fw.write("DIRECTOR: "+p.getDirector());
        fw.write("\n");
        fw.write("AÑO: "+p.getAño());
        fw.write("\n\n");
    }
    
    //Metodo para cerrar el enlace
    public void cerrarEnlace() throws IOException {
        fw.close();
    }
}
