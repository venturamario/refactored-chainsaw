package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ExamenP2 {
    
    LT tec = new LT(); //ENLACE CON LA CLASE LT
    
    //DECLARAR UNA VARIABLE CONSTANTE ENTERA QUE REPRESENTA EL FINAL DE UNA LÍNEA
    private static final char SALTOLINEA = '\n';
    
    /*MÉTODO BOOLEAN QUE DEVUELVE TRUE AL IDENTIFICAR ALGUNO DE LOS SEPARADORES
    DE PALABRAS MÁS COMUNES*/
    private boolean Separador(char c) {
        return ((c == ' ') || (c == ',') || (c == '.') || (c == ';') || (c == ':')
             || (c == '-') || (c == '_') || (c == '@') || (c == '#') || (c == '?')
             || (c == '¿') || (c == '!') || (c == '¡') || (c == '+') || (c == '/')
                ||(c == '\n')||(c == SALTOLINEA));
    }
    
    
    //--------------ENCONTRAR LAS PALABRAS QUE CONTIENEN 'CIL'------------------
    public void EncontrarCIL(String NomFic) {
        FileReader input = null;
        try {
        String currentDir = new File(".").getAbsolutePath();
        System.out.println("");

        //ABRIR FICHERO
        input = new FileReader(NomFic);
        BufferedReader reader = new BufferedReader(input);
        int valor;
        valor = reader.read();
        
        //VARIABLES QUE USAREMOS EN EL DESARROLLO DEL PROGRAMA
        char letras1[] = new char[35];
        char cil[] = "cil".toCharArray();
        int idx = 0;
        
        //LEER Y HACER PROCESO
        while (valor != -1) {
          char c = (char) valor;
          if ((Separador(c) == false) && (c != SALTOLINEA)) {
                letras1[idx] = c;
                idx++;
            } else {
                //CREAR ARRAY DE LETRAS DEL TAMAÑO JUSTO
                char letras2[];
                if (c == SALTOLINEA) {
                    /*SI SE DETECTA UN SALTO DE LÍNEA, SE AÑADE AL ARRAY letras1 UNA CASILLA MÁS DE LAS QUE TOCAN (SE PUEDE COMPROBAR
                    CON EL DEBUG RUNNER DE JAVA), POR TANTO, EL ARRAY letras2 TENDRÁ UNA CASILLA DE MÁS. POR ESO SUMAMOS O RESTAMOS UNO*/
                    letras2 = new char[idx-1];
                } else {
                    letras2 = new char[idx];
                }
                
                //COPIAR ARRAY LETRAS1 EN LETRAS2 CON EL TAMAÑO JUSTO
                for (int i = 0; i < letras2.length; i++) {
                  letras2[i] = letras1[i];
                }
                
                //COMPROBAR SI TIENE LA SECUENCIA 'cil'
                int contador = 0; int posicion = 0;
                for (int i = 0; i < letras2.length; i++) {
                    if (letras2[i] == cil[posicion]) {
                        posicion++;
                        contador++;
                    } else {
                        contador = 0;
                    }
                }
                
                //SI EN ALGÚN MOMENTO SE TIENE QUE contador == cil.length, LA PALABRA TIENE LA SECUENCIA 'cil'
                if (contador == cil.length) {
                    System.out.print("'");
                    for (int i = 0; i < letras2.length; i++) {
                        System.out.print(letras2[i]);
                    }
                    System.out.print("' ES UNA PALABRA CON LA SECUENCIA 'cil'\n");
                }
                //REINICIAR VARIABLES
                idx=0;
            }
          valor = reader.read();
        }
        //CUANDO valor == -1, SE PIERDE LA ÚLTIMA PALABRA, POR TANTO HAY QUE RECUPERARLA PARA ANALIZARLA
        if (valor == -1) {
                char letras2[] = new char[idx];
                for (int i = 0; i < letras2.length; i++) {
                    letras2[i] = letras1[i];
                }
                
                //COMPROBAR SI TIENE LA SECUENCIA 'cil'
                int contador = 0; int posicion = 0;
                for (int i = 0; i < cil.length; i++) {
                    if (letras2[i] == cil[posicion]) {
                        posicion++;
                        contador++;
                    } else {
                        contador = 0;
                    }
                }
                
                //SI EN ALGÚN MOMENTO SE TIENE QUE contador == cil.length, LA PALABRA TIENE LA SECUENCIA 'cil'
                if (contador == cil.length) {
                    System.out.print("'");
                    for (int i = 0; i < letras2.length; i++) {
                        System.out.print(letras2[i]);
                    }
                    System.out.print("' ES UNA PALABRA CON LA SECUENCIA 'cil'\n");
                }  
            }
        reader.close();
        input.close();
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
    
    
    //-----------------ENCONTRAR LAS PALABRAS CON UNA O TODAS LAS LETRAS MENOS UNA IGUALES---------------------
    public void EncontrarPalabras(String NomFic) {
        System.out.print("\n\tINTRODUCE LA PALABRA QUE DESEES: ");
        char usuario[] = tec.llegirLiniaA();
        //EJEMPLOS PARA PROBAR: 'cala', 'acaparo', etc...
        
        FileReader input = null;
        try {
        String currentDir = new File(".").getAbsolutePath();
        System.out.println("");

        //ABRIR FICHERO
        input = new FileReader(NomFic);
        BufferedReader reader = new BufferedReader(input);
        int valor;
        valor = reader.read();
        
        //VARIABLES QUE USAREMOS EN EL DESARROLLO DEL PROGRAMA
        char letras1[] = new char[35];
        int idx = 0;
        
        //LEER Y HACER PROCESO
        while (valor != -1) {
          char c = (char) valor;
          if ((Separador(c) == false) && (c != SALTOLINEA)) {
                letras1[idx] = c;
                idx++;
            } else {
              char letras2[];
                //CREAR ARRAY DE LETRAS DEL TAMAÑO JUSTO
                if (c == SALTOLINEA) {
                    /*SI SE DETECTA UN SALTO DE LÍNEA, SE AÑADE AL ARRAY letras1 UNA CASILLA MÁS DE LAS QUE TOCAN (SE PUEDE COMPROBAR
                    CON EL DEBUG RUNNER DE JAVA), POR TANTO, EL ARRAY letras2 TENDRÁ UNA CASILLA DE MÁS. POR ESO SUMAMOS O RESTAMOS UNO*/
                    letras2 = new char[idx-1];
                } else {
                    letras2 = new char[idx];
                }
                
                //COPIAR ARRAY LETRAS1 EN LETRAS2 CON EL TAMAÑO JUSTO
                for (int i = 0; i < letras2.length; i++) {
                  letras2[i] = letras1[i];
                }
                
                //REALIZAR LA COMPROBACIÓN DE SI TIENE TODOS LOS CARÁCTERES IGUALES MENOS UNO 
                //Entiendo que son palabras que son exactamente iguales excepto por una letra (solo se diferencian en una letra)
                int iguales = 0; int diferentes = 0;
                
                //Deben tener la misma longitud
                if (usuario.length == letras2.length) {
                    for(int i = 0; i < letras2.length; i++) {
                        if (usuario[i] == letras2[i]) {
                            iguales++;
                        } else {
                            diferentes++;
                        }
                    }
                }
                
                //SI SON IGUALES EXCEPTO POR UNA LETRA, iguales = usuario.length - 1 y diferentes = 1
                if ((iguales == (usuario.length - 1)) && (diferentes == 1)) {
                    System.out.print("'");
                    for (int i = 0; i < usuario.length; i++) {
                        System.out.print(letras2[i]);
                    }
                    System.out.print("' TIENE TODAS LAS LETRAS IGUALES MENOS UNA\n");
                }
                idx = 0;
            }
          valor = reader.read();
        }
        //CUANDO valor == -1, SE PIERDE LA ÚLTIMA PALABRA, POR TANTO HAY QUE RECUPERARLA PARA ANALIZARLA
            if (valor == -1) {
                char letras2[];
                letras2 = new char[idx];
                for (int i = 0; i < letras2.length; i++) {
                    letras2[i] = letras1[i];
                }

                //REALIZAR LA COMPROBACIÓN DE SI TIENE TODOS LOS CARÁCTERES IGUALES MENOS UNO 
                //Entiendo que son palabras que son exactamente iguales excepto por una letra (solo se diferencian en una letra)
                int iguales = 0;
                int diferentes = 0;

                //Deben tener la misma longitud
                if (usuario.length == letras2.length) {
                    for (int i = 0; i < letras2.length; i++) {
                        if (usuario[i] == letras2[i]) {
                            iguales++;
                        } else {
                            diferentes++;
                        }
                    }
                }

                //SI SON IGUALES EXCEPTO POR UNA LETRA, iguales = usuario.length - 1 y diferentes = 1
                if ((iguales == (usuario.length - 1)) && (diferentes == 1)) {
                    System.out.print("'");
                    for (int i = 0; i < usuario.length; i++) {
                        System.out.print(letras2[i]);
                    }
                    System.out.print("' TIENE TODAS LAS LETRAS IGUALES MENOS UNA\n");
                }
            }
        reader.close();
        input.close();
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
    
    
}
