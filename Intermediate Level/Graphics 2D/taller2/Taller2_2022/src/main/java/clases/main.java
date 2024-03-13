
package clases;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class main extends JFrame implements ActionListener {

    //-------< ATRIBUTOS >-------
    static int complejidad;         //Complejidad del juego
    static boolean jugando = false; //Para saber si hay una partida en curso
    static int tamaño;              //Tamaño del tablero
    static int numNiveles;          //Numero de niveles que se jugarán
    static int nivelActual;         //Nivel actual del juego
    static int puntuacion;          //Puntuacion de la partida
    static int fila,columna;        //Fila y columna de la casilla diferente
    static int i,j;                 //Indices
    static JPanel panelCorrecto;    //Panel que se deberia clicar
    static JPanel paneles[][];      //Panel seleccionado por el usuario
    static JButton botones[][];     //Botones del tablero 
    static long tiempo1,tiempo2;
    public JButton botonCorrecto,boton;
    static Random r;                //Random
    CardLayout local;
    //Lista de colores para escoger aleatoriamente (8 colores diferentes)
    public Color colores[] = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.CYAN, Color.ORANGE, Color.PINK, Color.MAGENTA};
    //Declaración de variables de graficos
    public JFrame ventana;
    public JPanel panelBotones;
    public JSplitPane separador1;
    public JSplitPane separador2;
    public JSplitPane separador3;
    public JPanel panelSuperior;
    public JPanel panelInformacion;
    public JMenuBar barraMenu;
    public JMenu menu;
    public JMenuItem nuevaPartidaMenu;
    public JMenuItem salirMenu;
    public JPanel panelInformativo1;
    public JPanel panelInformativo2;
    public JPanel panelInformativo3;
    public JPanel panelInformativo4;
    public JLabel etiquetaNomNivelesPartida;
    public JLabel etiquetaValNivelesPartida;
    public JLabel etiquetaNomNivelesRestantes;
    public JLabel etiquetaValNivelesRestantes;
    public JLabel etiquetaNomNivelActual;
    public JLabel etiquetaValNivelActual;
    public JLabel etiquetaNombrePuntuacion;
    public JLabel etiquetaValPuntuacion;
    public JButton nuevaPartidaBoton;
    public JButton salirBoton;
    public JPanel panelVisualizacion;
    public JPanel panelJuego;
    public JPanel panelStandby;
    public JLabel gif;
    
    
    //--------------------------------------------------------------------------
    public static void main(String[] args) {
        new main().principal();
    }
    //--------------------------------------------------------------------------
    
    //Método principal
    public void principal() {
        try {
            
            //Crear entorno gráfico
            graficos();
            //Gestionar eventos
            ActionEvent evento = null;
            evento.getSource();
            actionPerformed(evento);
            
             
            
        } catch (NullPointerException e) {
            System.out.println("");
        } catch (Exception e) {
            System.out.println("");
        }
    }
    
    //Método que crea el entorno gráfico del juego
    public void graficos() {
        //ENTORNO GRÁFICO VERSIÓN COMPLETA (VERSIÓN PUNTUABLE SOBRE 10)
        try {
            //-----PANELES, CONTENEDORES, ETC-----
            numNiveles = 0;
            nivelActual = 0;
            puntuacion = 0;
            
            //---> Principal
            ventana = new JFrame();
            panelBotones = new JPanel();
            
            //---> Separadores
            separador1 = new JSplitPane();
            separador2 = new JSplitPane();
            separador3 = new JSplitPane();
            
            //---> Menu
            panelSuperior = new JPanel();
            panelInformacion = new JPanel();
            barraMenu = new JMenuBar();
            menu = new JMenu("MENU");
            nuevaPartidaMenu = new JMenuItem("NUEVA PARTIDA");
            nuevaPartidaMenu.addActionListener(this);
            salirMenu = new JMenuItem("SALIR");
            salirMenu.addActionListener(this);
            barraMenu.setLayout(new GridLayout(1,1));
            
            //---> Marcador de punutuaciones
            panelInformativo1 = new JPanel();
            panelInformativo2 = new JPanel();
            panelInformativo3 = new JPanel();
            panelInformativo4 = new JPanel();
            etiquetaNomNivelesPartida = new JLabel("NIVELES PARTIDA");
            etiquetaValNivelesPartida = new JLabel("000");
            etiquetaNomNivelesRestantes = new JLabel("NIVELES RESTANTES");
            etiquetaValNivelesRestantes = new JLabel("000");
            etiquetaNomNivelActual = new JLabel("NIVEL ACTUAL");
            etiquetaValNivelActual = new JLabel("000");
            etiquetaNombrePuntuacion = new JLabel("PUNTUACIÓN");
            etiquetaValPuntuacion = new JLabel("000"); 
            
            //---> Zona sur (botones inferiores)
            nuevaPartidaBoton = new JButton("NUEVA PARTIDA");
            nuevaPartidaBoton.addActionListener(this);
            salirBoton = new JButton("SALIR");
            salirBoton.addActionListener(this);
            panelBotones.setLayout(new GridLayout(1,2));
            panelBotones.add(nuevaPartidaBoton);
            panelBotones.add(salirBoton);
            
            //---> Panel central con gif
            panelVisualizacion = new JPanel();
            panelVisualizacion.setLayout(new CardLayout());
            panelVisualizacion.setBackground(Color.WHITE);
            panelJuego = new JPanel();
            panelStandby = new JPanel();
            panelStandby.setBackground(new Color(20,20,20));
            
            
            //-----CONFIGURAR ENTORNO GRÁFICO----- 
            //---> Ventana
            ventana.setTitle("TALLER 2");
            ventana.getContentPane().setBackground(Color.BLUE);
            ventana.setResizable(true);
            BorderLayout bl = new BorderLayout();
            ventana.setLayout(bl);
            ventana.setSize(400,250);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setVisible(true);
            
            //---> Paneles de cada región
            //Norte
            panelSuperior.setBackground(Color.GREEN);
            ventana.getContentPane().add(panelSuperior, BorderLayout.NORTH);
            //Centro
            panelVisualizacion.setBackground(Color.BLACK);
            ventana.getContentPane().add(panelVisualizacion, BorderLayout.CENTER);
            //Sur
            panelBotones.setBackground(Color.MAGENTA);
            ventana.getContentPane().add(panelBotones, BorderLayout.SOUTH);
            
            //--->Zona norte
            panelSuperior.setLayout(new BorderLayout());
            menu.add(nuevaPartidaMenu);
            menu.add(salirMenu);
            menu.setBackground(Color.DARK_GRAY);
            barraMenu.add(menu);
            panelSuperior.add(barraMenu, BorderLayout.NORTH);
            panelInformativo1.setLayout(new GridLayout(1,2));
            panelInformativo1.setBackground(Color.ORANGE);
            panelInformativo2.setLayout(new GridLayout(1,2));
            panelInformativo2.setBackground(Color.ORANGE);
            panelInformativo3.setLayout(new GridLayout(1,2));
            panelInformativo3.setBackground(Color.ORANGE);
            panelInformativo4.setLayout(new GridLayout(1,2));
            panelInformativo4.setBackground(Color.ORANGE);
            panelInformativo1.add(etiquetaNomNivelesPartida);
            panelInformativo1.add(etiquetaValNivelesPartida);
            panelInformativo2.add(etiquetaNomNivelesRestantes);
            panelInformativo2.add(etiquetaValNivelesRestantes);
            panelInformativo3.add(etiquetaNomNivelActual);
            panelInformativo3.add(etiquetaValNivelActual);
            panelInformativo4.add(etiquetaNombrePuntuacion);
            panelInformativo4.add(etiquetaValPuntuacion);
            panelInformacion.setLayout(new GridLayout(2,2));
            panelInformacion.add(panelInformativo1);
            panelInformacion.add(panelInformativo2);
            panelInformacion.add(panelInformativo3);
            panelInformacion.add(panelInformativo4);
            panelSuperior.add(panelInformacion, BorderLayout.SOUTH);
            
            //---> Zona central
            gif = new JLabel(new ImageIcon("uib.gif"));
            panelStandby.add(gif);
            //CardLayout para cambiar de ventana
            CardLayout local = (CardLayout) (panelVisualizacion.getLayout());
            panelVisualizacion.add(panelStandby,"panelStandby");
            local.show(panelVisualizacion, "panelJuego");
            
        } catch (Exception e) {

        }
    }
    
    /*
    ============================================================================
    ============================GESTIÓN DE EVENTOS==============================
    ============================================================================
    */
    //Gestión de eventos
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Salir
            if ((salirBoton == e.getSource()) || (salirMenu == e.getSource())) {
                System.exit(0);
            }

            //Nueva partida
            if ((nuevaPartidaBoton == e.getSource()) || (nuevaPartidaMenu == e.getSource())) {
                if (!jugando) {
                    //---Empezar juego---
                    jugando = true;
                    tiempo1 = System.currentTimeMillis();
                    //Dar valor al tamaño y a la complejidad
                    nivelesYcomplejidad();

                    //Iteración de todo el juego hasta que este acabe
                    tamaño = 2;
                    nivelActual = 0;
                    

                    //Actualizar marcadores
                    actualizarMarcador(true);
                    //Crear Tablero
                    crearTablero();
                    //CardLayout para cambiar de ventana
                    local = (CardLayout) (panelVisualizacion.getLayout());
                    //Añadir el tablero a la pantalla encima del gif con CardLayout
                    panelVisualizacion.add(panelJuego, "panelJuego");
                    local.show(panelVisualizacion, "panelJuego");
                } else {
                    warning("NO PUEDES EMPEZAR UNA PARTIDA HABIENDO OTRA EN CURSO","   ERROR   ");
                }
            }

            //Boton clicado correcto
            if (botonCorrecto == e.getSource()) {
                //Comprobar si es el ultimo nivel
                if (nivelActual == (numNiveles-1)) {
                    //---Botón Correcto---
                    tiempo2 = System.currentTimeMillis();
                    long tiempo = tiempo2-tiempo1;
                    double time = tiempo/1000;
                    System.out.println("BOTÓN CORRECTO");
                    botonCorrecto.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                    panelCorrecto.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                    puntuacion += tamaño;
                    //Actualizar marcadores
                    actualizarMarcador(true);
                    String s = "HAS GANADO LA PARTIDA CON " + puntuacion + " PUNTOS EN "+time+" SEGUNDOS";
                    warning(s, "   ENHORABUENA   ");
                    //Juego terminado
                    local = (CardLayout) (panelVisualizacion.getLayout());
                    //Añadir el tablero a la pantalla encima del gif con CardLayout
                    local.show(panelVisualizacion, "panelStandby");

                    //Restablecer contadores y variables
                    jugando = false;
                    puntuacion = 0;
                    nivelActual = 0;
                    numNiveles = 0;

                    //Reiniciar marcador
                    actualizarMarcador(false);
                } else {
                    //---Botón Correcto---
                    System.out.println("BOTÓN CORRECTO");
                    //Borde verde para inmdicar que ha acertado
                    botonCorrecto.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                    panelCorrecto.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                    //Proxima iteracion
                    puntuacion += tamaño;
                    nivelActual++;
                    tamaño++;
                    //Actualizar marcadores
                    actualizarMarcador(true);
                    //Crear Tablero de tamaño nuevo
                    crearTablero();
                    //CardLayout para cambiar de ventana
                    local = (CardLayout) (panelVisualizacion.getLayout());
                    //Añadir el tablero a la pantalla encima del gif con CardLayout
                    panelVisualizacion.add(panelJuego, "panelJuego");
                    local.show(panelVisualizacion, "panelJuego");
                }
            }

            //Boton clicado incorrecto
            for (i = 0; i < tamaño; i++) {
                for (j = 0; j < tamaño; j++) {
                    //SE HA PULSADO EL BOTÓN INCORRECTO
                    if (botones[i][j] == e.getSource()) {
                        //---Botón Incorrecto---
                        tiempo2 = System.currentTimeMillis();
                        long tiempo = tiempo2 - tiempo1;
                        double time = tiempo / 1000;
                        System.out.println("BOTÓN INCORRECTO");
                        //Borde verde en el botón correcto
                        botonCorrecto.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                        panelCorrecto.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                        //Borde rojo en el cuadrado clicado
                        botones[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                        paneles[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                        //Avisar al usuario de que ha perdido
                        String s = "HAS ACABADO LA PARTIDA CON " + puntuacion + " PUNTOS EN "+time+" SEGUNDOS";
                        warning(s, "   BOTÓN INCORRECTO   ");
                        //Juego terminado
                        local = (CardLayout) (panelVisualizacion.getLayout());
                        //Añadir el tablero a la pantalla encima del gif con CardLayout
                        local.show(panelVisualizacion, "panelStandby");

                        //Restablecer contadores y puntuaciones
                        puntuacion = 0;
                        numNiveles = 0;
                        nivelActual = 0;
                        jugando = false;

                        //Actualizar marcador
                        actualizarMarcador(false);
                    }
                }
            }
        } catch (Exception ex) {

        }
    }
    //==========================================================================
    
    //Método para actualizar el marcador
    public void actualizarMarcador(boolean siguienteNivel) {
        
        //String que se usará para dar valor a las etiquetas de los JLabel
        String numero;
        
        //Hacer actualizaciones
        if (siguienteNivel) {
            //SE PASA AL SIGUIENTE NIVEL
            numero = (numNiveles + "");
            etiquetaValNivelesPartida.setText("00" + numero);
            numero = ((numNiveles - nivelActual) + "");
            etiquetaValNivelesRestantes.setText("00" + numero);
            numero = (nivelActual + "");
            etiquetaValNivelActual.setText("00" + numero);
            numero = (puntuacion + "");
            etiquetaValPuntuacion.setText("00" + numero);
        } else {
            //EL MARCADOR SE ACTUALIZA PORQUE LA PARTIDA HA ACABADO
            etiquetaValNivelesPartida.setText("000");
            etiquetaValNivelesRestantes.setText("000");
            etiquetaValNivelActual.setText("000");
            etiquetaValPuntuacion.setText("000");
        }

    }
    
    //Método para crear un color parecido al resto de colores del tablero
    public Color crearColor(Color original) {
        //Color inical
        Color colorC;
        //Coeficiente usado para obtener un nuevo color
        int coeficiente = 10/complejidad;
        
        //Obtener nuevo color dependiendo de la complejidad
        int r = original.getRed();      //Canal rojo del color original
        int g = original.getGreen();    //Canal verde del color original
        int b = original.getBlue();     //Canal azul del color original
        
        //Dar valor a los canales alfa
        switch (complejidad) {
            case 1:
                //Coeficiente = 10
                r += 6*coeficiente;
                g += 6*coeficiente;
                b += 6*coeficiente;
                break;
            case 2:
                //Coeficiente = 5
                r += 10*coeficiente;
                g += 10*coeficiente;
                b += 10*coeficiente;
                break;
            case 3:
                //Coeficiente = 3'33
                r += 12*coeficiente;
                g += 12*coeficiente;
                b += 12*coeficiente;
                break;
            case 4:
                //Coeficiente = 2'5
                r += 11*coeficiente;
                g += 11*coeficiente;
                b += 11*coeficiente;
                break;
            case 5:
                //Coeficiente = 2
                r += 11*coeficiente;
                g += 11*coeficiente;
                b += 11*coeficiente;
                break;
            case 6:
                //Coeficiente = 1'66
                r += 12*coeficiente;
                g += 12*coeficiente;
                b += 12*coeficiente;
                break;
            case 7:
                //Coeficiente = 1'42
                r += 11*coeficiente;
                g += 11*coeficiente;
                b += 11*coeficiente;
                break;
            case 8:
                //Coeficiente = 1'25
                r += 10*coeficiente;
                g += 10*coeficiente;
                b += 10*coeficiente;
                break;
            case 9:
                //Coeficiente = 1'111
                r += 10*coeficiente;
                g += 10*coeficiente;
                b += 10*coeficiente;
                break;
            case 10:
                //Coeficiente = 1
                r += 8*coeficiente;
                g += 8*coeficiente;
                b += 8*coeficiente;
                break;
            default:
                break;
        }
        
        //Comprobar que los valores esten en el intervalo [0,255]
        if (r > 255) {
            r = 255;
        }
        if (b > 255) {
            b = 255;
        }
        if (g > 255) {
            g = 255;
        }
        
        //Crear nuevo color
        colorC = new Color(r,g,b);
        return colorC;
    }
    
    //Método para dar valor al tamaño y a la complejidad
    public void nivelesYcomplejidad() {
        
        //---Introducir tamaño y complejidad---
        
        //Leer tamaño
        numNiveles = leerNum("INTRODUCE EL NÚMERO DE NIVELES QUE QUIERES JUGAR");
        while (numNiveles < 1 || numNiveles > 10) {
            warning("EL DATO QUE HAS INTRODUCIDO ES INCORRECTO", "NUMERO INVÁLIDO");
            numNiveles = leerNum("INTRODUCE EL NÚMERO DE NIVELES QUE QUIERES JUGAR");
        }

        //Leer complejidad
        complejidad = leerNum("INTRODUCE LA COMPLEJIDAD DEL TABLERO [1..10]");
        while (complejidad < 1 || complejidad > 10) {
            warning("EL DATO QUE HAS INTRODUCIDO ES INCORRECTO", "NUMERO INVÁLIDO");
            complejidad = leerNum("INTRODUCE LA COMPLEJIDAD DEL TABLERO [1..10]");
        }
    }
    
    //Método para crear el tablero
    public void crearTablero() {
        
        panelJuego = new JPanel();
        panelJuego.setLayout(new GridLayout(tamaño,tamaño)); 
        //Escoger un color aleatorio de la lista de colores
        r = new Random();
        int colorNum = r.nextInt(8);
        //Fila y columna aleatoria del tablero
        fila = r.nextInt(tamaño);
        columna = r.nextInt(tamaño);
        botones = new JButton[tamaño][tamaño];
        paneles = new JPanel[tamaño][tamaño];

        //Instanciar y crear paneles
        for (i = 0; i < tamaño; i++) {
            for (j = 0; j < tamaño; j++) {
                //Crear botón además del panel
                botones[i][j] = new JButton();
                paneles[i][j] = new JPanel();
                
                if ((i == fila) && (j == columna)) {
                    //Crear color con la complejidad
                    Color c = crearColor(colores[colorNum]);
                    //Boton
                    botonCorrecto = new JButton();
                    botonCorrecto.setBackground(c);
                    botonCorrecto.setText(".");
                    botonCorrecto.setForeground(c);
                    botonCorrecto.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
                    botonCorrecto.addActionListener(this);
                    //Panel
                    panelCorrecto = new JPanel();
                    panelCorrecto.setBackground(c);
                    panelCorrecto.setLayout(new BorderLayout());
                    panelCorrecto.add(botonCorrecto,BorderLayout.CENTER);                 
                    //Añadir bordes para haer mas claro el tablero
                    panelCorrecto.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
                    //Añadir el tablero al panel de juego
                    panelJuego.add(panelCorrecto);      
                } else { 
                    //Boton
                    boton = new JButton();
                    boton.setBackground(colores[colorNum]);
                    boton.setText(".");
                    boton.setForeground(colores[colorNum]);
                    boton.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
                    boton.addActionListener(this);
                    botones[i][j] = boton;
                    
                    //Panel
                    JPanel panel = new JPanel();
                    panel.setBackground(colores[colorNum]);
                    panel.setLayout(new BorderLayout());
                    panel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
                    panel.add(boton,BorderLayout.CENTER);
                    paneles[i][j] = panel;
                    //Añadir el tablero al panel de juego
                    panelJuego.add(panel);
                }
            }
        }
    }
    
    //Método para preguntar un numero mediante una ventana emergente
    private static int leerNum(String s) {
        //VARIABLES
        int t = 0;
        boolean ward;
        
        //DAR VALOR A LA VARIABLE t
        do {
            ward = true;
            try {
                t = Integer.parseInt(JOptionPane.showInputDialog(s));
            } catch (NumberFormatException e) {
                // TODO: handle exception
                JOptionPane.showMessageDialog(null, "ERROR, DATO INVÁLIDO", "ERROR",JOptionPane.WARNING_MESSAGE);
                ward = false;
            }
        } while (ward == false);
        
        //RETORNAR EL VALOR LEÍDO
        return t;
    }
    
    //Método para mandar aviso al usuario
    private static void warning(String s, String titulo) {
        JOptionPane.showMessageDialog(null, s, titulo,JOptionPane.WARNING_MESSAGE);
    }
}