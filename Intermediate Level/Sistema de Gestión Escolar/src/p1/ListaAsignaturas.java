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

//CLASE LISTA DE OBJETOS ASIGNATURA
public class ListaAsignaturas {
    
    //----------------------------------------------------------ATRIBUTOS----------------------------------------------------------
    //Objeto curso que apunta al primer elemento de la lista
    private Asignatura primero;
    //Nodo que se usará como auxiliar para poder almacenar asignaturas y asi dar valor al campo seg
    private Asignatura auxA;
    
    
    //----------------------------------------------------------MÉTODOS-----------------------------------------------------------
    //Constrcutor
    public ListaAsignaturas() {
        primero = null;
    }
    
    //Metodo para insertar una asignatura
    public void insertar(Asignatura a) {
        //Comprobar si la lista esta vacia, y de ser asi, añade el nuevo nodo como nuevo primer nodo de la lista
        if (primero == null) {
            primero = a;
            //auxA = primero;
        } else {
            //En caso contrario, insertarlo al final de la lista
            for (auxA = primero; auxA.getSig() != null; auxA = auxA.getSig()) {
            }
            auxA.setSig(a);
            auxA = auxA.getSig();
            auxA.setSig(null);
        }
    }
    
    //Metodo para comparar los campos codigo de diferentes nodos
    public boolean busquedaInsercion(int info) {
        //Nodo auxiliar
        Asignatura a = null;
        //Iteracion a lo largo de la lista de nodos
        for (auxA = primero; auxA != null; auxA = auxA.getSig()) {
            if (primero.getCodigo() == info) {
                //Generar nodo con valor de info random
                    int r = leerNum("¿QUE VALOR DE INFO QUIERES DAR AL NUEVO NODO?");
                    Asignatura nuevoA = new Asignatura(r);
                    //Meter el nodo a la izquierda del indicado
                    nuevoA.setSig(primero);
                    primero = nuevoA;
                    return true;
            } else {
                if (auxA.getCodigo() == info) {
                    //Generar nodo con valor de info random
                    int r = leerNum("¿QUE VALOR DE INFO QUIERES DAR AL NUEVO NODO?");
                    Asignatura nuevoA = new Asignatura(r);
                    //Meter el nodo a la izquierda del indicado 
                    a.setSig(nuevoA);
                    nuevoA.setSig(auxA);
                    return true;
                }
            }

            a = auxA;
        }
        return false;
    }
    
    //Buscar una asignatura en concreto a partir de su código
    public Asignatura busqueda(int codigo) {
        Asignatura a = null;
        for (auxA = primero; auxA != null; auxA = auxA.getSig()) {
            if (auxA.getCodigo() == codigo) {
                a = auxA;
                auxA = null;
                return a;
            }
        }
        return a;
    }
    
    //Método que permite saber si una asignatura esta dentro de una lista
    public boolean existe(int codigo) {
        Boolean encontrada = false;
        for (auxA = primero; auxA != null; auxA = auxA.getSig()) {
            if (auxA.getCodigo() == codigo) {
                encontrada = true;
                auxA = null;
                return encontrada;
            }
        }
        return encontrada;
    }
    
    //Metodo para insertar una nueva asignatura en la posicion dada
    public void insercionNuevaAsignatura(Asignatura a) {
        //Booleano que indica si ya se ha introducido el nuevo nodo
        boolean introducido = false;
        
        for (auxA = primero; auxA.getSig() != null; auxA = auxA.getSig()) {
            if (introducido == false) {

                if (primero.getCodigo() == a.getCodigo()) {
                    //Insertar nodo en la posicion correcta
                    a.setSig(primero.getSig());
                    primero.setSig(a);
                    introducido = true;

                } else {
                    if (auxA.getSig().getCodigo() == a.getCodigo()) {
                        //Insertar nodo en la posicion correcta
                        a.setSig(auxA.getSig());
                        auxA.setSig(a);
                        introducido = true;
                    }
                }
            }
        }
    }
    
    //Introducir una nueva asignatura en una posicion dada
    public void introducir(Asignatura a) {
        boolean introducido=false;
        
        for (auxA = primero; auxA!=null; auxA=auxA.getSig()) {
            if (!introducido) {
                
                if (primero.getCodigo() == a.getCodigo()) {
                    a.setSig(primero.getSig());
                    primero.setSig(a);
                    introducido=true;
                    
                } else {
                    if (auxA.getSig().getCodigo() == a.getCodigo()) {
                        a.setSig(auxA.getSig());
                        auxA.setSig(a);
                        introducido = true;
                    }
                }
            }
        }
    }
    
