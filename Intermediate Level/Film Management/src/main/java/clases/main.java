/*
AUTOR: Mario Ventura Burgos
FECHA: 3-03-2022
ASIGNATURA: Programación II
TRABAJO: Programa de gestión de objetos película con ficheros
*/

package clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

//Programa prinicipal que usa las funcionalidades de las otras clases
public class main {
    //------------------------ATRIBUTOS------------------------
    private static boolean iterar = true;           //Iteracion infinita
    private static final int maxPeliculas = 3;      //Máximo de películas almacenables
    private static String nomFic;                   //Nombre del fichero
    private static ficheroPeliculaIn peliculaIn;    //enlace de entrada con el fichero
    private static ficheroPeliculaOut peliculaOut;  //enlace de salida con el fichero
    
    
    //-------------------------MÉTODOS-------------------------
    //Método main
    public static void main(String[] args) {
        //Para que el programa no detenga la ejecución en caso de excepciones
        while(iterar) {
            limpiarPantalla();  //Limpiar pantalla antes de comenzar
            principal();        //Método principal para leer/esribir peliculas
        }
    }
    
    //Método principal que se ejecuta en las iteraciones del main
    private static void principal() {
        try {
            //-----------INTRODUCCIÓN AL USUARIO-----------
            introduccion();
            //Preguntar por el nombre del fichero
            nomFic = leerCadena("ESCRIBE NOMBRE DEL FICHERO QUE SE CREARÁ:");
            limpiarPantalla();

            //-----------ESCRIBIR 3 PELÍCULAS-----------
            //Instanciar enlace con el fichero (salida)
            peliculaOut = new ficheroPeliculaOut(nomFic);
            //Llamar al método que usa el enlace para escribir en el fichero
            escribirPeliculas(nomFic, maxPeliculas);

            //-----------LEER FICHERO DE PELIS-----------
            //Instanciar enlace con el fichero (entrada)
            peliculaIn = new ficheroPeliculaIn(nomFic);
            //Leer películas almacenadas en el fichero
            leerPeliculas(nomFic);
            
            //-----------PRÓXIMA ITERACIÓN-----------
            int seguir = leerNum("\t¿QUIERES SALIR?\nEscribe '1' para salir y otra cosa para continuar");
            if (seguir == 1) {
                limpiarPantalla();
                System.out.println("\t\tADIÓS\n\n\n\n\n");
                System.exit(0);
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("NO SE HA ENCONTRADO EL FICHERO: "+e.toString());
        } catch (IOException e) {
            System.err.println("ERROR DE ENTRADA O SALIDA: "+e.toString());
        } catch (Exception e) {
            System.err.println("SE HA PRODUCIDO UN ERROR DEL TIPO: "+e.toString());
        }
    }
    
    //Método para hacer una introducción por consola al usuario
    private static void introduccion() {
        System.out.println("========================================================");
        System.out.println("===========GESTIÓN DE PELÍCULAS CON FICHEROS============");
        System.out.println("========================================================\n\n\n\n\n\n\n\n");
    }
    
    //Limpiar consola
    private static void limpiarPantalla() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    //Escribir peliculas en el fichero
    private static void escribirPeliculas(String nombreFichero,int maximo) throws IOException {
        //Escribir 3 objetos pelicula en el fichero iterando 3 veces
        for(int i=0; i<maximo; i++) {
            //---LEER DATOS DE LA PELÍCULA ANTES DE ESCRIBIRLA---
            //Leer nombre de la película
            String n = leerCadena("Título de la película " +(i+1) + ":");
            //Leer director de la película
            String d = leerCadena("Director de la película " +(i+1) + ":");
            //Año de la película
            int a = leerNum("Año de estreno la película " + (i+1) + ":");
            
            //Crear objeto Pelicula que será escrito en fichero
            Pelicula p = new Pelicula(n,d,a);
            
            //Metodo para escribir los datos de una pelicula en el fichero
            peliculaOut.escribirPelicula(p);
            //Informar al usuario de que se ha escrito correctamente la pelicula
            System.out.println("---< SE HA AÑADIDO LA PELÍCULA >---\n\n\n");
        }
        //Cerrar enlace de salida con el fichero dado
        peliculaOut.cerrarEnlace();
    }
    
    //Método para leer un fichero con películas almacenadas
    private static void leerPeliculas(String nonmbreFichero) throws IOException {
        //Introducción al usuario
        System.out.println("\n\n\n\n\nRESULTADO DE LA LECTURA DE " + nomFic);
        //Leer los objetos película del fichero
        peliculaIn.leerPeliculas(nomFic);
        //Cerrar enlace de entrada con el fichero
        peliculaIn.cerrarEnlace();
    }
    
    //Lectura de datos primitivos:
    private static String leerCadena(String s) throws IOException {
        //String que se leerá
        String nombre = null;
        //Aviso al usuario para que sepa qué debe escribir
        System.out.println(s);
        //Se lee lo que se introduce por teclado
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Método readLine() para leer una linea y almacenarla en un String
        nombre = br.readLine();
        //Devolver el string leído
        return nombre;
    }
    private static int leerNum(String s) throws IOException {
        //Aviso al usuario para que sepa qué debe escribir
        System.out.println(s);
        //Lectura de datos de tipo primitivo en Java
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Lectura
        String linea = br.readLine();
        //Convertir de cadena a numero con el metodo Parse Int
        int num = Integer.parseInt(linea);
        //Devolver entero leído
        return num;
    }
}