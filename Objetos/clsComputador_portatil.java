package Objetos;

public class clsComputador_portatil extends clsDispositivo {

    private String sistemaOperativo;
    private String procesador;

    public clsComputador_portatil() {

        sistemaOperativo = "";
        procesador = "";
    }

    public clsComputador_portatil(String serial, String marca, float tamaño, float precio, String sistemaOperativo, String procesador) {
        super(serial, marca, tamaño, precio);
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

}

