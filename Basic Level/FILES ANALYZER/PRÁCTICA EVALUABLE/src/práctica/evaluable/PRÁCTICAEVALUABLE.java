/*
    AUTOR: Mario Ventura Burgos
    DNI 43223476J
    Grupo 03
    Profesor: Miquel Mascaró Portells
    Fecha: 15/02/2021
*/

package práctica.evaluable;

public class PRÁCTICAEVALUABLE { 
    
    //MÉTODO DE EJECUCUIÓN DEL PROGRAMA FINAL DE LA PRÁCTICA
    public void Principal(){ 
   
        //CREAR ENLACE CON LA CLASE 'MÉTODOS' PARA EJECUTAR SUS MÉTODOS
        MÉTODOS m = new MÉTODOS();

        //SE PIDE AL USUARIO QUE INTRODUZCA EL ARCHIVO A LEER Y SE EMPIEZA A TRATAR CON ÉL
        m.NombreFichero();
        Paraula pal = null;
        Paraula nom = m.GetNomFic(pal); //OBTENER EL NOMBRE DEL FICHERO
        
        /*COGER EL VALOR DE MAXIMO Y numpalabras PARA POSTERIORMENTE COMPROBAR QUE NO SE
        EXCEDE EL MAXIMO DE PALABRAS PERMITIDO (MAXIMO = 500)*/
        m.ExecedeMaximo(nom);
        int a = 0;
        int numpalabras = m.GetNumpalabras(a);       //MÉTODO DEFINDIDO EN LA CLASE 'MÉTODOS'
        int b = 0;
        int MAXIMO = m.GetMAXIMO(b);                 //MÉTODO DEFINDIDO EN LA CLASE 'MÉTODOS'
        LT tec = new LT();
        char usuario[];
       
        //COMENZAR A TRATAR CON EL FICHERO DE TEXTO (SI NO SE EXCEDEN LOS LIMITES PERMITIDOS)
        if (numpalabras < MAXIMO) {
            
            //LECTURA DEL FICHERO Y VISUALIZACIÓN DE CARACTERES, PALABRAS Y LINEAS
            m.LeerFicheroYMas(nom.toString());
            
            //MENÚ CON TODAS LAS OPCIONES DEL PROGRAMA
            m.Menu(nom.toString());
            
        } else {
            
            //MOSTRAR UN AVISO DE QUE SE EXCEDE EL MÁXIMO DE PALABRAS
            m.Error();
        }
    }
    
    public static void main(String[] args) {
        new PRÁCTICAEVALUABLE().Principal();
    }
    
}
