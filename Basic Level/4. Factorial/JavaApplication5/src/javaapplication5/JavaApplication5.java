package javaapplication5;
public class JavaApplication5 {
    public static void main(String[] args) {

        //INTRODUCIR VARIABLES 
        LT tec = new LT();
        Integer a;
        Integer b = 1;

        
        
        //LEER TECLADO Y HACER CÁLCULO
        System.out.println("Introduce un numero para calcular su factorial");
        a = tec.llegirSencer();
        if (a <= 0) {
            System.out.println("DAAAALE CHE SOS PELOTUDOOO");
        }

        for (int i = 1; i<=a; i++) {
            b = b * i;
        }
        System.out.println("El valor de tu factorial es " + b);

    }

}

/*RECORDAR QUE EL TAMAÑO QUE SOPORTA UN INTEGER ES DE 4 BYTES, Y ES PROBABLE QUE
SI LA VARIABLE A ES MAYOR A 10. POR EJEMPLO, SI QUEREMOS CALCULAR EL FACTORIAL
DE 20 NOS DARÁ ERROR. POR ESO ES MEJOR USAR UN DOUBLE, YA QUE SU CAPACIDAD ES
DE 8 A 16 BYTES (10^230 VALORES APROX)*/