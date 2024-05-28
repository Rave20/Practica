package Methods;

import Objetos.clsEstudiante_diseno;
import Objetos.clsTableta_grafica;
import javax.swing.JOptionPane;

public class gestionEstudiantes_diseno {

    //Declaración de variables globales
    String cadena_dis;
    String auxcadena_dis;
    boolean banderita_dis;
    Objetos.clsEstudiante_diseno[] vecEstudiante_dis;
    Objetos.clsEstudiante_diseno[] auxvecEstudiante_dis;
    Objetos.clsTableta_grafica[] vecTablet;
    Objetos.clsTableta_grafica[] auxvecTablet;
    int tamVector;

    // Método para establecer el tamaño de los vectores según la entrada del usuario y retornar el tamaño
    public int establecerTamano() {
        tamVector = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuantos prestamos desea registrar: "));
        return tamVector;
    }

    public gestionEstudiantes_diseno() {
        cadena_dis = "";
        banderita_dis = false;
        tamVector = 0;
        auxcadena_dis = "";
    }

    //CRUD
    //Crear(Registro)
    public String CreatedPrestamo_dis() {

        int tamanoVec = establecerTamano();

        vecEstudiante_dis = new clsEstudiante_diseno[tamanoVec];
        vecTablet = new clsTableta_grafica[tamanoVec];

        for (int i = 0; i < vecEstudiante_dis.length; i++) {

            String cedula;
            boolean cedulaRepetida = false;
            JOptionPane.showMessageDialog(null, "Datos Estudiante");
            do {
                cedula = JOptionPane.showInputDialog("¿Cuál es la cedula del estudiante?");

                // Verificar si la cédula ya existe en el arreglo
                for (int j = 0; j < i; j++) {
                    if (vecEstudiante_dis[j].getCedula().equals(cedula)) {
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

            vecEstudiante_dis[i] = new Objetos.clsEstudiante_diseno(cedula,
                    JOptionPane.showInputDialog("¿Cual es el nombre del estudiante"),
                    JOptionPane.showInputDialog("¿Cual es el Apellido del estudiante"),
                    JOptionPane.showInputDialog("¿Cual es el telefono del estudiante"),
                    JOptionPane.showInputDialog("¿Cual es la modalidad de estudio (Virtual / Presencial)?"),
                    Integer.parseInt(JOptionPane.showInputDialog("¿Cual es la cantidad de Asignaturas que está viendo?"))
            );

            JOptionPane.showMessageDialog(null, "Datos Tableta grafica");
            vecTablet[i] = new Objetos.clsTableta_grafica(JOptionPane.showInputDialog("Ingrese el Serial de la Tableta grafica"),
                    JOptionPane.showInputDialog("Ingrese la Marca de la Tableta grafica"),
                    Float.parseFloat(JOptionPane.showInputDialog("Ingrese el Tamaño de la Tableta grafica (Pg)")),
                    Float.parseFloat(JOptionPane.showInputDialog("Ingrese Precio de la Tableta grafica")),
                    JOptionPane.showInputDialog("Selecione Almacenamiento deseado :\n"
                            + "256 GB \n"
                            + "512 GB \n"
                            + "1 TB \n"
                            + "Ingrese el nombre como se ve en pantalla"),
                    Float.parseFloat(JOptionPane.showInputDialog("Ingrese Peso de la Tableta grafica (Kg)")));

        }

        return "Datos guardados con éxito";
    }

    //Buscar registro
    public String searchPrestamo_dis(String cedula) {
        clsEstudiante_diseno objEstu = new clsEstudiante_diseno();
        clsTableta_grafica objTable = new clsTableta_grafica();
        cadena_dis = "Registro de Prestamo \n";

        for (int i = 0; i < vecEstudiante_dis.length; i++) {
            objEstu = vecEstudiante_dis[i];
            objTable = vecTablet[i];

            if (objEstu.getCedula().equalsIgnoreCase(cedula) || objTable.getSerial().equalsIgnoreCase(cedula)) {
                

                cadena_dis += "Cedula: " + vecEstudiante_dis[i].getCedula() + "\n"
                        + "Nombre: " + vecEstudiante_dis[i].getName() + "\n"
                        + "Apellido: " + vecEstudiante_dis[i].getApellido() + "\n"
                        + "Telefono: " + vecEstudiante_dis[i].getTelefono() + "\n"
                        + "Modalidad de estudio: " + vecEstudiante_dis[i].getModalida() + "\n"
                        + "Cantidad de Asignaturas: " + vecEstudiante_dis[i].getCantAsig() + "\n"
                        + "Serial: " + vecTablet[i].getSerial() + "\n"
                        + "Marca: " + vecTablet[i].getMarca() + "\n"
                        + "Tamaño: " + vecTablet[i].getTamaño() + "\n"
                        + "Precio: " + vecTablet[i].getPrecio() + "\n"
                        + "Almacenamiento: " + vecTablet[i].getAlmacenamiento() + "\n"
                        + "Peso: " + vecTablet[i].getPeso() + "\n";

                banderita_dis = true;
            }
        }

        if (banderita_dis) {
            return cadena_dis;
        } else {
            return "No se encontró el registro con el ID especificado";
        }

    }

    //Modificar Registro
    public String UpdatePrestamo_dis(String cedula) {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("Selecione que datos necesita actualizar:\n"
                + "1. Estudiante\n"
                + "2. Tableta Grafica\n"));
        switch (opc) {
            case 1:
                for (int i = 0; i < vecEstudiante_dis.length; i++) {
                    if (vecEstudiante_dis[i].getCedula().equalsIgnoreCase(cedula) || vecTablet[i].getSerial().equalsIgnoreCase(cedula)) {
                        updateEstudianteDis(vecEstudiante_dis[i]);
                        banderita_dis = true;
                        break;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < vecEstudiante_dis.length; i++) {
                    if (vecEstudiante_dis[i].getCedula().equalsIgnoreCase(cedula) || vecTablet[i].getSerial().equalsIgnoreCase(cedula)) {
                        updateTableta(vecTablet[i]);
                        banderita_dis = true;
                        break;
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
        return "Se Actualizo correctamente";
    }

    private clsEstudiante_diseno updateEstudianteDis(clsEstudiante_diseno objEstDis) {
        while (JOptionPane.showConfirmDialog(null, "¿Desea cambiar un dato?") == JOptionPane.YES_NO_OPTION) {

            switch (JOptionPane.showInputDialog(
                    "¿Qué dato desea modificar para el estudiante?\n"
                    + "1. Nombre\n"
                    + "2. Apellido\n"
                    + "3. Teléfono\n"
                    + "4. Modalidad de estudio\n"
                    + "5. Cantidad de Asignaturas\n")) {
                case "1":
                    objEstDis.setName(JOptionPane.showInputDialog("Nuevo nombre del estudiante"));
                    break;
                case "2":
                    objEstDis.setApellido(JOptionPane.showInputDialog("Nuevo apellido del estudiante"));
                    break;
                case "3":
                    objEstDis.setTelefono(JOptionPane.showInputDialog("Nuevo teléfono del estudiante"));
                    break;
                case "4":
                    objEstDis.setModalida(JOptionPane.showInputDialog("Nueva modalidad de estudio (Virtual / Presencial)"));
                    break;
                case "5":
                    objEstDis.setCantAsig(Integer.parseInt(JOptionPane.showInputDialog("Nueva cantidad de Asignaturas")));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡Error! la opción elegida no es correcta");
            }
        }

        return objEstDis;
    }

    private clsTableta_grafica updateTableta(clsTableta_grafica objTableta) {

        while (JOptionPane.showConfirmDialog(null, "¿Desea cambiar un dato?") == JOptionPane.YES_NO_OPTION) {

            switch (JOptionPane.showInputDialog("¿Qué dato desea modificar para la Tableta Grafica?\n"
                    + "1. Marca\n"
                    + "2. Tamaño\n"
                    + "3. Precio\n"
                    + "4. Alamacenamiento\n"
                    + "5. Peso\n")) {
                case "1":
                    objTableta.setMarca(JOptionPane.showInputDialog("Nueva marca de de la Tableta Grafica "));
                    break;
                case "2":
                    objTableta.setTamaño(Float.parseFloat(JOptionPane.showInputDialog("Nuevo tamaño de la Tableta Grafica (Pg)")));
                    break;
                case "3":
                    objTableta.setPrecio(Float.parseFloat(JOptionPane.showInputDialog("Nuevo precio de la Tableta Grafica")));
                    break;
                case "4":
                    objTableta.setAlmacenamiento(JOptionPane.showInputDialog("Selecione Nuevo Almacenamiento deseado :\n"
                            + "256 GB \n"
                            + "512 GB \n"
                            + "1 TB \n"
                            + "Ingrese el nombre como se ve en pantalla"));
                    break;
                case "5":
                    objTableta.setPeso(Float.parseFloat(JOptionPane.showInputDialog("Nuevo Peso de la Tableta Grafica (Kg)")));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡Error! la opción elegida no es correcta");
            }
        }
        return objTableta;
    }
    
    //Eliminar Registro
    public String DeletePrestamo_ing(String cedula) {
        clsEstudiante_diseno objEstu = new clsEstudiante_diseno();
        clsTableta_grafica objTablet = new clsTableta_grafica();

        // Crear nuevos arrays temporales con el tamaño adecuado
        auxvecEstudiante_dis = new clsEstudiante_diseno[vecEstudiante_dis.length - 1];
        auxvecTablet = new clsTableta_grafica[vecTablet.length - 1];

        int j = 0; // Variable para controlar el índice del nuevo array auxiliar de estudiantes
        int k = 0; // Variable para controlar el índice del nuevo array auxiliar de computadores

        // Eliminar el registro tanto del estudiante como del computador
        for (int i = 0; i < vecEstudiante_dis.length; i++) {
            objEstu = vecEstudiante_dis[i];
            objTablet = vecTablet[i];

            if (objEstu.getCedula().equalsIgnoreCase(cedula) || objTablet.getSerial().equalsIgnoreCase(cedula)) {
                banderita_dis = true;
            } else {
                auxvecEstudiante_dis[j] = vecEstudiante_dis[i];
                auxvecTablet[k] = vecTablet[i];
                k++;
                j++;
            }
        }

        if (banderita_dis) {
            // Si se encontró y eliminó el registro, actualiza los vectores principales
            vecEstudiante_dis = auxvecEstudiante_dis;
            vecTablet= auxvecTablet;
            return "Registro eliminado con éxito";
        } else {
            return "No se encontró el registro con el ID especificado";
        }
    }
    
    //Contar tables
    public String contarTabletasRegistradas() {
        int contador = 0;
        cadena_dis = "Total de Tabletas Graficas en el inventario : ";

        // Verificar si el arreglo de tabletas es nulo o está vacío
        if (vecTablet == null || vecTablet.length == 0) {
            cadena_dis += "0";
        } else {
            for (int i = 0; i < vecTablet.length; i++) {
                // Contar las tabletas que no son nulas
                if (vecTablet[i] != null) {
                    contador++;
                    auxcadena_dis += "\n"
                            + "Serial: " + vecTablet[i].getSerial() + "\n"
                            + "Marca: " + vecTablet[i].getMarca() + "\n"
                            + "Tamaño: " + vecTablet[i].getTamaño() + "\n"
                            + "Precio: " + vecTablet[i].getPrecio() + "\n"
                            + "Almacenamiento: " + vecTablet[i].getAlmacenamiento() + "\n"
                            + "Peso: " + vecTablet[i].getPeso() + "\n";
                }
            }
        }
        
        cadena_dis += contador + auxcadena_dis;
        return cadena_dis;
    }


    
}
