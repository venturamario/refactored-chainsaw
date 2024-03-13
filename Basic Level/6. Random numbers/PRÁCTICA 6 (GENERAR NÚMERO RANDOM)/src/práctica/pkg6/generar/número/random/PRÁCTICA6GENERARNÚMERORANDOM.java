package práctica.pkg6.generar.número.random;

import java.util.Random;

public class PRÁCTICA6GENERARNÚMERORANDOM {

    public static void main(String[] args) {

        //DECLARAR VARIABLES 
        LT tec = new LT();
        Random a = new Random();
        Integer usu;
        int cpu;

        
        
        //EMPEZAR PROCESO
        System.out.println("Introduce un nº del 1 al 6: ");
        usu = tec.llegirSencer();
        cpu = a.nextInt(6) + 1;
        if (usu == cpu) {
            System.out.println("Ganaste ché");
        } else {
            System.out.println("Perdiste ché");
        }
    }
}
