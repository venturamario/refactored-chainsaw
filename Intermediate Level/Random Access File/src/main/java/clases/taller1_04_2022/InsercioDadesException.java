/*
AUTOR: Mario Ventura Burgos
FECHA: 04-2022
ASIGNATURA: Programación II
TRABAJO: Programa de gestión de ficheros de albumes con votos
*/

package clases.taller1_04_2022;

//========================================================
//CLASE QUE HEREDA DE 'EXCEPTION' Y PERMITE LA CREACIÓN
//DE EXCEPCIONES PERSONALIZADAS QUE SE DARÁN EN CASO
//DE QUE UN USUARIO INTRODUZCA UN DATO ERRÓNEO
//========================================================

public class InsercioDadesException extends Exception {
    
    //Constructores
    public InsercioDadesException() {
        //Vacío
    }
    public InsercioDadesException(String s) {
        //Llamar al constructor de la clase padre (clase Exception de Java)
        super(s);
    }
 
}