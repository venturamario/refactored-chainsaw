package Clases;

public class Ejecutable {
    
    public static void main(String[] args) {
        ExamenP2 a = new ExamenP2();
        
        //EJECUCIÓN DE TODO LO ANTERIOR
        char nombre[] = "entrada.txt".toCharArray();
        Paraula NomFic = new Paraula(nombre);
        
        a.EncontrarPalabras(NomFic.toString());
        a.EncontrarCIL(NomFic.toString());
        System.out.println("\n\n");
    }
    
    
}
