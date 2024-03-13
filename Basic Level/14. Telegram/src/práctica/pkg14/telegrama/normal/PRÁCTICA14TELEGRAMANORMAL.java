package práctica.pkg14.telegrama.normal;
public class PRÁCTICA14TELEGRAMANORMAL {

    public void inicio() {

        //DECLARAR VARIABLES Y PONER LT
        System.out.println("INTRODUCE TU TEXTO:");
        LT tec = new LT();
        int contador = 0;
        final double preciopp = 0.10;
        char r[] = tec.llegirLiniaA();
        Character letrap = ' ';
        Character letra;

        //PROCESO
        for (int posicion = 0; posicion < r.length; posicion++) {
            letra = r[posicion];
            if ((letrap == ' ') && (letra != ' ')) {
            contador++;
            }
            letrap = letra;
        }
        System.out.println("EL Nº DE PALABRAS DEL MENSAJE ES DE " + contador);
        System.out.println("POR TANTO EL PRECIO A PAGAR ES DE " + (preciopp * contador) + " EUROS");
    }

    public static void main(String[] args) {
        (new PRÁCTICA14TELEGRAMANORMAL()).inicio();
    }

}
