/*
AUTOR: Mario Ventura
CURSO: 2021/2022
ASIGNATURA: Programación II
PROGRAMA: Resolver sistema de ecuaciones lineal mediante matrices
PROFESOR: Juan Montes de Oca
*/

package clases.problemamatrices;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

//Programa principal
public class main {
    
    //----> ATRIBUTOS
    //Ejercicio 1
    public BufferedReader br;                       //Buffered Reader
    public Matriz matrizA;                          //Matriz 'A'
    public Matriz matrizB;                          //Matriz 'B'
    private int filas;                              //Filas de una matriz
    private int columnas;                           //Columnas de una matriz
    private float valor;                            //Valor de la matrix en i,j
    private int opcion;                             //Opcion del menu
    private final boolean iterar = true;            //Iterador 1
    private boolean iterar2;                        //Iterador 2
    private final String nomFic = "matrices.dat";   //Nombre del fichero in/out
    //Ejercicio 2
    private FicheroMatricesInOut fichero;           //Objeto FicheroMatricesInOut
    private File f;                                 //Objeto File
    private final int maxMatrices = 100;            //Máximo de matrices almacenables
    
    
    //----> MÉTODOS
    public static void main(String[] args) {
        try {
            new main().principal();
        } catch (Exception e) {
            System.err.println("HA SUCEDIDO UN ERROR DEL TIPO "+e.getLocalizedMessage());
        }
    }
    
    //Método principal
    public void principal() throws IOException { 
        
        //---> Hacer opcion escogida
        while (iterar) {
            //---> Menu
            clearScreen();
            printMenu();
            opcion = leerNum("\n\n\n\n¿Qué opción deseas hacer?");
            while ((opcion != 1) && (opcion != 2)&&(opcion!=3)) {
                System.out.println("\n----- ¡¡¡NÚMERO INCORRECTO!!! -----\n");
                printMenu();
                opcion = leerNum("¿Qué opción deseas hacer?");
            }
            
            //Ejercicio escogido
            switch (opcion) {
                case 1:
                    clearScreen();
                    ejercicio1();
                    break;
                case 2:
                    clearScreen();
                    ejercicio2();
                    break;
                case 3:
                    salir(0);
            }
        }
    }
    
    private void salir(int exitStatus) {
        clearScreen();
        System.out.println("\tSe ha eliminado el fichero 'matrices.dat'");
        System.out.println("\t\t-- Hasta la próxima --\n\n\n\n\n\n\n");
        System.exit(0);
    }
    
    /*
    ###########################################################################
    */
    
    //Método que resuelve el ejercicio 1
    private void ejercicio1() throws IOException {
        //Introducción al enunciado
        System.out.println("=====================================================================");
        System.out.println("====SE VA A CREAR UN SISTEMA DE ECUACIONES MATRICIAL DE LA FORMA:====");
        System.out.println("=====================================================================\n");
        //Imprimir enunciado por pantalla
        printEnunciado();
        System.out.println("");

        //---> Matriz A
        //Leer por teclado la dimension de la matriz
        filas = leerNum("----> INTRODUCE EL TAMAÑO DE LA MATRIZ 'A'");
        columnas = filas;
        //Crear e inicializar matriz con la dimension dada
        System.out.println("SE CREA LA MATRIZ 'A' CON TAMAÑO " + filas + "x" + columnas);
        matrizA = new Matriz(filas, columnas);
        matrizA.inicializar();
        //Mostrar matriz (inicialmente vacía)
        System.out.println(matrizA.toString());
        //Dar valor a la matriz
        crearMatriz(matrizA);
        //Mostrar matriz inicializada
        System.out.println("LA MATRIZ A ES LA SIGUIENTE:");
        System.out.println(matrizA.toString());

        //---> Matriz B
        //Inicialiazar matriz B
        matrizB = new Matriz(filas, 1);
        System.out.println("SE CREA LA MATRIZ 'B' CON TAMAÑO " + filas + "x1");
        matrizB.inicializar();
        //Dar valor a la matriz B
        crearMatriz(matrizB);
        //Mostrar matriz inicializada
        System.out.println("LA MATRIZ 'B' ES LA SIGUIENTE:");
        System.out.println(matrizB.toString() + "\n");

        //Mostrar enunciado con los datos introducidos
        System.out.println("====================================================================");
        System.out.println("=====EL SISTEMA DE ECUACIONES MATRICIAL CREADO ES EL SIGUIENTE:=====");
        System.out.println("====================================================================\n");
        printSistemaEcuaciones(matrizA,matrizB);
        System.out.println("\n\n");
        
        
        //---> Resolver con Gauss
        System.out.println("-----< PULSA ENTER PARA RESOLVER EL SISTEMA >-----\n");
        waitForEnter();
        //Resolver con Gauss
        resolverSistemaGauss(matrizA, matrizB);
    }
    
