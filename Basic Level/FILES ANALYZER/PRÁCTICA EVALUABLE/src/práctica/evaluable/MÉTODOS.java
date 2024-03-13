package práctica.evaluable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class MÉTODOS {
    
    //VARIABLES GLOBALES Y ENLACES CON LAS OTRAS CLASES
    Paraula par = new Paraula();
    LT tec = new LT();
    private final int CAPACIDAD = 35;          //CAPACIDAD MÁXIMA DE LETRAS POR PALABRA (ASEGURA QUE CABE CUALQUIER PALABRA CABE)
    public final int MAXIMO = 500;     //MÁXIMO DE PALABRAS EN EL TEXTO
    
    //MÉTODO PARA OBTENER "MAXIMO" DESDE OTRA CLASE
    public int GetMAXIMO(int a) {
        a = MAXIMO;
        return a;
    }
    
    //MÉTODO PARA LIMPIAR PANTALLA ANTES DE HACER OTRA FUNCIÓN DEL MENÚ PARA QUE QUEDE TODO MÁS LIMPIO
    private void LimpiarPantalla() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    //MÉTODO PARA AVISAR AL USUARIO DE QUE SE EXCEDE EL NÚMERO MÁXIMO DE PALABRAS
    public void Error() {
        System.out.println("\t><><><><><><><><><><><>________ERROR________<><><><><><><><><><><><");
        System.out.println("\t---EL FICHERO EXCEDE EL MAXIMO DE PALABRAS. NO SE PUEDE PROCESAR---\n\n\n");
    }

    //PRESENTACIÓN DEL FICHERO
    private void PresentacionFichero() {
        System.out.println("\n\t-------------------------------------------------------------------------");
        System.out.println("\t-----------------EL FICHERO CONTIENE EL SIGUIENTE TEXTO:-----------------");
        System.out.println("\t-------------------------------------------------------------------------\n");
    }
    
    //PEDIR PALABRA PARA BUSCAR
    private void PedirPalabra() {
        System.out.println("\t--------------------------------------------------------------------------");
        System.out.println("\t-----------------------¿QUE PALABRA DESEAS BUSCAR?------------------------");
        System.out.println("\t--------------------------------------------------------------------------\n\n");
    }
    
    //PRESENTACIÓN DEL MENÚ
    public void PresentacionMenu() {
        System.out.println("\t-------------------------------------------------------------------------");
        System.out.println("\t--------------------¿QUE DESEAS HACER CON EL FICHERO?--------------------");
        System.out.println("\t--------------- ESCRIBE EL NÚMERO DE LA ORDEN A REALIZAR ----------------");
        System.out.println("\t-------------------------------------------------------------------------\n");
    }
    
    //USUARIO ESCOGE QUE FICHERO LEER (DEBE ACABAR EN .TXT)
    public void PedirNombre() {
        System.out.println("\t--------------------------------------------------------------------------");
        System.out.println("\t-------INTRODUCE EL NOMBRE DEL FICHERO A LEER (DEBE ACABAR EN .TXT)-------");
        System.out.println("\t----------------------------EJEMPLO: TEXTO.TXT----------------------------");
        System.out.println("\t--------------------------------------------------------------------------\n");
        System.out.print("\tNOMBRE DEL FICHERO ---------->  ");
    }
    
    //DECLARAR UNA VARIABLE CONSTANT ENTERA QUE REPRESENTA EL FINAL DE UNA LÍNEA
    private static final char SALTOLINEA = '\n';
    
    /*MÉTODO BOOLEAN QUE DEVUELVE TRUE AL IDENTIFICAR ALGUNO DE LOS SEPARADORES
    DE PALABRAS MÁS COMUNES*/
    private boolean Separador(char c) {
        return ((c == ' ') || (c == ',') || (c == '.') || (c == ';') || (c == ':')
             || (c == '-') || (c == '_') || (c == '@') || (c == '#') || (c == '?')
             || (c == '¿') || (c == '!') || (c == '¡') || (c == '+') || (c == '/')
                ||(c == SALTOLINEA));
    }
    
    //MÉTODO QUE DETECTA SI EL CARACTER LEÍDO ES UNA VOCAL
    private boolean EsVocal(char c) {
        return ((c=='a')||(c=='e')||(c=='i')||(c=='o')||(c=='u')||(c=='A')||(c=='E')||(c=='I')||(c=='O')||(c=='U')||
                (c=='á')||(c=='é')||(c=='í')||(c=='ó')||(c=='ú')||(c=='à')||(c=='è')||(c=='ì')||(c=='ò')||(c=='ù')||
                (c=='Á')||(c=='É')||(c=='Í')||(c=='Ó')||(c=='Ú')||(c=='À')||(c=='È')||(c=='Ì')||(c=='Ò')||(c=='Ù')||
                (c=='ä')||(c=='ë')||(c=='ï')||(c=='ö')||(c=='ü')||(c=='Ä')||(c=='Ë')||(c=='Ï')||(c=='Ö')||(c=='Ü'));
    }
    
    //MÉTODO PARA CONTAR SIGNOS DE PUNTUACIÓN
    private boolean SignoPuntuacion(char c) {
        boolean EsSigno = false;
        char signos[] = "¡!¿?,;.:-_´`'".toCharArray();
        for (int i = 0; i < signos.length; i++) {
            if (c == signos[i]) {
                EsSigno = true;
            }
        }
        return EsSigno;
    }
    
    //MÉTODO PARA CONTAR LETRAS CON DIERESI
    private boolean TieneDieresi(char c) {
        boolean tiene = false;
        char signos[] = "äëïöüÄËÏÖÜ".toCharArray();
        for (int i = 0; i < signos.length; i++) {
            if (c == signos[i]) {
                tiene = true;
            }
        }
        return tiene; 
    }
    
    //MÉTODO QUE DETECTA SI EL CARACTER LEÍDO TIENE ACENTO
    private boolean Acento(char c) {
        return ((c=='á')||(c=='é')||(c=='í')||(c=='ó')||(c=='ú')||(c=='à')||(c=='è')||(c=='ì')||(c=='ò')||(c=='ù')||
                (c=='Á')||(c=='É')||(c=='Í')||(c=='Ó')||(c=='Ú')||(c=='À')||(c=='È')||(c=='Ì')||(c=='Ò')||(c=='Ù'));
    }
    
    //MÉTODO BOOLEAN PARA COMPARAR DOS ARRAYS DE CARACTERES
    private boolean SonIgualesArray(char[] a, char[] b) {
        int x = 0;
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == b[i]) {
                    x++;
                }
            }
            if (x == a.length) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    //MÉTODO PARA DETECTAR SI UN CARACTER ESTÁ EN MAYÚSCULA
    private boolean EsMayuscula(char c) {
        boolean encontrado = false;
        char alfabetoMayus[] = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();
        for (int i = 0; i < alfabetoMayus.length; i++) {
            if (c==alfabetoMayus[i]) {
                encontrado = true;
            }
        }
        return encontrado;
    }
    
    //MÉTODO PARA SABER SI SE HA ENCONTRADO ALGÚN NÚMERO
    private boolean EsNumero(char c) {
        boolean encontrado = false;
        char Numeros[] = "0123456789".toCharArray();
        for (int i = 0; i < Numeros.length; i++) {
            if (c==Numeros[i]) {
                encontrado = true;
            }
        }
        return encontrado;
    }
    
    //MÉTODO PARA VER SI UNA PALABRA TIENE MÁS DE 5 VOCALES
    private boolean Tiene5Vocales(char s[]) {
        boolean encontrado = false;
        int contador = 0;
        for (int x = 0; x < s.length; x++) {
            if (EsVocal(s[x])==true) {
                contador++;
            }
        }
        if (contador >= 5) {
            encontrado = true;
        }
        return encontrado;
    }
    
    //MÉTODO PARA DETECTAR SI EL BUFFERED READER HA ENCONTRADO UN CARACTER
    int numcaracteres = 0;
    private int EsCaracter(char c) {
        char[] alfabeto = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890.,:@?!()<>".toCharArray();
        int idx = 0;
        while ((idx < alfabeto.length) && (c != alfabeto[idx])) {
            idx++;
        }
        if (idx < alfabeto.length) {
            numcaracteres++;
        }
        return numcaracteres;
    }
    
    //MÉTODO BOOLEAN QUE DETECTA SI EL CARACTER LEIDO ES LETRA O NÚMERO
    private boolean EsLetra(char c) {
        boolean Caracter = false;
        char[] alfabeto = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890".toCharArray();
        int idx = 0;
        while ((idx < alfabeto.length) && (c != alfabeto[idx])) {
            idx++;
        }
        if (idx < alfabeto.length) {
            Caracter = true;
        }
        return Caracter;
    }
    
    Paraula NomFic = null;        
    
    //MÉTODO PARA OBTENER DEL USUARIO EL NOMBRE DEL FICHERO A LEER
    public Paraula NombreFichero() {
        LT tec = new LT();
        File fil = null;
        PedirNombre();
        while (fil == null) {
            NomFic = new Paraula(tec.llegirLiniaA());
            
            if (NomFic != null) {
               fil = new File(NomFic.toString());
               if (!fil.exists()) {
               System.out.println("\n\tERROR: FICHERO INEXISTENTE O NO ENCONTRADO");
               System.out.print("\tNOMBRE DEL FICHERO ---------->  ");
               fil = null;
               } 
            } else {
               System.out.println("\n\tERROR: FICHERO INEXISTENTE O NO ENCONTRADO\n\n");
               System.out.print("\tNOMBRE DEL FICHERO ---------->  ");
               fil = null;
            }
        }
        return NomFic;
    }
    
    //MÉTODO PARA OBTENER EL NOMBRE DEL FICHERO DESDE OTRA CLASE
    public Paraula GetNomFic(Paraula a) {
        a = NomFic;
        return a;
    }
        
    //PRESENTACIÓN DEL MÉTODO DE DECODIFICACIÓN
    private void PresentacionDecodificar() {
        System.out.println("\t--------------------------------------------------------------------------");
        System.out.println("\t------------EL TEXTO DECODIFICADO SE GUARDARÁ EN EL FICHERO---------------");
        System.out.println("\t---------DONDE ANTERIORMENTE SE HA LLEVADO A CABO LA CODIFICACION---------");
        System.out.println("\t----EL TEXTO DEL FICHERO Codificado.txt DEBE SER IGUAL A " +NomFic+ "-----");
        System.out.println("\t--------------------------------------------------------------------------");
    }
    
    //MIRAR SI SE EXCEDE EL NUMERO DE PALABRAS
        int PALABRAS = 0;
        public void ExecedeMaximo(Paraula nom) {
        FileReader input = null;
        try {
            String currentDir = new File(".").getAbsolutePath();
            input = new FileReader(nom.toString());
            BufferedReader reader = new BufferedReader(input);
            int valor;
            valor = reader.read();   
            //VARIABLES PARA CONTAR PALABRAS
            char letrap = ' ';
            char letra;
            while (valor != -1) {
                char c = (char) valor;
                letra = c;
                 if (letra!=SALTOLINEA) {
                    if ((EsLetra(letrap) == false) && (EsLetra(letra) == true)) {
                        PALABRAS++;
                    }
                } 
                letrap = letra;
                valor = reader.read();
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
        
    //MÉTODO PARA OBTENER EL NUMERO DE PALABRAS DESDE OTRA CLASE    
    public int GetNumpalabras(int a) {
    a = PALABRAS;
    return a;
    }
        
    //LEER FICHERO ESCOGIDO POR USUARIO USANDO BUFFEREDREADER
    public void LeerFicheroYMas (String NomFic) {
        FileReader input = null;
        try {
            String currentDir = new File(".").getAbsolutePath();

            //ABRIR FICHERO
            PresentacionFichero();
            input = new FileReader(NomFic);
            BufferedReader reader = new BufferedReader(input);
            int valor;
            valor = reader.read();
            
            //DECLARAR VARIABLES QUE SE USARÁN POSTERIORMENTE
            int numCaracteres = 0, numLineas = 1;
            
            //PROCESAR EL FICHERO USANDO Separador(); Y EsCaracter(); y EsLetra();
            while (valor != -1) {
                char c = (char) valor;
                System.out.print(c);

                //------CONTAR CARACTERES---------------
                EsCaracter(c);

                //------CONTAR LÍNEAS-------------------
                if (c == SALTOLINEA) {
                    numLineas++;
                }

                //------PALABRAS YA CONTADAS CON ANTERIORIDAD--------
                valor = reader.read();
            }    
        //IMPRIMIR DATOS FINALES
        System.out.println("\n\n\t1) EL FICHERO CONTIENE UN TOTAL DE " +numcaracteres+ " CARACTERES,");
        System.out.println("\t2) EL FICHERO CONTIENE UN TOTAL DE " +PALABRAS+ " PALABRAS.");
        System.out.println("\t3) EL FICHERO CONTIENE UN TOTAL DE " +numLineas+ " LÍNEAS DE TEXTO\n\n");
        
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
    
    //MÉTODO QUE MUESTRA LAS OPCIONES QUE TIENE EL MENÚ DEL PROGRAMA
    private void OpcionesMenu() {
        System.out.println("\tNOMBRE DEL FICHERO CON EL QUE SE ESTÁ TRABAJANDO: " +NomFic);
        //RECORDAR LA SEMILLA UNA VEZ SE HAYA ESTABLECIDO
        if ((res != null) && (res > -1) && (res <= 10000)) {
        System.out.println("\tSEMILLA DE CODIFICACIÓN: " +res);
        }
        System.out.println("\n\n\t1)\t VISUALIZAR LA LETRA MÁS REPETIDA A LO LARGO DEL FICHERO");
        System.out.println("\t2)\t VISUALIZAR LAS APARICIONES DE CADA LETRA A LO LARGO DEL FICHERO");
        System.out.println("\t3)\t VISUALIZAR LA PALABRA QUE MÁS VECES APARECE EN EL FICHERO");
        System.out.println("\t4)\t BUSCAR UNA PALABRA EN EL FICHERO");
        System.out.println("\t5)\t BUSCAR UN TEXTO EN EL FICHERO");
        System.out.println("\t6)\t BUSCAR TODAS LAS PALABRAS QUE APARECEN REPETIDAS (DE FORMA CONSECUTIVA)");
        System.out.println("\t7)\t CODIFICAR FICHERO DE TEXTO");
        System.out.println("\t8)\t ESTABLECER UNA SEMILLA DE CODIFICACIÓN DEL FICHERO");
        System.out.println("\t9)\t VER OTRA INFORMACIÓN (INFORMACIÓN EXTRA SOBRE EL FICHERO)");
        System.out.println("\n\t PARA SALIR DEL MENÚ, ESCRIBE '0' Y PULSA ENTER\n");
        System.out.print("\tNÚMERO DE LA ORDEN A REALIZAR ---------->  ");
    }
        
    //----------------------------------MENÚ------------------------------------
    public void Menu(String nom) {
        LT tec = new LT();
        MÉTODOS m = new MÉTODOS();
        Paraula par = new Paraula();
        PresentacionMenu();
        OpcionesMenu();
        Integer Salir = 0;
        Integer op1 = 1;
        Integer op2 = 2;
        Integer op3 = 3;
        Integer op4 = 4;
        Integer op5 = 5;
        Integer op6 = 6;
        Integer op7 = 7;
        Integer op8 = 8;
        Integer op9 = 9;
        Integer usuario = tec.llegirSencer();
        //CONTEMPLAR LA POSIBILIDAD DE QUE EL USUARIO SE EQUIVOQUE
        while ((usuario != op1) && (usuario != op2) && (usuario != op3) && (usuario != op4) && (usuario != op5) && (usuario != op6) && (usuario != op7)
                && (usuario != op8) && (usuario != op9) && (usuario != Salir)) {
            System.out.println("\t----------------------ESA NO ES UNA OPCIÓN VÁLIDA----------------------");
            System.out.print("\tINTRODUCE UNA DE LAS OPCIONES O PULSA '0' PARA SALIR ---------> ");
            usuario = tec.llegirSencer();
        }
        while (usuario != Salir) {
            if (usuario == op1) {
                LetraMasRepetida(nom);
                System.out.println("\t\n\nDESEAS HACER ALGO MÁS?\n\n");
                OpcionesMenu();
                usuario = tec.llegirSencer();
                while ((usuario != op1) && (usuario != op2) && (usuario != op3) && (usuario != op4) && (usuario != op5) && (usuario != op6) && (usuario != op7)
                        && (usuario != op8) && (usuario != op9) && (usuario != Salir)) {
                    System.out.println("\t----------------------ESA NO ES UNA OPCIÓN VÁLIDA----------------------");
            System.out.print("\tINTRODUCE UNA DE LAS OPCIONES O PULSA '0' PARA SALIR ---------> ");
                    usuario = tec.llegirSencer();
                }
            } else if (usuario == op2) {
                AparicionesLetra(nom);
                System.out.println("\t\n\nDESEAS HACER ALGO MÁS?\n\n");
                OpcionesMenu();
                usuario = tec.llegirSencer();
                while ((usuario != op1) && (usuario != op2) && (usuario != op3) && (usuario != op4) && (usuario != op5) && (usuario != op6) && (usuario != op7)
                        && (usuario != op8) && (usuario != op9) && (usuario != Salir)) {
                    System.out.println("\t----------------------ESA NO ES UNA OPCIÓN VÁLIDA----------------------");
            System.out.print("\tINTRODUCE UNA DE LAS OPCIONES O PULSA '0' PARA SALIR ---------> ");
                    usuario = tec.llegirSencer();
                }
            } else if (usuario == op3) {
                PalabraMasRepetida(nom);
                System.out.println("\t\n\nDESEAS HACER ALGO MÁS?\n\n");
                OpcionesMenu();
                usuario = tec.llegirSencer();
                while ((usuario != op1) && (usuario != op2) && (usuario != op3) && (usuario != op4) && (usuario != op5) && (usuario != op6) && (usuario != op7)
                        && (usuario != op8) && (usuario != op9) && (usuario != Salir)) {
                    System.out.println("\t----------------------ESA NO ES UNA OPCIÓN VÁLIDA----------------------");
            System.out.print("\tINTRODUCE UNA DE LAS OPCIONES O PULSA '0' PARA SALIR ---------> ");
                    usuario = tec.llegirSencer();
                }
            } else if (usuario == op4) {
                BuscarPalabra(nom);
                System.out.println("\t\n\nDESEAS HACER ALGO MÁS?\n\n");
                OpcionesMenu();
                usuario = tec.llegirSencer();
                while ((usuario != op1) && (usuario != op2) && (usuario != op3) && (usuario != op4) && (usuario != op5) && (usuario != op6) && (usuario != op7)
                        && (usuario != op8) && (usuario != op9) && (usuario != Salir)) {
                    System.out.println("\t----------------------ESA NO ES UNA OPCIÓN VÁLIDA----------------------");
            System.out.print("\tINTRODUCE UNA DE LAS OPCIONES O PULSA '0' PARA SALIR ---------> ");
                    usuario = tec.llegirSencer();
                }
            } else if (usuario == op5) {
                BuscarTexto(nom);
                System.out.println("\t\n\nDESEAS HACER ALGO MÁS?\n\n");
                OpcionesMenu();
                usuario = tec.llegirSencer();
                while ((usuario != op1) && (usuario != op2) && (usuario != op3) && (usuario != op4) && (usuario != op5) && (usuario != op6) && (usuario != op7)
                        && (usuario != op8) && (usuario != op9) && (usuario != Salir)) {
                    System.out.println("\t----------------------ESA NO ES UNA OPCIÓN VÁLIDA----------------------");
            System.out.print("\tINTRODUCE UNA DE LAS OPCIONES O PULSA '0' PARA SALIR ---------> ");
                    usuario = tec.llegirSencer();
                }
            } else if (usuario == op6) {
                PalabrasRepetidas(nom);
                System.out.println("\t\n\nDESEAS HACER ALGO MÁS?\n\n");
                OpcionesMenu();
                usuario = tec.llegirSencer();
                while ((usuario != op1) && (usuario != op2) && (usuario != op3) && (usuario != op4) && (usuario != op5) && (usuario != op6) && (usuario != op7)
                        && (usuario != op8) && (usuario != op9) && (usuario != Salir)) {
                    System.out.println("\t----------------------ESA NO ES UNA OPCIÓN VÁLIDA----------------------");
            System.out.print("\tINTRODUCE UNA DE LAS OPCIONES O PULSA '0' PARA SALIR ---------> ");
                    usuario = tec.llegirSencer();
                }
            } else if (usuario == op7) {
                Codificar(nom, res);
                System.out.println("\t\n\nDESEAS HACER ALGO MÁS?\n\n");
                OpcionesMenu();
                usuario = tec.llegirSencer();
                while ((usuario != op1) && (usuario != op2) && (usuario != op3) && (usuario != op4) && (usuario != op5) && (usuario != op6) && (usuario != op7)
                        && (usuario != op8) && (usuario != op9) && (usuario != Salir)) {
                    System.out.println("\t----------------------ESA NO ES UNA OPCIÓN VÁLIDA----------------------");
            System.out.print("\tINTRODUCE UNA DE LAS OPCIONES O PULSA '0' PARA SALIR ---------> ");
                    usuario = tec.llegirSencer();
                }
            } else if (usuario == op8) {
                CogerSemilla();
                System.out.println("\t\n\nDESEAS HACER ALGO MÁS?\n\n");
                OpcionesMenu();
                usuario = tec.llegirSencer();
                while ((usuario != op1) && (usuario != op2) && (usuario != op3) && (usuario != op4) && (usuario != op5) && (usuario != op6) && (usuario != op7)
                        && (usuario != op8) && (usuario != op9) && (usuario != Salir)) {
                    System.out.println("\t----------------------ESA NO ES UNA OPCIÓN VÁLIDA----------------------");
            System.out.print("\tINTRODUCE UNA DE LAS OPCIONES O PULSA '0' PARA SALIR ---------> ");
                    usuario = tec.llegirSencer();
                }
            } else if (usuario == op9) {
                Otros(nom);
                System.out.println("\t\n\nDESEAS HACER ALGO MÁS?\n\n");
                OpcionesMenu();
                usuario = tec.llegirSencer();
                while ((usuario != op1) && (usuario != op2) && (usuario != op3) && (usuario != op4) && (usuario != op5) && (usuario != op6) && (usuario != op7)
                        && (usuario != op8) && (usuario != op9) && (usuario != Salir)) {
                    System.out.println("\t----------------------ESA NO ES UNA OPCIÓN VÁLIDA----------------------");
            System.out.print("\tINTRODUCE UNA DE LAS OPCIONES O PULSA '0' PARA SALIR ---------> ");
                    usuario = tec.llegirSencer();
                }
            }
        }
        if (usuario == Salir) {
            LimpiarPantalla();
            System.out.println("\t------------------------ADIÓS------------------------\n\n\n\n\n");
        }
    }
    
    
    //---------------------MIRAR LA LETRA MÁS REPETIDA--------------------------
    private void LetraMasRepetida(String NomFic) {
        FileReader input = null;
        try {
        String currentDir = new File(".").getAbsolutePath();
        System.out.println("");

        //ABRIR FICHERO
        input = new FileReader(NomFic);
        BufferedReader reader = new BufferedReader(input);
        int valor;
        valor = reader.read();
        char alfabeto[] = "abcdefghijklmnñopqrstuvwxyz".toCharArray();
        int frecuencias[] = new int[alfabeto.length];
        while (valor != -1) {
            char c = (char) valor;

            //-----------------PROCESO-----------------//
            //CONTAR APARICIONES Y ANOTARLAS EN EL ARRAY FRECUENCIAS[]
            int idx = 0;
            if (c == alfabeto[idx]) {
                frecuencias[idx]++;
            } else {
                while ((idx < alfabeto.length)&&(c != alfabeto[idx])) {
                    idx++;
                }
                if (idx<alfabeto.length) {frecuencias[idx]++;}
            }
          valor = reader.read();
        }
        //MOSTRAR RESULTADOS
        System.out.println("\tAL LEER EL FICHERO, SE HA OBTENIDO QUE: \n\n");
        int mayor = frecuencias[0];
        int posicion = 0;
        for (int i=1; i<frecuencias.length; i++) {
            if (frecuencias[i]>mayor) {
                mayor = frecuencias[i];
                posicion = i;
            }
        }
        System.out.println("\tLA LETRA MÁS REPETIDA ES LA LETRA '" +alfabeto[posicion]+ "'");
        System.out.println("\tQUE SE REPITE UN TOTAL DE " +mayor+ " VECES");
        
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
    
    //---------------------Nº APARICIONES CADA CARACTER-------------------------
    private void AparicionesLetra(String NomFic) {
    FileReader input = null;
    try {
        //SE BUSCARÁ EL FICHERO EN LA SIGUIENTE UBICACIÓN:
        String currentDir = new File(".").getAbsolutePath();
        System.out.println("");
        
        //ABRIR FICHERO
        input = new FileReader(NomFic);
        BufferedReader reader = new BufferedReader(input);
        int valor;
        valor = reader.read();

        //PROCESO DE LEER CARACTER A CARACTER:
        char alfabeto[] = "abcdefghijklmnñopqrstuvwxyz".toCharArray();
        int frecuencias[] = new int[alfabeto.length];
        while (valor != -1) {
            char c = (char) valor;
            //-----------------PROCESO-----------------//
            //CONTAR APARICIONES
            int idx = 0;
            if (c == alfabeto[idx]) {
                frecuencias[idx]++;
            } else {
                while ((idx < alfabeto.length)&&(c != alfabeto[idx])) {
                    idx++;
                }
                if (idx<alfabeto.length) {frecuencias[idx]++;}
            } 
            valor = reader.read();
        }
        //MOSTRAR RESULTADOS
        System.out.println("\tAL LEER EL FICHERO, SE HA OBTENIDO QUE: \n\n");
        int i = 0;
        while (i < alfabeto.length) {
            System.out.println("\tEL Nº DE VECES QUE APARECE EL CARACTER '" + alfabeto[i] + "' ES DE " + frecuencias[i]);
            i++;
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
    
    //-------------------------PALABRA MÁS REPETIDA-----------------------------
    private void PalabraMasRepetida(String NomFic) {
        FileReader input = null;
        try {
            String currentDir = new File(".").getAbsolutePath();
            System.out.println("");
            input = new FileReader(NomFic);
            BufferedReader reader = new BufferedReader(input);
            int valor;
            valor = reader.read();

            //ARRAYS DE CAPACIDAD 35 LETRAS, PARA ASEGURARNOS DE QUE CABE TODO TIPO DE PALABRA
            char letras1[] = new char[CAPACIDAD];
            char letras3[] = new char[CAPACIDAD];

            //ARRAY DE CARACTERES CUYO TAMAÑO SE DEFINIRÁ LUEGO
            char letras2[];
            char letras4[];

            //ARRAY QUE ALMACENA LA FRECUENCIA DE APARICIÓN DE CADA PALABRA
            int frecuencias[] = new int[MAXIMO];

            //VARIABLES AUXULIARES
            int idx = 0;
            int indice = 0;
            int posicion = 0;
            int frec = 0;

            //LEER EL FICHERO Y HACER EL PROCESO
            while (valor != -1) {
                char c = (char) valor;

                //IR ALMACENANDO LETRAS HASTA QUE SE ACABE DE LEER UNA PALABRA
                if (Separador(c) == false) {
                    letras1[idx] = c;
                    idx++;
                } else {

                    //CREAR ARRAY LETRAS2 CON EL TAMAÑO JUSTO
                    /*SI SE DETECTA UN SEPARADOR, Y MÁS CONCRETAMENTE UN SALTO DE LINEA, EL COMPORTAMIENTO ES DIFERENTE Y SIEMPRE
                    SE ACABA AÑADIENDO UNA CASILLA DE MÁS A letras1 DEBIDO A QUE EL SALTO DE LÍNEA NO ES EN SÍ UN CARÁCTER, SI NO UNA ESPECIE
                    DE "CÓDIGO" QUE SE PUEDE TRANSOFRMAR/ENTENDER COMO CARACTER Y QUE INDICA CUANDO HAY UN SALTO DE LÍNEA. LA COMPLEJIDAD DE TODO ESTO HACE
                    QUE CUANDO UNA LÍNEA NO ACABA EN PUNTO, COMA, ETC... LA ÚLTIMA PALABRA SE GUARDE CON UNA CASILLA DE MÁS EN EL ARRAY 
                    (SE PUEDE COMPROBAR CON EL DebugRunner DEL PROPIO NETBEANS), Y ESTO HACE QUE AL COMPARAR ARRAYS, AL NO TENER LA MISMA LONGITUD,
                    EL MÉTODO DETECTE QUE NO SON DOS ARRAYS IGUALES Y POR TANTO NO SON DOS PALABRAS IGUALES. POR ESTO, PARA QUE EL PROGRAMA PUEDA
                    LEER CORRECTAMENTE Y TRATAR LAS PALABRAS QUE ESTÁN A FINAL DE LÍNEA TENIENDO EN CUENTA LA POSIBILIDAD DE QUE ESTA NO ACABE EN
                    PUNTO; COMO SE SABE QUE SE AÑADE UNA CASILLA DE MÁS, SE HARÁ QUE EL ARRAY letras2 TENGA UN TAMAÑO DE idx-1 SOLO EN CASO DE QUE
                    SE LA ÚLTIMA PALABRA DE LA LÍNEA*/
                    if (c == SALTOLINEA) {
                        letras2 = new char[idx - 1];
                    } else {
                        letras2 = new char[idx];
                    }

                    //COPIAR CONTENIDO DE letras1 EN letras2
                    for (int i = 0; i < letras2.length; i++) {
                        letras2[i] = letras1[i];
                    }

                    //------YA TENEMOS LA PALABRA LEÍDA Y ALMACENADA, PROCEDEMOS A COMPARARLA CON EL RESTO DE PALABRAS DEL FICHERO------
                    //LEER FICHERO ENTERO PARA COMPARARLO CON LA PALABRA ALMACENADA EN letras2
                    FileReader input2 = null;
                    input2 = new FileReader(NomFic);
                    BufferedReader reader2 = new BufferedReader(input2);
                    int valor2;
                    valor2 = reader2.read();
                    while (valor2 != -1) {
                        char s = (char) valor2;
                        if (Separador(s) == false) {
                            letras3[indice] = s;
                            indice++;
                        } else {
                            if (s == SALTOLINEA) {
                                letras4 = new char[indice - 1];
                            } else {
                                letras4 = new char[indice];
                            }
                            for (int z = 0; z < letras4.length; z++) {
                                letras4[z] = letras3[z];
                            }
                            if (SonIgualesArray(letras2, letras4) == true) {
                                frec++;
                            }
                            indice = 0;
                        }
                        valor2 = reader2.read();
                    }
                    //RECUPERAR ÚLTIMA PALABRA QUE SE PIERDE SI valor2 == -1
                    if (valor2 == -1) {
                        letras4 = new char[indice];
                        for (int z = 0; z < letras4.length; z++) {
                            letras4[z] = letras3[z];
                        }
                        if (SonIgualesArray(letras2, letras4) == true) {
                            frec++;
                        }
                    }

                    //AHORA YA SABEMOS CUANTAS VECES APARECE LA PALABRA letras2, ASIQUE ALMACENAMOS ESA FRECUENCIA EN EL ARRAY DE FRECUENCIAS
                    frecuencias[posicion] = frec;

                    //REINICIAR EL VALOR DE LA VARIABLE frec PARA VOLVER A EMPEZAR A CONTAR
                    posicion++;
                    frec = 0;
                    idx = 0;
                }
                valor = reader.read();
            }

            //RECUPERAR LA ÚLTIMA PALABRA, QUE SE PIERDE CUANDO valor == -1
            if (valor == -1) {
                letras2 = new char[idx];
                for (int i = 0; i < letras2.length; i++) {
                    letras2[i] = letras1[i];
                }

                //LEER FICHERO ENTERO PARA COMPARARLO CON LA PALABRA ALMACENADA EN letras2
                FileReader input2 = null;
                input2 = new FileReader(NomFic);
                BufferedReader reader2 = new BufferedReader(input2);
                int valor2;
                valor2 = reader.read();
                while (valor2 != -1) {
                    char s = (char) valor2;
                    if (Separador(s) == false) {
                        letras3[indice] = s;
                        indice++;
                    } else {
                        if (s == SALTOLINEA) {
                            letras4 = new char[indice - 1];
                        } else {
                            letras4 = new char[indice];
                        }
                        for (int z = 0; z < letras4.length; z++) {
                            letras4[z] = letras3[z];
                        }
                        if (SonIgualesArray(letras2, letras4) == true) {
                            frec++;
                        }
                        indice = 0;
                    }
                    valor2 = reader2.read();
                }
                //RECUPERAR ÚLTIMA PALABRA QUE SE PIERDE SI valor2 == -1
                if (valor2 == -1) {
                    letras4 = new char[indice];
                    for (int z = 0; z < letras4.length; z++) {
                        letras4[z] = letras3[z];
                    }
                    if (SonIgualesArray(letras2, letras4) == true) {
                        frec++;
                    }
                }

                //AHORA YA SABEMOS CUANTAS VECES APARECE LA PALABRA letras2, ASIQUE ALMACENAMOS ESA FRECUENCIA EN EL ARRAY DE FRECUENCIAS
                frecuencias[posicion] = frec;

                //REINICIAR EL VALOR DE LA VARIABLE frec PARA VOLVER A EMPEZAR A CONTAR
                posicion++;
                frec = 0;
            }

            //AHORA YA SABEMOS CUANTAS VECES APARECE CADA PALABRA, POR TANTO PROCEDEMOS COMPARAR PARA VER CUÁL APARECE MÁS
            int mayor = frecuencias[0];
            int pos = 0;
            for (int i = 1; i < frecuencias.length; i++) {
                if (frecuencias[i] > mayor) {
                    mayor = frecuencias[i];
                    pos = i;
                }
            }
            
            //LA VARIABLE MAYOR TIENE ALMACENADO LA FRECUENCIA DE APARICIÓN DE LA PALABRA QUE MÁS APARECE. MOSTREMOS CUÁL ES
            System.out.println("\t------------------LA PALABRA/PALABRAS MÁS REPETIDA/REPETIDAS EN EL TEXTO SON------------------\n\n");
            FileReader input3 = null;
            input3 = new FileReader(NomFic);
            BufferedReader reader3 = new BufferedReader(input3);
            int valor3;
            valor3 = reader3.read();

            //NUEVOS ARRAYS DE CARACTERES Y VARIABLES VARIAS
            char letras5[] = new char[CAPACIDAD];
            char letras6[];
            int ind = 0;
            int lugar = 0;

            //LEER FICHERO UNA VEZ MÁS PARA PODER MOSTRAR LA PALABRA EN CONCRETO, YA QUE NO SE PUEDEN ALMACENAR PALABRAS
            while (valor3 != -1) {
                char r = (char) valor3;
                if (Separador(r) == false) {
                    letras5[ind] = r;
                    ind++;
                } else {
                    if (r == SALTOLINEA) {
                        letras6 = new char[ind - 1];
                    } else {
                        letras6 = new char[ind];
                    }
                    for (int i = 0; i < letras6.length; i++) {
                        letras6[i] = letras5[i];
                    }

                    //SI LA PALABRA TIENE UNA FRECUENCIA DE APARICION == A "mayor", MOSTRARLA TAMBIÉN
                    if ((frecuencias[lugar] == mayor) && (letras6.length >= 1 /*ES DECIR, QUE letras6 NO ESTÁ VACÍO*/)) {
                        System.out.print("\tLA PALABRA \t'");
                        for (int x = 0; x < letras6.length; x++) {
                            System.out.print(letras6[x]);
                        }
                        System.out.print("' \tAPARECE UN TOTAL DE " + frecuencias[lugar] + " VECES A LO LARGO DEL FICHERO\n");
                    }

                    //VARIABLE "lugar" CRECE SIEMPRE Y LA VARIABLE ind VUELVE A SER 0 PARA REPETIR EL PROCESO
                    lugar++;
                    ind = 0;
                }
                valor3 = reader3.read();
            }
            //RECUPERAR PALABRA QUE SE PIERDE SI valor3 == -1
            if (valor3 == -1) {
                letras6 = new char[ind];
                for (int i = 0; i < letras6.length; i++) {
                    letras6[i] = letras5[i];
                }
                //SI LA PALABRA TIENE UNA FRECUENCIA DE APARICION == A "mayor", MOSTRARLA TAMBIÉN
                if (frecuencias[lugar] == mayor) {
                    System.out.print("\tLA PALABRA '");
                    for (int x = 0; x < letras6.length; x++) {
                        System.out.print(letras6[x]);
                    }
                    System.out.print("' APARECE UN TOTAL DE " + frecuencias[lugar] + " VECES A LO LARGO DEL FICHERO\n");
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
    
    //---------------------BUSCAR UNA PALABRA EN EL TEXTO-----------------------
    private void BuscarPalabra(String NomFic) {
        FileReader input = null;
        try {
        String currentDir = new File(".").getAbsolutePath();
        System.out.println("");
        
        //ABRIR FICHERO
        input = new FileReader(NomFic);
        BufferedReader reader = new BufferedReader(input);
        int valor;
        valor = reader.read();
        //ARRAY DE CAPACIDAD 35 LETRAS, PARA ASEGURARNOS DE QUE CABE TODO TIPO DE PALABRA
        char letras1[] = new char[CAPACIDAD];
        int idx = 0;
        int posicion = 0;
        int columna = 1;
        int linea = 1;
        int columnas[] = new int[MAXIMO];    //TAMAÑO QUE ASEGURA CASI AL 100% QUE NO FALTARÁ ESPACIO
        int lineas[] = new int [MAXIMO];     //TAMAÑO QUE ASEGURA CASI AL 100% QUE NO FALTARÁ ESPACIO
        //LEER LA PALABRA QUE EL USUARIO QUIERE BUSCAR
        PedirPalabra();
        System.out.print("\tESCRIBE UNA PALABRA A BUSCAR ----------> ");
        char Usuario[] = tec.llegirLiniaA();
        //EN REALIDAD SE LEE UN ARRAY, Y SE USA EL MÉTODO DE COMPARACIÓN DE ARRAYS PARA BUSCAR LA PALABRA A MEDIDA QUE SE LEE
        
        //VARIABLE QUE NOS PERMITIRÁ SABER SI NO SE HA ENCONTRADO LA PALABRA EN EL FICHERO
        int NoEncontrado = 0;
        
        //CADA VEZ QUE SE TERMINE DE LEER UNA PALABRA, SE ALMACENA COMO ARRAY Y SE COMPARA CON LA INTRODUCIDA POR EL USUARIO
        while (valor != -1) {
            char c = (char) valor;
            if ((Separador(c) == false) && (c != SALTOLINEA)) {
                letras1[idx] = c;
                idx++;
                columna++;
            } else {
                //CREAR ARRAY DE LETRAS DEL TAMAÑO JUSTO
                char letras2[];
                if (c == SALTOLINEA) {
                    /*SI SE DETECTA UN SEPARADOR, Y MÁS CONCRETAMENTE UN SALTO DE LINEA, EL COMPORTAMIENTO ES DIFERENTE Y SIEMPRE
                    SE ACABA AÑADIENDO UNA CASILLA DE MÁS A letras1 DEBIDO A QUE EL SALTO DE LÍNEA NO ES EN SÍ UN CARÁCTER, SI NO UNA ESPECIE
                    DE "CÓDIGO" QUE SE PUEDE TRANSOFRMAR/ENTENDER COMO CARACTER Y QUE INDICA CUANDO HAY UN SALTO DE LÍNEA. LA COMPLEJIDAD DE TODO ESTO HACE
                    QUE CUANDO UNA LÍNEA NO ACABA EN PUNTO, COMA, ETC... LA ÚLTIMA PALABRA SE GUARDE CON UNA CASILLA DE MÁS EN EL ARRAY 
                    (SE PUEDE COMPROBAR CON EL DebugRunner DEL PROPIO NETBEANS), Y ESTO HACE QUE AL COMPARAR ARRAYS, AL NO TENER LA MISMA LONGITUD,
                    EL MÉTODO DETECTE QUE NO SON DOS ARRAYS IGUALES Y POR TANTO NO SON DOS PALABRAS IGUALES. POR ESTO, PARA QUE EL PROGRAMA PUEDA
                    LEER CORRECTAMENTE Y TRATAR LAS PALABRAS QUE ESTÁN A FINAL DE LÍNEA TENIENDO EN CUENTA LA POSIBILIDAD DE QUE ESTA NO ACABE EN
                    PUNTO; COMO SE SABE QUE SE AÑADE UNA CASILLA DE MÁS, SE HARÁ QUE EL ARRAY letras2 TENGA UN TAMAÑO DE idx-1 SOLO EN CASO DE QUE
                    SE LA ÚLTIMA PALABRA DE LA LÍNEA*/
                    letras2 = new char[idx-1];
                    columnas[posicion] = columna-1;  //AL AÑADIRSE UNA CASILLA DE MÁS, SE CUENTA UNA COLUMNA MÁS DE LAS NECESARIAS
                } else {
                    letras2 = new char[idx];
                    columnas[posicion] = columna;
                }
                //COPIAR ARRAY LETRAS1 EN LETRAS2 CON EL TAMAÑO JUSTO
                for(int i=0; i<letras2.length; i++) {
                letras2[i]=letras1[i];
                }
                
                lineas[posicion] = linea;
                //SI LO QUE EL USUARIO BUSCA ES IGUAL A LA PALBRA LEÍDA, SE MUESTRA SU POSICIÓN
                if (SonIgualesArray(letras2, Usuario) == true) {
                    System.out.println("\tSE HA ENCONTRADO LA PALABRA EN LA LÍNEA \t" +lineas[posicion]+ "\t Y EN LA COLUMNA " +columnas[posicion]);
                    NoEncontrado++;
                }
                //REINICIAR VARIABLES
                if (c == SALTOLINEA) {
                    columna = 0; //COMO HAY UN SALTO DE LÍNEA, LAS COLUMNAS VUELVEN A EMPEZAR
                    linea++;
                }
                columna++;
                posicion++;
                idx=0;
            }
            valor = reader.read();
        }
        /*SI EL VALOR == -1, SALE DEL WHILE Y LO ÚLTIMO QUE SE HABIA GUARDADO SE PIERDE,
        POR TANTO SE PIERDE LA ULTIMA PALABRA. POR ESO SE HACE LO SIGUIENTE:   */
            if (valor == -1) {
                char letras2[] = new char[idx];
                for (int i = 0; i < letras2.length; i++) {
                    letras2[i] = letras1[i];
                }
                columnas[posicion] = columna;
                lineas[posicion] = linea;
                if (SonIgualesArray(letras2, Usuario) == true) {
                    NoEncontrado++;
                    System.out.println("\tSE HA ENCONTRADO LA PALABRA EN LA LÍNEA \t" +lineas[posicion]+ "\t Y EN LA COLUMNA " +columnas[posicion]);
                }
            }
            //SI NO SE HA ENCONTRADO LA PALABRA EN EL FICHERO, DECIRSELO AL USUARIO
            if (NoEncontrado == 0) {
                System.out.println("\tNO SE HA ENCONTRADO LA PALABRA EN EL FICHERO\n\n\n");
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
    
    //------------------BUSCAR Y LOCALIZAR PALABRAS REPETIDAS-------------------
    private void PalabrasRepetidas(String NomFic) {
        FileReader input = null;
        try {
            String currentDir = new File(".").getAbsolutePath();
            System.out.println("");

            //ABRIR FICHERO
            input = new FileReader(NomFic);
            BufferedReader reader = new BufferedReader(input);
            int valor;
            valor = reader.read();
            //ARRAY DE CAPACIDAD 35 LETRAS, PARA ASEGURARNOS DE QUE CABE TODO TIPO DE PALABRA
            char letras1[] = new char[CAPACIDAD];
            char letras3[] = new char[CAPACIDAD];  //ARRAY QUE USAREMOS POSTERIORMENTE
            int idx = 0;
            
            //VARIABLES PARA CONTABILIZAR LAS LÍNEAS Y LAS COLUMNAS
            int posicion = 0;
            int columna = 0;
            int linea = 1;
            int columnas[] = new int[MAXIMO];    //TAMAÑO QUE ASEGURA CASI AL 100% QUE NO FALTARÁ ESPACIO
            int lineas[] = new int[MAXIMO];      //TAMAÑO QUE ASEGURA CASI AL 100% QUE NO FALTARÁ ESPACIO
            
            //VARIABLE QUE NOS PERMITIRÁ SABER SI NO SE HA ENCONTRADO EL TEXTO EN EL FICHERO
            int NoEncontrado = 0;
            
            //CADA VEZ QUE SE TERMINE DE LEER UNA PALABRA, SE ALMACENA COMO ARRAY Y SE COMPARA CON LA INTRODUCIDA POR EL USUARIO
            while (valor != -1) {
                char c = (char) valor;
                if ((Separador(c) == false) && (c != SALTOLINEA)) {
                    letras1[idx] = c;
                    idx++;
                    columna++;
                } else {
                    //CREAR ARRAY DE LETRAS DEL TAMAÑO JUSTO
                    char letras2[];
                    if (c == SALTOLINEA) {
                        /*SI SE DETECTA UN SEPARADOR, Y MÁS CONCRETAMENTE UN SALTO DE LINEA, EL COMPORTAMIENTO ES DIFERENTE Y SIEMPRE
                    SE ACABA AÑADIENDO UNA CASILLA DE MÁS A letras1 DEBIDO A QUE EL SALTO DE LÍNEA NO ES EN SÍ UN CARÁCTER, SI NO UNA ESPECIE
                    DE "CÓDIGO" QUE SE PUEDE TRANSOFRMAR/ENTENDER COMO CARACTER Y QUE INDICA CUANDO HAY UN SALTO DE LÍNEA. LA COMPLEJIDAD DE TODO ESTO HACE
                    QUE CUANDO UNA LÍNEA NO ACABA EN PUNTO, COMA, ETC... LA ÚLTIMA PALABRA SE GUARDE CON UNA CASILLA DE MÁS EN EL ARRAY 
                    (SE PUEDE COMPROBAR CON EL DebugRunner DEL PROPIO NETBEANS), Y ESTO HACE QUE AL COMPARAR ARRAYS, AL NO TENER LA MISMA LONGITUD,
                    EL MÉTODO DETECTE QUE NO SON DOS ARRAYS IGUALES Y POR TANTO NO SON DOS PALABRAS IGUALES. POR ESTO, PARA QUE EL PROGRAMA PUEDA
                    LEER CORRECTAMENTE Y TRATAR LAS PALABRAS QUE ESTÁN A FINAL DE LÍNEA TENIENDO EN CUENTA LA POSIBILIDAD DE QUE ESTA NO ACABE EN
                    PUNTO; COMO SE SABE QUE SE AÑADE UNA CASILLA DE MÁS, SE HARÁ QUE EL ARRAY letras2 TENGA UN TAMAÑO DE idx-1 SOLO EN CASO DE QUE
                    SE LA ÚLTIMA PALABRA DE LA LÍNEA*/
                        letras2 = new char[idx - 1];
                        columnas[posicion] = columna - 1;  //AL AÑADIRSE UNA CASILLA DE MÁS, SE CUENTA UNA COLUMNA MÁS DE LAS NECESARIAS
                    } else {
                        letras2 = new char[idx];
                        columnas[posicion] = columna;
                    }
                    //COPIAR ARRAY LETRAS1 EN LETRAS2 CON EL TAMAÑO JUSTO
                    for (int i = 0; i < letras2.length; i++) {
                        letras2[i] = letras1[i];
                    }
                    //---------------USAR ESTRUCTURA "letrap == letra" PERO CON ARRAYS PARA COMPROBAR SI SE REPITEN----------------
                    //COMPROBAR SI SON LA MISMA PALABRA CON EL MÉTODO SonIgualesArray(char[] a, char[] b) Y MOSTRARLO
                    lineas[posicion] = linea; 
                    if (SonIgualesArray(letras3,letras2)==true) {
                        System.out.print("\tSE HA ENCONTRADO LA PALABRA '");
                        for (int y = 0; y < letras3.length; y++) {
                            System.out.print(letras3[y]);
                        }
                        System.out.print("' REPETIDA EN LA LÍNEA \t" +lineas[posicion]+ "\t COLUMNA \t" +columnas[posicion]+ "\n");
                        NoEncontrado++;
                    }
                    //ARRAY letras3 CON EL MISMO CONTENIDO QUE letras2
                    letras3 = new char[letras2.length];
                    //COPIAR CONTENIDO DEL ARRAY letras2 EN letras3
                    for (int i = 0; i < letras3.length; i++) {
                        letras3[i] = letras2[i];
                    }
                    
                    //REINICIAR VARIABLES
                    if (c == SALTOLINEA) {
                        columna = 0; //COMO HAY UN SALTO DE LÍNEA, LAS COLUMNAS VUELVEN A EMPEZAR
                        linea++;
                    }
                    columna++;
                    posicion++;
                    idx = 0;
                }
                valor = reader.read();
            }
            /*SI EL VALOR == -1, SALE DEL WHILE Y LO ÚLTIMO QUE SE HABIA GUARDADO SE PIERDE,
        POR TANTO SE PIERDE LA ULTIMA PALABRA. POR ESO SE HACE LO SIGUIENTE:   */
            if (valor == -1) {
                char letras2[] = new char[idx];
                for (int i = 0; i < letras2.length; i++) {
                    letras2[i] = letras1[i];
                }
                columnas[posicion] = columna;
                lineas[posicion] = linea;
                //COMPROBAR SI ES IGUAL A LA PALABRA ANTERIOR
                if (SonIgualesArray(letras3, letras2) == true) {
                    System.out.print("\tSE HA ENCONTRADO LA PALABRA '");
                    for (int y = 0; y < letras3.length; y++) {
                        System.out.print(letras3[y]);
                    }
                    System.out.print("' REPETIDA EN LA LÍNEA \t" + lineas[posicion] + "\t COLUMNA \t" + columnas[posicion] + "\n\n\n");
                    NoEncontrado++;
                }
            }
            if (NoEncontrado == 0) {
                System.out.println("NO HAY PALABRAS REPETIDAS EN EL FICHERO DE TEXTO '"+NomFic+ "'");
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
    
    //-----------------BUSCAR UN "TEXTO" DENTRO DEL FICHERO---------------------    
    private void BuscarTexto(String NomFic) {
        FileReader input = null;
        try {
        String currentDir = new File(".").getAbsolutePath();
        System.out.println("");
        System.out.println("\t-----------------------------------------------------------------");
        System.out.println("\t--------------INTRODUCE EL TEXTO QUE QUIERAS BUSCAR--------------");
        System.out.println("\t-----------------------------------------------------------------\n\n");
        //LEER EN FORMA DE ARRAY DE CARACTERES LO QUE EL USUARIO INTRODUCE PARA BUSCAR
        System.out.print("\tESCRIBE UN TEXTO A BUSCAR ----------> ");
        char usuario[] = tec.llegirLiniaA();
        input = new FileReader(NomFic);
        BufferedReader reader = new BufferedReader(input);
        int valor;
        valor = reader.read();
        
        //VARIABLE QUE NOS PERMITIRÁ AVANZAR EN LA COMPROBACIÓN
        int encontrado = 0;
        
        //VARIABLE QUE NOS PERMITIRÁ SABER SI NO SE HA ENCONTRADO EL TEXTO EN EL FICHERO
        int NoEncontrado = 0;
        
        //VARIABLES PARA CONTABILIZAR LÍNEAS Y COLUMNAS
        int linea = 1;
        int columna = 1;
        int lineas[] = new int [MAXIMO];     //TAMAÑO QUE ASEGURA CASI AL 100% QUE NO FALTARÁ ESPACIO
        int columnas[] = new int[MAXIMO];    //TAMAÑO QUE ASEGURA CASI AL 100% QUE NO FALTARÁ ESPACIO
        //LEER CARACTER A CARACTER Y COMPROBAR SI LO QUE SE LEE COINCIDE CON LO QUE HA INTRODUCIDO EL USUARIO
            while (valor != -1) {
                char c = (char) valor;
                if (c == SALTOLINEA) {
                    //INDICAR EL CAMBIO DE LINEA Y REINICIAR EL CONTADOR DE LA COLUMNA
                    linea++;
                    columna = 1;
                }
                /*SI LA LETRA LEÍDA COINCIDE, LA PRÓXIMA VEZ SE COMPROBARÁ LA SIGUIENTE LETRA, Y ASÍ SUCESIVAMENTE HASTA QUE
                encontrado == usuario.length, QUE QUERRÁ DECIR QUE SE HA ENCONTRADO EL TEXTO*/
                if (c == usuario[encontrado]) {
                    encontrado++;
                } else {
                    encontrado = 0;
                }
                //REGISTRAR Y ALMACENAR POSICIÓN (LÍNEA Y COLUMNA)
                columnas[encontrado] = columna;
                lineas[encontrado] = linea;
                columna++;
                
                //MOSTRAR UBICACIÓN DEL TEXTO EN CASO DE QUE SE HAYA ENCONTRADO
                if (encontrado == usuario.length) {
                    System.out.println("\tSE HA ENCONTRADO EL TEXTO EN LA LÍNEA \t" +lineas[encontrado]+ "\t COLUMNA \t" +columnas[encontrado]);
                    //REINICIAR VARIABLE PARA PODER SEGUIR BUSCANDO EL TEXTO
                    encontrado = 0;
                    //AUMENTAR EL VALOR PARA HACER SABER AL PROGRAMA QUE SE HA ENCONTRADO EL TEXTO Y QUE ESTE NO DIGA LO CONTRARIO
                    NoEncontrado++;
                }
                valor = reader.read();
            }
        //SI NO SE HA ENCONTRADO EL TEXTO, SE DEBE INFORMAR AL USUARIO
        if (NoEncontrado == 0) {
            System.out.println("\tNO SE HA ENCONTRADO EL TEXTO EN EL FICHERO");
        } 
        System.out.println("\n\n");
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
      
    //-----------------ESTABLECER "SEMILLA" DE CODIFICACIÓN---------------------
    Integer res = -1;
    //MÉTODO PARA SABER SI LA VARIABLE res ES UN NÚMERO
    private boolean EsNumero(int a) {
        boolean EsNumero = false;
        if ((a<0)||(a>=0)) {
            EsNumero = true;
        }
        return EsNumero;
    }
    
    private int CogerSemilla() {
        LT tec = new LT();
        System.out.println("\n\n\t-------------------------------------------------------------------");
        System.out.println("\t-----INTRODUCE UNA SEMILLA DE CODIFICACIÓN (Nº ENTRE 0 Y 9999)-----");
        System.out.println("\t--------ESTA SEMILLA GENERARÁ UNA CODIFICACIÓN EN CONCRETO---------");
        System.out.println("\t-------------------------------------------------------------------\n");
        System.out.print("\tSEMILLA ---------->  ");
        res = tec.llegirSencer();
        while ((res == null) || (res <= -1) || (res > 10000) || (EsNumero(res) == false)) {
            System.out.println("\tESA NO ES UNA OPCIÓN VÁLIDA");
            System.out.print("\tSEMILLA ---------->  ");
            res = tec.llegirSencer();
        }
        return res;
    }
    
    //------------------------CODIFICAR EL FICHERO------------------------------ 
    private void Codificar(String Nomfic, int semilla) {
        FileReader input = null;
        try {
            String currentDir = new File(".").getAbsolutePath();
            System.out.println("");
            input = new FileReader(Nomfic);
            BufferedReader reader = new BufferedReader(input);
            int valor;
            valor = reader.read();
            
            //SI EL USUARIO SE HA OLVIDADO DE INTRODUCIR LA SEMILLA, SE LA PEDIREMOS:
            if (res == -1) {
                CogerSemilla();
                semilla = res;
            }
            
            //CREAR SEMILLA Y PALABRA FICHERO
            System.out.println("\n\tEL RESULTADO DE LA CODIFICACIÓN SE PODRÁ VER EN EL FICHERO 'Codificado.txt'\n\n\n");
            Random ran = new Random(semilla);

            //ARRAYS "ORIGINAL" Y "CODIFICADO"
            char original[] = "abcdefghijklmnopqrstuvwxyzçñ.,:@?!()<>".toCharArray();
            char codificado[] = new char[original.length];
            //HACER QUE EL ARRAY CODIFICADO NO TENGA VALORES
            for (int i = 0; i < original.length; i++) {  // això és per esborrarlo
                codificado[i] = 0;
            }
            //ARRAY DE CODIFICACIÓN SEGÚN EL VALOR DE LA SEMILLA
            for (int i = 0; i < original.length; i++) {
                int ind = ran.nextInt(original.length);
                while (codificado[ind] != 0) {
                    ind = ran.nextInt(original.length);
                }
                codificado[ind] = original[i];
            }
            //ARRAY DE TAMAÑO GRANDE PARA CONTENER TODO EL TEXTO
            char LetrasGrande[] = new char[9999];
            int idx = 0;

            //-------PROCESO DE CODIFICACIÓN       
            while (valor != -1) {
                char c = (char) valor;
                LetrasGrande[idx] = c;
                idx++;

                valor = reader.read();
            }
            //ADAPTAR TAMAÑO DEL ARRAY
            char letras[] = new char[idx];
            for (int i = 0; i < letras.length; i++) {
                letras[i] = LetrasGrande[i];
            }

            //CODIFICAR ARRAY "LETRAS"
            FicheroIn fi = new FicheroIn(NomFic);
            fi.ProcesarArchivo(original, codificado);
            
            //PREGUNTAR AL USUARIO QUE HACER A CONTINUACIÓN
            System.out.println("\tSI QUIERES SEGUIR TRABAJANDO CON EL FICHERO CODIFICADO ESCRIBE '1' Y PULSA ENTER");
            System.out.println("\tSI QUIERES DECODIFICAR EL FICHERO ANTES DE TRABAJAR CON ÉL, ESCRIBE '2' Y PULSA ENTER");
             System.out.print("\tINTRODUCE UNA DE LAS DOS OPCIONES -----------> ");
            Integer Trabajar = 1;
            Integer Dec = 2;
            Integer usuario = tec.llegirSencer();
            while ((usuario != Dec) && (usuario != Trabajar)) {
                System.out.println("\tESA NO ES UNA OPCIÓN VÁLIDA");
                System.out.print("\tINTRODUCE UNA DE LAS DOS OPCIONES -----------> ");
                usuario = tec.llegirSencer();
            }
            
            if (usuario == 1) {
                
                //CAMBIAR EL ARCHIVO CON EL QUE SE TRABAJA
                char s[] = "Codificado.txt".toCharArray();
                NomFic = new Paraula(s);
                
            } else if (usuario == 2) {
                
                Decodificar(Nomfic, res);
                //CAMBIAR EL ARCHIVO CON EL QUE SE TRABAJA
                char s[] = "Codificado.txt".toCharArray();
                NomFic = new Paraula(s);
                
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
    
    //-------------------DECODIFICAR EL TEXTO CODIFICADO------------------------ 
    private void Decodificar(String Nomfic, int semilla) {
        System.out.println("\t-------------------¡DECODIFICACIÓN HECHA!--------------------\n\n");
        PresentacionDecodificar();
        FileReader input = null;
        try {
            String currentDir = new File(".").getAbsolutePath();
            System.out.println("");
            input = new FileReader(Nomfic);
            BufferedReader reader = new BufferedReader(input);
            int valor;
            valor = reader.read();
            //ARRAYS "ORIGINAL" Y "CODIFICADO"
            char original[] = "abcdefghijklmnopqrstuvwxyzçñ.,:@?!()<>".toCharArray();
            char codificado[] = new char[original.length];

            //-------PROCESO DE DECODIFICACIÓN               
            FicheroIn fi = new FicheroIn(NomFic);
            fi.ProcesarArchivo(codificado, original);

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
    
    //-------------------INFORMACIÓN EXTRA DEL FICHERO--------------------------
    private void Otros(String NomFic) {
        FileReader input = null;
        try {
            String currentDir = new File(".").getAbsolutePath();
            input = new FileReader(NomFic);
            BufferedReader reader = new BufferedReader(input);
            int valor;
            valor = reader.read();
            
            //VARIABLES QUE USAREMOS PARA DAR INFORMACIÓN EXTRA
            int numVocales = 0, numLineas = 1; int numAcentos = 0;
            int numMayusculas = 0; int numeros = 0; int numLetras = 0;
            int contador = 0; int idx = 0; int posicion = 0;
            int dieresi = 0; int signos = 0;
            char letras1[] = new char[CAPACIDAD];
            char letras2[]; //ALMACENAR PALABRA
            int longitudes[] = new int[MAXIMO];    //ALMACENAR LONGITUD DE CADA PALABRA
            
            System.out.println("\n\n\t---------------------------INFORMACIÓN EXTRA SOBRE EL FICHERO---------------------------");
            
            while (valor != -1) {
                char c = (char) valor;
                //-----------------CONTAR VOCALES Y ACENTOS---------------------
                if (EsVocal(c) == true) {
                    numVocales++;
                }
                //-----------------CONTAR CONSONANTES---------------------------
                if (EsLetra(c) == true) {
                    numLetras++;
                }
                //-----------------CONTAR ACENTOS-------------------------------
                if (Acento(c) == true) {
                    numAcentos++;
                }
                //-----------------CONTAR MAYÚSCULAS----------------------------
                if (EsMayuscula(c) == true) {
                    numMayusculas++;
                }
                //-----------------CONTAR NÚMEROS------------------------------
                if (EsNumero(c) == true) {
                    numeros++;
                }
                //---------------CONTAR SIGNOS DE PUNTUACIÓN--------------------
                if (SignoPuntuacion(c) == true) {
                    signos++;
                }
                //------------------CONTAR LETRAS CON DIERESI-------------------
                if (TieneDieresi(c) == true) {
                    dieresi++;
                }
                //---------REGISTRAR LA LONGITUD DE CADA PALABRA---------------
                if (Separador(c) == false) {
                    letras1[idx] = c;
                    idx++;
                } else {
                    if (c == SALTOLINEA) {
                        letras2 = new char[idx - 1];
                    } else {
                        letras2 = new char[idx];
                    }
                    for (int i = 0; i < letras2.length; i++) {
                        letras2[i] = letras1[i];
                    }
                    
                    //---------------MIRAR SI TIENE 5 VOCALES-------------------
                    if (Tiene5Vocales(letras2) == true) {
                        contador++;
                    }
                    
                    //----VARIABLES PARA REGISTRAR LA LONGITUD DE LA PALABRA----
                    longitudes[posicion] = letras2.length;
                    posicion++;
                    idx = 0;
                }

                valor = reader.read();
            }
            //COMPARAR LONGITUDES DE TODAS LAS PALABRAS
            int mayor = longitudes[0];
            int pos = 0;
            for (int i = 1; i < longitudes.length; i++) {
                if (longitudes[i] > mayor) {
                    mayor = longitudes[i];
                    pos = i;
                }
            }
                
     //IMPRIMIR DATOS FINALES
     System.out.println("\n\n\t1) EL FICHERO CONTIENE UN TOTAL DE " +numLetras+ " LETRAS");
     System.out.println("\t2) DE ESAS LETRAS, " +numVocales+ " SON VOCALES Y " +(numLetras - numVocales)+ " SON CONSONANTES");
     System.out.println("\t3) DE ESAS VOCALES, HAY UN TOTAL DE " +numAcentos+ " VOCALES CON ACENTO");
     System.out.println("\t4) DE TODAS LAS LETRAS CONTENIDAS EN EL TEXTO, " +numMayusculas+ " SON MAYÚSCULAS Y " +(numLetras-numMayusculas)+ " SON MINÚSCULAS");
     System.out.println("\t5) DE TODOS LOS CARACTERES DEL TEXTO, " +numeros+ " SON NÚMEROS");
     System.out.println("\t6) ADEMÁS, HAY UN TOTAL DE " +contador+ " PALABRAS QUE CONTIENEN 5 O MÁS VOCALES");
     System.out.println("\t7) LA PALABRA MÁS LARGA DEL TEXTO TIENE UNA LONGITUD DE " +mayor+ " LETRAS");
     System.out.println("\t8) SE HA ENCONTRADO UN TOTAL DE " +dieresi+ " LETRAS CON DIÉRESIS");
     System.out.println("\t9) SE HA ENCONTRADO UN TOTAL DE " +signos+ " SIGNOS DE PUNTUACIÓN");
        
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
    
    /*
    AUTOR: Mario Ventura Burgos
    DNI 43223476J
    Grupo 03
    Profesor: Miquel Mascaró Portells
    Fecha: 15/02/2021
    */
    
}
