/*
CLASE Cliente
*/

package entrega_15_03_cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class Cliente implements Serializable{
    //ATRIBUTOS
    private int codigo;
    private String nombre;
    private String DNI;
    private String direccion;
    private int edad;
    private String mail;
    private int telefono;
    //atributo objeto centinela
    private static final Cliente CENTINELA = new Cliente(-1,"","","",0,"",0);
            
    //CONSTRUCTORES
    //constructor vacio
    public Cliente (){
        codigo = 0;
    }
    //constructor
    public Cliente(int cod, String nom, String nif, String dir, int e, String m, int telf){
        codigo = cod;
        nombre = nom;
        DNI = nif;
        direccion = dir;
        edad = e;
        mail = m;
        telefono = telf;
    }
    
    //METODOS
    //metodos getters y setters
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getMail() {
        return mail;
    }
   public void setMail(String mail) {
        this.mail = mail;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    //metodo para la lectura de objetos cliente por teclado
    public void lectura(){
        try{
            System.out.println("DATOS DEL CLIENTE: \n");
            codigo = leerNum("Introduce un codigo numerico: ");
            nombre = leerCadena("Introduce un nombre: ");
            DNI = leerCadena("Introduce el DNI: ");
            direccion = leerCadena("Introduce su direccion: ");
            edad = leerNum("Introduzca su edad: ");
            mail = leerCadena("Introduce su correo electronico: ");
            telefono = leerNum("Introduce su numero de telefono: ");
        }catch (Exception e){
            System.out.println("ERROR DE LECTURA"+e.toString());
        }    
    }
    
    //metodos complementarios al metodo lectura
    //lectura de datos primitivos:
    public static String leerCadena(String s) throws IOException {
        String nombre = null;
        System.out.print(s);
        //Se lee lo que se introduce por teclado
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nombre = br.readLine();
        return nombre;
    }
    public static int leerNum(String s) throws IOException {
        System.out.print(s);
        //Lectura de datos de tipo primitivo en Java
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Lectura
        String linea = br.readLine();
        //Parse Int
        int num = Integer.parseInt(linea);
        //Devolver entero
        return num;
    }
    
    //metodo toString
    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nombre=" + nombre + ", DNI=" + DNI + ", direccion=" + direccion + ", edad=" + edad + ", mail=" + mail + ", telefono=" + telefono + '}';
    }
    
    //metodo booleano para verificar si un objeto cliente es el CENTINELA
    public boolean esCentinela(){
        return codigo == CENTINELA.codigo;
    }
    
    //metodo que devuelve el objeto CENTINELA
    public static Cliente getCentinela(){
        return CENTINELA;
    }
}
