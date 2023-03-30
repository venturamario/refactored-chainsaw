/*
PRÁCTICA EVALUABLE 1

Asignatura:    Algoritmia y Estructuras de Datos
Autores:       Mario Ventura, Luis Miguel Vargas, Felip Toni Font
Fecha:         05-12-2021
*/

package p1;

//CLASE LISTA DE OBJETOS ESTUDIANTE

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ListaEstudiantes {
    
    //----------------------------------------------------------ATRIBUTOS----------------------------------------------------------
    //Objeto curso que apunta al primer elemento de la lista
    private Estudiante primero;
    //Nodo que se usará como auxiliar para poder almacenar nodos y asi dar valor al campo seg
    private Estudiante auxE;
    
    
    
    //----------------------------------------------------------MÉTODOS-----------------------------------------------------------
    //Constrcutor
    public ListaEstudiantes() {
        primero = null;
    }
    
    //Metodo para insertar un estudiante
    public void insertar(Estudiante e) {
        e.setNumAsignaturas(e.getNumAsignaturas() + 1);
        //Comprobar si la lista esta vacia, y de ser asi, añade el nuevo nodo como nuevo primer nodo de la lista
        if (primero == null) {
            primero = e;
            e.setSig(null);
        } else {
            //En caso contrario, insertarlo al final de la lista
            for (auxE = primero; auxE.getSig()!=null; auxE=auxE.getSig()) {
            }
            auxE.setSig(e);
            auxE=auxE.getSig();
            auxE.setSig(null);
        }
    }
    
    //Buscar una asignatura en concreto a partir de su código
    public boolean busqueda(String dni) {
        //Booleano que indica si se ha encontrado un nodo con el mismo valor de info
        boolean encontrado = false;
        for (auxE = primero; auxE != null; auxE = auxE.getSig()) {
            if (auxE.getDNI() == dni) {
                return true;
            }
        }
        return false;
    }
    
    //Metodo para insertar una nueva asignatura en la posicion dada
    public void insercionNuevoEstudiante(Estudiante e) {
        //Booleano que indica si ya se ha introducido el nuevo nodo
        boolean introducido = false;
        
        for (auxE = primero; auxE != null; auxE = auxE.getSig()) {
            if (introducido == false) {

                if (primero.getDNI() == e.getDNI()) {
                    //Insertar nodo en la posicion correcta
                    e.setSig(primero.getSig());
                    primero.setSig(e);
                    introducido = true;

                } else {
                    if (auxE.getSig().getDNI() == e.getDNI()) {
                        //Insertar nodo en la posicion correcta
                        e.setSig(auxE.getSig());
                        auxE.setSig(e);
                        introducido = true;
                    }
                }
            }
        }
    }
    
    //Introducir un nuevo Curso
    public void introducir(Estudiante e) {
        boolean introducido=false;
        
        for (auxE = primero; auxE!=null; auxE=auxE.getSig()) {
            if (!introducido) {
                
                if (primero.getDNI() == e.getDNI()) {
                    e.setSig(primero.getSig());
                    primero.setSig(e);
                    introducido=true;
                    
                } else {
                    if (auxE.getSig().getDNI() == e.getDNI()) {
                        e.setSig(auxE.getSig());
                        auxE.setSig(e);
                        introducido = true;
                    }
                }
            }
        }
    }
    
    //Metodo get Primero
    public Estudiante getPrimero() {
        return primero;
    }
    
    //Metodo para saber el tamaño de la lista
    public int getSize() {
        int contador = 0;
         for (auxE = primero; auxE != null; auxE = auxE.getSig()) {
             contador++;
         }
         return contador;
    }
    
    //ELIMINAR ESTUDIANTE
    public void eliminar(String dni) {
        Estudiante e = null;
        boolean eliminado=false;
        for (auxE= primero; auxE!=null; auxE=auxE.getSig()) {
            if (!eliminado) {
                if (primero.getDNI() == dni) {
                    e = primero;
                    primero = primero.getSig();
                    e.setSig(null);
                    eliminado=true;
                } else {
                    if (auxE.getSig().getDNI() == dni) {
                        e = auxE.getSig();
                        auxE.setSig(auxE.getSig().getSig());
                        e.setSig(null);
                        eliminado=true;
                    }
                }
            }
        }
    }
    
    //METODO PARA ELIMINAR A TODOS LOS ESTUDIANTES
    public void eliminarTodos() {
        Estudiante e = null;
        //Iterar toda la lista y eliminar a todos los estudiantes
        for (auxE = primero; auxE!=null; auxE=auxE.getSig()) {
            //Eliminar toda la puta lista de los cojones hostia ya estoy hasta el putisimo nabo
            if (auxE == primero) {
                e = primero;
                primero = primero.getSig();
                e.setSig(null);
            } else {
                e = auxE;
                e.setSig(null); 
            }
            //Ale a tomar por culo
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
        Estudiante aux;
        
        //ITERACIÓN EN TODA LA LISTA
        for (aux = primero; aux != null; aux = aux.getSig()) {
            s = s +(aux.getNombre()+"-"+aux.getDNI()+", ");
        }
        return s;
    }
   
    //MÉTODO PARA COMPROBAR SI UN CÓDIGO YA ESTA EN USO
    public boolean dniUsado(String dni) {
        //Opcion 1 Cursos, Opcion 2 Asignaturas; Opcion 3 estudiantes
        boolean usado = false;
        //Comprobar si se usa el codigo
        Estudiante aux;
        for (aux = primero; aux != null; aux = aux.getSig()) {
            if(aux.getDNI() == dni) {
                return true;
            }
        }
        return usado;
    }
    
    //MÉTODO PARA ORDENAR LA LISTA (BURBUJA)
    public ListaEstudiantes ordenar() {
        //USO DE ARRAYS PARA APLICAR MÉTODOS DE ORDENACIÓN
        int tamaño = getSize();
        Estudiante asig[] = new Estudiante[tamaño];
        int k=0;
        ListaEstudiantes lista;
        
        //ITERACIÓN DE TODA LA LISTA PARA GUARDAR LOS ESTUDIANTES
        for(auxE=primero; auxE!=null; auxE=auxE.getSig()) {
            //MIRAR DE QUE TIPO ES LA ASIGNATURA
            Estudiante e;
            e = new Estudiante(auxE.getNombre(), auxE.getDNI(),auxE.getNumAsignaturas());
            e.setSig(null);
            asig[k]=e;
            k++;
        }
        auxE = null; //Reiniciar el valor por si acaso
        
        //UNA VEZ TENEMOS LOS CURSOS GUARDADOS, APLICAR ORDENACIÓN
        Estudiante aux;
        for(int x=0; x<asig.length; x++) {
            for(int y=0; y<(asig.length-1); y++) {
                //ENTEROS AUXILIARES
                String actual = asig[y].getNombre();
                String siguiente = asig[y+1].getNombre();
                //COMPROBACIÓN DE SI HACE FALTA REORDENAR LOS CURSOS
                if (actual.compareTo(siguiente) > 0) {
                    aux = asig[y];
                    asig[y]=asig[y+1];
                    asig[y+1]=aux;
                }
            }
        }
        
        //CREAR NUEVO OBJETO LISTA A PARTIR DEL ARRAY ORDENADO
        lista = new ListaEstudiantes();
        for(int x=0; x<asig.length; x++) {
            lista.insertar(asig[x]);
        }
        
        //DEVOLVER LA LISTA ORDENADA
        return lista;
    }
}
