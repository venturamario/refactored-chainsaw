package práctica.evaluable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FicheroIn {
    
    private FileReader fr;
    private BufferedReader br;
    private Character car;
    private int lin;
    private int col;
    
    //CONSTRUCTOR
    public FicheroIn(Paraula nom) {
        archivo = nom;
        try {
            fr = new FileReader(archivo.toString());
            br = new BufferedReader(fr);
            lin = col = 1;
        } catch (FileNotFoundException e) {
            System.err.println("EXCEPTION ABRIENDO " + archivo + ": " + e);
        }
    }
    
    //LEER
    public Character llegir() {
        int aux;
        Character ca = null;
        try {
            aux = br.read();
            if (aux >= 0) {
                ca = (char) aux;
                if (ca.charValue() == 10) {
                    lin++;
                    col = 1;
                } else {
                    if (ca.charValue() != 13) {
                        col++;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Excepcion llegint caracter a l'arxiu " + archivo + ": " + e);
        }
        return ca;
    }
    
    //CERRAR FICHERO
    public void close() {
        try {
            br.close();
            fr.close();
        } catch (Exception e) {
            System.err.println("Excepcion tancant l'arxiu " + archivo + ": " + e);
        } finally {
            try {
                fr.close();
            } catch (Exception e2) {
                System.err.println("Excepcion tancant l'arxiu " + archivo + ": " + e2);
            }
        }
    }
    
    
    //------------------------------CODIFICACION--------------------------------
    //ATRIBUTOS Y VARIABLES PARA CODIFICAR
    private int llavor;
    private Paraula archivo;
    private char[] original;
    private char[] codificado;
    
    //PROCESAR EL ARCHIVO DE TEXTO Y CODIFICARLO/DECODIFICARLO
    public void ProcesarArchivo(char alfa[], char[] beta) {
        FicheroIn fi = new FicheroIn(archivo);
        FicheroOut fo = new FicheroOut(new Paraula("Codificado.txt".toCharArray()));
        Character c = fi.llegir();
        char car = 0;
        int ind;
        while (c != null) {
            ind = 0;
            //ENONTRAR QUE CARACTER ES EL LEÍDO
            while ((ind < alfa.length) && (alfa[ind] != c)) {
                ind++;
            }
            //CARACTER NO ENCONTRADO, NO CODIFICAR
            if (ind == alfa.length) { 
                car = c;
            } else {
                //CARACTER ENCONTRADO, CODIFICAR
                car = beta[ind];  
            }
            fo.gravar(car);
            c = fi.llegir();
        }
        fi.close();
        fo.close();
        File fich = new File(archivo.toString());
        fich.delete();
        File fich2 = new File("tempo.tmp");
        fich2.renameTo(fich);
    }
     
}
