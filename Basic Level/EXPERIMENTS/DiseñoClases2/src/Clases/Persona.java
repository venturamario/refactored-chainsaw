package Clases;

public class Persona {
    
    //---------------------------------ATRIBUTOS--------------------------------
    String Nombre;
    int Edad;
    String DNI;
    Character Sexo; //H para hombre, M para mujer
    float Peso;
    float Altura;
    
    final Character SexoPredet = 'H';
    
    //----------------------------------MÉTODOS---------------------------------
    
    //Construcores    
    public Persona() {
        Persona p1 = new Persona("", 0, "", SexoPredet, 0, 0);
    }
    
    public Persona (String n, int e, Character s) {
        Nombre = n;
        Edad = e;
        Sexo = s;
        
        Persona p1 = new Persona(n, e, "", s, 0, 0);
    }
    
    public Persona (String n, int e, String dni, Character s, float p, float a) {
        Nombre = n;
        Edad = e;
        DNI = dni;
        Sexo = s;
        Peso = p;
        Altura = a;
        
        Persona p1 = new Persona(n, e, dni, s, p, a);
    }
    
    //Crear Objeto
    Persona p1 = new Persona();
    
    //Métodos Set
    public void SetNombre(String n) {
        Nombre = n;
    }
    public void SetEdad(int e) {
        Edad = e;
    }
    public void SetSexo(Character s) {
        Sexo = s;
    }
    public void SetPeso(float p) {
        Peso = p;
    }
    public void SetAltura (float a) {
        Altura = a;
    }
      
    
    //Método CalcularIMC
    float IMC;
    public int CalcularIMC() {
        int resultado = 0;
        IMC = (Peso/(Altura*Altura));
        if (IMC < 20) {
            resultado = -1;
        } else if ((IMC >= 20) && (IMC <= 25)) {
            resultado = 0;
        } else if (IMC > 25) {
            resultado = 1;
        }
        
        return resultado;
    }
    
    //Método esMayorDeEdad
    public boolean esMayorDeEdad() {
        boolean MayorDeEdad = false;
        if (Edad >= 18) {
            MayorDeEdad = true;
        }
        return MayorDeEdad;
    }
    
    //Método comprobarSexo
    public boolean comprobarSexo(Character s) {
        boolean correcto = false;
        if ((s == 'H') || (s == 'M')) {
            correcto = true;
        }
        //Si el sexo no es correcto, será H
        if (correcto == false) {
            s = 'H';
        }
        //Mostrar si el sexo introducido es correcto (true o false)
        return correcto;
    }
    
    //Método toString
    @Override
    public String toString() {
        String informacion;
        
        //Mostrar información
        String n = p1.Nombre;
        int e = p1.Edad;
        String dni = p1.DNI;
        Character s = p1.Sexo;
        float p = p1.Peso;
        float a = p1.Altura;
        
        informacion = ("Nombre: " +n+ "\nEdad: " +e+ "\nDNI: " +dni+ "\nSexo: " +s+ "\nPeso: " +p+ "\nAltura: " +a);
        return informacion;
    }
    
}
