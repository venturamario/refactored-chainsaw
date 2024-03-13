package práctica.evaluable;

public class Paraula {
    //CONSTANTES PÚBLICAS
    private final int TRAM = 10;
    public static final char blanc = ' ';
    
    // ATRIBUTOS
    public char[] lletres;
    public int llargaria;
    public int capaci = 20;

    //CONSTRUCTOR 1
    public Paraula() {
        lletres = new char[capaci];
        llargaria = 0;
    }

    //CONSTRUCTOR 2 (PARÁMETRO: ARRAY DE CHAR)
    public Paraula(char[] s) {
        capaci = s.length;
        lletres = new char[capaci];
        llargaria = 0;
        for (int i = 0; i < s.length; i++) {
            lletres[llargaria++] = s[i];
        }
    }
    
    //CONVERTIR OBJETO PALABRA A STRING
    @Override
    public String toString() {
        String msg = "";
        for (int idx = 0; idx < llargaria; idx++) {
            msg += lletres[idx];
        }
        return msg;
    }

    //OBTENER LONGITUD DE UNA PALABRA
    public int getLlarg() {
        return llargaria;
    }
    
}
