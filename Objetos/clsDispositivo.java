package Objetos;

public abstract class clsDispositivo {

    private String serial;
    private String marca;
    private float tamaño;
    private float precio;

    public clsDispositivo() {
        serial = "";
        marca = "";
        tamaño = 0;
        precio = 0;
    }

    public clsDispositivo(String serial, String marca, float tamaño, float precio) {
        this.serial = serial;
        this.marca = marca;
        this.tamaño = tamaño;
        this.precio = precio;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getTamaño() {
        return tamaño;
    }

    public void setTamaño(float tamaño) {
        this.tamaño = tamaño;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}

