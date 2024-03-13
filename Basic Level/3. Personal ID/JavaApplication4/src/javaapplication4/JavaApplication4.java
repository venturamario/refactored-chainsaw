package javaapplication4;
public class JavaApplication4 {
    public static void main(String[] args) {

        //DECLARAR VARIABLES Y PONER EL LT
        LT tec = new LT();

        String n;
        Integer e;
        Character g;
        String d;

        
        //PEDIR AL USUARIO EL VALOR DE CADA VARIABLE Y RECOPILAR INFORMACIÓN
       System.out.println("\n\tVAMOS A CREAR UN CARNÉ DE ESTUDIANTE:\n");
        do {
            System.out.print("Introduce tu nombre ---->");
            n = tec.llegirLiniaS();
             if (n==null) {
               System.out.println("ERROR");
            }
        } while (n == null);
        
        do {
            System.out.print("Introduce tu edad ---->");
            e = tec.llegirSencer();
            if (e<=0) {
               System.out.println("ERROR");
            }
            if (e>=120) {
            System.out.println("Dale che sos más viejo que Jesucristo");
            }
        } while (e == null);
        
        do {
            System.out.print("Introduce tu género: M para masculino, F para femenino ---->");
            g = tec.llegirCaracter();
            if (g == null) {
               System.out.println("ERROR");
            }
        } while (g == null);
        
        do{
            System.out.print("Introduce tu DNI ---->");
            d = tec.llegirLiniaS();
            if (d==null) {
               System.out.println("ERROR");
            }
        } while (d == null);
        
        //MOSTRAR RESULTADO FINAL 
        
        System.out.println("\n\n\t---TARJETA DE IDENTIFICACIÓN---");
        System.out.println("\tNombre: " + n);
        System.out.println("\tEdad: " + e + " años");
        System.out.println("\tGénero: " + g);
        System.out.println("\tDNI: " + d);
    }   
}
