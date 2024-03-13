package pkg3.comptarla;
public class Main {
    
    private void inicio() {
        
        //DECLARAR VARIABLES Y LT
        LT entrada = new LT();
        final char fiSequencia = '.';
        char lletra, lletrap;
        int nombre = 0;
        int ind = 0;
        char[] frase;
        
        //PROCESO
        System.out.print("Escriu un text acabat en '" + fiSequencia + "' i comptaré les 'la' que hi ha:");
        frase = entrada.llegirLiniaA();
        System.out.println(frase.length);
        lletra = ' ';
        lletrap = ' ';       
        while ((lletra != fiSequencia) && (ind < frase.length)) {
            if ((lletrap == 'l') && (lletra == 'a')) {
                nombre++;
            }
            lletrap = lletra;
            lletra = frase[ind];
            ind++;
        }
        System.out.println(
                "El nombre de 'la' que has escrit és: " + nombre);
    }

    public static void main(String[] args) {
        (new Main()).inicio();
    }
}
