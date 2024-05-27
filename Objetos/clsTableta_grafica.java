package Objetos;

public class clsTableta_grafica extends clsDispositivo{
    
    private String almacenamiento;
    private float peso;

    public clsTableta_grafica() {
        almacenamiento = "";
        peso = 0;
    }

    public clsTableta_grafica(String serial, String marca, float tamaño, float precio, String almacenamiento, float peso) {
        super(serial, marca, tamaño, precio);
        this.almacenamiento = almacenamiento;
        this.peso = peso;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    } 
}

