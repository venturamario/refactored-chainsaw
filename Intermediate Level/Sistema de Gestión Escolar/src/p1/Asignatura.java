/*
PRÁCTICA EVALUABLE 1

Asignatura:    Algoritmia y Estructuras de Datos
Autores:       Mario Ventura, Luis Miguel Vargas, Felip Toni Font
Fecha:         05-12-2021
*/

package p1;

//CLASE ASIGNATURA
public class Asignatura {
    
    //--------------------------------ATRIBUTOS---------------------------------
    String nombre;  //Nombre de la asignatura
    int codigo;     //Codigo asociado a la asignatura
    Asignatura siguiente;
    tipoOptativa perfil;
    Integer creditos;
    ListaEstudiantes estudiantes;
    
    //---------------------------------MÉTODOS----------------------------------
    
    //CONSTRUCOTRES
    //Vacío
    public Asignatura () {
        estudiantes = new ListaEstudiantes();
    }
    
    //Nombre
    public Asignatura(String n) {
        estudiantes = new ListaEstudiantes();
        nombre = n;
    }
    
    //Código
    public Asignatura(Integer c) {
        estudiantes = new ListaEstudiantes();
        codigo = c;
    }
    
    //Lista de estudiantes
    public Asignatura(ListaEstudiantes lista) {
        estudiantes = lista;
    }
    
    //Codigo y nombre
    public Asignatura(Integer c, String n) {
        estudiantes = new ListaEstudiantes();
        nombre = n;
        codigo = c;
    }
    
    //Codigo nombre y creditos
    public Asignatura(Integer c, String n, Integer cred) {
        estudiantes = new ListaEstudiantes();
        nombre = n;
        codigo = c;
        creditos = cred;
    }
    
    //Constructores completos para asignaturas optativas y obligatorias
    public Asignatura(int c, String n, tipoOptativa tipo, Integer creditos) {
        estudiantes = new ListaEstudiantes();
        codigo = c;
        nombre = n;
        perfil = tipo;
        this.creditos = creditos;
    }
    
    //Completo con la lista de estudiantes como parámetro
    public Asignatura(int c, String n, tipoOptativa tipo, Integer creditos, ListaEstudiantes lista) {
        estudiantes = lista;
        codigo = c;
        nombre = n;
        perfil = tipo;
        this.creditos = creditos;
    }
    
    //MÉTODOS GETTER
    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public Asignatura getSig() {
        return siguiente;
    }
    
    public tipoOptativa getPerfil() {
        return perfil;
    }
    
    public Integer getCreditos() {
        return creditos;
    }
    
    public ListaEstudiantes getListaEstudiantes() {
        return estudiantes;
    }
    
    
    //MÉTODOS SETTER
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setSig(Asignatura a) {
        siguiente = a;
    }
    
    public void setListaEstudiantes(ListaEstudiantes lista) {
        this.estudiantes = lista;
    }
    
    
    //MÉTODO toString
    @Override
    public String toString() {
        return("NOMBRE: "+nombre+", CÓDIGO: "+codigo);
    }
    
    //Eliminar los estudiantes
    public void eliminarEstudiantes() {
        //Eliminar los estudiantes de una asignatura
        estudiantes.eliminarTodos();
    }
    
    //FIN DE LA CLASE ASIGNATURA
}
