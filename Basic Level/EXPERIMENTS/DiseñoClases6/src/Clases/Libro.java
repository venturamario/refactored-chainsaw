package Clases;

public class Libro {
    
    //ATRIBUTOS
    String ISBN;
    String Titulo;
    String Autor;
    int NumPaginas;
    
    //MÉTODOS
    
    //Métodos Constructores
    public Libro () {
    String ISBN;
    String Titulo;
    String Autor;
    int NumPaginas;
    }
    
    public Libro (String a, String b, String c, int d) {
    ISBN = a;
    Titulo = b;
    Autor = c;
    NumPaginas = d;
    }
    
    //Métodos Set
    public void SetTitulo(String a) {
        Titulo = a;
    }
    
    public void SetISBN(String a) {
        ISBN = a;
    }
    
    public void SetAutor(String a) {
        Autor = a;
    }
    
    public void SetNumPaginas(int a) {
        NumPaginas = a;
    }
    
    //Métodos Get
    public String GetISBN(Libro a) {
        return a.ISBN;
    }
    
    public String GetAutor() {
        return Autor;
    }
    
    public String GetTitulo() {
        return Titulo;
    }
    
    public int GetNumPaginas() {
        return NumPaginas;
    }
    
    //Método toString
    public String toString() {
        String datos;
        datos = ("ISBN: " +ISBN+ "\nTÍTULO: " +Titulo+ "\nAUTOR: " +Autor+ "\nNÚMERO DE PÁGINAS: " +NumPaginas);
        return datos;
    }
    
}
