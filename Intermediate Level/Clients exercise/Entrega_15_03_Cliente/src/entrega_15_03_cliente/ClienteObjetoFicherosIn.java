/*
Clase complementaria ClienteObjetoFicherosIn que posibilitará la lectura de objetos Cliente
desde ficheros a nivel de objetos. Hay que tener en cuenta que el final de fichero se
detectará a través de la técnica del centinela, en este caso, se trataría de escribir como
último objeto del fichero el objeto Cliente CENTINELA.
*/

package entrega_15_03_cliente;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ClienteObjetoFicherosIn {
    //ATRIBUTOS
    ObjectInputStream fichero = null;
    
    //CONSTRUCTOR
    public ClienteObjetoFicherosIn(String nombrefichero) {
        try {
            fichero = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nombrefichero)));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: EL FICHERO NO EXISTE " + nombrefichero);
        } catch (IOException e){
            System.out.println("ERROR DE LECTURA CON EL FICHERO " + nombrefichero);
        }
    }
    //METODOS
    //metodo leerCliente que lleva a cabo la lectura de objetos cliente desde el fichero
    public Cliente leerCliente(){
        //declaracion del objeto cliente
        Cliente cliente = new Cliente();
        try {
            //lectura objeto cliente desde el fichero
            cliente = (Cliente) fichero.readObject();
        } catch (EOFException error){
            return null;
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA CON EL FICHERO");
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR: NO SE HA PODIDO ENCONTRAR LA CLASE Cliente");
        }
        //devolucion objeto Cliente leído
        return cliente;
    }
    
    //metodo cerrarEnlaceFichero que cierra el enlace con el fichero
    public void cerrarEnlaceFichero(){
        if (fichero != null){
            try {
                //cierre del enlace con el fichero
                fichero.close();
            } catch (IOException ex) {
                System.out.println("ERROR DE LECTURA CON EL FICHERO");
            }
        }
    }
}
