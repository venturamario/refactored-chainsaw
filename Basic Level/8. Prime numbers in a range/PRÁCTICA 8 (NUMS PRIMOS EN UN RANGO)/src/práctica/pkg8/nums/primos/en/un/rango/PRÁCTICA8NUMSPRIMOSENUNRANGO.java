package práctica.pkg8.nums.primos.en.un.rango;
public class PRÁCTICA8NUMSPRIMOSENUNRANGO {
    
    public int num;
    public void inicio () {

        //DECLARACIÓN VARIABLES Y LT    
        LT tec = new LT();
        System.out.println("INTRODUCE EL VALOR MÁXIMO DEL RANGO");
        final int x = tec.llegirSencer();
        int resto;
        

        
        //CÁLCULO DE Nº PRIMOS DE 0 HASTA X
        for (int y = 2; y < x; y++) {
            for (int a = y - 1; a <= 1 ; a - 1); {
              do {
                  resto = y % a;
                } while (resto != 0);  
            }
        }  System.out.println (y + "ES UN NÚMERO PRIMO");
    }
    public static void main (String[] args) {
        (new PRÁCTICA8NUMSPRIMOSENUNRANGO()).inicio();
    }
}