    //Método para resolver el sistema con Gauss
    private void resolverSistemaGauss(Matriz A, Matriz B) {
        //Usar copias para no modificar matrices originales
        Matriz a,b;
        a = A;
        b = B;
        //Resolver sistema
        System.out.println("=====================================================");
        System.out.println("SE RESUELVE EL SISTEMA:");
        printSistemaEcuaciones(a,b);
        System.out.println("=====================================================");
        System.out.println("CREANDO ECUACIONES A PARTIR DE LAS MATRICES DADAS:");
        printEcuaciones(a,b);
        System.out.println("=====================================================");
        System.out.println("Y SE OBTIENE LO SIGUIENTE:");
        Gauss(a,b);
        System.out.println("=====================================================");
        System.out.println("=====================================================");
        System.out.println("=====================================================\n\n\n");
    }
    
    //Algortimo de Gauss
    private void Gauss(Matriz A, Matriz B) {
        int col = columnas+1;
        Matriz resolver = new Matriz(filas,col);
        //Array bidimensional necesario para el algoritmo
        float[][] valores = new float[filas][col];
        
        //Iteracion para dar valor a la matriz y al array bidimensional
        for(int i=0; i<filas; i++) {
            for(int j=0; j<col; j++) {
                if(j==(col-1)) {
                    valores[i][j] = B.getValorEn(i,0);
                    resolver.setValorEn(B.getValorEn(i,0),i,j);
                } else {
                    valores[i][j] = A.getValorEn(i,j);
                    resolver.setValorEn(A.getValorEn(i,j),i,j);
                }
            }
        }
        System.out.println(resolver.toString());
        
        //Algoritmo de Gauss
        int var = filas;    //Dimension
        int piv = 0;        //pivote
        for (int a = 0; a < var; a++) {
            pivote(valores, piv, var);

            System.out.println("\tRENGLÓN " + (a + 1) + " ENTRE EL PIVOTE");
            muestramatriz(valores, var);

            System.out.println("");

            System.out.println("\t HACEMOS CEROS PARA QUE EL SISTEMA SEA MÁS FÁCIL DE RESOLVER");
            hacerceros(valores, piv, var);

            muestramatriz(valores, var);
            System.out.println("");
            piv++;
        }
        
        System.out.println("\n\n\n\nSOLUCION AL SISTEMA DE ECUACIONES:");
        System.out.println("------------------------------------------");
        for (int x = 0; x < var; x++) {
            System.out.println("EL VALOR DE X" + (x + 1) + " ES: " + valores[x][var]);
        }
        System.out.println("------------------------------------------");
    }
    
    //Necesarios para gauss
    static void muestramatriz(float matriz[][], int var) {
        for (int x = 0; x < var; x++) {
            for (int y = 0; y < (var + 1); y++) {
                System.out.print(" " + matriz[x][y] + " |");
            }
            System.out.println("");
        }

    }
    private void pivote(float matriz[][], int piv, int var) {
        float temp = 0;
        temp = matriz[piv][piv];
        for (int y = 0; y < (var + 1); y++) {

            matriz[piv][y] = matriz[piv][y] / temp;
        }
    }
    private void hacerceros(float matriz[][], int piv, int var) {
        for (int x = 0; x < var; x++) {
            if (x != piv) {
                float c = matriz[x][piv];
                for (int z = 0; z < (var + 1); z++) {
                    matriz[x][z] = ((-1 * c) * matriz[piv][z]) + matriz[x][z];
                }
            }
        }
    }
    
