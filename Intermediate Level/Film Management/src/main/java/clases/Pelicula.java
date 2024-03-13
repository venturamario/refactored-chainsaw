/*
AUTOR: Mario Ventura Burgos
FECHA: 3-03-2022
ASIGNATURA: Programación II
TRABAJO: Programa de gestión de objetos película con ficheros
*/

package clases;

//CLASE PELICULA
public class Pelicula {
    
    //------------------------ATRIBUTOS------------------------
    private String titulo;          //Título de la pelicula
    private String director;        //Director de la película
    private int año;                //Año de estreno de la película
    
    
    //-------------------------MÉTODOS-------------------------
    //Constructor/es
    public Pelicula() {
        //Constructor vacío
    }
    public Pelicula(String t, String d, int a) {
        titulo = t;     //Titulo
        director = d;   //Director
        año = a;        //Año de estreno
    }
    
    //Métodos getter
    public String getTitulo() {
        return titulo;  //Devuelve el titulo de la película
    }
    public String getDirector() {
        return director;    //Devuelve el director de la película
    }
    public int getAño() {
        return año; //Devuelve el año de estreno de la película
    }
}
