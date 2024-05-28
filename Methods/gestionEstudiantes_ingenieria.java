package Methods;

import Objetos.clsEstudiante_ingenieria;
import Objetos.clsComputador_portatil;
import javax.swing.JOptionPane;

public class gestionEstudiantes_ingenieria {

    //Declaración de variables globales
    String cadena_ing;
    String auxcadena_ing;
    boolean banderita_ing;
    clsEstudiante_ingenieria[] vecEstudiante_ing;
    clsEstudiante_ingenieria[] auxvecEstudiante_ing;
    clsComputador_portatil[] vecComputador;
    clsComputador_portatil[] auxvecComputador;
    int tamVector;

    // Método para establecer el tamaño de los vectores según la entrada del usuario y retornar el tamaño
    public int establecerTamano() {
        tamVector = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuantos prestamos desea registrar: "));
        return tamVector;
    }

    //constructor
    public gestionEstudiantes_ingenieria() {
        cadena_ing = "";
        auxcadena_ing = "";
        banderita_ing = false;
        tamVector = 0;

    }

    //CRUD
    //Crear(Registro)
    public String CreatedPrestamo_ing() {

        int tamanoVec = establecerTamano();

        vecEstudiante_ing = new clsEstudiante_ingenieria[tamanoVec];
        vecComputador = new clsComputador_portatil[tamanoVec];

        for (int i = 0; i < vecEstudiante_ing.length; i++) {

            String cedula;
            boolean cedulaRepetida = false;
            JOptionPane.showMessageDialog(null, "Datos Estudiante");
            do {
                cedula = JOptionPane.showInputDialog("¿Cuál es la cedula del estudiante?");

                // Verificar si la cédula ya existe en el arreglo
                for (int j = 0; j < i; j++) {
                    if (vecEstudiante_ing[j].getCedula().equals(cedula)) {
                        cedulaRepetida = true;
                        JOptionPane.showMessageDialog(null, "La cedula ya está registrada, por favor ingrese otra.");
                        break;
                    }
                }

                // Si la cédula no está repetida, salir del bucle
                if (!cedulaRepetida) {
                    break;
                }

            } while (true);

            vecEstudiante_ing[i] = new clsEstudiante_ingenieria(cedula,
                    JOptionPane.showInputDialog("¿Cual es el nombre del estudiante"),
                    JOptionPane.showInputDialog("¿Cual es el Apellido del estudiante"),
                    JOptionPane.showInputDialog("¿Cual es el telefono del estudiante"),
                    Integer.parseInt(JOptionPane.showInputDialog("¿Semestre Actualmente cursado?")),
                    Float.parseFloat(JOptionPane.showInputDialog("¿Cual es su Promedio Acumulado?")));

            JOptionPane.showMessageDialog(null, "Datos Computador");
            vecComputador[i] = new clsComputador_portatil(JOptionPane.showInputDialog("Ingrese el Serial del Computador"),
                    JOptionPane.showInputDialog("Ingrese la Marca del Computador"),
                    Float.parseFloat(JOptionPane.showInputDialog("Ingrese tamaño del computador")),
                    Float.parseFloat(JOptionPane.showInputDialog("Ingrese Precio del computador")),
                    JOptionPane.showInputDialog("Selecione Sistema Operativo :\n"
                            + "Windows 7\n"
                            + "Windows 10\n"
                            + "Windows 11\n"
                            + "Ingrese el nombre como se ve en pantalla"),
                    JOptionPane.showInputDialog("Selecione Procesador:\n"
                            + "AMD Ryzen\n"
                            + "Intel Core i5\n"
                            + "Ingrese el nombre como se ve en pantalla"));

        }
        return "Datos guardados con éxito";
    }

