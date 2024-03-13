package Clases;

public class Electrodomestico {
    LT tec = new LT();
    
    //---------------------------------ATRIBUTOS--------------------------------
    char Color = 'B';
    char Colores[] = "BNRAG".toCharArray();
    
    int Precio = 100;
    
    char ConsumoEnergetico = 'F';
    char Consumos[] = "ABCDEF".toCharArray();
    
    int Peso = 5;
    
    //----------------------------------MÉTODOS---------------------------------
    
    //Métodos Constructores
    public Electrodomestico() {
        Color = 'B';
        Precio = 100;
        ConsumoEnergetico = 'F';
        Peso = 5;
    }
    
    public Electrodomestico(int a, int b) {
        Color = 'B';
        Precio = a;
        ConsumoEnergetico = 'F';
        Peso = b;
    }
    
    public Electrodomestico(char c, int p, char e, int d) {
        Color = c;
        comprobarColor(c);
        Precio = p;
        ConsumoEnergetico = e;
        comprobarConsumoEnergetico(e);
        Peso = d;
    }
    
    //Métodos Get
    public char GetColor() {
        return Color;
    }
    
    public int GetPrecio() {
        return Precio;
    }
    
    public char GetConsumo() {
        return ConsumoEnergetico;
    }
    
    public int GetPeso() {
        return Peso;
    }
    
    //Método comprobarConsumoEnergetico(char letra)
    public boolean comprobarConsumoEnergetico(char a) {
        boolean correcto = true;
        if ((a != 'A') && (a != 'B') && (a != 'C') && (a != 'D') && (a != 'E') && (a != 'F')) {
            correcto = false;
        }
        if (correcto == false) {
            ConsumoEnergetico = 'F';
        }
        return correcto;
    }
    
    //Método comprobarColor(char c)
    public boolean comprobarColor(char c) {
        boolean correcto = true;
        if ((c != 'B') && (c != 'N') && (c != 'R') && (c != 'A') && (c != 'G')) {
            correcto = false;
        }
        if (correcto == false) {
            Color = 'B';
        }
        return correcto;
    }
    
    //Método precioFinal()
    public int precioFinal() {
        int precio = 0; Precio = 0;
        if (ConsumoEnergetico == 'A') { precio = 100; }
        if (ConsumoEnergetico == 'B') { precio = 80; }
        if (ConsumoEnergetico == 'C') { precio = 60; }
        if (ConsumoEnergetico == 'D') { precio = 50; }
        if (ConsumoEnergetico == 'E') { precio = 30; }
        if (ConsumoEnergetico == 'F') { precio = 10; }
        
        if ((Peso > 0) && (Peso <= 19)) { Precio = precio + 50; }
        if ((Peso > 20) && (Peso <= 49)) { Precio = precio + 50; }
        if ((Peso > 50) && (Peso <= 79)) { Precio = precio + 80; }
        if (Peso > 80) { Precio = precio + 100; }
        
        return Precio;
    }
    
}
