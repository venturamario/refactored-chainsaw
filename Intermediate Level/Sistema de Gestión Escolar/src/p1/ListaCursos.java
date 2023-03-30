/*
PRÁCTICA EVALUABLE 1

Asignatura:    Algoritmia y Estructuras de Datos
Autores:       Mario Ventura, Luis Miguel Vargas, Felip Toni Font
Fecha:         05-12-2021
*/

package p1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ListaCursos {
    
    //----------------------------------------------------------ATRIBUTOS----------------------------------------------------------
    //Objeto curso que apunta al primer elemento de la lista
    private Curso primero;
    //Nodo que se usará como auxiliar para poder almacenar nodos y asi dar valor al campo seg
    private Curso auxCurso;
    
    
    
    //----------------------------------------------------------MÉTODOS-----------------------------------------------------------
    //Constrcutor
    public ListaCursos() {
        primero = null;
    }
    
    //Metodo para insertar un curso
    public void insertar(Curso c) {
        
        
        //Comprobar si la lista esta vacia, y de ser asi, añade el nuevo nodo como nuevo primer nodo de la lista
        if (primero == null) {
            primero = c;
            c.setSig(null);
        } else {
            //En caso contrario, insertarlo al final de la lista
            for (auxCurso = primero; auxCurso.getSig()!=null; auxCurso=auxCurso.getSig()) {
            }
            auxCurso.setSig(c);
            auxCurso=auxCurso.getSig();
            auxCurso.setSig(null);
            }
        }
    
    //Metodo para imprimir una lista con gráficos
    public void imprimirGraficamente() {
        Curso aux;
        int contador = 1;
        for (aux = primero; aux != null; aux = aux.getSig()) {
            
            contador++;
        }
        System.out.println("\n");
    }
    
    //Metodo para comparar los campos info de diferentes nodos
    public boolean busquedaInsercion(int info) {
        //Nodo auxiliar
        Curso c = null;
        //Iteracion a lo largo de la lista de nodos
        for (auxCurso = primero; auxCurso != null; auxCurso = auxCurso.getSig()) {
            if (primero.getCodigo() == info) {
                //Generar nodo con valor de info random
                    int r = leerNum("¿QUE VALOR DE INFO QUIERES DAR AL NUEVO NODO?");
                    Curso nuevoCurso = new Curso(r);
                    //Meter el nodo a la izquierda del indicado
                    nuevoCurso.setSig(primero);
                    primero = nuevoCurso;
                    return true;
            } else {
                if (auxCurso.getCodigo() == info) {
                    //Generar nodo con valor de info random
                    int r = leerNum("¿QUE VALOR DE INFO QUIERES DAR AL NUEVO NODO?");
                    Curso nuevoCurso = new Curso(r);
                    //Meter el nodo a la izquierda del indicado 
                    c.setSig(nuevoCurso);
                    nuevoCurso.setSig(auxCurso);
                    return true;
                }
            }

            c = auxCurso;
        }
        return false;
    }
    
    //Buscar un curso en concreto a partir de su código
    public Curso busqueda(int info) {
        Curso c = null;
        for (auxCurso = primero; auxCurso != null; auxCurso = auxCurso.getSig()) {
            if (auxCurso.getCodigo() == info) {
                c = auxCurso;
                return c;
            }
        }
        return c;
    }
    
    //Metodo para insertar el nuevo nodo en la posicion dada
    public void insercionNuevoNodo(int info) {
        //Nuevo nodo
        Curso añadido = new Curso(info);
        //Booleano que indica si ya se ha introducido el nuevo nodo
        boolean introducido = false;
        
        for (auxCurso = primero; auxCurso != null; auxCurso = auxCurso.getSig()) {
            if (introducido == false) {

                if (primero.getCodigo() == info) {
                    //Insertar nodo en la posicion correcta
                    añadido.setSig(primero.getSig());
                    primero.setSig(añadido);
                    introducido = true;

                } else {
                    if (auxCurso.getSig().getCodigo() == info) {
                        //Insertar nodo en la posicion correcta
                        añadido.setSig(auxCurso.getSig());
                        auxCurso.setSig(añadido);
                        introducido = true;
                    }
                }
            }
        }
    }
    
    //Introducir un nuevo Curso
    public void introducir(int info) {
        Curso c= new Curso(info);
        boolean introducido=false;
        
        for (auxCurso = primero; auxCurso!=null; auxCurso=auxCurso.getSig()) {
            if (!introducido) {
                
                if (primero.getCodigo() == info) {
                    c.setSig(primero.getSig());
                    primero.setSig(c);
                    introducido=true;
                    
                } else {
                    if (auxCurso.getSig().getCodigo() == info) {
                        c.setSig(auxCurso.getSig());
                        auxCurso.setSig(c);
                        introducido = true;
                    }
                }
            }
        }
    }
    
    //Metodo get Primero
    public Curso getPrimero() {
        return primero;
    }
    
    //Metodo para saber el tamaño de la lista
    public int getSize() {
        int contador = 0;
         for (auxCurso = primero; auxCurso != null; auxCurso = auxCurso.getSig()) {
             contador++;
         }
         return contador;
    }
    
    //ELIMINAR CURSO DE LISTA DE CURSOS
    public void eliminar(int info) {
        Curso a=null;
        boolean eliminado=false;
        for (auxCurso= primero; auxCurso!=null; auxCurso=auxCurso.getSig()) {
            if (!eliminado) {
                if (primero.getCodigo() == info) {
                    a= primero;
                    primero = primero.getSig();
                    a.setSig(null);
                    eliminado=true;
                } else {
                    if (auxCurso.getSig().getCodigo() == info) {
                        a= auxCurso.getSig();
                        auxCurso.setSig(auxCurso.getSig().getSig());
                        a.setSig(null);
                        eliminado=true;
                    }
                }
            }
        }
    }
    
    //LEER NUMERO PARA INTRODUCIR COMO CÓDIGO
    private int leerNum(String s) {
        System.out.println(s);
        System.out.print("NUMERO ----> ");
        //Valor que introducirá el usuario
        Integer usuario = null;
        
        try {
            
            //Leer lo que el usuario introduce
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String linea = in.readLine();
            usuario = Integer.parseInt(linea);
            
        } catch (Exception e) {
           System.out.println("SE HA PRODUCIDO UN ERROR AL INTRODUCIR EL NUMERO");
        }
        return usuario;
    }
    
    //MÉTODO toString
    @Override
    public String toString() {
        String s = "";
        Curso aux;
        int contador = 1;
        for (aux = primero; aux != null; aux = aux.getSig()) {
            
            s = s +("NOMBRE: "+aux.getNombre()+", CÓDIGO: "+aux.getCodigo()+"---->");
            contador++;
        }
        return s;
    }
    
    //MÉTODO PARA COMPROBAR SI UN CÓDIGO YA ESTA EN USO
    public boolean codigoUsado(int codigo) {
        //Opcion 1 Cursos, Opcion 2 Asignaturas; Opcion 3 estudiantes
        boolean usado = false;
        //Comprobar si se usa el codigo
        Curso aux;
        for (aux = primero; aux != null; aux = aux.getSig()) {
            if(aux.getCodigo()==codigo) {
                return true;
            }
        }
        return usado;
    }
    
}
