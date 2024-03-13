package MAIN;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class tratamientoFichero {

    //-------------------------VARIABLES Y CONSTANTES---------------------------
    static boolean acabar = false;              //Indica si el programa debe acabar
    static final int maxVocales = 5;            //Maximo de palabras del fichero
    static String ficOut = "vocalesOut.txt";   //Nombre del fichero de salida
    static int numVocales = 0;                  //Contador de palabras
    
    //Maximo de palabras del fichero
    static String vocales[] = new String[maxVocales];
    //contador de frecunecias de cada palabra
    static int frecuencias[] = new int[maxVocales];
    
       
    
    //--------------------------------MÉTODOS-----------------------------------
    //Método main
    public static void main(String[] args) {
        //Estructura iterativa infinita para que el programa no se detenga
        while (acabar == false) {
            principal();
        }
    }
    
    //Método principal
    private static void principal() {
        //Usar bloque try cacth para conptemplar posibles excepciones
        try {         
            //Leer fichero de texto y almacenar palabras
            leerFichero("ficheroPrueba.txt");
            
            //Mostrar resultados
            System.out.println("1. EL NUMERO DE VOCALES ES: " +numVocales);
            System.out.print("2. LA FRECUENCIA DE APARICIÓN DE LAS VOCALES, EN ORDEN, ES: ");
            for (int i=0; i<maxVocales; i++) {
                System.out.println(frecuencias[i] + ", ");
            }
            
            
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        }
    }
    
    //Méetodo         
    private static void leerFichero(String nombreFichero) throws Exception {
        //Abrir enlaces con el fichero
        FileReader fr = new FileReader(nombreFichero);
        
        //Entero para seguir leyendo
        int valor = fr.read();
        char letra;
        
        //Bucle de lectura de palabras
        while (valor != -1) {
            letra = (char) valor;
            //Leer letra y comprobar si es una vocal
            if (esVocal(letra) == true) {
                //Aumenta el numero de vocales
                numVocales++;
                //Escribir vocal en fichero de salida
                escribirVocal(ficOut,letra);
                
            }
            //Leer la siguiente letra
            valor =  fr.read();
        }
        acabar = true;
    }
    
    private static boolean esVocal(char letra) {
        if (letra == 'a') {
            frecuencias[0]++;
            return true;
        } if (letra == 'e') {
            frecuencias[1]++;
            return true;
        } if (letra == 'i') {
            frecuencias[2]++;
            return true;
        } if (letra == 'o') {
            frecuencias[3]++;
            return true;
        } if (letra == 'u') {
            frecuencias[4]++;
            return true;
        }
        return false;
    }
    
    private static void escribirVocal(String nombreFichero, char letra) throws IOException {
        
        //Para escribir
        FileWriter fw = new FileWriter(nombreFichero, true);
        //Cerrar enlace
        fw.close();
        
    }
}
