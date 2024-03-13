/*
AUTOR: Mario Ventura Burgos
FECHA: 04-2022
ASIGNATURA: Programación II
TRABAJO: Programa de gestión de ficheros de albumes con votos
*/

package clases.taller1_04_2022;

//CLASE ALBUM

import java.io.Serializable;

public class Album implements Serializable {
    
    //------------------------ATRIBUTOS------------------------
    int posicion;       // Posicion en el ranking
    int año;            // Año de edicion
    String titulo;      // Titulo del album
    String artista;     // Nombre del artista o grupo
    double estrellas;   // Numero de estrellas (puntuacion)
    int numEdiciones;   // Numero de ediciones
    String tipo;        // Tipo de album (java enum)
    int votos;          // Numero de votos
    
    //------------------------MÉTODOS------------------------
    //Constructores
    public Album() {
        
    }
    public Album(int posicion, int año, String titulo, String artista, double estrellas, int numEdiciones, String tipo) {
        this.posicion = posicion;           // 4 bytes
        this.año = año;                     // 4 bytes
        this.titulo = titulo;               // 62 bytes
        this.artista = artista;             // 62 bytes
        this.tipo = tipo;                   // 62 bytes
        this.estrellas = estrellas;         // 8 bytes
        this.numEdiciones = numEdiciones;   // 4 bytes
        this.votos = 0;                     // 4 bytes
        
        //TOTAL: 62*3 + 4*4 + 8 bytes cada album
    }
    public Album(int posicion, int año, String titulo, String artista, double estrellas, int numEdiciones, String tipo, int votos) {
        this.posicion = posicion;
        this.año = año;
        this.titulo = titulo;
        this.artista = artista;
        this.tipo = tipo;
        this.estrellas = estrellas;
        this.numEdiciones = numEdiciones;
        this.votos = votos;
    }

    @Override
    public String toString() {
        return "Posicion: " + posicion + ", Año: " + año + ", Título: " + titulo + ", Artista: " + artista + ", Estrellas: " +
                + estrellas + ", Ediciones: " + numEdiciones + ", Tipo: " + tipo + ".";
    }
    
    
    //Metodos setter
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public void setAño(int año) {
        this.año = año;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public void setEstrellas(double estrellas) {
        this.estrellas = estrellas;
    }
    public void setNumEdiciones(int numEdiciones) {
        this.numEdiciones = numEdiciones;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setVotos(int votos) {
        this.votos = votos;
    }
    
    //Métodos getter
    public int getPosicion() {
        return posicion;
    }
    public int getAño() {
        return año;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getArtista() {
        return artista;
    }
    public double getEstrellas() {
        return estrellas;
    }
    public int getNumEdiciones() {
        return numEdiciones;
    }
    public String getTipo() {
        return tipo;
    }
    public int getVotos() {
        return votos;
    }
    
    
}
