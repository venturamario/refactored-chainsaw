/*
Programa que posibilita grabar en un fichero, de nombre clientes_edad_<edad>.dat, 
todos los objetos Clientes del fichero clientes.dat que tengan la edad intrdocida
por teclado a petición del programa. Por ejemplo, si el usuario introduce la edad 
18 el fichero deberá llamarse clientes_edad_18.dat.
 */
package entrega_15_03_cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Entrega_15_03_Cliente_Grabacion {
    //ATRIBUTOS
    ClienteObjetoFicherosIn ficheroin;
    ClienteObjetoFicherosOut fout;
    Cliente cliente;
    String nombrefichero = "clientes_edad_";
    int edad;
    int contador = 0;
    
    //METODOS
    //metodo main
    public static void main(String[] args){
        new Entrega_15_03_Cliente_Grabacion().metodoprincipal();
    }
    
    //metodo principal
    public void metodoprincipal(){
        //instanciamos el objeto fichero para establecer el enlace con "clientes.dat"
        ficheroin = new ClienteObjetoFicherosIn("clientes.dat");
        //pedimos al usuario que nos indique la edad de los clientes
        edad = leerNum("Escribe la edad del cliente para visualizar todos los de esa edad: ");
        
        //bucle para recorrer el fichero "clientes.dat" para poder grabar en el otro
        //fichero, los clientes con la edad solicitada por el usuario
        for (cliente = ficheroin.leerCliente(); !cliente.esCentinela(); cliente = ficheroin.leerCliente()) {
            if (cliente.getEdad() == edad) {
                if (contador == 0) {
                    contador++;
                    //instanciamos el objeto fichero para establecer el enlace con "clientes_edad_<edad>.dat
                    fout = new ClienteObjetoFicherosOut(nombrefichero + edad + ".dat");
                    fout.escribirCliente(cliente);
                    System.out.println(cliente.toString());
                } else {
                    if (contador > 0) {
                        fout.escribirCliente(cliente);
                        System.out.println(cliente.toString());
                    }
                }

            } 
        }
        if (contador == 0){
            System.out.println("NO EXISTE NINGUN CLIENTE CON ESA EDAD");
        }else{
            fout.cerrarEnlaceFichero();
        }
        //cerrar enlace con el fichero
        ficheroin.cerrarEnlaceFichero();
    }
    
    
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
        //Devolver entero
            return num;
    }
}

