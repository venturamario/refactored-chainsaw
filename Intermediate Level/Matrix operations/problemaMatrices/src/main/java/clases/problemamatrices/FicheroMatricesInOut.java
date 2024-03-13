/*
AUTOR: Mario Ventura
CURSO: 2021/2022
ASIGNATURA: Programación II
PROGRAMA: Resolver sistema de ecuaciones lineal mediante matrices
PROFESOR: Juan Montes de Oca
*/

package clases.problemamatrices;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


//Operaciones de entrada y salida con objetos matriz en ficheros
public class FicheroMatricesInOut {
    
    //---> ATRIBUTOS
    private BufferedReader br;          //Buffered Reader
    private RandomAccessFile raf;       //Random Access File
    private String nomFic;              //Nombre del fichero para enlazar
    private String modo;                //Modo (r // rw)
    private File f;                     //Objeto File
    private final int longitudFloat = 4;//Longitud en bytes de un float (32 bits)
    private boolean Final = false;      //Indica si el puntero esta en el EOF
    
    //---> MÉTODOS
    //Constructor
    public FicheroMatricesInOut() {
        //Vacío
    }
    public FicheroMatricesInOut(String nombre,String modo) {
        try {
            nomFic = nombre;
            raf = new RandomAccessFile(nombre,modo);
        } catch (Exception e) {
            System.err.println("ERROR EN LA CREACION DEL OBJETO" +e.getMessage());
        }
    }
    public FicheroMatricesInOut(File f, String tipo) {
        try {
            this.f = f;
            raf = new RandomAccessFile(f,tipo);
        } catch (Exception e) {
            System.err.println("ERROR EN LA CREACION DEL OBJETO" +e.getMessage());
        }
    }
    
    //Getters
    public RandomAccessFile getRaf() {
        return raf;
    }
    public String getNomFic() {
        return nomFic;
    }
    public File getFile() {
        return f;
    }
    public void setFinal(boolean b) {
        Final = b;
    }
    
    //Setters
    public void setRaf(RandomAccessFile raf) {
        this.raf = raf;
    }
    public void setNomFic(String nomFic) {
        this.nomFic = nomFic;
    }
    public void setF(File f) {
        this.f = f;
    }
    public boolean getFinal() {
        return Final;
    }
    
    //Lectura de un objeto matriz
    public Matriz lectura() {
        
        //VARIABLES
        Matriz matriz = new Matriz();
        matriz.inicializar();
        int filas,columnas;
        float valor;
        
        //Uso de bloque try-catch
        try {
            
            //---DAR VALOR A LAS VARIABLES DEL OBJETO MATRIZ---
            //Filas
            filas = raf.readInt();
            //Columnas
            columnas = raf.readInt();
            
            //Instanciar nuevo objeto Matriz
            matriz = new Matriz(filas,columnas);
            
            //Dar valor a los elementos de la matriz
            for(int i=0; i<filas; i++) {
                for(int j=0; j<columnas; j++) {
                    valor = raf.readFloat();
                    matriz.setValorEn(valor,i,j);
                }
            }
            
            System.out.println(matriz.toString());
            System.out.println("-----------------------------");
            
        } catch (EOFException e) {
            Final = true;
        } catch (Exception e) {
            System.err.println("ERROR EN LA LECTURA DE LA MATRIZ: "+e.getLocalizedMessage());
        } finally {
            return matriz;
        }
    }
    
    //Para colocar el puntero donde se desee
    public void colocarPuntero(long posicion) throws IOException {
        raf.seek(posicion);
    }
    
    //Obtener la longitud del fichero
    public long getLongitud() throws IOException {
        return raf.length();
    }

    //Escritura de una matriz en fichero
    public void escritura(Matriz m) {
        try {
            //--------ESCRITURA DEL ALBUM PASADO COMO PARÁMETRO--------
            
            //Filas 
            raf.writeInt(m.getNumFilas());
            //Columnas
            raf.writeInt(m.getNumColumnas());
            //Elementos
            for(int i=0; i<m.getNumFilas(); i++) {
                for (int j=0; j<m.getNumColumnas(); j++) {
                    raf.writeFloat(m.getValorEn(i,j));
                }
            }
        } catch (Exception e) {
            
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