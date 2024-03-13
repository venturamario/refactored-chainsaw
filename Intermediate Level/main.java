/*
AUTOR:          Mario Ventura & Luis Miguel Vargas Durán
VÍDEO:          https://youtu.be/tnXSn2-Ue3E
ASIGNATURA:     Programación II
TRABAJO:        Práctica Final
FECHA:          2022
PROFESOR:       Juan Montes de Oca Durán
*/

package clases.practicafinal;

import clases.practicafinal.Baraja.barajaVacia;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//---> Desarrollo del juego del 7
public class main extends JFrame implements ActionListener {
    
    //---------------------ATRIBUTOS---------------------
    //---> Objetos y variables
    private Baraja baraja;                          //Baraja
    private Mesa mesa;                              //Mesa sobre la que se jugará
    private Jugador[] jugadoresCPU;                 //Jugadores de la partida
    private Jugador player;                         //Jugador
    private  int tirada = 1;                        //Contador de tiradas
    private final int numJugadoresCPU = 3;          //Nº de jugadores de la partida (CPU)
    private boolean cartasRepartidas = false;       //Para saber si las cartas se han repartido
    private boolean playerMovement = false;         //Para saber si el usuario ha hecho su movimiento
    private boolean mesaNueva = true;               //Para saber si crear una mesa nueva
    private boolean primerTurno = true;             //Para saber si es el primer turno
    private boolean reiniciar = false;              //Para saber si se ha reiniciado
    
    //---> Iconos ImageIcon de java
    private final ImageIcon cartaOculta = new ImageIcon("card_back_blue.png");
    private final ImageIcon imagen = new ImageIcon("verde.png");
    
    //---> Variables para crear gráficos
    //Ventana
    public JFrame ventana;                      //Ventana del programa
    //Parte superior de la zona de juego
    public JPanel panelMarcador;                //Panel que contiene el "marcador"
    public JLabel etiquetaCartasJug1;           //Contiene nº cartas Jugador 1
    public JLabel etiquetaCartasJug2;           //Contiene nº cartas Jugador 2
    public JLabel etiquetaCartasJug3;           //Contiene nº cartas Jugador 3
    public JPanel panelJugador1;                //Contiene la etiqueta del Jug.1
    public JPanel panelJugador2;                //Contiene la etiqueta del Jug.2
    public JPanel panelJugador3;                //Contiene la etiqueta del Jug.3
    //Centro de la zona de juego
    public JPanel panelMesa;                    //Panel donde se pondrán las cartas
    public JPanel panelJuego;                   //Panel donde se pone Marcador y Mesa
    //Inferior de la zona de juego
    public JPanel panelInferior;                //Panel inferior de la interfaz
    public JPanel panelCartasUsuario;           //Panel con las 13 cartas del usuario
    public JLabel etiquetaCartasUsuario;        //Etiqueta de cada carta del usuario
    public JLabel etiquetaInformacion;          //Etiqueta que muestra información
    public String stringInfo;                   //Información de la etiqueta anterior
    //Zona inferior de la ventana
    public JPanel panelInformacion;             //Panel informativo
    public JPanel panelBotones;                 //Panel con los botones de las cartas
    public JButton botones[];                   //Lista de botones (1 por carta)
    public JButton botonMezclar;                //Botón para mezclar la baraja
    public JButton botonJugar;                  //Botón para jugar un turno
    public JButton botonReiniciar;              //Botón para reiniciar la partida
    public JButton botonPasar;                  //Botón para pasar un turno (usuario)
    
    //---> Colores que usaremos a lo largo del programa
    public Color colorPoker = new Color(0,187,45);      //Verde claro de fondo
    public Color colorVerdeOscuro = new Color(0,127,15);//Verde oscuro
    public Color colorTurquesa = new Color(93,193,185); //Turquesa (para botón)
    //Laterales
    public JPanel panelEste;                    //Panel Este (para añadir margen)
    public JPanel panelOeste;                   //Panel Oeste (para añadir margen)
    
    //---> Array de nombre para los jugadores de la CPU
    static final String[] nombres = {"Enrique","Luismi","Arya","Sasha","Valentina","FelipToni"};
    
    
    
    //----------------------MÉTODOS----------------------
    //Método main que llama a principal()
    public static void main(String[] args) {
        new main().principal();
    }
    
    //---< MÉTODO PRINCIPAL >---
    //Método principal donde se invocan al resto de métodos
    private void principal() {
        //Uso del bloque try-catch para gestionar posibles excepciones
        try {
            //---> Crear e inicializar baraja
            baraja = new Baraja();
            baraja.inicializar();
            
            //---> Inicializar mesa
            mesa = new Mesa(4,13);          //Crear mesa
            mesa.inicializar();             //Inicializar mesa
            mesa.añadirBaraja(baraja);      //Añade la baraja en la mesa
            mesa.imprimirMesa();            //Imprimir (por consola)
            
            //---> Inicializar CPU y repartir Cartas
            inicializarCPU();
            player = new Jugador();
            
            //---> Crear interfaz gráfica de usuario
            botones = new JButton[13];
            graficos();
            
            //---> Gestión de eventos
            ActionEvent evento = null;
            evento.getSource();
            actionPerformed(evento);
            

        } catch (NumberFormatException e) {
            System.err.println("ERROR EN EL FORMATO DEL NÚMERO");
        } catch (Exception e) {
            
        }
    }
    
