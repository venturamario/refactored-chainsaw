/*
Programa que posibilita la búsqueda de un objeto Cliente en el fichero
clientes.dat. Se solicita al usuario la introducción del NOMBRE del objeto Cliente a
buscar.
 */
package entrega_15_03_cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Entrega_15_03_Cliente_Busqueda2 {
    //ATRIBUTOS
    Cliente cliente;
    ClienteObjetoFicherosIn ficheroin;
    String nombre;
    boolean encontrado = false;
    
    //METODOS
    //Metodo main
    public static void main (String[] args){
        new Entrega_15_03_Cliente_Busqueda2().metodoprincipal();
    }
    
    //Metodo principal
    private void metodoprincipal(){
        //solicitar al usuario el codigo del cliente
        nombre = leerCadena("Introduce el nombre del cliente a buscar: ");
        //instanciacion del objeto fichero para establecer el enlace con "clientes.dat"
        ficheroin = new ClienteObjetoFicherosIn("clientes.dat");
        //bucle para recorrer el fichero hasta encontrar el codigo solicitado o 
        //el fichero acabe
        cliente = ficheroin.leerCliente();
        
        while(cliente.getCodigo()!= -1){
            if (cliente.getNombre().equals(nombre)){
                System.out.println("Se ha encontrado el cliente y es: "+cliente.toString());
                encontrado = true;
            }
            cliente = ficheroin.leerCliente();
        }
        if (encontrado == false){
            System.out.println("EL CLIENTE NO EXISTE");
        }
    }
    
    //metodo para leer el nombre del cliente solicitado
     public static String leerCadena(String s){
        String nombre = null;
        try {
            System.out.print(s);
            //Se lee lo que se introduce por teclado
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            nombre = br.readLine();
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA");
        }
        return nombre;
    }
}
