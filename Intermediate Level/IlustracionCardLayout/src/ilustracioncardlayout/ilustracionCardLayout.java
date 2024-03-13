/*
ILUSTRACIÓN UTILIZACIÓN ADMINISTRADOR DE LAYOUT CardLayout
 */
package ilustracioncardlayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Juan
 */
public class ilustracionCardLayout {
    
    private JPanel panelInterfaces, portada, interface1, interface2, interface3,
                   interface4, interface5, interface6, interface7, interface8;
                   
    JPanel[] interfaces = {interface1, interface2, interface3,
                      interface4, interface5, interface6, interface7, interface8};
    JButton[] botones;
    Color colRandom;
    JButton botonCorrecto;
    boolean nuevaPartida = false;
    boolean volver = false;
    int posRandom;
    private JFrame ventana;
    //declaración método main
    public static void main(String[] args) {
        new ilustracionCardLayout().metodoPrincipal();
    }
    
    //declaración método metodoPrincipal
    public  void metodoPrincipal() {
////////////////////////////////////////////////////////////////////////////////
//                      DECLARACIÓN CONTENEDOR                                //
//////////////////////////////////////////////////////////////////////////////// 
/////////////            DECLARACIÓN CONTENEDOR JFrame          ////////////////
        //CREACION DEL CONTENEDOR JFrame ventana
        ventana = new JFrame("ILUSTRACIÓN CardLayout"); 

        
/////////////     PANEL DE CONTENIDOS DEL CONTENEDOR JFrame     ////////////////         
        //DECLARACIÓN PANEL DE CONTENIDOS JContentPane DEL CONTENEDOR JFrame 
        //ventana
        Container panelContenidos=ventana.getContentPane();
        //ASIGNACIÓN DEL GESTOR DE LAYOUT FlowLayout AL PANEL DE CONTENIDOS
        //panelContenidos
        panelContenidos.setLayout(new BorderLayout());     
        
        


        
////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                DECLARACIÓN CONTENEDORES y COMPONENTES                      //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//////////        DECLARACIÓN CONTENEDOR JPanel  panelBotones      /////////////
////////////////////////////////////////////////////////////////////////////////
        JPanel panelBotones=new JPanel();
        //asignación administrador de Layout GridLayout
        panelBotones.setLayout(new GridLayout(1,3,2,2));
        //introducción contenedor JPanel panelBotones en el contenedor panelContenidos
        panelContenidos.add(panelBotones,BorderLayout.SOUTH);
        

//////////     DECLARACIONES Y DEFINICIONES COMPONENTES JButton    /////////////
//////////DECLARACIÓN componente JButton boton1 
        JButton boton1= new JButton("NUEVA PARTIDA");
        //INTRODUCCIÓN COMPONENTE JButton boton1 EN EL PANEL panelBotones
        panelBotones.add(boton1);
        //ASIGNACIÓN DEL GESTOR DE EVENTO gestorEvento A LA COMPONENTE JButton 
        //boton1
        boton1.addActionListener(new manipuladorEventosFuncionalidades());
        
        
        
////////////////////////////////////////////////////////////////////////////////        
//////////     DECLARACIÓN CONTENEDOR JPanel  panelInterfaces      /////////////
////////////////////////////////////////////////////////////////////////////////
        panelInterfaces=new JPanel();
        //asignación administradorde layout CardLayout
        panelInterfaces.setLayout(new CardLayout());
        
        panelContenidos.add(panelInterfaces,BorderLayout.CENTER);

 
        

////////////////////////////////////////////////////////////////////////////////
//////////        DECLARACIÓN CONTENEDOR JPanel portada        /////////////
        portada=new JPanel();
        JLabel imagen = new JLabel();
        
        imagen.setIcon(new ImageIcon("uib.gif"));
        portada.add(imagen);
        
        //INTRODUCCIÓN CONTENEDOR interface2 EN EL CONTENEDOR panelInterfaces
        //ASOCIADO AL LITERAL "INTERFACE 2"
        panelInterfaces.add(portada,"PORTADA");

////////////////////////////////////////////////////////////////////////////////
//////////       DECLARACIÓN CONTENEDOR JPanel interfaces        /////////////



for(int i=0; i<interfaces.length; i++){
    interfaces[i] = new JPanel();
    interfaces[i].setLayout(new GridLayout(i+2,i+2));
    
    botones = new JButton[(i+2)*(i+2)];
    Random colorRnd = new Random();
    int r = colorRnd.nextInt(256);
    int g = colorRnd.nextInt(256);
    int b = colorRnd.nextInt(256);
    colRandom = new Color(r,g,b);
    for(int j=0; j<botones.length; j++){
        
        botones[j] = new JButton();
        botones[j].setBackground(colRandom);
        botones[j].setText("·");
        botones[j].setForeground(colRandom);
       
        botones[j].setBorder(BorderFactory.createLineBorder(Color.WHITE,2));

        botones[j].addActionListener(new manipuladorEventosFuncionalidades());
        interfaces[i].add(botones[j]);
       
    }
    // Pintar casilla random de otro color
   // Color colorCorrecto = new Color(colRandom.getRed()+10,
                                   // colRandom.getBlue()+10,
                                   // colRandom.getGreen()+10);
    Random rnd = new Random();
    posRandom = rnd.nextInt((i+2)*(i+2));
    botonCorrecto = botones[posRandom];
 
    botonCorrecto.setText("BOTON "+i);
    botonCorrecto.setForeground(colRandom.darker());
    botonCorrecto.setBackground(colRandom.darker());
    
    panelInterfaces.add(interfaces[i],"PANEL "+(i+1));
}


   
////////////////////////////////////////////////////////////////////////////////
//                  ÚLTIMAS INTERVENCIONES CONTENEDOR JFrame                  //
////////////////////////////////////////////////////////////////////////////////  
        //DIMENSIONAMIENTO AUTOMÁTICO DEL CONTENEDOR JFrame ventana EN FUNCIÓN
        //DE LAS COMPONENTES INTRODUCIDAS EN ÉL
        ventana.pack();
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA DE WINDOWS EN EL CONTENEDOR 
        //JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800,800);
        ventana.setResizable(false);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }    