    //Metodo get Primero
    public Asignatura getPrimero() {
        return primero;
    }
    
    //Metodo para ordenar la lista de nodos
    public void ordenarLista(int tamaño) {
        //Copiar campos info de los nodos en un array de numeros enteros
        int i=0;
        int [] infos = new int[tamaño];
        for (auxA = primero; auxA.getSig()!=null; auxA=auxA.getSig()) {
            infos[i]=auxA.getCodigo();
            i++;
        }
        //Ordenar array con el metodo sort de la clase array
        infos[i]=auxA.getCodigo();
        Arrays.sort(infos); //Ordenacion ascendente del array
        //primero=null;
        
        //ORDENAR LISTA
        for (int k = 0; k < infos.length; k++) {
            for (auxA = primero; auxA.getSig() != null; auxA = auxA.getSig()) {
                if (infos[k] == auxA.getCodigo()) {
                    insertar(auxA);
                }
            }
        }
    }
    
    //Método de ordenacion con Burbuja
    public void ordenacionBurbuja(int tamaño) {
        //Arrays que se van a ordenar
        String[] nombres = new String[tamaño];
        int codigos[] = new int[tamaño];
        int creditos[] = new int[tamaño];
        tipoOptativa tipos[] = new tipoOptativa[tamaño];
        
        //Ordenación mediante el método de la burbuja
        
        //Insertar asignaturas de forma ordenada
        for (int i=0; i<nombres.length; i++) {
            Asignatura a = new Asignatura(codigos[i],nombres[i],tipos[i],creditos[i]);
            insertar(a);
        }
        
    }
    
    //Metodo para saber el tamaño de la lista
    public int getSize() {
        int contador = 0;
         for (auxA = primero; auxA != null; auxA = auxA.getSig()) {
             contador++;
         }
         return contador;
    }
    
