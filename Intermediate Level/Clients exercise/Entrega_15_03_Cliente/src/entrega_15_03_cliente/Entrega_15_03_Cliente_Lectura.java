/*
Programa que posibilita el recorrido del fichero clientes.dat visualizando en
pantalla los objetos Cliente contenidos en él
*/

package entrega_15_03_cliente;

public class Entrega_15_03_Cliente_Lectura {
    //ATRIBUTOS
    Cliente cliente;
    ClienteObjetoFicherosIn ficheroin;
   
    //METODOS
    //Metodo main
    public static void main(String[] args) {   
        new Entrega_15_03_Cliente_Lectura().metodoprincipal();
    }
    
    //Metodo principal
    private void metodoprincipal(){
        //INSTANCIACIONES
        //instanciacion del objeto fichero para establecer el enlace con clientes.dat
        ficheroin = new ClienteObjetoFicherosIn("clientes.dat");
        //bucle para recorrer el fichero y visualizar todos los objetos cliente
        for(cliente=ficheroin.leerCliente(); !cliente.esCentinela();cliente = ficheroin.leerCliente()){
            //visualizamos el objeto cliente
            System.out.println(cliente.toString());
        }
        //cerramos enlace con el fichero
        ficheroin.cerrarEnlaceFichero();
    }
}
