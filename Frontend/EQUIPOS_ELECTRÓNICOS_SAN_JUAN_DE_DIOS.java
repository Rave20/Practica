package Frontend;

import javax.swing.JOptionPane;

public class EQUIPOS_ELECTRÓNICOS_SAN_JUAN_DE_DIOS {

    public static void main(String[] args) {

        Methods.gestionEstudiantes_ingenieria objIng = new Methods.gestionEstudiantes_ingenieria();
        Methods.gestionEstudiantes_diseno objDis = new Methods.gestionEstudiantes_diseno();
        int opc = 0;

        JOptionPane.showMessageDialog(null, "--- Bienvenido/a al sistema de Gestion de Prestamos --- \n"
                + "--- Equipos Electronicos San Juan de Dios ---");

        do {

            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menú Principal:\n"
                    + "1. Estudiantes de Ingeniería\n"
                    + "2. Estudiantes de Diseño\n"
                    + "3. Imprimir inventario total\n"
                    + "4. Salir del programa\n"
                    + "Ingrese el número correspondiente a la opción que desee:"));

            if (opc == 1) {

                switch (Integer.parseInt(JOptionPane.showInputDialog(
                        "Menú Estudiantes de Ingeniería:\n"
                        + "1. Registrar préstamo de equipo\n"
                        + "2. Modificar préstamo de equipo (Por serial o cedula)\n"
                        + "3. Devolución de equipo (se elimina el registro) (Por serial o cedula)\n"
                        + "4. Buscar equipo (Por serial o cedula)\n"
                        + "5. Volver al menú principal\n"
                        + "Ingrese el número correspondiente a la opción que desee:"))) {
                    case 1:
                        JOptionPane.showMessageDialog(null, objIng.CreatedPrestamo_ing());
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, objIng.UpdatePrestamo_ing(
                                JOptionPane.showInputDialog("¿Ingrese Cedula o Serial para modificar datos")));
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, objIng.DeletePrestamo_ing(
                                JOptionPane.showInputDialog("Ingrese Cedula o Serial para devolución de equipo")
                        ));
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, objIng.searchPrestamo_ing(
                                JOptionPane.showInputDialog("Ingrese Cedula o Serial para Buscar registro de prestamo")));
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "--- Volviendo al menú principal ---");
                        continue;
                    default:
                        JOptionPane.showMessageDialog(null,
                                "¡Error! la opción elegida no es correcta");
                        break;
                }

            }

            if (opc == 2) {

                switch (Integer.parseInt(JOptionPane.showInputDialog(
                        "Menú Estudiantes de Diseño:\n"
                        + "1. Registrar préstamo de equipo\n"
                        + "2. Modificar préstamo de equipo (Por serial o cedula)\n"
                        + "3. Devolución de equipo (se elimina el registro) (Por serial o cedula)\n"
                        + "4. Buscar equipo (Por serial o cedula)\n"
                        + "5. Volver al menú principal\n"
                        + "Ingrese el número correspondiente a la opción que desee:"))) {
                    case 1:
                        JOptionPane.showMessageDialog(null, objDis.CreatedPrestamo_dis());
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, objDis.UpdatePrestamo_dis(
                                JOptionPane.showInputDialog("¿Ingrese Cedula o Serial para modificar datos")));
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, objDis.DeletePrestamo_ing(
                                JOptionPane.showInputDialog("Ingrese Cedula o Serial para devolución de equipo")
                        ));
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, objDis.searchPrestamo_dis(
                                JOptionPane.showInputDialog("Ingrese Cedula o Serial para Buscar registro de prestamo")));
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "--- Volviendo al menú principal ---");
                        continue;
                    default:
                        JOptionPane.showMessageDialog(null,
                                "¡Error! la opción elegida no es correcta");
                        break;
                }

            }
            
            if (opc == 3) {
                JOptionPane.showMessageDialog(null,
                                "--- Inventario ----");
                JOptionPane.showMessageDialog(null, objIng.contarComputadoresRegistrados());
                JOptionPane.showMessageDialog(null, objDis.contarTabletasRegistradas());
            }

        } while (opc != 4);
        
                JOptionPane.showMessageDialog(null,
                "Fin del sistema.");
    }

}
