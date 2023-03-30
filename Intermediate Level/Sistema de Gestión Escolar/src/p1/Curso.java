/*
PRÁCTICA EVALUABLE 1

Asignatura:    Algoritmia y Estructuras de Datos
Autores:       Mario Ventura, Luis Miguel Vargas, Felip Toni Font
Fecha:         05-12-2021
*/

package p1;

//CLASE CURSO
public class Curso {
    
    //--------------------------------ATRIBUTOS---------------------------------
    int numAsignaturas;         //Numero de asignaturas
    String nombre;              //Nombre del curso
    int codigo;                 //Codigo asociado al curso
    Curso siguiente;            //Siguiente curso [C]-->
    tipoFP tipo;                //Tipo de fp
    cursoB cursoBachillerato;   //Tipo de curso de bachiller
    ListaAsignaturas listaA;    //Lista de asignaturas
    ListaEstudiantes listaE;    //Lista de estudiantes del curso
    
    //---------------------------------MÉTODOS----------------------------------
    
    //CONSTRUCTORES
    //Vacío
    public Curso() {
        listaA = new ListaAsignaturas();
        listaE = new ListaEstudiantes();
    }
    
    //Codigo
    public Curso(int n) {
        listaA = new ListaAsignaturas();
        listaE = new ListaEstudiantes();
        codigo = n;
    }
    
    //Nombre
    public Curso (String n) {
        listaA = new ListaAsignaturas();
        listaE = new ListaEstudiantes();
        nombre = n;
    }
    
    //Nombre y codigo
    public Curso(int c, String n) {
        listaA = new ListaAsignaturas();
        listaE = new ListaEstudiantes();
        nombre = n;
        codigo = c;
    }
    
    //Constructores completos para bach y fp
    public Curso(int c, String n, tipoFP t) {
        listaA = new ListaAsignaturas();
        listaE = new ListaEstudiantes();
        codigo = c;
        nombre = n;
        tipo = t;
    }
    public Curso(int c, String n, cursoB curso) {
        listaA = new ListaAsignaturas();
        listaE = new ListaEstudiantes();
        codigo = c;
        nombre = n;
        cursoBachillerato = curso;
    }
    
    //MÉTODOS GETTER
    public int getNumAsignaturas() {
        return numAsignaturas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public Curso getSig() {
        return siguiente;
    }
    
    public ListaAsignaturas getListaAsignaturas() {
        return listaA;
    }
    
    //MÉTODOS SETTER
    public void setNumAsignaturas(int numAsignaturas) {
        this.numAsignaturas = numAsignaturas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setSig(Curso c) {
        siguiente = c;
    }
    
    public void setListaAsignaturas(ListaAsignaturas lista) {
        listaA = lista;
    }
    
    //MÉTODO toString
    @Override
    public String toString() {
        return ("NOMBRE: "+nombre+", CÓDIGO: "+codigo+". ");
    }
    
    public String toString2() {
        String s = "";
        if(tipo==null) {
            //Es bachiller
            s = s+(nombre+", CÓDIGO "+codigo+", CURSO "+cursoBachillerato+" BACH.");
        } else {
            //Es FP
            s = s+(nombre+", CÓDIGO "+codigo+", FP DE "+tipo+".");
        }
        return s;
    }
    
    //FIN DE LA CLASE CURSO
}
