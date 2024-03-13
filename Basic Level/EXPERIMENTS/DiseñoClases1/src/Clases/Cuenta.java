package Clases;

public class Cuenta {
    
    //--------------------------------ATRIBUTOS---------------------------------
    String Titular;
    double Cantidad;
    
    //---------------------------------MÉTODOS----------------------------------
    
    //Métodos Constructores
    public Cuenta (String titular) {
        Titular = titular;
    }
    
    public Cuenta (String titular, double cantidad) {
        Titular = titular;
        Cantidad = cantidad;
    }
    
    
    
    //Método ingresar
    public double Ingresar(double dinero) {
        if (dinero >= 0) {
            Cantidad = Cantidad + dinero;
        }
        return Cantidad;
    }
    
    //Método retirar
    public double retirar (double dinero) {
        Cantidad = Cantidad - dinero;
        //Si la cantidad que se retira es mayor que la que había antes, nos quedamos en numeros rojos y la caantifad de dinero en la cuenta es 0$
        if ((Cantidad - dinero) < 0) {
            Cantidad = 0;
        }
        return Cantidad;
    }
    
    
    
}
