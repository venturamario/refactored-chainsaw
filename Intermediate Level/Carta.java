/*
AUTOR:          Mario Ventura & Luis Miguel Vargas Durán
VÍDEO:          https://youtu.be/tnXSn2-Ue3E
ASIGNATURA:     Programación II
TRABAJO:        Práctica Final
FECHA:          2022
PROFESOR:       Juan Montes de Oca Durán
*/

package clases.practicafinal;

class Carta {
    private int num;                //Numero de la carta
    private Palo pal;               //Palo de la carta
    private String nombre;          //Nombre de la carta

    // Constructores
    public Carta() {
        nombre = "verde.png";
    }
    public Carta(Palo pal, int i) {
        try {
            this.num = i;
            this.pal = pal;
            nombre = (num + "_of_" + pal + ".png");
        } catch (Exception e) {
            
        }
    }

    //toString
    @Override
    public String toString() {
        String s = "";
        if (num <= 10) {
            s = ("["+num +","+pal+"]");
        } else {
            switch (num) {
                case 11:
                    s = ("[J," + pal + "]");
                    return s;
                case 12:
                    s = ("[Q," + pal + "]");
                    return s;
                case 13:
                    s = ("[K," + pal + "]");
                    return s;
            }
        }  
        return s;
    }
    
    //Getters
    public int getNum() {
        return num;
    }
    public Palo getPal() {
        return pal;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPosicionMesa() {
        //Para saber en que fila de la mesa se coloca (cada palo va en una fila)
        if (pal == pal.clubs) {
            return 0;
        } else if (pal == pal.diamonds) {
            return 1;
        }else if (pal == pal.hearts) {
            return 2;
        } else {
            return 3;
        }
    }
    
    //Setters
    public void setNombre(int f, int c) {
        String n = "";
        
        //Coger palo
        if (f == 0) {
            n += "clubs";
        } else if (f == 1) {
            n += "diamonds";
        } else if (f == 2) {
            n += "hearts";
        } else if (c == 3) {
            n += "spades";
        }
        int numero = (c+1);
        n += (numero+"_of_"+n+".png");
        nombre = n;
    }
}
