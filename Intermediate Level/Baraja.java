/*
AUTOR:          Mario Ventura & Luis Miguel Vargas Durán
VÍDEO:          https://youtu.be/tnXSn2-Ue3E
ASIGNATURA:     Programación II
TRABAJO:        Práctica Final
FECHA:          2022
PROFESOR:       Juan Montes de Oca Durán
*/

package clases.practicafinal;
import java.util.Random;

//CLASE BARAJA
class Baraja {

    //----------ATRIBUTOS----------
    public final int MAXCARTASPORPALO=13;                   //Cartas por palo
    public final int NUMPALOS = 4;                          //Numero de palos
    public final int MAXCARTAS=MAXCARTASPORPALO*NUMPALOS;   //Cartas por baraja
    private Carta baraja[];                                 //Baraja
    private int n;                                          //Entero auxiliar

    
    //----------MÉTODOS----------
    // Constructores
    public Baraja() {
        //Array vacio
        baraja = new Carta[MAXCARTAS];
    }
    //Inicializar la baraja creando cartas
    public void inicializar() {
        //Variables auxiliares
        int numero = 1;
        int palo = 1;
        //Inicializar array de cartas
        baraja = new Carta[MAXCARTAS];
        Palo p = null;
        
        //Dar valor a las cartas
        for (int i = 0; i < MAXCARTAS; i++) {
            if (palo == 1) {
                baraja[i] = new Carta(p.clubs, numero);
                numero++;
                //System.out.println(baraja[i].toString() + " ");
                //Pasar al siguente palo
                if (numero == 14) {
                    palo++;         //Siguiente palo
                    numero = 1;     //Reiniciar numero
                }
            } else if (palo == 2) {
                baraja[i] = new Carta(p.diamonds, numero);
                numero++;
                //Pasar al siguente palo
                if (numero == 14) {
                    palo++;         //Siguiente palo
                    numero = 1;     //Reiniciar numero
                }
            } else if (palo == 3) {
                baraja[i] = new Carta(p.hearts, numero);
                numero++;
                //Pasar al siguente palo
                if (numero == 14) {
                    palo++;         //Siguiente palo
                    numero = 1;     //Reiniciar numero
                }
            } else if (palo == 4) {
                baraja[i] = new Carta(p.spades, numero);
                numero++;
                if (numero == 14) {
                    i = MAXCARTAS;
                }
            }
        }
        //Nmero de cartas de la baraja
        n = MAXCARTAS;
    }
    //Imprimir la baraja por consola para debugging
    public void imprimirBaraja() {
        int idx = 0;
        //Iteración de toda la baraja
        for (int i = 0; i < MAXCARTAS; i++) {
            //Método toString() de la carta
            System.out.print(baraja[i].toString() + " ");
            idx++;
            //Para mostrar cada palo en una línea
            if (idx==13) {
                System.out.println("");
                idx = 0;
            }
        }
    }
    //Barajar las cartas
    public void mezclar() {
         //Barajar las cartas con la implementación
         //Durstenfeld del algoritmo de Fisher-Yates
        Random rnd = new Random();
        //Iteración 'downto' de las cartas para barajarlas todas
        for (int i = MAXCARTAS - 1; i > 0; i--) {
            int pos = rnd.nextInt(i + 1);
            Carta c = baraja[pos];
            baraja[pos] = baraja[i];
            baraja[i] = c;
        }
    }
    //Getters
    public int getNumCartes() {
        return n;
    }
    public Carta getCartaAt(int n) {
       return baraja[n]; 
    }
    public int getCartasPorPalo() {
        return MAXCARTASPORPALO;
    }
    public int getNumPalos() {
        return NUMPALOS;
    }
    //Setters
    public void setCartaAt(int indice,Carta c) {
        baraja[indice] = c;
    }
    
    /*
    ----------------------------------------------------------------------------
    */
    
    //Clase para crear excepciones personalizadas
    public static class barajaVacia extends Exception {
        //Constructor vacío
        public barajaVacia() {
            
        }
        //Constructor con string
        public barajaVacia(String e) {
            //Llamar a la clase madre de la que se hereda (clase Exception)
            //Pasandole el string recibido como parámetro
            super(e);
        }
    }
}