    //Buscar registro
    public String searchPrestamo_ing(String cedula) {
        clsEstudiante_ingenieria objEstu = new clsEstudiante_ingenieria();
        clsComputador_portatil objCompu = new clsComputador_portatil();
        cadena_ing = "Registro de Prestamo \n";

            for (int i = 0; i < vecEstudiante_ing.length; i++) {
                objEstu = vecEstudiante_ing[i];
                objCompu = vecComputador[i];

                if (objEstu.getCedula().equalsIgnoreCase(cedula) || objCompu.getSerial().equalsIgnoreCase(cedula)) {

                    cadena_ing += "Cedula: " + vecEstudiante_ing[i].getCedula() + "\n"
                            + "Nombre: " + vecEstudiante_ing[i].getName() + "\n"
                            + "Apellido: " + vecEstudiante_ing[i].getApellido() + "\n"
                            + "Telefono: " + vecEstudiante_ing[i].getTelefono() + "\n"
                            + "Semestre: " + vecEstudiante_ing[i].getNumSemestre() + "\n"
                            + "Promedio Acumulado: " + vecEstudiante_ing[i].getPromedio() + "\n"
                            + "Serial: " + vecComputador[i].getSerial() + "\n"
                            + "Marca: " + vecComputador[i].getMarca() + "\n"
                            + "Tamaño: " + vecComputador[i].getTamaño() + "\n"
                            + "Precio: " + vecComputador[i].getPrecio() + "\n"
                            + "Sistema Operativo: " + vecComputador[i].getSistemaOperativo() + "\n"
                            + "Procesador: " + vecComputador[i].getProcesador() + "\n";

                    banderita_ing = true;
                }
            }

            if (banderita_ing) {
                return cadena_ing;
            } else {
                return "No se encontró el registro con el ID especificado";
            }

    }

