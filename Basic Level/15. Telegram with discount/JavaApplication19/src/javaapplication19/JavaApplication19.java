package javaapplication19;
public class JavaApplication19 {

    public void inicio() {

        //PRESENTACIÓN
        System.out.println("DESCUENTO DE NAVIDAD!!! PALABRAS DE MENOS DE 4 LETRAS POR 0$ Y PERA A GRANEL A 3X2 EL KILO!!!");
        System.out.println("INTRODUCE TU TEXTO:");

        //INICIALIZACIÓN, DECLARAR VARIABLES Y PONER LT
        LT tec = new LT();
        final char FINAL = '.';
        final int OFERTA = 4;
        int cpalabras = 0;
        int cletras = 0;
        final double preciopp = 0.10;
        char frase[] = tec.llegirLiniaA();
        int aux = 0;
        Character letra;

        //PROCESO
        do {
            do {
                letra = frase[aux];
                cletras++;
                aux++;
            } while ((letra != FINAL) && (letra != ' '));
            if (cletras > OFERTA) { cpalabras++; }
            cletras = 0;
            aux++;
        } while (aux <= frase.length);
        
        //DAR RESULTADOS
        System.out.println("EL NUMERO TOTAL DE PALABRAS DE MÁS DE 4 LETRAS ES DE " + cpalabras);
        System.out.println("POR TANTO EL PRECIO A PAGAR ES DE " + cpalabras * preciopp);
        System.out.println("MUCHAS GRACIAS Y VISCA CATALUNYA");
    }

    public static void main(String[] args) {
        (new JavaApplication19()).inicio();
    }
}
