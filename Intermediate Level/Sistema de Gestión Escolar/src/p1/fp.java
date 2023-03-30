package p1;

//CLASE FP, QUE ES HERENCIA DE LA CLASE CURSO
public abstract class fp extends Curso {

    //SOLO TIENE UN ATRIBUTO: EL TIPO DE FP (enum)
    tipoFP especialidad;

    //GETTER DEL ATRIBUTO ESPECIALIDAD
    public tipoFP getEspecialidad() {
        return especialidad;
    }
}
