package práctica.pkg20;
import java.io.FileReader;
public class PRÁCTICA20 {

    public void VocalesFichero() {

        System.out.println("\n\t---ABRE UN FICHERO Y YO CONTARÉ LA CANTIDAD DE VOCALES QUE APARECEN---");
        System.out.println("\t---EL FICHERO CONTIENE EL TEXTO SIGUIENTE:---\n");

        FileReader input = null;
        try {
            input = new FileReader("entrada1.txt");
            int valor;
            int numvocales = 0;
            int numconsonantes = 0;
            int numletras = 0;
            long tiempo = System.currentTimeMillis();
            valor = input.read();
            while (valor != -1) {
                char c = (char) valor;
                System.out.print(c);
                numletras++;
                if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u')) {
                    numvocales++;
                }
                if ((c != 'a') && (c != 'e') && (c != 'i') && (c != 'o') && (c != 'u') && (c != ' ')) {
                    numconsonantes++;
                }

                valor = input.read();
            }

            System.out.println("\n\nLA LONGITUD DEL TEXTO ES DE: " + numletras + " CARÁCTERES. DE ESOS, TENEMOS QUE:");
            System.out.println("EL Nº DE VOCALES DEL FICHERO ES: " + numvocales);
            System.out.println("EL Nº DE CONSONANTES DEL FICHERO ES: " + numconsonantes);
            System.out.println("EL PROGRAMA HA TARDADO: " + ((System.currentTimeMillis() - tiempo) / 1000) + " ms");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new PRÁCTICA20().VocalesFichero();
    }
}
