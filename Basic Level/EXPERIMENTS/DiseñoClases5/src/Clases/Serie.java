package Clases;

public class Serie {
    
    //---------------------------------ATRIBUTOS--------------------------------
    String Titulo;
    int NumTemporadas = 3;
    boolean Entregado = false;
    String Genero;
    String Creador;
    
    //----------------------------------MÉTODOS---------------------------------
    
    //Métodos Constructores
    public Serie () {
    String Titulo;
    NumTemporadas = 3;
    Entregado = false;
    String Genero;
    String Creador;
    }
    
    public Serie(String titulo, String creador) {
    Titulo = titulo;
    NumTemporadas = 3;
    Entregado = false;
    String Genero;
    Creador = creador;
    }
    
    public Serie(String titulo, int numero, String creador, String genero) {
    Titulo = titulo;
    NumTemporadas = numero;
    Entregado = false;
    Genero = genero;
    Creador = creador;
    }
    
    //Métodos Get
    public String GetTitulo() {
        return Titulo;
    }
    
    public String GetCreador() {
        return Creador;
    }
    
    public String GetGenero() {
        return Genero;
    }
    
    public int GetNumTemporadas() {
        return NumTemporadas;
    }
    
    //Métodos Set
    public void SetTitulo(String a) {
        Titulo = a;
    }
    
    public void SetNumTemporadas(int a) {
        NumTemporadas = a;
    }
    
    public void SetGenero(String a) {
        Genero = a;
    }
    
    public void SetCreador(String a) {
        Creador = a;
    }
    
    //Método toString
    public String toString() {
        String datos;
        datos = ("TÍTULO: " +Titulo+ "\nNÚMERO DE TEMPORADAS: " +NumTemporadas+ "\nENTREGADO: " +Entregado+
                "\nGÉNERO: " +Genero+ "\nCREADOR: " +Creador);
        return datos;
    }
    
}
