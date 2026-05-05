package Sistema;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Ventana gráfica para la gestión de alumnos
public class VentanaAlumno extends JFrame {
    
    // Colores usados en la interfaz
    private final Color FONDO = new Color(255, 228, 240);
    private final Color BOTON = new Color(255, 170, 210);
    private final Color TEXTO = new Color(150, 40, 110);
    private final Color BORDE = new Color(200, 90, 150);

    // Objeto para manejar la base de datos de alumnos
    private final Consultas_BD_Alumno alum = new Consultas_BD_Alumno();
    
    // Constructor de la ventana
    public VentanaAlumno() {
        setTitle("Alumnos");
        setSize(450, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel(new GridLayout(6,1,15,15));
        panel.setBackground(FONDO);
        panel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));

        // Título de la ventana
        JLabel titulo = new JLabel("Gestión de Alumnos", JLabel.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setForeground(TEXTO);

        // Botones de la interfaz
        JButton insertar = boton("Insertar");
        JButton mostrar  = boton("Mostrar");
        JButton editar   = boton("Editar");
        JButton eliminar = boton("Eliminar");
        JButton salir    = boton("Salir");

        // Acción para insertar alumno
        insertar.addActionListener(e -> {
            try {
                insertarAlumno();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        // Acción para mostrar alumnos
        mostrar.addActionListener(e -> mostrarAlumnos());
        
        // Acción para editar alumno
        editar.addActionListener(e -> editarAlumno());
        
        // Acción para eliminar alumno
        eliminar.addActionListener(e -> eliminarAlumno());
        
        // Cierra la ventana
        salir.addActionListener(e -> dispose());

        // Agrega los componentes al panel
        panel.add(titulo);
        panel.add(insertar);
        panel.add(mostrar);
        panel.add(editar);
        panel.add(eliminar);
        panel.add(salir);
        
        // Agrega el panel a la ventana
        add(panel);
    }

     // Método para crear botones con el mismo estilo
    private JButton boton(String t){
        JButton b = new JButton(t);
        b.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b.setBackground(BOTON);
        b.setForeground(TEXTO);
        b.setBorder(BorderFactory.createLineBorder(BORDE,2,true));
        return b;
    }

    // Método para insertar un alumno
    private void insertarAlumno() throws SQLException {
        JTextField n = new JTextField();
        JTextField a = new JTextField();
        JTextField m = new JTextField();
        JTextField c = new JTextField();

         // Formulario de captura
        Object[] datos_alum = {
                "Nombre:", n,
                "Apellido:", a,
                "Matrícula:", m,
                "Correo:", c
        };
        
        // Muestra el formulario
        if (JOptionPane.showConfirmDialog(this, datos_alum,"Insertar Alumno", JOptionPane.OK_CANCEL_OPTION)
                == JOptionPane.OK_OPTION) {
            
            // Valida campos vacíos
            if (n.getText().isEmpty() || a.getText().isEmpty()|| m.getText().isEmpty() || c.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,"No se permiten campos vacíos 💔");
                return;
            }
            
            // Crea el objeto alumno
            Alumno al = new Alumno();
            al.setNombre(n.getText());
            al.setApellido(a.getText());
            al.setMatricula(m.getText());
            al.setCorreo(c.getText());
            
            // Inserta en la base de datos
            alum.insertar(al);

            JOptionPane.showMessageDialog(this,"Alumno registrado correctamente 💗");
        }
    }

    // Método para mostrar los alumnos registrados
    private void mostrarAlumnos() {
        JTextArea area = new JTextArea(15,32);
        area.setEditable(false);

        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement("select * from alumno");
            ResultSet rs = ps.executeQuery();
            
            // Verifica si hay registros
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this,"No hay alumnos registrados 💔");
                return;
            }
            
            // Recorre y muestra los alumnos
            do {
                area.append(
                        "ID: " + rs.getInt("id_alumno") + "\n" +
                        "Nombre: " + rs.getString("nombre") + "\n" +
                        "Apellido: " + rs.getString("apellido") + "\n" +
                        "Matrícula: " + rs.getString("matricula") + "\n" +
                        "Correo: " + rs.getString("correo") + "\n" +
                        "------------------------------\n"
                );
            }while (rs.next());

            JOptionPane.showMessageDialog(this,new JScrollPane(area), "Alumnos",JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al mostrar");
        }
    }
    
    // Método para editar un alumno
    private void editarAlumno() {
        JTextField id = new JTextField();
        JTextField n = new JTextField();
        JTextField a = new JTextField();
        JTextField m = new JTextField();
        JTextField c = new JTextField();

        Object[] datosalum = {
                "ID:", id,
                "Nuevo nombre:", n,
                "Nuevo apellido:", a,
                "Nueva matrícula:", m,
                "Nuevo correo:", c
        };

        if (JOptionPane.showConfirmDialog(this, datosalum,"Editar Alumno", JOptionPane.OK_CANCEL_OPTION)== JOptionPane.OK_OPTION) {

            try {
                Alumno al = new Alumno();
                al.setIdAlumno(Integer.parseInt(id.getText()));
                al.setNombre(n.getText());
                al.setApellido(a.getText());
                al.setMatricula(m.getText());
                al.setCorreo(c.getText());

                alum.ActualizarDato(al);

                JOptionPane.showMessageDialog(this,
                        "Alumno actualizado 💗");

            } catch (AlumnosVacioException | HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this,"Datos inválidos");
            }
        }
    }
    
    // Método para eliminar un alumno
    private void eliminarAlumno() {
        String input = JOptionPane.showInputDialog(this,
                "ID del alumno a eliminar");

        if (input == null || input.isEmpty()) return;

        try {
            int id = Integer.parseInt(input);
            // Verifica si el alumno existe
            if (!existeAlumno(id)) {
                JOptionPane.showMessageDialog(this, "El ID no existe 💔");
                return;
            }

            Alumno al = new Alumno();
            al.setIdAlumno(id);
            
            // Elimina de la base de datos
            alum.EliminarDato(al);

            JOptionPane.showMessageDialog(this,"Alumno eliminado 💗");

        } catch (AlumnosVacioException | HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    // Verifica si un alumno existe en la base de datos
    private boolean existeAlumno(int id){
        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement("select id_alumno from alumno where id_alumno=?");
            ps.setInt(1, id);
            return ps.executeQuery().next();
        } catch (SQLException e) {
            return false;
        }
    }
}
