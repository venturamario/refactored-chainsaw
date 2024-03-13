package ClasePassword;

public class Password {
    
    //---------------------------------ATRIBUTOS--------------------------------
    int Longitud = 8;
    String Contraseña;
    
    //----------------------------------MÉTODOS---------------------------------
    
    //Constructores
    public Password() {
        Longitud = 8;
        Contraseña = GenerarContraseña();
    }
    
    public Password(int longitud) {
        Longitud = longitud;
        Contraseña = GenerarContraseña();
    }
    
    //Método Set
    public void SetLongitud(int a) {
        Longitud = a;
    }
    
    //Métodos Get
    public int GetLongitud() {
        return Longitud;
    }
    
    public String GetContraseña() {
        return Contraseña;
    }
    
    
    //Generar Contraseña
    char contraseña2[];
    public String GenerarContraseña() {
        LT tec = new LT();
        System.out.println("\tINTRODUCE UNA CANTIDAD DE ENTRE 0 Y 10 NÚMEROS");
        char contraseña[] = tec.llegirLiniaA();
        contraseña2 = new char[contraseña.length + 1];
        Longitud = (contraseña2.length + 1);
        for (int i = 0; i < contraseña.length; i++) {
            contraseña2[i] = contraseña[i];
        }
        System.out.println("\tINTROODUCE UNA LETRA MAYÚSCULA O MINÚSCULA");
        char a = tec.llegirCaracter();
        contraseña2[contraseña.length + 1] = a;
        return contraseña2.toString();
    }
    
    //Método EsFuerte
    public boolean EsFuerte(char[] s) {
        s = contraseña2;
        char mayusculas[] = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();
        int fin = (contraseña2.length - 1);
        if (contraseña2.length > 8) {
            for (int i = 0; i < mayusculas.length; i++) {
                if (contraseña2[fin] == mayusculas[i]) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
