package examenp1;
import java.util.Random;

public class Barco {
    
    //--------------------------------ATRIBUTOS---------------------------------
    int Cebo;
    float Pescado;
    private final int MaxBodega = 500;
    
    //----------------------------------MÉTODOS---------------------------------
    
    //Métodos Constructores
    public Barco (int a) {
        Cebo = a;      //Se carga la cantidad de cebo que se desee
        Pescado = 0;   //Siempre se empieza con la bodega vacía
    }
    
    //Método pesca
    public float Pesca(int cebo) {
        //Si se especifica una cantidad de cebo superior a la que se tiene, se usa la cantidad restante
        if (cebo > Cebo) {
            Cebo = (cebo - Cebo);
        }
        
        //Pescar. Por cada unidad de cebo (i) sale un número aleatorio entre 0 y 10
        for (int i = 0; ((i < Cebo)&&(Pescado <= MaxBodega)); i++)  {
            Random a = new Random();
            int numero = a.nextInt(10);
            Pescado = Pescado + numero;
        }
        
        //Devolver la cantidad de pescado que se ha recogido
        return Pescado;
    }
    
    //Método Transfiere Cebo
    public int TransfiereCebo(int cebo, Barco a, Barco b) {
        //Barcos cuyo cebo va a ser transferido 
        Barco barco1 = a;
        Barco barco2 = b;
        
        //Si la cantidad de cebo que se quiere transferir es mayor a la que se tiene, se transfiere todo:
        if (cebo > barco1.Cebo) {
            cebo = barco1.Cebo; //No se puede transferir todo lo que se pretendia. Se transferirá todo lo que se tenga.
        }
        
        //Transferir Cebo
        barco1.Cebo = Cebo - cebo; //El barco 1 le da Cebo al barco 2, por tanto, pierde cebo
        barco2.Cebo = Cebo + cebo; //El barco 2 recibe cebo, por tanto esa cantidad se suma a la inicial
        
        //Devolver la cantidad de cebo que se ha transferido
        return cebo;
    }
    
    //Método equals
    public boolean equals(Barco a, Barco b) {
        boolean iguales = false;
        
        //Misma cantidad de cebo
        if (a.Cebo == b.Cebo) {
            //Si la diferencia de sus cantidades es menor o igual a 100 gramos (0,100 quilos), son iguales
            if (((a.Pescado - b.Pescado) >= -0.100) && ((a.Pescado - b.Pescado) <= 0.100)) {
                iguales = true;
            }
        }
        
        //Mostrar si son iguales
        return iguales;
    }
    
    //Método toString
    public String toString() {   
        //Mostrar información del barco
        return ("EL BARCO TIENE UNA CANTIDAD DE "+Pescado+ " QUILOS DE PESCADO\n" +
                "Y UNA CANTIDAD DE " +Cebo+ " UNIDADES DE CEBO.");
    }
    
}