    //Modificar Registro
    public String UpdatePrestamo_ing(String cedula) {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("Selecione que datos necesita actualizar:\n"
                + "1. Estudiante\n"
                + "2. Computador\n"));
        switch (opc) {
            case 1:
                for (int i = 0; i < vecEstudiante_ing.length; i++) {
                    if (vecEstudiante_ing[i].getCedula().equalsIgnoreCase(cedula) || vecComputador[i].getSerial().equalsIgnoreCase(cedula)) {
                        updateEstudiante(vecEstudiante_ing[i]);
                        banderita_ing = true;
                        break;
                    } 
                }
                break;
            case 2:
                for (int i = 0; i < vecEstudiante_ing.length; i++) {
                    if (vecEstudiante_ing[i].getCedula().equalsIgnoreCase(cedula) || vecComputador[i].getSerial().equalsIgnoreCase(cedula)) {
                        updateComputador(vecComputador[i]);
                        banderita_ing = true;
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Cedula o Serial no encontrado");
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
        return "Se Actualizo correctamente";
    }

    private clsEstudiante_ingenieria updateEstudiante(clsEstudiante_ingenieria objEstIng) {
        while (JOptionPane.showConfirmDialog(null, "¿Desea cambiar un dato?") == JOptionPane.YES_NO_OPTION) {

            switch (JOptionPane.showInputDialog(
                    "¿Qué dato desea modificar para el estudiante?\n"
                    + "1. Nombre\n"
                    + "2. Apellido\n"
                    + "3. Teléfono\n"
                    + "4. Semestre\n"
                    + "5. Promedio Acumulado\n")) {
                case "1":
                    objEstIng.setName(JOptionPane.showInputDialog("Nuevo nombre del estudiante"));
                    break;
                case "2":
                    objEstIng.setApellido(JOptionPane.showInputDialog("Nuevo apellido del estudiante"));
                    break;
                case "3":
                    objEstIng.setTelefono(JOptionPane.showInputDialog("Nuevo teléfono del estudiante"));
                    break;
                case "4":
                    objEstIng.setNumSemestre(Integer.parseInt(JOptionPane.showInputDialog("Nuevo semestre del estudiante")));
                    break;
                case "5":
                    objEstIng.setPromedio(Float.parseFloat(JOptionPane.showInputDialog("Nuevo promedio acumulado del estudiante")));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡Error! la opción elegida no es correcta");
            }
        }

        return objEstIng;
    }

    private clsComputador_portatil updateComputador(clsComputador_portatil objCompu) {

        while (JOptionPane.showConfirmDialog(null, "¿Desea cambiar un dato?") == JOptionPane.YES_NO_OPTION) {

            switch (JOptionPane.showInputDialog("¿Qué dato desea modificar para el computador?\n"
                    + "1. Marca\n"
                    + "2. Tamaño\n"
                    + "3. Precio\n"
                    + "4. Sistema Operativo\n"
                    + "5. Procesador\n")) {
                case "1":
                    objCompu.setMarca(JOptionPane.showInputDialog("Nueva marca del computador"));
                    break;
                case "2":
                    objCompu.setTamaño(Float.parseFloat(JOptionPane.showInputDialog("Nuevo tamaño del computador")));
                    break;
                case "3":
                    objCompu.setPrecio(Float.parseFloat(JOptionPane.showInputDialog("Nuevo precio del computador")));
                    break;
                case "4":
                    objCompu.setSistemaOperativo(JOptionPane.showInputDialog("Selecione Nuevo Sistema Operativo :\n"
                            + "Windows 7\n"
                            + "Windows 10\n"
                            + "Windows 11\n"
                            + "Ingrese el nombre como se ve en pantalla"));
                    break;
                case "5":
                    objCompu.setProcesador(JOptionPane.showInputDialog("Selecione Nuevo Procesador:\n"
                            + "AMD Ryzen\n"
                            + "Intel Core i5\n"
                            + "Ingrese el nombre como se ve en pantalla"));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡Error! la opción elegida no es correcta");
            }
        }
        return objCompu;
    }

    //Eliminar registro
    public String DeletePrestamo_ing(String cedula) {
        clsEstudiante_ingenieria objEstu = new clsEstudiante_ingenieria();
        clsComputador_portatil objCompu = new clsComputador_portatil();

        // Crear nuevos arrays temporales con el tamaño adecuado
        auxvecEstudiante_ing = new clsEstudiante_ingenieria[vecEstudiante_ing.length - 1];
        auxvecComputador = new clsComputador_portatil[vecComputador.length - 1];

        int j = 0; // Variable para controlar el índice del nuevo array auxiliar de estudiantes
        int k = 0; // Variable para controlar el índice del nuevo array auxiliar de computadores

        // Eliminar el registro tanto del estudiante como del computador
        for (int i = 0; i < vecEstudiante_ing.length; i++) {
            objEstu = vecEstudiante_ing[i];
            objCompu = vecComputador[i];

            if (objEstu.getCedula().equalsIgnoreCase(cedula) || objCompu.getSerial().equalsIgnoreCase(cedula)) {
                banderita_ing = true;
            } else {
                auxvecEstudiante_ing[j] = vecEstudiante_ing[i];
                auxvecComputador[k] = vecComputador[i];
                k++;
                j++;
            }
        }

        if (banderita_ing) {
            // Si se encontró y eliminó el registro, actualiza los vectores principales
            vecEstudiante_ing = auxvecEstudiante_ing;
            vecComputador = auxvecComputador;
            return "Registro eliminado con éxito";
        } else {
            return "No se encontró el registro con el ID especificado";
        }
    }

    //Contar computadores
    public String contarComputadoresRegistrados() {
        int contador = 0;
        cadena_ing = "Total de computadores en el inventario : ";

        // Verificar si el arreglo de computadoras es nulo o está vacío
        if (vecComputador == null || vecComputador.length == 0) {
            cadena_ing += "0";
        } else {
            for (int i = 0; i < vecComputador.length; i++) {
                // Contar las computadoras que no son nulas
                if (vecComputador[i] != null) {
                    contador++;
                    auxcadena_ing += "\n"
                            + "Serial: " + vecComputador[i].getSerial() + "\n"
                            + "Marca: " + vecComputador[i].getMarca() + "\n"
                            + "Tamaño: " + vecComputador[i].getTamaño() + "\n"
                                + "Precio: " + vecComputador[i].getPrecio() + "\n"
                            + "Sistema Operativo: " + vecComputador[i].getSistemaOperativo() + "\n"
                            + "Procesador: " + vecComputador[i].getProcesador() + "\n";
                }
            }
        }
        
        cadena_ing += contador + auxcadena_ing;
        return cadena_ing;
}

}

