package Clases;
public class Main {

    public static void main(String[] args) {

        //Crear objetos
        Libro a = new Libro("1234", "La vida de tu abuela", "Leo Mesi", 69);
        Libro b = new Libro("7777", "SIUUUUU", "Serresiete (CR7)", 7);
        
        //Mostrar Resultados
        System.out.println("\n");
        System.out.println(a.toString());
        System.out.println("\n");
        System.out.println(b.toString());
        System.out.println("\n");
        
        //Mostrar el que tiene más páginas
        if (a.NumPaginas > b.NumPaginas) {
            System.out.println("EL LIBRO QUE MÁS PÁGINAS TIENE ES: " + a.Titulo);
        } else {
            System.out.println("EL LIBRO QUE MÁS PÁGINAS TIENE ES: " + b.Titulo);
        }
    }
}
