/*
AUTOR: Mario Ventura Burgos
FECHA: 04-2022
ASIGNATURA: Programación II
TRABAJO: Programa de gestión de ficheros de albumes con votos
*/

package clases.taller1_04_2022;

import java.io.File;
import java.io.RandomAccessFile;


public class FitxerAlbums {
    /*********************************************************
    * CLASE CON ATRIBUTOS Y FUNCIONALIDADES PARA EL FLUJO DE
    * ENTRADA Y SALIDA DE DATOS CON FICHEROS MEDIANTE EL USO
    * DEL ACCESO ALEATORIO.
    *********************************************************/
    
    //----------------------ATRIBUTOS----------------------
    RandomAccessFile raf;   // Random Access File
    String nomFic;          // Nombre del fichero
    final int longi = 62;   // Longitud maxima de un String (longitud del titulo mas largo)
    File f;                 // Objeto file
    
    //----------------------MÉTODOS----------------------
    //Constructor
    public FitxerAlbums(String fichero, String tipo) {
        try {
            nomFic = fichero;
            raf = new RandomAccessFile(fichero,tipo);
        } catch (Exception e) {
            System.err.println("ERROR EN LA CREACION DEL OBJETO 'ficheroIn'" +e.getMessage());
        }
    }
    public FitxerAlbums(File f, String tipo) {
        try {
            this.f = f;
            raf = new RandomAccessFile(f,tipo);
        } catch (Exception e) {
            System.err.println("ERROR EN LA CREACION DEL OBJETO 'ficheroIn'" +e.getMessage());
        }
    }
    
    //Getter
    public RandomAccessFile getRAF() {
        return raf;
    }
    
    //Obtener longitud del objeto
    private int getLongitudAlbum() {
        //3 Strings, 1 double, 4 ints:
        return ((longi*3)+(8)+(4*4));
    }
    
    //Lectura
    public Album lectura() {
        
        //VARIABLES
        Album a = new Album();
        int posicion;       
        int año;            
        int ediciones;   
        int votos;         
        
        double estrellas;   
        
        String titulo = "";
        String artista = "";
        String tipo = "";
    
        
        //Uso de bloque try-catch
        try {
            
            //DAR VALOR A LAS VARIABLES DEL OBJETO ALBUM
            //Posicion
            posicion = raf.readInt();
            //Año
            año = raf.readInt();
            //Titulo
            for (int i=0; i<longi; i++) {
                titulo += raf.readChar();
            }
            //Artista
            for (int i=0; i<longi; i++) {
                artista += raf.readChar();
            }
            //Tipo
            for (int i=0; i<longi; i++) {
                tipo += raf.readChar();
            }
            //Estrellas
            estrellas = raf.readDouble();
            //Ediciones
            ediciones = raf.readInt();
            //Votos
            votos = raf.readInt();
            
            //Objeto album
            a = new Album(posicion, año, titulo, artista, estrellas, ediciones, tipo, votos);
            
            //Devolver album
            
        } catch (Exception e) {
            
        } finally {
            return a;
        }
    }
    
    //Escritura
    public void escritura(Album a) {
        //Uso de bloque try-catch
        try {
            
            //--------ESCRITURA DEL ALBUM PASADO COMO PARÁMETRO--------
            
            //POSICIÓN EN EL RANKING
            raf.writeInt(a.getPosicion()); 
            
            //AÑO DE EDICIÓN
            raf.writeInt(a.getAño());  
            
            //TÍTULO DEL ALBUM
            if (a.getTitulo().length() < longi) {
                for (int i=a.getTitulo().length(); i < longi; i++) {
                        a.setTitulo(a.getTitulo() + " ");
                }
            }
            raf.writeChars(a.getTitulo());
            
            //ARTISTA DEL ALBUM
            if (a.getArtista().length() < longi) {
                for (int i=a.getArtista().length(); i<longi; i++) {
                    a.setArtista(a.getArtista()+" ");
                }
            }
            raf.writeChars(a.getArtista());
            
            //TIPO DE ALBUM
            if (a.getTipo().length() < longi) {
                for (int i=a.getTipo().length(); i<longi; i++) {
                    a.setTipo(a.getTipo()+" ");
                }
            }
            raf.writeChars(a.getTipo());
            
            //ESTRELLAS DE VALORACIÓN DEL ALBUM
            raf.writeDouble(a.getEstrellas());
            
            //NUMERO DE EDICIONES DEL ALBUM
            raf.writeInt(a.getNumEdiciones());
            
            //NUMERO DE VOTOS DEL ALBUM
            raf.writeInt(a.getVotos());
            
        } catch (NumberFormatException e) {
            System.err.println("ERROR DE FORMARTO DE NUMERO EN " +e.getLocalizedMessage());
        } catch (Exception e) {
            System.err.println("ERROR: " +e.getMessage());
        }
    }
    
    //Cerrar flujo de datos con el fichero
    public void cerrarEnlace() {
        try {
            raf.close();
        } catch (Exception e) {
            System.err.println("ERROR AL CERRAR EL ENLACE CON EL FICHERO");
        }
    }
    
    //Mover Puntero
    public void situarPuntero(int n) {
        try {
            int tamaño = getLongitudAlbum();
            raf.seek(n*tamaño);
        } catch (Exception e) {
            
        }
    }
    
    //Para borrar un fichero
    void borrar(File Ffichero) {
    /***************************************************************
     * El metodo "Borrar" como su nombre lo indica, nos ayuda a
     * borrar un fichero previamente creado, este metodo cuenta con
     * un parametro, el cual es el nombre del fichero que deseamos
     * borrar
    ****************************************************************/
        try {
            // Comprovamos si el fichero existe  de ser así procedemos a borrar el archivo
            if (Ffichero.exists()) {
                Ffichero.delete();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