    //Método para imprimir el menu
    private void printMenu() {
        System.out.println("=====================================================================");
        System.out.println("================== ¿QUÉ EJERCICIO DESEAS RESOLVER? ==================");
        System.out.println("=====================================================================\n");
        System.out.println("\t1. Resolver Sistema de Ecuaciones Lineal con matrices");
        System.out.println("\t2. Problema de matrices con búsqueda y ordenacion");
        System.out.println("\t3. Salir\n");
    }
    
    //Método para imprimir por pantalla la estructura del sistema de ecuaciones a plantear
    private void printEnunciado() {
        System.out.println("[A11 A12 A13 ... A1n] [x1]     [B1]");
        System.out.println("[A21 A22 A23 ... A2n] [x2]     [B2]");
        System.out.println("[... ... ... ... ...] [..]  =  [..]");
        System.out.println("[Am1 Am2 Am3 ... Amn] [xn]     [Bn]");
        System.out.println("\n---DONDE LA MATRIZ 'A' ES CUADRADA---\n");
    }
    
    //Método para imprimir el sistema de ecuaciones con los valores dados
    private void printSistemaEcuaciones(Matriz a, Matriz b) {
        //Variables para iterar
        int i,j;
        int columna = 0;
        //Iteracion
        for(i=0; i<filas; i++) {
            j=0;
            System.out.print("[");
            while(j<columnas) {
                if (j == (columnas-1)) {
                    System.out.print(a.getValorEn(i, j) + "");
                    j++;
                } else {
                    System.out.print(a.getValorEn(i, j) + "  ");
                    j++;    
                }
                
            }
            System.out.println("] [x"+(columna+1)+"]  =  ["+b.getValorEn(columna,0)+"]");
            columna++;
        }
    }
    
    //Método para imprimir el sistema de ecuaciones sin forma matricial
    private void printEcuaciones(Matriz a, Matriz b) {
        //Variables para iterar
        int i,j;
        int columna = 0;
        //Iteracion
        for(i=0; i<filas; i++) {
            j=0;
            while(j<columnas) {
                if (j == (columnas-1)) {
                    System.out.print("("+a.getValorEn(i,j)+")x"+(j+1));
                    j++;
                } else {
                    System.out.print("("+a.getValorEn(i,j)+")x"+(j+1)+" + ");
                    j++;
                } 
            }
            System.out.println(" = "+b.getValorEn(columna,0));
            columna++;
        }
    }
    
    //Le da valor a cada Aij de la matriz
    private void crearMatriz(Matriz matriz) throws IOException {
        for(int i=0; i<matriz.getNumFilas(); i++) {
            for(int j=0; j<matriz.getNumColumnas(); j++) {
                //Leer valor de la matriz
                valor = leerNumDecimal("---> Introduce el valor en ("+(i+1)+","+(j+1)+")");
                //Dar valor a la matriz en la posicion dada
                matriz.setValorEn(valor,i,j);
            }
        }
    }
    
    //Método para leer un numero entero
    private int leerNum(String s) throws IOException {
        //VARIABLES
        int t = 0;
        boolean ward;
        
        //DAR VALOR A LA VARIABLE t
        do {
            ward = true;
            try {
                System.out.println(s);
                br = new BufferedReader(new InputStreamReader(System.in));
                String linea = br.readLine();
                t = Integer.parseInt(linea);

            } catch (NumberFormatException e) {
                ward = false;
            }
        } while (ward == false);
        
        //RETORNAR EL VALOR LEÍDO
        return t;
    }
    