    //ELIMINAR CURSO DE LISTA DE CURSOS A PARTIR DE SU CODIGO
    public void eliminar(int info) {
        Asignatura a = null;
        boolean eliminado=false;
        for (auxA= primero; auxA!=null; auxA=auxA.getSig()) {
            if (!eliminado) {
                if (primero.getCodigo() == info) {
                    a= primero;
                    primero = primero.getSig();
                    a.setSig(null);
                    eliminado=true;
                } else {
                    if (auxA.getSig().getCodigo() == info) {
                        a= auxA.getSig();
                        auxA.setSig(auxA.getSig().getSig());
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
        Asignatura aux;
        
        //EL STRING CAMBIA EN FUNCION DE SI ES UNA ASIGNATURA OBLIGATORIA O OPTATIVA
        for (aux = primero; aux != null; aux = aux.getSig()) {
            
            //INFORMACIÓN DE LA ASIGNATURA
            if (aux.getPerfil() == null) {
                    s = s + (aux.getNombre() + ", CÓDIGO " + aux.getCodigo() + ", OBLIGATORIA, " + aux.getCreditos() + "CRÉDITOS. ESTUDIANTES: ");
            } else {
                    s = s + (aux.getNombre() + ", CÓDIGO " + aux.getCodigo() + ", OPTATIVA, " + aux.getPerfil() + ". ESTUDIANTES: ");
            }
            
            //ESTUDIANTES DE LA ASIGNATURA
            //ListaEstudiantes listaEst = aux.getListaEstudiantes();
            //listaEst = listaEst.ordenar();
            //String x = listaEst.toString();
            s = s + aux.getListaEstudiantes().ordenar().toString();
        }
        
        //DEVOLVER EL STRING GENERADO A RAÍZ DE LA ITERACIÓN
        return s;
    }
    
    //toString 2 sin estudiantes de la asignatura
    public String toString2(ListaCursos listaC) {
        String s = "";
        Asignatura aux,aux2;
        Curso auxC;
        
        //EL STRING CAMBIA EN FUNCION DE SI ES UNA ASIGNATURA OBLIGATORIA O OPTATIVA
        for (aux = primero; aux != null; aux = aux.getSig()) {

            //INFORMACIÓN DE LA ASIGNATURA
            if (aux.getPerfil() == null) {
                s = s + (aux.getNombre() + ",CÓDIGO: " + aux.getCodigo() + ",OBLIGATORIA," + aux.getCreditos() + " CRÉDITOS | ");
                //MIRAR A QUE CURSO PERTENECE LA ASIGNATURA
                for (auxC = listaC.getPrimero(); auxC != null; auxC = auxC.getSig()) {
                    for (aux2 = auxC.getListaAsignaturas().getPrimero(); aux2 != null; aux2 = aux2.getSig()) {
                        if (aux.getCodigo() == aux2.getCodigo()) {
                            s = s + ("PERTENECE AL CURSO: " + auxC.toString2());
                        }
                    }
                }
                
            } else {
                s = s + (aux.getNombre() + ",CÓDIGO: " + aux.getCodigo() + ",OPTATIVA,TIPO " + aux.getPerfil() + " | ");
                //MIRAR A QUE CURSO PERTENECE LA ASIGNATURA
                for (auxC = listaC.getPrimero(); auxC != null; auxC = auxC.getSig()) {
                    for (aux2 = auxC.getListaAsignaturas().getPrimero(); aux2 != null; aux2 = aux2.getSig()) {
                        if (aux.getCodigo() == aux2.getCodigo()) {
                            s = s + ("PERTENECE AL CURSO: " + auxC.toString2());
                        }
                    }
                }
            }
        }
        
        //DEVOLVER EL STRING GENERADO A RAÍZ DE LA ITERACIÓN
        return s;
    }
     
    //MÉTODO PARA ELIMINAR LAS ASIGNATURAS DE LA LISTA
    public void eliminarAsignaturas() {
        //Iterar sobre la lista eliminando cada asignatura
        Asignatura a;
        for (auxA = primero; auxA != null; auxA = auxA.getSig()) {
            a = auxA;
            eliminar(a.getCodigo());
         }
    }
    
    //Eliminar estudiantes de cada asignatura
    public void eliminarEstudiantes() {
        Asignatura a;
        for (auxA = primero; auxA != null; auxA = auxA.getSig()) {
            a = auxA;
            a.eliminarEstudiantes();
         }
    }
    
    //MÉTODO PARA COMPROBAR SI UN CÓDIGO YA ESTA EN USO
    public boolean codigoUsado(int codigo) {
        //Opcion 1 Cursos, Opcion 2 Asignaturas; Opcion 3 estudiantes
        boolean usado = false;
        //Comprobar si se usa el codigo
        Asignatura aux;
        for (aux = primero; aux != null; aux = aux.getSig()) {
            if(aux.getCodigo()==codigo) {
                usado = true;
            }
        }
        return usado;
    }
    
    //MÉTODO PARA ORDENAR LA LISTA (BURBUJA)
    public ListaAsignaturas ordenar() {
        //USO DE ARRAYS PARA APLICAR MÉTODOS DE ORDENACIÓN
        int tamaño = getSize();
        Asignatura asig[] = new Asignatura[tamaño];
        int k=0;
        ListaAsignaturas lista;
        
        //ITERACIÓN DE TODA LA LISTA PARA GUARDAR LAS ASIGNATURAS
        for(auxA=primero; auxA!=null; auxA=auxA.getSig()) {
            //MIRAR DE QUE TIPO ES LA ASIGNATURA
            Asignatura a;
            if (auxA.getPerfil()==null) {
                //ES OBLIGATORIA
                a = new Asignatura(auxA.getCodigo(),auxA.getNombre(),null,auxA.getCreditos(),auxA.getListaEstudiantes());
            } else {
                //ES OPTATIVA
                a = new Asignatura(auxA.getCodigo(),auxA.getNombre(),auxA.getPerfil(),null);
            }
            a.setSig(null);
            asig[k]=a;
            k++;
        }
        auxA = null; //Reiniciar el valor por si acaso
        
        //UNA VEZ TENEMOS LAS ASIGNATURAS GUARDADOS, APLICAR ORDENACIÓN
        Asignatura aux;
        for(int x=0; x<asig.length; x++) {
            for(int y=0; y<(asig.length-1); y++) {
                //ENTEROS AUXILIARES
                int actual = asig[y].getCodigo();
                int siguiente = asig[y+1].getCodigo();
                //COMPROBACIÓN DE SI HACE FALTA REORDENAR LOS CURSOS
                if (actual > siguiente) {
                    aux = asig[y];
                    asig[y]=asig[y+1];
                    asig[y+1]=aux;
                }
            }
        }
        
        //CREAR NUEVO OBJETO LISTA A PARTIR DEL ARRAY ORDENADO
        lista = new ListaAsignaturas();
        for(int x=0; x<asig.length; x++) {
            //Inertar asignatura en la lista
            lista.insertar(asig[x]);
        }
        
        //DEVOLVER LA LISTA ORDENADA
        return lista;
    }
}
