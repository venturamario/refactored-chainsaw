/*
AUTOR: Mario Ventura Burgos
FECHA: 04-2022
ASIGNATURA: Programación II
TRABAJO: Programa de gestión de ficheros de albumes con votos
*/

package clases.taller1_04_2022;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Random;

public class main {
  
    //------------------------ATRIBUTOS------------------------
    static int opcion;
    static boolean seguir = true;
    static RandomAccessFile raf;
    static final String nomFic = "GreatestAlbums.txt";
    static final String ficVotos = "AlbumesConVotos.dat";
    static final int numAlbumes = 100;
    static FitxerAlbums fin,finAux;
    
    
    
    //------------------------MÉTODOS--------------------------
    //Método main
    public static void main(String[] args) throws InsercioDadesException {
        //Limpiar pantalla
        clearScreen();

        //Bloque try catch para contemplar posibles excepciones
        try {
            //Iterar
            while (seguir) {
                //Mostrar menu
                System.out.println("\n\n");
                verMenu();

                //Leer ocpión a realizar
                opcion = leerNum();
                //Comprobar dato
                if (comprobarNum(opcion) == false || opcionValida(opcion) == false) {
                    throw new InsercioDadesException("ERROR: EL DATO O EL FORMATO DEL DATO SON INCORRECTOS\n\n\n");                  
                }

                //Mirar si el usuario quiere salir
                if (opcion == 0) {
                    seguir = false;
                    salir();
                }

                clearScreen();

                //Ejecutar opcion escogida por el usuario
                switch (opcion) {
                    case 1:
                        opcion1();
                        break;
                    case 2:
                        opcion2();
                        break;
                    case 3:
                        opcion3();
                        break;
                    case 4:
                        opcion4();
                        break;
                    case 5:
                        opcion5();
                        break;
                    default:
                        break;
                }

                //Siguiente iteracion
                System.out.println("\n\n\n");
                System.out.println("\t QUIERE HACER ALGO MÁS?");
            }
            
        } catch(InsercioDadesException e) {
            //---EXCEPCIÓPN PERSONALIZADA---
            throw new InsercioDadesException("ERROR: EL DATO O EL FORMATO DEL DATO SON INCORRECTOS");
            
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (IOException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        }

    }
    
    //Metodo para salir
    private static void salir() {
        //Borrar ficheros auxiliares si existen (el metodo borrar hace esa comprobacion)
        File f1 = new File(ficVotos);
        File f2 = new File("auxVotos.dat");
        fin = new FitxerAlbums(f1,"rw");
        fin.borrar(f1);
        fin.borrar(f2);
        fin.cerrarEnlace();
        
        //Salir del programa
        clearScreen();
        System.out.println("\t\t\tGRACIAS POR VOTAR\n\n\n\n\n\n\n\n\n\n\n");
        System.exit(0);
    }
    
    //Método de visualizacion del menu
    private static void verMenu() {
        System.out.println("Gestió dels discs que s'haurien d' escoltar");
        System.out.println("");
        System.out.println("1. Veure el contingut del fitxer de text i inicilitza fitxer de vots");
        System.out.println("2. Veure el contingut del fitxer de vots d' accès aleatori");
        System.out.println("3. Un vot manual");
        System.out.println("4. Simula vots aleatoris");
        System.out.println("5. Calcula el millor album");
        System.out.println("0. Sortir");
        System.out.println("");
        System.out.println("\tInsereix Opció");
    }
    
    //Limpiar pantalla
    static void clearScreen() {
        for(int i=0; i<50; i++) {
            System.out.println("\n\n\n\n");
        }
    }
    
    //Lectura primitiva por teclado
    private static int leerNum() throws IOException,InsercioDadesException {
        //Lectura de datos de tipo primitivo en Java
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Lectura
        String linea = br.readLine();
        //Convertir de cadena a numero con el metodo Parse Int
        int num = Integer.parseInt(linea);
        //Devolver entero leído
        return num;
    }
    private static int leerNum(String s) throws IOException, InsercioDadesException {
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
    
    //---Métodos de las opciones del menu---
    static void opcion1() throws InsercioDadesException {
        //RECORRIDO DEL FICHERO + INICIALIZACION FICHERO VOTOS
        
        try {
            //Variables
            Album a;
            int idx = 0;
            BufferedReader f = new BufferedReader(new FileReader(nomFic));
            fin = new FitxerAlbums(ficVotos, "rw");

            //---Recorrido fichero---
            while (idx < numAlbumes) {

                //Leer datos del album
                int posicion = Integer.parseInt(f.readLine());
                int año = Integer.parseInt(f.readLine());
                String titulo = f.readLine();
                String artista = f.readLine();
                String tipo = f.readLine();
                double estrellas = Double.parseDouble(f.readLine());
                int ediciones = Integer.parseInt(f.readLine());
                int votos = 0;

                //Crear objeto Album con los datos leidos
                a = new Album(posicion, año, titulo, artista, estrellas, ediciones, tipo, votos);
                System.out.println("ÁLBUM " + (idx + 1) + " --> " + a.toString());

                //Escribir album en archivo binario con objeto objeto ficheroIn
                fin.escritura(a);

                //Siguiente iteracion para siguiente album
                idx++;
            }
            
            f.close();
            
        } catch (NumberFormatException e) {
            System.out.println("ERROR DE FORMATO DE NUMERO EN:\n " +e.getLocalizedMessage());
        } catch (FileNotFoundException e) {
            System.out.println("NO SE HA ENCONTRADO EL ARCHIVO INDICADO");
        } catch (IOException e) {
            System.out.println("ERROR DE ENTRADA O SALIDA DE DATOS");
        } finally {
            //Cerrar flujos de entrada
            fin.cerrarEnlace();
        }
    }
    
    static void opcion2() throws InsercioDadesException {
        //RECORRIDO DEL FICHERO DE VOTOS
        
        try {
            
            //Variables
            fin = new FitxerAlbums(ficVotos,"rw");
            BufferedReader f = new BufferedReader(new FileReader("AlbumesConVotos.dat"));
            Album a;
            int numAlbumes = 100;
            int albumesLeidos = 0;
            
            
            //Lectura
            while (albumesLeidos < numAlbumes) {
                
                //Instanciar objeto album mediante la lectura del archivo .dat
                a = fin.lectura();
                
                //Mostrar album
                String s = ("#"+a.getPosicion()+"  Votos: "+a.getVotos()+", Título: "+a.getTitulo()+", Artista: "+a.getArtista()+"Año:"+a.getAño());
                System.out.println(s);

                //Aumentar contador
                albumesLeidos++;
            }

            f.close();
            
        } catch (Exception e) {
            
        } finally {
            //Cerrar enlace
            fin.cerrarEnlace();
        }
    }
    
    static void opcion3() throws InsercioDadesException {
        try {
            //--PRESENTACION AL USUARIO--
            //Leer opcion del disco
            int numAlbum = leerNum("NÚMERO DEL DISCO QUE QUIERES VOTAR [1..100] ?");
            //Comprobar dato
            if (comprobarNum(numAlbum)==false || numAlbum > 100) {
                if (numAlbum>100) {
                    System.out.println("ALBUM INEXISTENTE, EL VOTO NO SE REALIZARA");
                    throw new InsercioDadesException("ERROR: EL DATO O EL FORMATO DEL DATO SON INCORRECTOS");
                } else {
                    throw new InsercioDadesException("ERROR: EL DATO O EL FORMATO DEL DATO SON INCORRECTOS");
                }
            }
            //Preguntar por puntuación
            int puntuacion = leerNum("PUNTUACIÓN DEL DISCO [1..10] ? ");
            //Comprobar dato
            if (comprobarNum(puntuacion)==false || puntuacion > 10) {
                if (numAlbum>10) {
                    System.out.println("PUNTUACION NO VÁLIDA, EL VOTO NO SE REALIZARA");
                    throw new InsercioDadesException("ERROR: EL DATO O EL FORMATO DEL DATO SON INCORRECTOS");
                } else {
                    throw new InsercioDadesException("ERROR: EL DATO O EL FORMATO DEL DATO SON INCORRECTOS");
                }
            }
            
            //---> DATOS CORRECTOS
            
            //Actualizar puntuacion del disco (Acceder a ese disco mediante acceso aleatorio)
            File faux = new File("auxVotos.dat");         //Aux
            finAux = new FitxerAlbums(faux,"rw");            //fin Auxiliar
            
            File f = new File(ficVotos);                  //Original
            fin = new FitxerAlbums(f,"rw");                  //Con votos
            
            
            //Variables
            int albumesLeidos = 1;
            Album a = new Album();
            
            //Leer hasta encontrar el album que buscamos
            while (albumesLeidos <= numAlbumes) {
                a = fin.lectura();      //Leer original
                //Si es el que se busca, se modifica añadiendo los votos
                if (numAlbum==albumesLeidos) {
                    a.setVotos(a.getVotos()+puntuacion);
                    //Mostrar album actualizado
                    String s = ("#"+a.getPosicion()+" Votos: "+a.getVotos()+" para "+a.getTitulo());
                    System.out.println(s);
                }
                finAux.escritura(a);    //Guardarlo en fichero temporal
                albumesLeidos++;        //Aumentar contador
            }
            
            //Eliminar original
            fin.borrar(f);
            fin.cerrarEnlace();
            
            //Crear nuevo archivo llamado como el eliminado
            f = new File(ficVotos);
            fin = new FitxerAlbums(f,"rw");    //Enlace con fichero
            finAux.situarPuntero(0);        //Cominezo del auxiliar
            
            //Copiar informacion del archivo temporal en el nuevo .txt
            for (int idx=0; idx < numAlbumes; idx++) {
                //Leer album
                a = finAux.lectura();
                //Escribir datos del album
                fin.escritura(a);
            }
            
            //Eliminar archivo temporal
            finAux.borrar(faux);   
            
        } catch (Exception e) {
            System.err.println("ERROR EN LA OPCIÓN 3 DEL MENU: "+e.getLocalizedMessage());
        } finally {
            //Cerrar enlaces
            fin.cerrarEnlace();
            finAux.cerrarEnlace();
        }
        
    }
    
    static void opcion4() throws InsercioDadesException {
        //VOTACIONES ALEATORIAS
        File f1 = new File(ficVotos);
        File f2 = new File("auxVotos.dat");
        
        try {
            //Preguntar al usuario por el numero de votaciones
            int numVotaciones = leerNum("¿CUANTAS VOTACIONES QUIERES HACER? [1..100]");
            //Comprobar dato
            if (comprobarNum(numVotaciones)==false || numVotaciones > 100) {
                if (numVotaciones>100) {
                    System.out.println("DEMASIADAS VOTACIONES, LA SIMULACIÓN NO SE REALIZARA");
                    throw new InsercioDadesException("ERROR: EL DATO O EL FORMATO DEL DATO SON INCORRECTOS");
                } else {
                    throw new InsercioDadesException("ERROR: EL DATO O EL FORMATO DEL DATO SON INCORRECTOS");
                }
            }
            
            System.out.println("\n\n\t...SIMULANDO VOTACIONES...");
            System.out.println("\t...DANOS UN MOMENTO...\n");
            
            //Iteracion de numVotaciones veces en las que se generaran votos aleatorios en cada iteracion
            for (int i=0; i<numVotaciones; i++) {
                //Genenar 10 votaciones aleatorias
                System.out.print("Voto "+(i+1)+": \t");
                for (int j=1; j<=10; j++) {
                    //Numero aleatorio entre 1 y 100
                    Random ran = new Random();
                    int numAlbum = ran.nextInt(100) + 1;
                    
                    //Enlaces con ficheros
                    fin = new FitxerAlbums(f1,"rw");
                    finAux = new FitxerAlbums(f2,"rw");
                    
                    //Leer hasta encontrar el album que buscamos
                    int albumesLeidos=1;
                    Album a;
                    while (albumesLeidos <= numAlbumes) {
                        a = fin.lectura();      //Leer original
                        //Si es el que se busca, se modifica añadiendo los votos
                        if (numAlbum == albumesLeidos) {
                            a.setVotos(a.getVotos() + j);
                            String s = ("[#"+a.getPosicion()+" -"+j+"] ");
                            System.out.print(s);
                        }
                        finAux.escritura(a);    //Guardarlo en fichero temporal
                        albumesLeidos++;        //Aumentar contador
                    }

                    //Eliminar original
                    fin.borrar(f1);
                    fin.cerrarEnlace();

                    //Crear nuevo archivo llamado como el eliminado
                    f1 = new File(ficVotos);
                    fin = new FitxerAlbums(f1, "rw");    //Enlace con fichero
                    finAux.situarPuntero(0);         //Cominezo del auxiliar

                    //Copiar informacion del archivo temporal en el nuevo .txt
                    for (int idx = 0; idx < numAlbumes; idx++) {
                        //Leer album
                        a = finAux.lectura();
                        //Escribir datos del album
                        fin.escritura(a);
                    }

                    //Eliminar archivo temporal
                    finAux.borrar(f2);
                    finAux.cerrarEnlace();
                    fin.cerrarEnlace();
                }
                System.out.println("");
            }
            System.out.println("\n=====================================================================");
            System.out.println("=========================VOTACIONES ACABADAS=========================");
            System.out.println("=====================================================================");
            
        } catch (Exception e) {
            System.err.println("ERROR: "+e.getLocalizedMessage());
        } finally {
            //Cerrar enlaces con ficheros
            finAux.cerrarEnlace();
            fin.cerrarEnlace();
        }
    }
    
    static void opcion5() throws InsercioDadesException {
        //MOSTRAR EL MEJOR DISCO
        
        try {
            //Variables
            File f1 = new File(ficVotos);
            fin = new FitxerAlbums(f1, "rw");
            Album mejorAlbum = new Album();
            Album a = new Album();
            int albumesLeidos = 0;
            
            //Primera lectura
            mejorAlbum = fin.lectura();
            albumesLeidos++;

            //Iteracion de lectura del fichero
            while (albumesLeidos < numAlbumes) {
                //Leer album
                a = fin.lectura();
                //Comprobar cual tiene más votos
                if (a.getVotos() > mejorAlbum.getVotos()) {
                    mejorAlbum = a;
                }
                //Siguiente iteracion
                albumesLeidos++;
            }
            
            //Se han leido todos los albumes y el objeto mejorAlbum es el que más votos tiene
            System.out.println("\n\n\nEL MEJOR ALBUM ES, CON "+mejorAlbum.getVotos()+" VOTOS:");
            System.out.println("num "+mejorAlbum.getPosicion()+", Año "+mejorAlbum.getAño()+", impress "+mejorAlbum.getNumEdiciones()+", titulo "+mejorAlbum.getTitulo()+", artista "+mejorAlbum.getArtista()+",con "+mejorAlbum.getEstrellas()+" estrellas.");
            
        } catch (Exception e) {
            
        } finally {
            fin.cerrarEnlace();
        }
    }
    
    //Metodos para comprobar un dato
    private static boolean comprobarNum(int n) {
        //Numero negativo
        if (n < 0) {
            return false;
        }
        //Numero demasiado grande
        if (n >= 2147483647) {
            return false;
        }
        //Todo correcto
        return true;
    }
    private static boolean opcionValida(int n) {
        return (n>=0)||(n<=5);
    }
}
