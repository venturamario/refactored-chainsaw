package CLASES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//CLASE MAIN QUE EJECUTA EL MÉTODO MAIN Y SUS SUBMÉTODOS
public class main {
    
    //ATRIBUTOS
    static int opcionUsuario;           //Opcion del menú que escoge el usuario
    
    
    
    //MÉTODOS
    //Método main
    public static void main(String[] args) {
        principal();
    }
    
    //Método principal
    private static void principal() {
        //Mostrar menú
        mostrarMenu();
    }
    
    //Método quen imprime el menú por consola
    private static void mostrarMenu() {
        limpiarPantalla();
        System.out.println("------< MENÚ DE GESTIÓN DE LIBROS >------");
        System.out.println("\n[1]\t ALTA ACTUALIZACIONES");
        System.out.println("[2] LISTADO LIBROS");
        System.out.println("[3] LISTADO ACTUALIZACIONES PENDIENTES DE PROCESAR");
        System.out.println("[4] LISTADO INCIDENCIAS ÚLTIMA ACTUALIZACIÓN");
        System.out.println("[5] ACTUALIZACIÓN FICHERO LIBROS");
        System.out.println("[6] SALIR");
        preguntarOpcion("¿QUÉ OPCION DESEAS HACER?");
    }
    
    //Método para limpiar la consola
    private static void limpiarPantalla() {
        for(int i=0; i < 10; i++) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }
    
    //Método para preguntar al usuario que opción del menú se quiere hacer
    private static void preguntarOpcion(String s) {
        System.out.print(s + "---> ");
        leerNum();
    }
    
    //metodo para leer el codigo numerico del cliente
    private static int leerNum() {
        int num = 0;
        try {
            //Lectura de datos de tipo primitivo en Java
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //Lectura
            String linea = br.readLine();
            //Parse Int
            num = Integer.parseInt(linea);
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA");
        }
        return num;
    }
}
