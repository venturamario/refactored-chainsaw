/*
Programa que posibilita la búsqueda de un objeto Cliente en el fichero
clientes.dat. Se solicita al usuario la introducción del CÓDIGO del objeto Cliente a
buscar.
*/
package entrega_15_03_cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Entrega_15_03_Cliente_Busqueda {
    //ATRIBUTOS
    Cliente cliente;
    ClienteObjetoFicherosIn ficheroin;
    int codigo;
    boolean encontrado = false;
    
    //METODOS
    //Metodo main
    public static void main (String[] args){
        new Entrega_15_03_Cliente_Busqueda().metodoprincipal();
    }
    
    //Metodo principal
    private void metodoprincipal(){
        //solicitar al usuario el codigo del cliente
        codigo = leerNum("Introduce el codigo numerico del cliente a buscar: ");
        //instanciacion del objeto fichero para establecer el enlace con "clientes.dat"
        ficheroin = new ClienteObjetoFicherosIn("clientes.dat");
        //bucle para recorrer el fichero hasta encontrar el codigo solicitado o 
        //el fichero acabe
        cliente = ficheroin.leerCliente();
        
        while(cliente.getCodigo() != -1){
            if (codigo == cliente.getCodigo()){
                System.out.println("Se ha encontrado el cliente y es: "+cliente.toString());
                encontrado = true;
            }
            cliente = ficheroin.leerCliente();
        }
        if (encontrado == false){
            System.out.println("EL CLIENTE NO EXISTE");
        }
    }
    
    //metodo para leer el codigo numerico del cliente
    public static int leerNum(String s) {
        int num = 0;
        try {
            System.out.print(s);
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
