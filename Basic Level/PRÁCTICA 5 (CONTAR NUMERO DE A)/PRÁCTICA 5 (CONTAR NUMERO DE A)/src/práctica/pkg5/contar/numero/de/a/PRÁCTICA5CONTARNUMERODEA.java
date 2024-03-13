package práctica.pkg5.contar.numero.de.a;

public class PRÁCTICA5CONTARNUMERODEA {

    public static void main(String[] args) {

        //DECLARAR VARIABLES Y LT
        LT tec = new LT();
        Character caracter;
        Integer b;

        b = 0;

        //PEDIR NOMBRE Y HACER PROCESO
        System.out.println ("Introduce una frase (debe finalizar en '.')");
        for (caracter = tec.llegirCaracter(); caracter != '.'; caracter = tec.llegirCaracter() ) {
            if (caracter == 'a') {
                b++;
            }
        }  
      System.out.println ("El número de A's es: " + b);
    }
}
