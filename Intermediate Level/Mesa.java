/*
AUTOR:          Mario Ventura & Luis Miguel Vargas Durán
VÍDEO:          https://youtu.be/tnXSn2-Ue3E
ASIGNATURA:     Programación II
TRABAJO:        Práctica Final
FECHA:          2022
PROFESOR:       Juan Montes de Oca Durán
*/

package clases.practicafinal;

//Mesa del juego
public class Mesa {
    
    //-------< ATRIBUTOS >-------
    int filas,columnas;     //Filas y columnas del tablero/mesa
    Carta cartas[][];       //Matriz de objetos carta (por consola)
    boolean acabada;        //Para saber si la partida ha acabado
    
    //-------< MÉTODOS >---------
    //Constructores
    public Mesa() {
        
    }
    public Mesa(int f, int c) {
        filas = f;
        columnas = c;
        cartas = new Carta[f][c];
        acabada = false;
    }
    
    //Getters
    public int getFilas() {
        return filas;
    }
    public int getColumnas() {
        return columnas;
    }
    public boolean getEstado() {
        return acabada;
    }
    public Carta getCartaAt(int i, int j) {
        return cartas[i][j];
    }
    
    //Setters
    public void setFilas(int f) {
        filas = f;
    }
    public void setColumnas(int c) {
        columnas = c;
    }
    public void setEstado(boolean b) {
        acabada = b;
    }
    
    //toString
    public void imprimirMesa() {
        for(int i=0; i<filas; i++) {
            for(int j=0; j<columnas; j++) {
                if (cartas[i][j].getNum() == 0) {
                    System.out.print("[ ]");
                } else {
                    System.out.print(cartas[i][j].toString());
                }
            }
            System.out.println("");
        }
        System.out.println("\n\n\n");
    }
    
    //Inicializar mesa
    public void inicializar() {
        for(int i=0; i<filas; i++) {
            for(int j=0; j<columnas; j++) {
                cartas[i][j] = new Carta();
            }
        }
    }
    
    //Colocar cartas
    public void colocarCarta(Carta c, int fila, int columna) {
        //Se coloca la carta dada en la posicion indicada
        cartas[fila][columna] = c;
    }
    
    //Mirar si se puede colocar una carta, y si se puede, se coloca
    public boolean sePuedeColocar(Carta c) {
        /*
        Se recorre toda la mesa buscando la primera posición en la que
        se pueda colocar una carta. Si se encuentra una posición donde
        sea posible, se coloca la carta y se devuelve true indicando que se
        ha colocado una carta. De lo contrario, se devuelve false indicando
        que el jugador pasa turno.
        */
        
        //Numero y palo de la carta
        int numero = c.getNum();
        Palo palo = c.getPal();
        //Posicion de la carta en la mesa
        int posicionCarta = c.getPosicionMesa();
        
        //---COMPROBACIONES---
        for(int i=0; i<filas; i++) {
            for(int j=0; j<columnas; j++) {
                //El jugador tiene dos números 7
                if(c.getNum() == 7) {
                    colocarCarta(c,posicionCarta,6);
                    return true;
                }
                //Estamos en la carta (posicion+1)
                //P.e: Hay un 2 de clubs y nosotros tenemos un 3 de clubs: Se puede colocar 
                if((cartas[i][j].getPal()==palo) && (cartas[i][j].getNum()==(numero-1))) {
                    colocarCarta(c,posicionCarta,(numero-1));
                    return true;
                }
                
                //Estamos en la carta (posicion-1)
                //P.e: Hay un 7 de clubs y nosotros tenemos un 6 de clubs: Se puede colocar 
                if((cartas[i][j].getPal()==palo) && (cartas[i][j].getNum()==(numero+1))) {
                    colocarCarta(c,posicionCarta,numero-1);
                    return true;
                }
            }
        }
        
        
        //Si se llega hasta aqui, no se puede colocar la carta
        return false;
    }
    
    //Añadir una baraja a la mesa
    public void añadirBaraja(Baraja b) {
        int idx = 0;
        for(int i=0; i<b.NUMPALOS; i++) {
            for(int j=0; j<b.MAXCARTASPORPALO; j++) {
                cartas[i][j] = b.getCartaAt(idx);
                idx++;
            }
        }
    }
}