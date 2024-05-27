package Objetos;

public class clsEstudiante_ingenieria extends clsEstudiante {

    private int numSemestre;
    private float promedio;

    public clsEstudiante_ingenieria() {
        numSemestre = 0;
        promedio = 0;

    }

    public clsEstudiante_ingenieria(String cedula, String name, String Apellido, String telefono, int numSemestre, float promedio) {
        super(cedula, name, Apellido, telefono);
        this.numSemestre = numSemestre;
        this.promedio = promedio;
    }

    public int getNumSemestre() {
        return numSemestre;
    }

    public void setNumSemestre(int numSemestre) {
        this.numSemestre = numSemestre;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

}

