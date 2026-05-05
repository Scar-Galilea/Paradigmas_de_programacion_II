package Sistema;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Ventana gráfica para la gestión de profesores
public class VentanaProfesor extends JFrame {
    
    // Colores usados en la interfaz
    private final Color FONDO = new Color(255, 228, 240);
    private final Color BOTON = new Color(255, 170, 210);
    private final Color TEXTO = new Color(150, 40, 110);
    private final Color BORDE = new Color(200, 90, 150);

    // Objeto para acceder a la base de datos de profesores
    private final Consultas_BD_Profesor profe = new Consultas_BD_Profesor();

    // Constructor de la ventana
    public VentanaProfesor() {
        setTitle("Profesores");
        setSize(450, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Panel principal de la ventana
        JPanel panel = new JPanel(new GridLayout(6, 1, 15, 15));
        panel.setBackground(FONDO);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        // Título de la ventana
        JLabel titulo = new JLabel("Gestión de Profesores", JLabel.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setForeground(TEXTO);

        // Botones de la interfaz
        JButton btnInsertar = crearBoton("Insertar");
        JButton btnMostrar  = crearBoton("Mostrar");
        JButton btnEditar   = crearBoton("Editar️");
        JButton btnEliminar = crearBoton("Eliminar");
        JButton btnSalir    = crearBoton("Salir");

        // Acción del botón insertar
        btnInsertar.addActionListener(e -> {
            try {
                insertarProfesor();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaProfesor.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        // Acción del botón mostrar
        btnMostrar.addActionListener(e -> mostrarProfesores());
        
        // Acción del botón editar
        btnEditar.addActionListener(e -> editarProfesor());
        
        // Acción del botón eliminar
        btnEliminar.addActionListener(e -> eliminarProfesor());
        
        // Cierra la ventana
        btnSalir.addActionListener(e -> dispose());
        
        // Agrega los componentes al panel
        panel.add(titulo);
        panel.add(btnInsertar);
        panel.add(btnMostrar);
        panel.add(btnEditar);
        panel.add(btnEliminar);
        panel.add(btnSalir);

        // Agrega el panel a la ventana
        add(panel);
    }

    // Método para crear botones con el mismo estilo
    private JButton crearBoton(String texto) {
        JButton b = new JButton(texto);
        b.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b.setBackground(BOTON);
        b.setForeground(TEXTO);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createLineBorder(BORDE, 2, true));
        return b;
    }

    // Método para insertar un profesor
    private void insertarProfesor() throws SQLException {
        JTextField nombre = new JTextField();
        JTextField apellido = new JTextField();
        JTextField correo = new JTextField();
        JTextField telefono = new JTextField();

        // Formulario para capturar datos
        Object[] datos = {
                "Nombre:", nombre,
                "Apellido:", apellido,
                "Correo:", correo,
                "Teléfono:", telefono
        };

        int op = JOptionPane.showConfirmDialog(this, datos, "Insertar Profesor",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (op == JOptionPane.OK_OPTION) {
            // Validación de campos vacíos
            if (nombre.getText().isEmpty() || apellido.getText().isEmpty()|| correo.getText().isEmpty() || telefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,"No se permiten campos vacíos 💔","Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                // Crea el objeto profesor
                Profesor p = new Profesor();
                p.setNombre(nombre.getText());
                p.setApellido(apellido.getText());
                p.setCorreo(correo.getText());
                p.setTelefono(Integer.parseInt(telefono.getText()));
                
                // Inserta en la base de datos
                profe.insertar(p);

                JOptionPane.showMessageDialog(this,"Profesor registrado correctamente 💗");

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "El teléfono debe ser numérico",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método para mostrar profesores
    private void mostrarProfesores() {
        JTextArea area = new JTextArea(15, 32);
        area.setEditable(false);
        area.setFont(new Font("Consolas", Font.PLAIN, 13));

        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement("select * from profesor");
            ResultSet rs = ps.executeQuery();
            
            // Verifica si hay registros
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this,"No hay profesores registrados 💔","Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            // Recorre y muestra los profesores
            do {
                area.append(
                        "ID: " + rs.getInt("id_profesor") + "\n" +
                        "Nombre: " + rs.getString("nombre") + "\n" +
                        "Apellido: " + rs.getString("apellido") + "\n" +
                        "Correo: " + rs.getString("correo") + "\n" +
                        "Teléfono: " + rs.getInt("telefono") + "\n" +
                        "----------------------------------\n"
                );
            } while (rs.next());

            JOptionPane.showMessageDialog(this,
                    new JScrollPane(area),
                    "Lista de Profesores",
                    JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Error al mostrar datos","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para editar un profesor
    private void editarProfesor() {
        JTextField id = new JTextField();
        JTextField nombre = new JTextField();
        JTextField apellido = new JTextField();
        JTextField correo = new JTextField();
        JTextField telefono = new JTextField();

        Object[] datos = {
                "ID del profesor:", id,
                "Nuevo nombre:", nombre,
                "Nuevo apellido:", apellido,
                "Nuevo correo:", correo,
                "Nuevo teléfono:", telefono
        };

        int op = JOptionPane.showConfirmDialog(this, datos, "Editar Profesor",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (op == JOptionPane.OK_OPTION) {
            try {
                Profesor p = new Profesor();
                p.setIdProfesor(Integer.parseInt(id.getText()));
                p.setNombre(nombre.getText());
                p.setApellido(apellido.getText());
                p.setCorreo(correo.getText());
                p.setTelefono(Integer.parseInt(telefono.getText()));
                
                 // Actualiza en la base de datos
                profe.ActualizarDato(p);

                JOptionPane.showMessageDialog(this,"Profesor actualizado correctamente 💗");

            } catch (ProfesorVacioException | HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this,"Datos inválidos","Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método para eliminar un profesor
    private void eliminarProfesor() {
        String input = JOptionPane.showInputDialog(
                this, "ID del profesor a eliminar:");

        if (input == null || input.isEmpty()) return;

        try {
            int id = Integer.parseInt(input);
            
            // Verifica si el profesor existe
            if (!existeProfesor(id)) {
                JOptionPane.showMessageDialog(this,"El ID no existe 💔","Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Profesor p = new Profesor();
            p.setIdProfesor(id);

            // Elimina de la base de datos
            profe.EliminarDato(p);

            JOptionPane.showMessageDialog(this,"Profesor eliminado correctamente 💗");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"ID inválido","Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArchivoProfesorException | ProfesorVacioException | HeadlessException e) {
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Verifica si un profesor existe en la base de datos
    private boolean existeProfesor(int id) {
        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement("select id_profesor from profesor where id_profesor = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }
}