    //Método para leer un double
    private float leerNumDecimal(String s) throws IOException {
        //VARIABLES
        float t = 0;
        boolean ward;
        
        //DAR VALOR A LA VARIABLE t
        do {
            ward = true;
            try {
                System.out.println(s);
                br = new BufferedReader(new InputStreamReader(System.in));
                String linea = br.readLine();
                t = Float.parseFloat(linea);

            } catch (NumberFormatException e) {
                ward = false;
            }
        } while (ward == false);
        
        //RETORNAR EL VALOR LEÍDO
        return t;
    }
    
    //Método que espera hasta que se pulsa enter
    private void waitForEnter() {
        int t;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String linea = br.readLine();
            t = Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            t = 1;
        } catch (Exception e) {
            
        }
    }
    
    //Limpiar la pantalla de la consola
    private void clearScreen() {
        for (int i=0; i<10; i++) {
            System.out.println("\n\n\n\n\n\n\n\n");
        }
    }
    
    /*
    ###########################################################################
    */
    
    //Método que resuelve el ejercicio 2
    private void ejercicio2() throws IOException {
        f = new File(nomFic);
        
        
        //Leer opcion del usuario
        iterar2 = true;
        while (iterar2) {
            //---> Menu
            clearScreen();
            menu2();
            opcion = leerNum("\n\n\n\n¿Qué apartado deseas hacer?");
            
            while ((opcion != 1) && (opcion != 2) && (opcion != 3) && (opcion != 4) && (opcion != 5) && (opcion != 6)) {
                System.out.println("\n----- ¡¡¡NÚMERO INCORRECTO!!! -----\n");
                menu2();
                opcion = leerNum("¿Qué opción deseas hacer?");
            }
            
            //Ejercicio escogido
            switch (opcion) {
                case 1:
                    clearScreen();
                    apartado1();
                    break;
                case 2:
                    clearScreen();
                    apartado2();
                    break;
                case 3:
                    clearScreen();
                    System.out.println("=============================");
                    System.out.println("LAS MATRICES DEL FICHERO SON:");
                    System.out.println("=============================");
                    apartado3();
                    System.out.println("---> Fichero leído correctamente\n");
                    break;
                case 4:
                    clearScreen();
                    apartado4();
                    break;
                case 5:
                    clearScreen();
                    iterar2 = false;
                    break;
                case 6:
                    salir(0);
                    break;
            }
            
            if(opcion != 5) {
                //Preguntar si quieres volver al ejercicio 1
                System.out.println("----- ¿QUIERES SEGUIR CON EL EJERCICIO 2? -----");
                int seguir = leerNum("\tESCRIBE 1 PARA SI || ESCRIBE 0 PARA NO");

                while ((seguir != 1) && (seguir != 0)) {
                    System.out.println("\n----- ¡¡¡NÚMERO INCORRECTO!!! -----\n");
                    System.out.println("----- ¿QUIERES SEGUIR CON EL EJERCICIO 2? -----");
                    seguir = leerNum("\tESCRIBE 1 PARA SI || ESCRIBE 0 PARA NO");
                }
                if (seguir == 0) {
                    iterar2 = false;
                }
            }
            
        }
        //Borrar fichero
        fichero = new FicheroMatricesInOut(f,"rw");
        fichero.borrar(f);
    }
    
    //Apartados del ejercicio 2
    private void apartado1() throws IOException {
        /*
        Lectura por teclado de un objeto MatrizNxM y grabación en un fichero de nombre
        matrices.dat gestionado a través de la clase RandomAccessFile.
        */
        
        //Objeto Matriz
        Matriz m;
        //Leer dimension de la matriz
        int filas = leerNum("¿Cuántas filas tiene la matriz?");
        int columnas = leerNum("¿Cuántas columnas tiene la matriz?");
        System.out.println("\n\n\n\n\n\n\n\n");
        
        //Instanciar matriz
        m = new Matriz(filas,columnas);
        m.inicializar();
        //Dar valor a los elementos de la matriz
        crearMatriz(m); 
        System.out.println("Se ha creado una matriz de tamaño "+filas+"x"+columnas);
        
        
        fichero = new FicheroMatricesInOut(f,"rw");
        
        //Colocar puntero al final del fichero para permitir añadir cuantas
        //matrices se quieran
        fichero.colocarPuntero(fichero.getLongitud());
        fichero.escritura(m);
        
        //Aviso al usuario de que se ha escrito correctamente
        System.out.println("\n--> Escritura Realizada\n\n\n");
        
        //Cerrar enlace para guardar cambios
        fichero.cerrarEnlace();
        
    }
    private void apartado2() throws IOException {
        /*
        Ordenación de los objetos MatrizNxM contenidos en el fichero matrices.dat teniendo
        en cuenta el criterio de ordenación creciente por el número de filas.
        3. Listado en la ventana de texto de todos los objetos MatrizNxM contenidos en el
        fichero matrices.dat
        */
        
        //--Se lee y muestra el fichero antes de ordenarlo--
        fichero = new FicheroMatricesInOut(f,"rw");
        fichero.colocarPuntero(0);
        ordenacionPorFilas(fichero,true);   //True == criterio ascendente
        
        
        //--Se muestra el fichero ordenado--
        System.out.println("--> Después de ordenar el fichero");
        apartado3();
    }
    private void apartado3() throws IOException {
        /*
        Listado en la ventana de texto de todos los objetos MatrizNxM contenidos en el
        fichero matrices.dat.
        */
        if (f.exists()) {
            //Lectura de la matriz en un fichero
            fichero = new FicheroMatricesInOut(f, "rw");
            fichero.colocarPuntero(0);

            //Recorrido del fichero
            Matriz m;
            boolean Final = false;
            
            while (!Final) {
                m = new Matriz();
                //Dar valor al objeto m
                m = fichero.lectura();
                Final = fichero.getFinal();
            }
            Final = false;
            fichero.setFinal(false);
            fichero.cerrarEnlace();
        } else {
            System.out.println("\n\n\t EL FICHERO NO EXISTE\n");
        }
    }
    private void apartado4() throws IOException {
        //Pedir nº de filas
        int numFilas = leerNum("¿Cuántas filas tiene la matriz que buscas?");
        
        //Leer fichero hasta encontrar la matriz que se busca
        fichero = new FicheroMatricesInOut(f,"rw");
        fichero.colocarPuntero(0);
        Matriz m = null;
        boolean Final = false;
        boolean encontrada = false;

        int idx = 0;
        System.out.println("---> Leyendo matrices del fichero hasta encontrar una coincidencia...\n");
        while ((!Final) && (idx < maxMatrices)) {
            m = new Matriz();
            
            m = fichero.lectura();
            idx++;
            Final = fichero.getFinal();
            if(m.getNumFilas() == numFilas) {
                idx = maxMatrices;
                Final = true;
                encontrada = true;
            }
        }
        Final = false;
        fichero.setFinal(false);
        fichero.cerrarEnlace();
        
        //Mostrar matrix encontrada
        if(encontrada) {
            System.out.println("---> Se ha encontrado una matriz con "+numFilas+" filas:\n");
            System.out.println(m.toString()+"\n\n");
        } else {
            System.out.println("---> No se ha encontrado una matriz con "+numFilas+" filas:\n\n");
        }
    }
    
    //Ordenación de las matrices por criterio de nº de filas
    private void ordenacionPorFilas(FicheroMatricesInOut fic, boolean criterio) throws IOException {
        //Comprobar criterio
        if(criterio) {
            //---> Ordenacion ascendente
            
            //--Guardar contenido en un fichero de objetos matriz--
            Matriz m;
            boolean Final = false;
            Matriz matrices[] = new Matriz[maxMatrices];
            fic.colocarPuntero(0);
            
            int idx = 0;
            System.out.println("\n--> Antes de Ordenar el Fichero:");
            while ((!Final)&&(idx<maxMatrices)) {
                m = new Matriz();
                m = fichero.lectura();
                matrices[idx] = m;
                idx++;
                Final = fichero.getFinal();
            }
            Final = false;
            fic.setFinal(false);
            fic.cerrarEnlace();
            
            //--Eliminar fichero antiguo--
            fic.borrar(fic.getFile());
            
            //--Ordenar array con el método de burbuja--
            //Copiar array con tamaño exacto
            Matriz matricesOrdenar[] = new Matriz[idx];
            for(int x=0; x<idx; x++) {
                matricesOrdenar[x] = matrices[x];
            }  
            Matriz aux; //Auxiliar para hacer swap
            for(int i=0; i<(idx-1); i++) {
                for(int j=0; j<(idx-1); j++) {
                    //Swap
                    if(matricesOrdenar[j].getNumFilas() > matricesOrdenar[j+1].getNumFilas()) {
                        aux = matricesOrdenar[j];
                        matricesOrdenar[j] = matricesOrdenar[j+1];
                        matricesOrdenar[j+1] = aux;
                    }
                }
            }
            
            //--Escribir array ordenado en un nuevo fichero de nombre igual al anterior--
            fic = new FicheroMatricesInOut(f,"rw");
            fic.colocarPuntero(0);
            //Iteracion de escritura
            for(int i=0; i<matricesOrdenar.length; i++) {
                fic.escritura(matricesOrdenar[i]);
            }
            fic.cerrarEnlace();
        } else {
            //---> Ordenacion descendente descendente
            
            //--Guardar contenido en un fichero de objetos matriz--
            Matriz m;
            boolean Final = false;
            Matriz matrices[] = new Matriz[maxMatrices];
            fic.colocarPuntero(0);
            
            int idx = 0;
            System.out.println("\n--> Antes de Ordenar el Fichero:");
            while ((!Final)&&(idx<maxMatrices)) {
                m = new Matriz();
                m = fichero.lectura();
                matrices[idx] = m;
                idx++;
                Final = fichero.getFinal();
            }
            Final = false;
            fic.setFinal(false);
            fic.cerrarEnlace();
            
            //--Eliminar fichero antiguo--
            fic.borrar(fic.getFile());
            
            //--Ordenar array con el método de burbuja--
            //Copiar array con tamaño exacto
            Matriz matricesOrdenar[] = new Matriz[idx];
            for(int x=0; x<idx; x++) {
                matricesOrdenar[x] = matrices[x];
            }  
            Matriz aux; //Auxiliar para hacer swap
            for(int i=0; i<(idx-1); i++) {
                for(int j=0; j<(idx-1); j++) {
                    //Swap
                    if(matricesOrdenar[j].getNumFilas() < matricesOrdenar[j+1].getNumFilas()) {
                        aux = matricesOrdenar[j];
                        matricesOrdenar[j] = matricesOrdenar[j+1];
                        matricesOrdenar[j+1] = aux;
                    }
                }
            }
            
            //--Escribir array ordenado en un nuevo fichero de nombre igual al anterior--
            fic = new FicheroMatricesInOut(f,"rw");
            fic.colocarPuntero(0);
            //Iteracion de escritura
            for(int i=0; i<matricesOrdenar.length; i++) {
                fic.escritura(matricesOrdenar[i]);
            }
            fic.cerrarEnlace();
        }
    }
    
    //Imprime las opciones del menu del ejercicio 2
    private void menu2() {
        System.out.println("=====================================================================");
        System.out.println("=================== ¿QUÉ APARTADO DESEAS RESOLVER? ==================");
        System.out.println("=====================================================================\n");
        System.out.println("\t1. Lectura por teclado de un objeto MatrizNxM y grabación en un fichero");
        System.out.println("\t2. Ordenación de los objetos MatrizNxM contenidos en el fichero matrices.dat teniendo\n" +
        "\t   en cuenta el criterio de ordenación creciente por el número de filas");
        System.out.println("\t3. Listado de todos los objetos MatrizNxM contenidos en el fichero");
        System.out.println("\t4. Buscar una matriz en el fichero");
        System.out.println("\t5. Volver al menú anterior");
        System.out.println("\t6. Salir del programa\n");
    }
}