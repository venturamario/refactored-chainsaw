package caracreu;
import java.util.Random;
public class CaraCreuBo {

    private void inicio() {
        
        //PROGRAMA PRINCIPAL. PROCESO UTILIZANDO SUBPROGRAMAS
        int vegades = numVegades(20, 50);
        int resultats[] = new int[vegades];
        ferJugades(resultats);
        if (hiHaQuatreCaresSeguides(resultats)) {
            System.out.println("Hi ha quatre cares o més seguides!");
        } else {
            System.out.println("No hi ha quatre cares o més seguides!");
        }
    }
    
    //----------------------CREAR SUBPROGRAMAS----------------------//
    
    //SUBPROGRAMA DE CREAR UN Nº DE VECES
    public int numVegades(int a, int b) {
        Random ran = new Random();
        int repeticiones = ran.nextInt((b - a + 1)) + a;
        System.out.print("De entre " + a + " i " + b + " vegades, ");
        System.out.println("vaig a fer-ne " + repeticiones);
        return repeticiones;
    }

    //SUBPROGRAMA DE TIRAR LA MONEDA Y VER SI ES CARA O CRUZ
    public void ferJugades(int r[]) {
        Random ran = new Random();
        for (int i = 0; i < r.length; i++) {
            r[i] = ran.nextInt(2);
        }
    }

    //SUBPROGRAMA PARA CONTAR SI SALE CARA 4 VECES SEGUIDAS O MÁS
    public boolean hiHaQuatreCaresSeguides(int r[]) {
        int cont = 0;
        boolean res = false;
        for (int i = 0; (i < r.length) && (!res); i++) {
            if (r[i] == 0) {
                cont++;
            } else {
                cont = 0;
            }
            if (cont == 4) {
                res = true;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        (new CaraCreuBo()).inicio();
    }

}
