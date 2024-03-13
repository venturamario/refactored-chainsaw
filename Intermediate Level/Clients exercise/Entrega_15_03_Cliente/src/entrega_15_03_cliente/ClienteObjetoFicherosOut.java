/*
Clase complementaria ClienteObjetoFicherosOut que posibilitará la escritura de objetos Cliente
en ficheros a nivel de objetos. Hay que tener en cuenta que el final de fichero se
detectará a través de la técnica del centinela, en este caso, se trataría de escribir como
último objeto del fichero el objeto Cliente CENTINELA.
*/

package entrega_15_03_cliente;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class ClienteObjetoFicherosOut {
    //ATRIBUTOS
    ObjectOutputStream fichero = null;
    
    //CONSTRUCTOR
    public ClienteObjetoFicherosOut(String nombrefichero) {
        try {
            fichero = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nombrefichero)));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: EL FICHERO NO EXISTE " + nombrefichero);
        } catch (IOException e){
            System.out.println("ERROR DE LECTURA CON EL FICHERO " + nombrefichero);
        }
    }
    
    //METODOS
    //metodo escribirCliente que lleva a cabo la escritura de objetos cliente en el fichero
    public void escribirCliente(Cliente cliente){
        try {
            //escritura objeto cliente en el fichero
            fichero.writeObject(cliente);
        }catch (IOException error) {
            System.out.println("ERROR DE LECTURA CON EL FICHERO "+ error.toString());
        }
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