    //---< MÉTODO PARA CREAR UNA INTERFAZ GRÁFICA >---
    //Método que crea una interfaz gráfica
    private void graficos() {
        
        //-----> Instanciar variables gráficas
        if(reiniciar == false) {
            //Es la 1ª vez
            ventana = new JFrame("\tJuego del 7");
        }
        
        ventana.setLayout(new BorderLayout());
        //---Zona superior de la mesa---
        //Paneles 
        panelMarcador = new JPanel();
        panelMarcador.setLayout(new FlowLayout());
        panelMarcador.setBackground(colorPoker);
        panelJugador1 = new JPanel();
        panelJugador1.setBackground(colorVerdeOscuro);
        panelJugador1.setLayout(new BorderLayout());
        panelJugador2 = new JPanel();
        panelJugador2.setBackground(colorVerdeOscuro);
        panelJugador2.setLayout(new BorderLayout());
        panelJugador3 = new JPanel();
        panelJugador3.setBackground(colorVerdeOscuro);
        panelJugador3.setLayout(new BorderLayout());
        //Jugador 1
        etiquetaCartasJug1 = new JLabel();
        etiquetaCartasJug1.setBounds(40,40,50,50);
        etiquetaCartasJug1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(68,92,Image.SCALE_SMOOTH)));
        etiquetaCartasJug1.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaCartasJug1.setVerticalAlignment(SwingConstants.CENTER);
        etiquetaCartasJug1.setFont(new Font("Calibri",Font.BOLD,55));
        etiquetaCartasJug1.setForeground(Color.WHITE);
        etiquetaCartasJug1.setText("0");
        //Jugador 2
        etiquetaCartasJug2 = new JLabel();
        etiquetaCartasJug2.setBounds(40,80,50,50);
        etiquetaCartasJug2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(68,92,Image.SCALE_SMOOTH)));
        etiquetaCartasJug2.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaCartasJug2.setVerticalAlignment(SwingConstants.CENTER);
        etiquetaCartasJug2.setFont(new Font("Calibri",Font.BOLD,55));
        etiquetaCartasJug2.setForeground(Color.WHITE);
        etiquetaCartasJug2.setText("0");
        //Jugador 3
        etiquetaCartasJug3 = new JLabel();
        etiquetaCartasJug3.setBounds(40,80,50,50);
        etiquetaCartasJug3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(68,92,Image.SCALE_SMOOTH)));
        etiquetaCartasJug3.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaCartasJug3.setVerticalAlignment(SwingConstants.CENTER);
        etiquetaCartasJug3.setFont(new Font("Calibri",Font.BOLD,55));
        etiquetaCartasJug3.setForeground(Color.WHITE);
        etiquetaCartasJug3.setText("0");
        //Añadir etiquetas
        panelJugador1.add(etiquetaCartasJug1);
        panelJugador2.add(etiquetaCartasJug2);
        panelJugador3.add(etiquetaCartasJug3);
        panelMarcador.add(panelJugador1);
        panelMarcador.add(panelJugador2);
        panelMarcador.add(panelJugador3);
        
        //---Zona donde se colocarán las cartas---
        panelJuego = new JPanel();
        panelJuego.setBackground(colorPoker);
        panelJuego.setLayout(new GridLayout(4,13)); 
        //Iteracion para crear mesa con las cartas en su posicion ordenada
        int idx = 0;
        for(int i=0; i<4; i++) {
            for(int j=0; j<13; j++) {
                JPanel panelCarta = new JPanel();
                panelCarta.setBounds(40,80,500,726);
                panelCarta.setBackground(colorVerdeOscuro);
                panelCarta.setBorder(BorderFactory.createLineBorder(colorPoker,2));
                Carta c = baraja.getCartaAt(idx);
                
                //Añadir icono al panel
                ImageIcon imagen = new ImageIcon(c.getNombre());
                JLabel etiqueta = new JLabel();
                etiqueta.setBounds(40,80,500,726);
                etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(66,90,Image.SCALE_SMOOTH)));
                panelCarta.add(etiqueta);
                panelJuego.add(panelCarta);
                idx++;
            }
        }
        
        //---Zona inferior de la mesa---
        panelInferior = new JPanel();
        panelInferior.setBackground(colorPoker);
        panelInferior.setLayout(new BorderLayout());
        panelCartasUsuario = new JPanel();
        panelCartasUsuario.setBackground(colorPoker);
        panelCartasUsuario.setLayout(new GridLayout(1,13));
        for(int i=0; i<13; i++) {
            if (i==0) {
                JPanel panelCarta = new JPanel();
                panelCarta.setBackground(colorVerdeOscuro);
                panelCarta.setBorder(BorderFactory.createLineBorder(colorPoker,2));
                //Añadir icono al panel
                ImageIcon imagen = new ImageIcon("verde.png");
                JLabel etiqueta = new JLabel();
                etiqueta.setBounds(10,80,500,726);
                etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(80,109,Image.SCALE_SMOOTH)));
                panelCarta.add(etiqueta);
                //Añadir al panel
                panelCartasUsuario.add(panelCarta);   
            } else {
                JPanel panelCarta = new JPanel();
                panelCarta.setBackground(colorPoker);
                panelCarta.setBorder(BorderFactory.createLineBorder(colorPoker,2));
                panelCartasUsuario.add(panelCarta);
            }
        }
        etiquetaCartasUsuario = new JLabel();
        etiquetaCartasUsuario.setForeground(Color.WHITE);
        etiquetaCartasUsuario.setFont(new Font("Calibri",Font.BOLD,25));
        etiquetaCartasUsuario.setText("13");
        panelInferior.add(etiquetaCartasUsuario,BorderLayout.NORTH);
        panelInferior.add(panelCartasUsuario,BorderLayout.CENTER);
        
        //---Zona central del juego---
        panelMesa = new JPanel();
        panelMesa.setBackground(colorPoker);
        panelMesa.setLayout(new BorderLayout());
        
        
        //---Zona inferior de la ventana---
        panelInformacion = new JPanel();
        panelInformacion.setBackground(Color.WHITE);
        panelInformacion.setLayout(new BorderLayout());
        panelBotones = new JPanel();
        panelBotones.setBackground(Color.WHITE);
        botonMezclar = new JButton("Mezclar");
        botonMezclar.setBackground(colorTurquesa);
        botonMezclar.addActionListener(this);
        botonJugar = new JButton("Jugar");
        botonJugar.addActionListener(this);
        botonJugar.setEnabled(false);
        botonPasar = new JButton("Pasar");
        botonPasar.setBackground(Color.YELLOW);
        botonPasar.addActionListener(this);
        botonReiniciar = new JButton("Reiniciar");
        botonReiniciar.addActionListener(this);
        botonReiniciar.setEnabled(false);
        panelBotones.add(botonMezclar);
        panelBotones.add(botonJugar);
        panelBotones.add(botonReiniciar);
        etiquetaInformacion = new JLabel("Antes de jugar hay que mezclar la baraja");
        panelInformacion.add(panelBotones,BorderLayout.NORTH);
        panelInformacion.add(etiquetaInformacion,BorderLayout.SOUTH);
        panelEste = new JPanel();
        panelEste.setBackground(colorPoker);
        panelOeste = new JPanel();
        panelOeste.setBackground(colorPoker); 
        panelMesa.add(panelMarcador,BorderLayout.NORTH);
        panelMesa.add(panelEste,BorderLayout.EAST);
        panelMesa.add(panelJuego,BorderLayout.CENTER);
        panelMesa.add(panelOeste,BorderLayout.WEST);
        panelMesa.add(panelInferior,BorderLayout.SOUTH); 
        
        //---Características de la ventana---
        if(reiniciar == true) {
            ventana.getContentPane().removeAll();
            reiniciar = false;
        }
        ventana.getContentPane().add(panelMesa,BorderLayout.CENTER);
        ventana.getContentPane().add(panelInformacion,BorderLayout.SOUTH);
        ventana.setSize(1000,650);
        ventana.setVisible(true);
        ventana.setBackground(colorPoker);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //---< MÉTODOS PARA MOSTRAR INFORMACIÓN POR CONSOLA >---
    //Mostrar la baraja por consola
    private void mostrarBaraja(Baraja b) {
        //Método toString de la clase baraja
        b.imprimirBaraja();
    }
    
    //---< DESARROLLO DEL JUEGO >---
    //Método que se usa cuando un jugador gana
    private void jugadorGanador(Jugador j) {
        //Imprimir estado de la mesa tras la tirada
        System.out.println("\n\nTIRADA GANADORA DE "+j.nombre+":");
        mesa.imprimirMesa();
        
        //Mensaje de que el jugador ha ganado
        System.out.println(j.nombre+" HA GANADO LA PARTIDA\n\n\n\n");
        
        //Icono del aviso
        String n;
        if (jugadoresCPU[0].getGanador()) {
            n = "Jug0Riu.png";
        } else if(jugadoresCPU[1].getGanador()) {
            n = "Jug1Riu.png";
        } else if(jugadoresCPU[2].getGanador()) {
            n = "Jug2Riu.png";
        } else {
            n = "Jug3Riu.png";
        }
        
        //Salir del juego
        ImageIcon iconoGanador = new ImageIcon(n);
        if(player.getGanador()) {
            informar("Has ganado la partida al colocar "+j.getCartaColocada().toString(),"¡¡¡ENHORABUENA!!!",iconoGanador);
        } else {
            informar(j.getNombre()+" ha ganado la partida al colocar\n\t"+j.cartaColocada.toString(),"¡¡¡FIN DE LA PARTIDA!!!",iconoGanador);
        }
        
        //Preguntar si se quiere jugar otra partida o salir
        int opcion = escogerOpcion("¿Quieres jugar otra partida?","SI","NO");
        if (opcion == 1) {
            //Mismo código que en reniciar partida
            //Llamada al método reiniciar
            reiniciar();
        } else {
            //Se detiene la ejecucion del programa
            salir(0);
        }
        
    }
    //Inicializar los jugadores de la CPU
    private void inicializarCPU() {
        //Nombre random para el jugador
        Random r = new Random();
        boolean fin = false;  
        
        //Declarar array de jugadores de la cpu
        jugadoresCPU = new Jugador[numJugadoresCPU];
        int id = 1;
        
        //Instanciar objetos jugador en cada posicion del array
        for(int i=0;i<jugadoresCPU.length;i++) {
            jugadoresCPU[i] = new Jugador();
            id++;
        }
        
        //Dar nombres random para hacerlo mas realista
        int idx = 0;
        while(fin==false && idx<3) {
            //Java util random para simular aleatoriedad
            int n = r.nextInt(6);
            String nombre = nombres[n];
            //Comprobar si el nombre esta cogido
            if (!nombreCogido(nombre)) {
                jugadoresCPU[idx].setNombre(nombre);
                idx++;
            }
            //Comprobar si ya esta todo inicializado
            if(idx == 3) {
                fin = true;
            }
        }
        
    }
    //Comprobar si un nombre ya está cogido
    private boolean nombreCogido(String n) {
        for(int i=0; i<jugadoresCPU.length; i++) {
            if(jugadoresCPU[i].getNombre().equals(n) == true) {
                //Nombre cogido
                return true;
            }
        }
        //Nombre libre
        return false;
    }
    //Repartir las cartas de la baraja hasta que quede vacía
    private void repartirCartas() throws barajaVacia {
        
        //Repartir las cartas a los jugadores de la partida
        for(int i=0; i<baraja.getNumCartes(); i++) {
            jugadoresCPU[0].darCarta(baraja.getCartaAt(i));
            baraja.setCartaAt(i,new Carta());
            i++;
            jugadoresCPU[1].darCarta(baraja.getCartaAt(i));
            baraja.setCartaAt(i,new Carta());
            i++;
            jugadoresCPU[2].darCarta(baraja.getCartaAt(i));
            baraja.setCartaAt(i,new Carta());
            i++;
            player.darCarta(baraja.getCartaAt(i));
            baraja.setCartaAt(i,new Carta());
        }
        System.out.println("\n\n--SE REPARTEN LAS CARTAS Y SE OBTIENE:\n");
        cartasJugadores();
    }
    //Mostrar las cartas de los jugadores
    private void cartasJugadores() {
        jugadoresCPU[0].printCartas();
        jugadoresCPU[1].printCartas();
        jugadoresCPU[2].printCartas();
        player.printCartas();
    }
    //Para detener la ejecución del programa
    private void salir(int estado) {
        System.exit(estado);
    }
    
    //---< LECTURA DE DATOS - ESCOGER OPCIONES >---
    //Lee un String y lo devuelve
    private String leerString(String s) {
        String nombre;
        nombre = JOptionPane.showInputDialog(s);
        return nombre;
    }
    //Manda un aviso al usuario con una ventana emergente
    private void warning(String s, String titulo) {
        JOptionPane.showMessageDialog(null,s,titulo,JOptionPane.WARNING_MESSAGE);
    }
    //Informa de algo al usuario mediante una ventana emergente
    private void informar(String s, String titulo, ImageIcon icono) {
        JOptionPane.showMessageDialog(null,s,titulo,JOptionPane.PLAIN_MESSAGE, icono);
    }
    //Ventana emergente con el clásico "si o no". Devuelve la opcion escogida
    private int escogerOpcion(String s,String op1,String op2) {
        //1 = SI
        //2 = NO
        int seleccion = JOptionPane.showOptionDialog(null, s, "Selector de opciones",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{op1, op2}, "opcion 1");
        
        return (seleccion+1);
    } 

    //---< GESTIÓN DE EVENTOS >---//Método que gestiona los eventos asociados a cada componente del programa
    @Override
    public void actionPerformed(ActionEvent e) {
        //----> GESTIONAR EVENTOS ASOCIADOS A CADA BOTÓN
        
        //Mezclar la baraja
        if(botonMezclar == e.getSource()) {
            
            //---> Mezclar baraja y mostrarla
            System.out.println("\n\nSE MEZCLA LA BARAJA Y QUEDA ASÍ:");
            baraja.mezclar();           //Mezclar baraja
            mesa.añadirBaraja(baraja);  //Añadir baraja mezclada a la mesa
            mostrarBaraja(baraja);      //Imprimir baraja por consola
            
            //---> Actualizar cartas mostradas en el panel gráfico
            actualizarTablero();        //Imprimir el objeto mesa de forma gráfica
            
            //---> Añadir paneles actualizados al panel de mesa de juego
            panelMesa.add(panelMarcador, BorderLayout.NORTH);
            panelMesa.add(panelEste, BorderLayout.EAST);
            panelMesa.add(panelJuego, BorderLayout.CENTER);
            panelMesa.add(panelOeste, BorderLayout.WEST);
            panelMesa.add(panelInferior, BorderLayout.SOUTH);
            
            //---> Actualizar etiqueta
            etiquetaInformacion = new JLabel("La baraja se ha mezclado");
            panelInformacion.removeAll();
            panelInformacion.updateUI();
            botonMezclar.setBackground(Color.WHITE);
            botonJugar.setBackground(colorTurquesa);
            panelInformacion.add(panelBotones,BorderLayout.NORTH);
            panelInformacion.add(etiquetaInformacion,BorderLayout.SOUTH);
            //---> Habilitar botones de jugar
            botonJugar.setEnabled(true);
            botonReiniciar.setEnabled(true);
            //--> Añadir el panel actualizado a la ventana
            ventana.getContentPane().add(panelInformacion,BorderLayout.SOUTH);
            ventana.getContentPane().add(panelMesa,BorderLayout.CENTER);  
        }
             
        
        //Jugar una partida
        if(botonJugar == e.getSource()) {
            
            try {
                String s = "";
                //---> Si es el primer turno, la mesa se vacía
                if (mesaNueva) {
                    mesa = new Mesa(4,13);
                    mesa.inicializar();
                    mesaNueva = false;
                    s = "Las cartas se han repartido, coloca un 7 si lo tienes";
                }
                
                //---> Establecer nombre para el usuario
                if(player.getNombre().equals(" ")) {
                    String nombre = leerString("¿Cuál es tu nombre?");
                    player.setNombre(nombre);   
                }
                
                //---> Si las cartas no se han repartido se reparten
                if (cartasRepartidas == false) {
                    repartirCartas();
                    cartasRepartidas = true;
                }
                
                //---> Uso de la variable 'primerTurno' para hacer turnos sobre la mesa
                if ((playerMovement==true)&&(player.getGanador()==false)) {
                    //Imprimir por consola
                    System.out.println("\n\n\n\t\t--------TURNO " + tirada + ":--------\n");
                    
                    //Tiradas automáticas de los jugadores de la CPU
                    if (jugadoresCPU[0].turnoAutomatico(primerTurno, mesa)) {
                        s += (jugadoresCPU[0].getNombre()+" ha colocado la carta "+jugadoresCPU[0].getCartaColocada().toString()+", ");
                    } else {
                        s+= (jugadoresCPU[0].getNombre()+" ha pasado turno, ");
                    }
                    
                    //Comprobar si el jugador anterior ha ganado
                    if(jugadoresCPU[0].getGanador()== false) {
                        if (jugadoresCPU[1].turnoAutomatico(primerTurno, mesa)) {
                            s += (jugadoresCPU[1].getNombre() + " ha colocado la carta " + jugadoresCPU[1].getCartaColocada().toString() + " y ");
                        } else {
                            s += (jugadoresCPU[1].getNombre() + " ha pasado turno y ");
                        }
                        
                        //Comprobar si el jugador anterior ha ganado
                        if(jugadoresCPU[1].getGanador()==false) {
                            if (jugadoresCPU[2].turnoAutomatico(primerTurno, mesa)) {
                                s += (jugadoresCPU[2].getNombre() + " ha colocado la carta " + jugadoresCPU[2].getCartaColocada().toString() + ".");
                            } else {
                                s += (jugadoresCPU[2].getNombre() + " ha pasado turno.");
                            }
                        }
                    }
                    
                    primerTurno = false;
                    playerMovement = false;
                    //Datos de los jugadores tras el turno
                    System.out.println("TRAS EL TURNO " + tirada + ":");
                    cartasJugadores();
                    tirada++;
                }
                
                //---> Actualizar gráficos e imprimir estado de la mesa
                //Actualizar cartas de la cpu
                actualizarCartasCPU();
                //Actualizar Tablero
                actualizarTablero();
                //Actualizar panel jugador
                actualizarCartasUsuario(true);
                //Añadir informacion actualizada al panel de mesa de juego
                panelMesa.removeAll();
                panelMesa.updateUI();
                panelMesa.add(panelMarcador, BorderLayout.NORTH);
                panelMesa.add(panelEste, BorderLayout.EAST);
                panelMesa.add(panelJuego, BorderLayout.CENTER);
                panelMesa.add(panelOeste, BorderLayout.WEST);
                panelMesa.add(panelInferior, BorderLayout.SOUTH);

                //Actualizar etiqueta inferior y botones
                etiquetaInformacion = new JLabel(s);
                panelInformacion.removeAll();
                panelInformacion.updateUI();
                panelBotones = new JPanel();
                panelBotones.add(botonPasar);
                panelBotones.add(botonReiniciar);
                panelInformacion.add(panelBotones, BorderLayout.NORTH);
                panelInformacion.add(etiquetaInformacion, BorderLayout.SOUTH);

                //Añadir a la ventana
                ventana.getContentPane().add(panelInformacion, BorderLayout.SOUTH);
                ventana.getContentPane().add(panelMesa, BorderLayout.CENTER);
                
                if (jugadoresCPU[0].getGanador()) {
                    jugadoresCPU[1].setGanador(false);
                    jugadoresCPU[2].setGanador(false);
                    jugadorGanador(jugadoresCPU[0]);
                    
                } else if (jugadoresCPU[1].getGanador()) {
                    jugadoresCPU[0].setGanador(false);
                    jugadoresCPU[2].setGanador(false);
                    jugadorGanador(jugadoresCPU[1]);
                } else if (jugadoresCPU[2].getGanador()) {
                    jugadoresCPU[0].setGanador(false);
                    jugadoresCPU[1].setGanador(false);
                    jugadorGanador(jugadoresCPU[2]);
                }

            } catch (barajaVacia ex) {
                warning("La baraja está vacía", "Error");
            }
        }
        
        //Reiniciar la partida
        if(botonReiniciar == e.getSource()) {
            int opcion = escogerOpcion("¡SI REINICIAS NO HAY VUELTA ATRÁS!","Reiniciar","No reiniciar");
            if(opcion == 1) {
                //Llamada al método reiniciar
                reiniciar();
            }
        }
        
        if (botonPasar == e.getSource()) {
            playerMovement = true;
            
            //---> Actualizar gráficos e imprimir estado de la mesa
            //Actualizar cartas de la cpu
            actualizarCartasCPU();
            //Actualizar Tablero
            actualizarTablero();
            //Actualizar panel jugador
            actualizarCartasUsuario(false);
            //Añadir informacion actualizada al panel de mesa de juego
            panelMesa.removeAll();
            panelMesa.updateUI();
            panelMesa.add(panelMarcador, BorderLayout.NORTH);
            panelMesa.add(panelEste, BorderLayout.EAST);
            panelMesa.add(panelJuego, BorderLayout.CENTER);
            panelMesa.add(panelOeste, BorderLayout.WEST);
            panelMesa.add(panelInferior, BorderLayout.SOUTH);

            //Actualizar etiqueta inferior y botones
            etiquetaInformacion = new JLabel(player.getNombre()+" ha pasado su turno. Pulsa el botón 'Turno CPU' para realizar la próxima tirada");
            panelInformacion.removeAll();
            panelInformacion.updateUI();
            botonJugar.setText("Turno CPU");
            botonJugar.setBackground(Color.CYAN);
            panelBotones = new JPanel();
            panelBotones.add(botonJugar);
            panelBotones.add(botonReiniciar);
            panelInformacion.add(panelBotones, BorderLayout.NORTH);
            panelInformacion.add(etiquetaInformacion, BorderLayout.SOUTH);

            //Añadir a la ventana
            ventana.getContentPane().add(panelInformacion, BorderLayout.SOUTH);
            ventana.getContentPane().add(panelMesa, BorderLayout.CENTER);
        }
        
        //---> Carta clicada por el usuario
        for(int i=0; i<botones.length; i++) {
            if(botones[i] == e.getSource()) {
                //Se ha clicado el boton botones[i], se añade a la mesa
                Carta c = player.getCartaAt(i);
                String s;
                //Hacer tirada
                if (player.turnoManual(primerTurno, mesa, c)) {
                    s = (player.getNombre()+" ha colocado "+c.toString());
                    player.setCartaAt(i,new Carta());
                    playerMovement = true;
                } else {
                    s = "Esa carta no puede colocarse, escoge una válida";
                }
                
                boolean intento;
                if (playerMovement == true) {
                    if (player.getGanador()) {
                        botonJugar.setText("PARTIDA FINALIZADA");
                        botonJugar.setBackground(Color.GREEN);
                        s += " y ha ganado la partida";
                    } else {
                        //Jugar siguiente movimiento de la CPU
                        botonJugar.setText("Turno CPU");
                        botonJugar.setBackground(Color.CYAN);
                    }
                    
                    panelBotones = new JPanel();
                    panelBotones.add(botonJugar);
                    intento = false;    
                } else {
                    //El usuario no ha tirado, debe seguir podiendo escoger
                    panelBotones = new JPanel();
                    panelBotones.add(botonPasar);
                    intento = true;
                }
                
                //---> Actualizar gráficos e imprimir estado de la mesa
                //Actualizar cartas de la cpu
                actualizarCartasCPU();
                //Actualizar Tablero
                actualizarTablero();
                //Actualizar panel jugador
                actualizarCartasUsuario(intento);
                //Añadir informacion actualizada al panel de mesa de juego
                panelMesa.removeAll();
                panelMesa.updateUI();
                panelMesa.add(panelMarcador, BorderLayout.NORTH);
                panelMesa.add(panelEste, BorderLayout.EAST);
                panelMesa.add(panelJuego, BorderLayout.CENTER);
                panelMesa.add(panelOeste, BorderLayout.WEST);
                panelMesa.add(panelInferior, BorderLayout.SOUTH);
                //Actualizar etiqueta inferior y botones
                etiquetaInformacion = new JLabel(s);
                panelInformacion.removeAll();
                panelInformacion.updateUI();
                panelBotones.add(botonReiniciar);
                panelInformacion.add(panelBotones, BorderLayout.NORTH);
                panelInformacion.add(etiquetaInformacion, BorderLayout.SOUTH);
                //Añadir a la ventana
                ventana.getContentPane().add(panelInformacion, BorderLayout.SOUTH);
                ventana.getContentPane().add(panelMesa, BorderLayout.CENTER);
                
                if (player.getGanador()) {
                    jugadoresCPU[0].setGanador(false);
                    jugadoresCPU[1].setGanador(false);
                    jugadoresCPU[2].setGanador(false);
                    jugadorGanador(player);
                }
            }
        }
    }
    
    
    //---< ACTUALIZAR PANELES GRÁFICOS >---
    //Reiniciar el valor de todos los componentes y variables del juego
    private void reiniciar() {
        
        //---Restaurar variables globales---
        tirada = 1;                     //Contador de tiradas
        cartasRepartidas = false;       //Para saber si las cartas se han repartido
        playerMovement = false;         //Para saber si el usuario ha hecho su movimiento
        mesaNueva = true;               //Para saber si crear una mesa nueva
        primerTurno = true;             //Para saber si es el primer turno
        reiniciar = false;              //Para saber si se ha reiniciado
        
        //---Instanciar objetos de nuevo
        //---> Crear e inicializar baraja
        baraja = new Baraja();
        baraja.inicializar();

        //---> Inicializar mesa
        mesa = new Mesa(4, 13);          //Crear mesa
        mesa.inicializar();             //Inicializar mesa
        mesa.añadirBaraja(baraja);      //Añade la baraja en la mesa
        mesa.imprimirMesa();            //Imprimir (por consola)

        //---> Inicializar CPU y repartir Cartas
        inicializarCPU();
        player = new Jugador();

        //---> Crear interfaz gráfica de usuario
        botones = new JButton[13];


        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\t---> SE HA REINICIADO LA PARTIDA\n\n");
        warning("¡HECHO!","Pulsa OK para reiniciar la partida");
        reiniciar = true;
        graficos();
    }
    //Actualizar el tablero con las cartas
    private void actualizarTablero() {
        panelJuego = new JPanel();
        panelJuego.setBackground(colorPoker);
        panelJuego.setLayout(new GridLayout(4, 13));

        //---> Iteracion para crear mesa vacía
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                JPanel panelCarta = new JPanel();
                panelCarta.setBackground(colorVerdeOscuro);
                panelCarta.setBorder(BorderFactory.createLineBorder(colorPoker, 2));
                panelCarta.setLayout(new BorderLayout());
                Carta c = mesa.getCartaAt(i,j);

                //Añadir icono al panel
                ImageIcon imagen = new ImageIcon(c.getNombre());
                JLabel etiqueta = new JLabel();
                etiqueta.setBounds(10, 80, 500, 726);
                etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(66, 90, Image.SCALE_SMOOTH)));
                panelCarta.add(etiqueta,BorderLayout.CENTER);
                panelJuego.add(panelCarta);
            }
        }
    }
    //Actualizar panel donde se muestran las cartas del usuario
    private void actualizarCartasUsuario(boolean habilitado) {
        //Eliminar estado anterior
        panelCartasUsuario.removeAll();
        panelCartasUsuario.updateUI();
        panelCartasUsuario = new JPanel();
        panelCartasUsuario.setBackground(colorPoker);
        panelCartasUsuario.setLayout(new GridLayout(1,13));
        
        //Nuevo estado
        for(int i=0; i<13; i++) {
            //---> CREAR ICONO
            Carta c = player.getCartaAt(i);
            ImageIcon imagen = new ImageIcon(c.getNombre());
            
            //---> CREAR BOTÓN
            botones[i] = new JButton();
            botones[i].setOpaque(true);
            botones[i].setEnabled(habilitado);
            botones[i].setBackground(colorPoker);
            botones[i].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(80,109,Image.SCALE_SMOOTH)));
            botones[i].addActionListener(this);
            
            //---> PANEL CON LA CARTA Y EL BOTÓN
            JPanel panelCarta = new JPanel();
            panelCarta.setLayout(new BorderLayout());
            panelCarta.setBackground(colorPoker);
            panelCarta.setBorder(BorderFactory.createLineBorder(colorPoker,2));
            panelCarta.add(botones[i],BorderLayout.CENTER);
            
            //---> AÑADIR AL PANEL DE CARTAS
            panelCartasUsuario.add(panelCarta);  
        }
        String numCartas = "    "+player.getNombre()+": "+player.getNumCartas()+" cartas";
        etiquetaCartasUsuario.setForeground(Color.WHITE);
        etiquetaCartasUsuario.setFont(new Font("Calibri",Font.BOLD,20));
        etiquetaCartasUsuario.removeAll();
        etiquetaCartasUsuario.updateUI();
        etiquetaCartasUsuario.setText(numCartas);
        
        //Añadir paneles actualizados
        panelInferior.removeAll();
        panelInferior.updateUI();
        panelInferior.add(etiquetaCartasUsuario,BorderLayout.NORTH);
        panelInferior.add(panelCartasUsuario,BorderLayout.CENTER);
        
    }
    //Actualizar las cartas de la cpu
    private void actualizarCartasCPU() {
        //Jugador 1
        etiquetaCartasJug1.removeAll();
        etiquetaCartasJug1.updateUI();
        etiquetaCartasJug1 = new JLabel();
        etiquetaCartasJug1.setBounds(40, 40, 50, 50);
        etiquetaCartasJug1.setIcon(new ImageIcon(cartaOculta.getImage().getScaledInstance(68, 92, Image.SCALE_SMOOTH)));
        etiquetaCartasJug1.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaCartasJug1.setVerticalAlignment(SwingConstants.CENTER);
        etiquetaCartasJug1.setFont(new Font("Calibri",Font.BOLD,55));
        etiquetaCartasJug1.setForeground(Color.WHITE);
        String n = jugadoresCPU[0].getNombre()+": "+ jugadoresCPU[0].getNumCartas();
        etiquetaCartasJug1.repaint();
        etiquetaCartasJug1.setText(n);
        
        //Jugador 2
        etiquetaCartasJug2.removeAll();
        etiquetaCartasJug2.updateUI();
        etiquetaCartasJug2 = new JLabel();
        etiquetaCartasJug2.setBounds(40, 40, 50, 50);
        etiquetaCartasJug2.setIcon(new ImageIcon(cartaOculta.getImage().getScaledInstance(68, 92, Image.SCALE_SMOOTH)));
        etiquetaCartasJug2.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaCartasJug2.setVerticalAlignment(SwingConstants.CENTER);
        etiquetaCartasJug2.setFont(new Font("Calibri",Font.BOLD,55));
        etiquetaCartasJug2.setForeground(Color.WHITE);
        n = jugadoresCPU[1].getNombre()+": "+ jugadoresCPU[1].getNumCartas();
        etiquetaCartasJug2.repaint();
        etiquetaCartasJug2.setText(n);
        //Jugador 3
        etiquetaCartasJug3.removeAll();
        etiquetaCartasJug3.updateUI();
        etiquetaCartasJug3 = new JLabel();
        etiquetaCartasJug3.setBounds(40, 40, 50, 50);
        etiquetaCartasJug3.setIcon(new ImageIcon(cartaOculta.getImage().getScaledInstance(68, 92, Image.SCALE_SMOOTH)));
        etiquetaCartasJug3.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaCartasJug3.setVerticalAlignment(SwingConstants.CENTER);
        etiquetaCartasJug3.setFont(new Font("Calibri",Font.BOLD,55));
        etiquetaCartasJug3.setForeground(Color.WHITE);
        n = jugadoresCPU[2].getNombre()+": "+ jugadoresCPU[2].getNumCartas();
        etiquetaCartasJug3.repaint();
        etiquetaCartasJug3.setText(n);
        
        //Añadir cpu modificada al panel que lo contiene
        panelJugador1.removeAll();
        panelJugador1.updateUI();
        panelJugador1.add(etiquetaCartasJug1);
        panelJugador2.removeAll();
        panelJugador2.updateUI();
        panelJugador2.add(etiquetaCartasJug2);
        panelJugador3.removeAll();
        panelJugador3.updateUI();
        panelJugador3.add(etiquetaCartasJug3);
        panelMarcador.removeAll();
        panelMarcador.updateUI();
        panelMarcador.add(panelJugador1);
        panelMarcador.add(panelJugador2);
        panelMarcador.add(panelJugador3);
    }
}