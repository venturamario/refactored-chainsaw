package práctica.pkg9.casino;
import java.util.Random;
public class PRÁCTICA9CASINO {

    public int num;
    public void inicio() {

        //--------------------JUEGO CASINO---------------------//
        
        //DECLARAR VARIABLES 
        LT tec = new LT();
        Random a = new Random();
        Integer usu;
        int cpu;
        int bote = 20;

        
        //ESCOGER NÚMERO RANDOM
        System.out.println("\tVAMOS A HACER APUESTAS");
        System.out.println("\tINTRODUCE EL Nº CON EL QUE QUIERAS APOSTAR (1 HASTA EL 6) ");
        System.out.println("\tSI ACIERTAS, TU DINERO SE DUPLICA, SI NO, SE TE RESTA 5");

        
        //HACER LOTERÍA
         while ((bote > 0) && (bote < 50)) {
         usu = tec.llegirSencer();
         cpu = (new Random()).nextInt(6) + 1;
         System.out.println("Jugador(" + usu + ") - CPU(" + cpu + ") ;  Bote:(" + bote + ").");
            
             if (cpu == usu) {
                 System.out.println("\tACERTASTE!!\n");
                 bote = bote * 2;
             } else {
                 System.out.println("\tCASI KRAK\n");
                 bote = bote - 5;
             }
        }
         
        if (bote == 0); {
            System.out.println("PERDISTE PELOTUDO LA BANCA TE GANÓ. BOTE FINAL:" + bote+ "\n\n");
        }
        if (bote >= 40); {
            System.out.println("GANASTE CONCHAETUMARE. TU BOTE FINAL ES DE " + bote+ "\n\n");
        }
    }

    public static void main (String[] args) {
        (new PRÁCTICA9CASINO()).inicio();
    }
}
