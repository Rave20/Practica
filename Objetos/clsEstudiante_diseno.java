package Objetos;

public class clsEstudiante_diseno extends clsEstudiante {

    private String modalida;
    private int cantAsig;

    public clsEstudiante_diseno() {
        modalida = "";
        cantAsig = 0;
    }

    public clsEstudiante_diseno(String cedula, String name, String Apellido, String telefono, String modalida, int cantAsig) {
        super(cedula, name, Apellido, telefono);
        this.modalida = modalida;
        this.cantAsig = cantAsig;
    }

    public String getModalida() {
        return modalida;
    }

    public void setModalida(String modalida) {
        this.modalida = modalida;
    }

    public int getCantAsig() {
        return cantAsig;
    }

    public void setCantAsig(int cantAsig) {
        this.cantAsig = cantAsig;
    }

}
