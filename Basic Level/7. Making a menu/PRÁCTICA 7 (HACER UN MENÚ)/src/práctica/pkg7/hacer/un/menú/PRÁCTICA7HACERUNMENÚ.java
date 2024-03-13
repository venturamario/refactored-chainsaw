package práctica.pkg7.hacer.un.menú;
public class PRÁCTICA7HACERUNMENÚ {

    public void inicio () {

        //DECLARAR VARIABLES Y PONER LT
        LT tec = new LT();
        Character a = 0;
        Character b = 0;
        Character c = 0;
        Character m = 0;
        Character s = 0;
        Character usu;

        //HACER PROCESO DE SELECCION DE VARIABLE
        System.out.println("ESCOGE UNA OPCIÓN DEL MENÚ (NO ENGAÑAR)");
        System.out.println("'a' --> 'Altas'");
        System.out.println("'b' --> 'Bajas'");
        System.out.println("'c' --> 'Consultas'");
        System.out.println("'m' --> 'Modificaciones'");
        System.out.println("'s' --> 'Salir'");

        usu = tec.llegirCaracter();
        if ((usu != 'a') && (usu != 'b') && (usu != 'c') && (usu != 'm') && (usu != 's')); {
        System.out.println("ESCRIBA BIEN CONCHAESUMARE");
        }
        
     
        if (null != usu) switch (usu) {
            case 'a':
                System.out.println ("----VOY A HACER UN ALTA----");
                break;
            case 'b':
                System.out.println ("----VOY A DARTE DE BAJA----");
                break;
            case 'c':
                System.out.println ("----VOY A HACER UNA CONSULTA----");
                break;
            case 'm':
                System.out.println ("----VOY A HACER UNA MODIFICACIÓN----");
                break;
            case 's':
                System.out.println ("----VOY A SALIR, NOS VEMOS COMPADRE ;)----");
                break;
            default:
                break;
        } 
        
        
    }
   
    public static void main (String[] args) {
        (new PRÁCTICA7HACERUNMENÚ()).inicio();
    }
}
