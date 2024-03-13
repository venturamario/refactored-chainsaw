package práctica.evaluable;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FicheroOut {

    private Paraula nomf;
    private FileWriter fw;
    private BufferedWriter bw;
    
    //CONSTRUCTOR
    public FicheroOut(Paraula nom) {
        nomf = nom;
        try {
            fw = new FileWriter(nomf.toString());
            bw = new BufferedWriter(fw);
        } catch (IOException e) {
            System.err.println("Excepcion creant l'arxiu " + nomf + ": " + e);
        }
    }
    
    //GRAVAR CONTENIDO 1
    public void gravar(char c) {
        char[] aux = new char[1];
        aux[0] = c;
        try {
            bw.write(aux);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    //GRAVAR CONTENIDO 2
    public void gravar(Paraula[] nums) {
        for (int i = 0; i < nums.length; i++) {
            try {
                bw.write(nums[i].toString());
                bw.newLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    //CERRAR
    public void close() {
        try {
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Excepcion tancant l'arxiu " + nomf + ": " + e);
        } finally {
            try {
                fw.close();
            } catch (Exception e2) {
                System.err.println("Excepcion tancant l'arxiu " + nomf + ": " + e2);
            }
        }
    }
    
}
