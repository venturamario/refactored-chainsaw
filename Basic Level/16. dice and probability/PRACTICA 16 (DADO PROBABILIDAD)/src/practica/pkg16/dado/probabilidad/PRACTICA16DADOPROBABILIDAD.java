package practica.pkg16.dado.probabilidad;
import java.util.Random;
public class PRACTICA16DADOPROBABILIDAD {
    
    public void inicio () {
    
    //DECLARAR VARIABLES
    LT tec = new LT();
    int jugadacpu;
    double numpartidas;
    double c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0;
    int aux = 1;
    
    
    //PRESENTACIÓN
    System.out.println("INTRODUCE EL NUMERO DE PARTIDAS QUE QUIERES JUGAR \n");
    numpartidas = tec.llegirSencer();
    
    //PROCESO
    while (aux <= numpartidas) {
    jugadacpu = (new Random()).nextInt(6) + 1;
    
        //CONTAR REPETICIONES DE CADA NÚMERO
        switch (jugadacpu) {
            case 1:
                c1++;
                break;
            case 2:
                c2++; 
                break;
            case 3:
                c3++;
                break;
            case 4:
                c4++;
                break;
            case 5:
                c5++;
                break;
            case 6:
                c6++;
                break;
            default:
                break;
        }  
    aux++;
    }

    
    //PROBABILIDADES
    System.out.println("\n\nLAS PROBABILIDADES DE CADA RESULTADO DEL DADO SON: \n");
    System.out.println("LA PROBABILIDAD DE QUE SALGA 1 ES: " + c1/numpartidas);
    System.out.println("LA PROBABILIDAD DE QUE SALGA 2 ES: " + c2/numpartidas);
    System.out.println("LA PROBABILIDAD DE QUE SALGA 3 ES: " + c3/numpartidas);
    System.out.println("LA PROBABILIDAD DE QUE SALGA 4 ES: " + c4/numpartidas);
    System.out.println("LA PROBABILIDAD DE QUE SALGA 5 ES: " + c5/numpartidas);
    System.out.println("LA PROBABILIDAD DE QUE SALGA 6 ES: " + c6/numpartidas);
    }
    public static void main(String[] args) {
        (new PRACTICA16DADOPROBABILIDAD()).inicio();
    }
}
