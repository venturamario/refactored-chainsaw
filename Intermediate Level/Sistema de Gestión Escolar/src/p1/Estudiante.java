/*
PRÁCTICA EVALUABLE 1

Asignatura:    Algoritmia y Estructuras de Datos
Autores:       Mario Ventura, Luis Miguel Vargas, Felip Toni Font
Fecha:         05-12-2021
*/

package p1;

//CLASE ESTUDIANTE
public class Estudiante {
    
    //--------------------------------ATRIBUTOS---------------------------------
    String nombre;
    String dni;
    int numAsignaturas = 0;
    ListaAsignaturas asignaturas;
    Estudiante siguiente;
    
    //---------------------------------MÉTODOS----------------------------------
    
    //CONSTRUCTORES
    //Vacío
    public Estudiante() {
        asignaturas = new ListaAsignaturas();
    }
    
    //Nombre
    public Estudiante(String n) {
        asignaturas = new ListaAsignaturas();
        nombre = n;
    }
    
    //nombre y dni
    public Estudiante(String n, String DNI) {
        asignaturas = new ListaAsignaturas();
        nombre = n;
        dni = DNI;
    }
    
    public Estudiante(String n, String DNI, int a) {
        asignaturas = new ListaAsignaturas();
        nombre = n;
        dni = DNI;
        numAsignaturas = a;
    }
    
    public void setNumAsignaturas(int ano) {
        numAsignaturas = ano;
    }
    
    public void setListaAsignaturas(ListaAsignaturas lista) {
        asignaturas = lista;
    }
    
    //MÉTODOS GETTER
    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return dni;
    }
    
    public Estudiante getSig() {
        return siguiente;
    }
    
    public int getNumAsignaturas() {
        return numAsignaturas;
    }
    
    public ListaAsignaturas getListaAsignaturas() {
        return asignaturas;
    }
    
    //MÉTODOS SETTER
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public void setSig(Estudiante e) {
        siguiente = e;
    }
    
    //MÉTODO toString
    @Override
    public String toString() {
        return("NOMBRE: "+nombre+", DNI: "+dni);
    }
    
    //MÉTODO PARA ELIMINAR UNA ASIGNATURA EN CONCRETO
    public void eliminarAsignatura(int codigo) {
        getListaAsignaturas().eliminar(codigo);
    }
}
