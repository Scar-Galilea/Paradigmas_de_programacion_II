package Sistema;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

// Ventana para gestionar la asignación entre tutor y alumno
public class VentanaAsignacion extends JFrame {
    // Colores para el diseño de la interfaz
    private final Color FONDO = new Color(255, 228, 240);
    private final Color BOTON = new Color(255, 170, 210);
    private final Color TEXTO = new Color(150, 40, 110);
    private final Color BORDE = new Color(200, 90, 150);
    
    // Objeto que maneja las consultas a la base de datos
    private final Consultas_BD_Asignacion asig = new Consultas_BD_Asignacion();
    
    // Constructor que crea y acomoda la ventana
    public VentanaAsignacion() {
        setTitle("Asignación Tutor–Alumno");
        setSize(480, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Panel principal con botones
        JPanel panel = new JPanel(new GridLayout(6,1,15,15));
        panel.setBackground(FONDO);
        panel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        
        // Título de la ventana
        JLabel titulo = new JLabel("Gestión de Asignaciones", JLabel.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setForeground(TEXTO);

        // Botones principales
        JButton insertar = boton("Insertar");
        JButton mostrar  = boton("Mostrar");
        JButton editar   = boton("Editar️");
        JButton eliminar = boton("Eliminar");
        JButton salir    = boton("Salir");

        // Acciones de cada botón
        insertar.addActionListener(e -> insertarAsignacion());
        mostrar.addActionListener(e -> mostrarAsignaciones());
        editar.addActionListener(e -> editarAsignacion());
        eliminar.addActionListener(e -> eliminarAsignacion());
        salir.addActionListener(e -> dispose());

        // Se agregan los componentes al panel
        panel.add(titulo);
        panel.add(insertar);
        panel.add(mostrar);
        panel.add(editar);
        panel.add(eliminar);
        panel.add(salir);

        add(panel);
    }
    
    // Método que da estilo a los botones
    private JButton boton(String t){
        JButton b = new JButton(t);
        b.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b.setBackground(BOTON);
        b.setForeground(TEXTO);
        b.setBorder(BorderFactory.createLineBorder(BORDE,2,true));
        return b;
    }
    
    // Inserta una nueva asignación tutor–alumno
    private void insertarAsignacion() {
        JTextField prof = new JTextField();
        JTextField alum = new JTextField();
        JTextField fecha = new JTextField();

        Object[] datos = {
                "ID Profesor:", prof,
                "ID Alumno:", alum,
                "Fecha (YYYY-MM-DD):", fecha
        };

        if (JOptionPane.showConfirmDialog(this, datos,"Nueva Asignación", JOptionPane.OK_CANCEL_OPTION)== JOptionPane.OK_OPTION) {

            try {
                int idProfesor = Integer.parseInt(prof.getText());
                int idAlumno   = Integer.parseInt(alum.getText());

                // Validaciones antes de insertar
                if (!existeProfesor(idProfesor)) {
                    JOptionPane.showMessageDialog(this,"El profesor no existe 💔");
                    return;
                }

                if (!existeAlumno(idAlumno)) {
                    JOptionPane.showMessageDialog(this,"El alumno no existe 💔");
                    return;
                }

                if (!fechaValida(fecha.getText())) {
                    JOptionPane.showMessageDialog(this,"Fecha inválida ❌\nFormato: YYYY-MM-DD");
                    return;
                }
                
                // Validaciones antes de insertar
                AsignacionTutorAlumno a = new AsignacionTutorAlumno();
                a.setIdProfesor(idProfesor);
                a.setIdAlumno(idAlumno);
                a.setFechaAsignacion(fecha.getText());
                
                // Se guarda en la base de datos
                asig.insertar(a);

                JOptionPane.showMessageDialog(this,"Asignación registrada 💗");

            } catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(this,"El alumno ya tiene tutor asignado 💔");
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Datos inválidos");
            }
        }
    }

    // Muestra todas las asignaciones registradas
    private void mostrarAsignaciones() {
        JTextArea area = new JTextArea(15,34);
        area.setEditable(false);

        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT asignacion.id_asignacion, alumno.nombre, alumno.apellido, " +
                    "profesor.nombre AS profe, asignacion.fecha_asignacion " +
                    "FROM asignacion " +
                    "JOIN alumno ON asignacion.id_alumno = alumno.id_alumno " +
                    "JOIN profesor ON asignacion.id_profesor = profesor.id_profesor"
            );

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this,"No hay asignaciones registradas 💔");
                return;
            }

            // Se recorren los resultados y se muestran
            do {
                area.append(
                        "ID Asignación: " + rs.getInt("id_asignacion") + "\n" +
                        "Alumno: " + rs.getString("nombre") + " " +
                        rs.getString("apellido") + "\n" +
                        "Tutor: " + rs.getString("profe") + "\n" +
                        "Fecha: " + rs.getString("fecha_asignacion") + "\n" +
                        "-----------------------------\n"
                );
            } while (rs.next());
            JOptionPane.showMessageDialog(this,new JScrollPane(area),"Asignaciones",JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Error al mostrar asignaciones");
        }
    }
    
    // Edita una asignación existente
    private void editarAsignacion() {
        JTextField idAsig = new JTextField();
        JTextField prof = new JTextField();
        JTextField alum = new JTextField();
        JTextField fecha = new JTextField();

        Object[] datos = {
                "ID Asignación:", idAsig,
                "Nuevo ID Profesor:", prof,
                "Nuevo ID Alumno:", alum,
                "Nueva Fecha (YYYY-MM-DD):", fecha
        };

        if (JOptionPane.showConfirmDialog(this, datos,"Editar Asignación", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {

            try {
                int idAsignacion = Integer.parseInt(idAsig.getText());
                int idProfesor   = Integer.parseInt(prof.getText());
                int idAlumno     = Integer.parseInt(alum.getText());

                // Validaciones
                if (!existeAsignacion(idAsignacion)) {
                    JOptionPane.showMessageDialog(this,"La asignación no existe 💔");
                    return;
                }

                if (!existeProfesor(idProfesor)) {
                    JOptionPane.showMessageDialog(this,"El profesor no existe 💔");
                    return;
                }

                if (!existeAlumno(idAlumno)) {
                    JOptionPane.showMessageDialog(this,"El alumno no existe 💔");
                    return;
                }

                if (!fechaValida(fecha.getText())) {
                    JOptionPane.showMessageDialog(this,"Fecha inválida \nFormato: YYYY-MM-DD");
                    return;
                }

                AsignacionTutorAlumno a = new AsignacionTutorAlumno();
                a.setIdAsignacion(idAsignacion);
                a.setIdProfesor(idProfesor);
                a.setIdAlumno(idAlumno);
                a.setFechaAsignacion(fecha.getText());

                asig.ActualizarDato(a);

                JOptionPane.showMessageDialog(this,"Asignación actualizada 💗");

            } catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(this,"El alumno ya tiene tutor 💔");
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this,"Datos inválidos");
            }
        }
    }

     // Elimina una asignación por ID
    private void eliminarAsignacion() {
        String input = JOptionPane.showInputDialog(this,
                "ID de asignación a eliminar");

        if (input == null || input.isEmpty()) return;

        try {
            int id = Integer.parseInt(input);

            if (!existeAsignacion(id)) {
                JOptionPane.showMessageDialog(this,
                        "La asignación no existe 💔");
                return;
            }

            AsignacionTutorAlumno a = new AsignacionTutorAlumno();
            a.setIdAsignacion(id);
            asig.EliminarDato(a);

            JOptionPane.showMessageDialog(this,"Asignación eliminada 💗");

        } catch (AsignacionLlenaException | AsignacionVaciaException | HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    // Verifica si la asignación existe
    private boolean existeAsignacion(int id){
        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement( "SELECT id_asignacion FROM asignacion WHERE id_asignacion=?");
            ps.setInt(1, id);
            return ps.executeQuery().next();
        } catch (SQLException e) {
            return false;
        }
    }

    // Verifica si el profesor existe
    private boolean existeProfesor(int id){
        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement("SELECT id_profesor FROM profesor WHERE id_profesor=?");
            ps.setInt(1, id);
            return ps.executeQuery().next();
        } catch (SQLException e) {
            return false;
        }
    }
    
    // Verifica si el alumno existe
    private boolean existeAlumno(int id){
        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement("SELECT id_alumno FROM alumno WHERE id_alumno=?");
            ps.setInt(1, id);
            return ps.executeQuery().next();
        } catch (SQLException e) {
            return false;
        }
    }
    
    // Valida que la fecha tenga el formato correcto
    private boolean fechaValida(String fecha) {
        try {
            Date.valueOf(fecha); // yyyy-MM-dd
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
