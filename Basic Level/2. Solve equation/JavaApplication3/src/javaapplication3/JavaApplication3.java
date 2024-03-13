package javaapplication3;
public class JavaApplication3 {
    public static void main(String[] args) {
        //INTRODUCIMOS VARIABLES A, B, y el "LT"
        Double a, b;
        LT tec = new LT();
        

        //LEER VALOR DE B Y DAR ERROR SI NO ES NUMERO REAL
        do {
            System.out.print("Introduce el coeficiente de b: ");
            b = tec.llegirReal();
            if (b == null) {
                System.out.println("PONLO BIEN CAPULLO");
            }
        } while (b == null);
        

        //LEER VALOR DE A Y DAR ERROR SI NO ES NUMERO REAL
        do {
            System.out.print("Introduce el coeficiente de a: ");
            a = tec.llegirReal();
            if (a == null) {
                System.out.println("QUE PONGAS UN NÚMERO, PARGUELA");
            }
        } while (a == null);

        
        //MOSTRAR EN PANTALLA EL RESULTADO FINAL
        System.out.println("El resultado de la ecuación es: " + (-b / a));

    }
}
       
        
    /* EJEMPLO PROFE
package javaapplication3;
public class JavaApplication3 {
    public static void main(String[] args) {
     
    LT tec = new LT();
    Double a, b;
    do {
    System.out.print(Introduce el valor de B);
    b = tec.llegirReal();
    if {b == null); {
        System.out.println("ERROR");
        }
    } while (b == null);

    do {
    System.out.print(Introduce el valor de A);
    a = tec.llegirReal();
    if {a == null); {
        System.out.println("ERROR");
        }
    } while (a == null);

System.out.println ("El resultado es " + (-b/a));
    
}
     */
