package Objetos;

public abstract class clsEstudiante {

    private String cedula;
    private String name;
    private String Apellido;
    private String telefono;


    public clsEstudiante() {

        cedula = "";
        name = "";
        Apellido = "";
        telefono = "";

    }

    public clsEstudiante(String cedula, String name, String Apellido, String telefono) {
        this.cedula = cedula;
        this.name = name;
        this.Apellido = Apellido;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}