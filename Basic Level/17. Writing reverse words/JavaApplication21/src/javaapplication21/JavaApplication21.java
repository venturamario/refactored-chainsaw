package javaapplication21;
public class JavaApplication21 {
    
    public void inicio () {
        
        //DECLARAR VARIABLES Y PONER LT
        LT tec = new LT();
        final int MAXIMO = 20;
        final char FINAL = '.';
        char palabra[] = new char [MAXIMO];
        
        //PRESENTACIÓN
        System.out.println("ESCRIBE UNA PALABRA DE MAXIMO " +MAXIMO+ " LETRAS Y ACABADA EN " +FINAL+ " Y YO LA INVERTIRÉ");
        palabra = tec.llegirLiniaA();
        int aux = palabra.length;
        System.out.println("LONGITUD DE LA PALABRA: " + aux);
        
        //ERROR
        if ((palabra.length > MAXIMO) || (palabra[aux-1] != FINAL)) {  System.out.println("ERROR"); } else {
        
        //MOSTRAR PALABRA INVERTIDA
        System.out.println("LA PALABRA QUE HAS INTRODUCIDO EN FORMA INVERTIDA ES: ");
        aux--;
        while (aux >= 0) {
        System.out.print(palabra[aux]);
        aux--;
        } System.out.println("\n\n");
    
        }
}
    public static void main(String[] args) {
        new JavaApplication21().inicio();
    }
}
