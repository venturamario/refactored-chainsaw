package Clases;

public class Videojuego {
    
    //---------------------------------ATRIBUTOS--------------------------------
    String Titulo;
    int HorasDuracion = 10;
    boolean Entregado = false;
    String Genero;
    String Compañia;
    
    //----------------------------------MÉTODOS---------------------------------
    
    //Métodos Constructores
    public Videojuego () {
    String Titulo;
    int HorasDuracion = 10;
    boolean Entregado = false;
    String Genero;
    String Compañia;
    }
    
    public Videojuego (String titulo, int horas) {
    Titulo = titulo;
    HorasDuracion = horas;
    boolean Entregado = false;
    String Genero;
    String Compañia;
    }
    
    public Videojuego (String titulo, int horas, String genero, String compañia) {
    Titulo = titulo;
    HorasDuracion = horas;
    boolean Entregado = false;
    Genero = genero;
    Compañia = compañia;
    }
    
    //Métodos Set
    public void SetTitulo(String a) {
        Titulo = a;
    }
    
    public void SetDuracion(int a) {
        HorasDuracion = a;
    }
    
    public void SetGenero(String a) {
        Genero = a;
    }
    
    public void SetCompañia(String a) {
        Compañia = a;
    }
    
    //Métodos Get
    public String GetTitulo() {
        return Titulo;
    }
    
    public int GetHoras() {
        return HorasDuracion;
    }
    
    public String GetGenero() {
        return Genero;
    }
    
    public String GetCompañia() {
        return Compañia;
    }
    
    //Método toString
    public String toString() {
        String datos;
        datos = ("TÍTULO: " +Titulo+ "\nHORAS DE DURACIÓN: " +HorasDuracion+ "\nENTREGADO: " +Entregado+
                "\nCOMPAÑÍA: " +Compañia+ "\nGÉNERO: " +Genero);
        return datos;
    }
    
}
