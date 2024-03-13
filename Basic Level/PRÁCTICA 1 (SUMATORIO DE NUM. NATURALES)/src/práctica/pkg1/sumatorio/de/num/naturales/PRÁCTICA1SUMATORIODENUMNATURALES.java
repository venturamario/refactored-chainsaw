package práctica.pkg1.sumatorio.de.num.naturales;

public class PRÁCTICA1SUMATORIODENUMNATURALES {

    public static void main(String[] args) {
//INTRODUCIR VARIABLES DE TIPO ENTERO
        int A = 0;
        int B = 0;
//CALCULAR SUMA DE N ENTEROS HASTA 20 JEJE
        do {
            A = A + 1;
            B = B + A;
        } while (A < 20);

        
//INTRODUCIMOS DOS VARIABLES NUEVAS
        int C = 0;
        int D = 0;
//CALCULAR SUMA DE N ENTEROS HASTA 10 XDLOL
        do {
            C = C + 1;
            D = D + C;
        } while (C < 10);


//INTRODUCIMOS UNA VARIABLE NUEVA Y HACEMOS EL CÁLCULO FINAL
        int E = B - D; 
    System.out.println("El resultado final es:" + (E));
    }
}


/*FORMA ALTERNATIVA Y MÁS EFICIENTE
EN VEZ DE SUMAR LOS 20 PRIMEROS Y RESTAR LOS 10 PRIMEROS, HACER LA SUMA DESDE
EL 10, YA QUE LOS 10 PRIMEROS SE ANULARÁN

int T = 0;
int C = 10;
do {
C = C + 1;
T = T + C;
} while (C < 20);
System.out.println ("EL RESULTADO ES:" + T);

ESTE CÓDIGO OCUPA MENOS RAM, TARDARÁ MENOS EN EJECUTARSE, ETC...
*/