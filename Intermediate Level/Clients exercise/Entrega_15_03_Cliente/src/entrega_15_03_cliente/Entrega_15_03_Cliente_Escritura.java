/*
Programa que posibilita la lectura por teclado de objetos Clientes y su
grabación en un fichero de nombre clientes.dat. El proceso de lectura y grabación
finalizará cuando el usuario lo indique. Los clientes se grabarán en
orden ascendente del atributo código.
*/

package entrega_15_03_cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Entrega_15_03_Cliente_Escritura {
    //ATRIBUTOS
    Cliente cliente;
    ClienteObjetoFicherosOut fout;
    String opcion;
    boolean fin = false;
    
    //METODOS   
    //Metodo main
    public static void main(String[] args){
        new Entrega_15_03_Cliente_Escritura().metodoprincipal();
    }
    
    //Metodo principal
    private void metodoprincipal(){
        //instanciacion del objeto fichero para establecer el enlace con clientes.dat
        //donde se grabaran los objetos clientes
        fout = new ClienteObjetoFicherosOut("clientes.dat");
        //bucle de lectura de objetos cliente
        while(fin == false){
            try {
                //instanciacion objeto cliente
                cliente = new Cliente();
                //lectura del objeto cliente
                cliente.lectura();
                //escribimos el objeto cliente en el fichero
                fout.escribirCliente(cliente);
                //mensaje para saber si el usuario desea continuar o no
                System.out.println("< > CONTINUAR: s/n ");
                //inicializacion de opcion
                opcion = leerCadena();
                //if que comprueba lo que quiere hacer el usuario y pone fin a true
                if (opcion.equals("n")){
                    fin = true;
                }
            } catch (IOException ex) {
                System.out.println("ERROR DE LECTURA");
            }
        }
        //escritura del objeto cenitnela al final del fichero
        fout.escribirCliente(Cliente.getCentinela());
        //cerrar enlace fichero
        fout.cerrarEnlaceFichero();
    }
    
     public static String leerCadena() throws IOException {
        String nombre = null;
        //Se lee lo que se introduce por teclado
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nombre = br.readLine();
        return nombre;
    }
}