        private class manipuladorEventosFuncionalidades implements ActionListener {
        Color color;
        @Override
        public void actionPerformed(ActionEvent evento)  { 
               
                
                CardLayout local = (CardLayout)(panelInterfaces.getLayout());
                switch (evento.getActionCommand()) {
                    case "NUEVA PARTIDA":   if(!nuevaPartida || !volver){
                                                local.show(panelInterfaces, "PANEL 1");
                                                nuevaPartida = true;
                                                volver = true;
                                            }
                                                 else{
                                            JOptionPane.showMessageDialog(ventana, "PARTIDA EN CURSO");
                                            }
                    
                                           
                                            break;
                                            
                    case "BOTON 0":  
                                    local.show(panelInterfaces, "PANEL 2");
                                  
                                    nuevaPartida = true;
                                    
                                    break;
                    case "BOTON 1":  
                                    local.show(panelInterfaces, "PANEL 3");
                                    nuevaPartida = true;
                                    
                                    break;
                                    
                    case "BOTON 2":  
                                    local.show(panelInterfaces, "PANEL 4");
                                    nuevaPartida = true;
                                    
                                    break;
                   case "BOTON 3":  
                                    local.show(panelInterfaces, "PANEL 5");
                                    nuevaPartida = true;
                                    
                                    break;
                    case "BOTON 4":  
                                    local.show(panelInterfaces, "PANEL 6");
                                    nuevaPartida = true;
                                    
                                    break;
                    case "BOTON 5":  
                                    local.show(panelInterfaces, "PANEL 7");
                                    nuevaPartida = true;
                                    
                                    break;
                    case "BOTON 6":  
                                    local.show(panelInterfaces, "PANEL 8");
                                    
                                    break;
                    case "BOTON 7": 
                                    volver = false;
                                    JOptionPane.showMessageDialog(ventana, "ERES GAY - FELICIDADES");
                                    
                                    break;
                  
                                    
                    case "·": JButton boton1 = (JButton) evento.getSource();
                                        JPanel panel = (JPanel) boton1.getParent();
                                        boton1.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
//                                       Component[] botones =  panel.getComponents();
//                                                botonC.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        JOptionPane.showMessageDialog(ventana, "MALARDO");
                                         boton1.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
                                         
                                         break;
                }

            }
        }
        

        

}
