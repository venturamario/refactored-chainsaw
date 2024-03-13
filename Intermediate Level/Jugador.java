/*
AUTOR:          Mario Ventura & Luis Miguel Vargas Durán
VÍDEO:          https://youtu.be/tnXSn2-Ue3E
ASIGNATURA:     Programación II
TRABAJO:        Práctica Final
FECHA:          2022
PROFESOR:       Juan Montes de Oca Durán
*/

package clases.practicafinal;

public class Jugador {
    
    //-----------------ATRIBUTOS-----------------
    final int cartasPerPlayer = 13;     //Cartas al inicio de la partida
    String nombre;                      //Nombre del jugador
    int numCartas;                      //Numero de cartas del jugador
    Carta[] cartas;                     //Lista de cartas del jugador
    Carta cartaColocada;                //Carta colocada
    int posicionCarta = 0;              //para saber donde colocar la carta sobre la mesa
    boolean ganador;                    //Se pone a true si el jugador es el que gana
    
    
    //-----------------MÉTODOS-----------------
    //Constructores
    public Jugador() {
        nombre = " ";
        numCartas = 0;
        ganador = false;
        cartas = new Carta[cartasPerPlayer];
    }
    public Jugador(String s, int a) {
        nombre = s;
        numCartas = a;
        ganador = false;
        cartas = new Carta[cartasPerPlayer];
    }
    
    //Getters
    public String getNombre() {
        return nombre;
    }
    public int getNumCartas() {
        return numCartas;
    }
    public Carta getCartaAt(int index) {
        return cartas[index];
    }
    public void printCartas() {
        System.out.println("LAS CARTAS DE "+nombre+" SON:");
        for (int i=0; i<cartasPerPlayer; i++) {
            if(cartas[i].getPal()!=null) {
                System.out.print(cartas[i].toString() + " ");
            }
        }
        System.out.println("\nTOTAL ---> "+numCartas+" Cartas");
    }
    public boolean getGanador() {
        return ganador;
    }
    public int getPosicionCarta() {
        return posicionCarta;
    }
    public Carta getCartaColocada() {
        return cartaColocada;
    }
    
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNumCartas(int numCartas) {
        this.numCartas = numCartas;
    }
    public void setGanador(boolean b) {
        ganador = b;
    }
    public void setPosicionCarta(int id) {
        this.posicionCarta = posicionCarta;
    }
    public void setCartaAt(int idx, Carta c) {
        cartas[idx] = c;
    }
    
    //Método toString
    @Override
    public String toString() {
        String s = "";
        s = ("NOMBRE: "+nombre+", nº DE CARTAS: "+numCartas+", GANADOR: "+ganador);
        return s;
    }

    //Método para dar una carta a un jugador
    public void darCarta(Carta c) throws Baraja.barajaVacia {
        //MODIFICAR ATRIBUTO cartas[]
        for(int i=0; i<cartas.length; i++) {
            if(cartas[i] == null) {
                cartas[i] = c;
                i = cartas.length;
            }
        }
        
        //MODIFICAR ATRIBUTO numCartas
        numCartas++;
    }
    
    //---< MÉTODOS QUE SIMULAN UN TURNO >---
    //Método que simula un turno automático de la cpu
    public boolean turnoAutomatico(boolean primerTurno, Mesa m) {
        //SIMULA EL TURNO DE UN JUGADOR
        //RECIBE: Booleano que indica si es el primer turno, Mesa sobre la que se juega
        //DEVUELVE: True si tras el turno el jugador gana la partida
        
        ganador = false;
        boolean accion = false;
        
        //---< Primer Turno >---
        if (primerTurno == true) {
            //Buscar una carta con un 7
            for(int i=0; i<cartas.length; i++)  {
                if(cartas[i].getNum() == 7) {
                    //Colocar la carta en la mesa
                    posicionCarta = cartas[i].getPosicionMesa();
                    m.colocarCarta(cartas[i],posicionCarta,6);
                    System.out.println(nombre+" HA COLOCADO LA CARTA "+cartas[i].toString()+" EN LA MESA POSICION 6,"+posicionCarta);
                    numCartas--;
                    cartaColocada = cartas[i];
                    cartas[i] = new Carta();
                    i=cartas.length;
                    accion = true;
                }
            }
        //---< Otros Turnos >---
        } else {
            //Recorrer las cartas y comprobar si se pueden colocar
            for(int i=0; i<cartas.length; i++) {
                if (m.sePuedeColocar(cartas[i])) {
                    //Se ha colocado la carta
                    System.out.println(nombre+" HA COLOCADO LA CARTA "+cartas[i].toString());
                    numCartas--;
                    cartaColocada = cartas[i];
                    cartas[i] = new Carta();
                    i=cartas.length;
                    accion = true;
                }
            }
        }
        
        //Comprobar si el jugador es el ganador, es decir, si ya no tiene cartas
        if(numCartas == 0) {
            m.setEstado(true);  //El estado de la mesa se declara como acabada
            ganador = true;     //EL jugador pasa a ser el ganador
        }
        
        //Imprimir mesa tras el turno
        if (accion == false) {
            //El jugador no podia colocar carta y ha pasado turno
            System.out.println(nombre+" HA PASADO SU TURNO PORQUE NO PUEDE COLOCAR NINGUNA CARTA\n");
        } else {
            //El jugador colocó carta y el estado de la mesa ha cambiado
            m.imprimirMesa();
        }
        
        //Retorno
        return accion;
    }
    //Método que simula un turno manual del usuario
    public boolean turnoManual(boolean primerTurno, Mesa m, Carta c) {
        //SIMULA EL TURNO DE UN JUGADOR (típicamente, el usuario)
        //RECIBE: Booleano que indica si es el primer turno, Mesa sobre la que se juega, Carta que se quiere poner
        //DEVUELVE: True si tras el turno el jugador ha hecho un movimiento
        
        ganador = false;
        boolean accion = false;
        
        //---< Primer Turno >---
        if (primerTurno == true) {
            //Comprobar si la carta es un 7 de cualquier palo
            if (c.getNum() == 7) {
                //Colocar la carta en la mesa
                posicionCarta = c.getPosicionMesa();
                m.colocarCarta(c, posicionCarta, 6);
                System.out.println(nombre + " HA COLOCADO LA CARTA " + c.toString() + " EN LA MESA POSICION 6," + posicionCarta);
                numCartas--;
                cartaColocada = c;
                accion = true;
            }
            
        //---< Otros Turnos >---
        } else {
            //Recorrer las cartas y comprobar si se pueden colocar
                if (m.sePuedeColocar(c)) {
                    //Se ha colocado la carta
                    System.out.println(nombre+" HA COLOCADO LA CARTA "+c.toString());
                    numCartas--;
                    cartaColocada = c;
                    c = new Carta();
                    accion = true;
                }
        }
        
        //Comprobar si el jugador es el ganador, es decir, si ya no tiene cartas
        if(numCartas == 0) {
            m.setEstado(true);  //El estado de la mesa se declara como acabada
            ganador = true;     //EL jugador pasa a ser el ganador
        }
        
        //Imprimir mesa tras el turno
        if (accion == false) {
            //El jugador no podia colocar carta y ha pasado turno
            System.out.println(nombre+" HA PASADO SU TURNO PORQUE NO PUEDE COLOCAR NINGUNA CARTA\n");
        } else {
            //El jugador colocó carta y el estado de la mesa ha cambiado
            m.imprimirMesa();
        }
        
        //Retorno
        return accion;
    }
}
