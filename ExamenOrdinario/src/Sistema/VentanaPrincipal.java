package Sistema;

import javax.swing.*;
import java.awt.*;


// Ventana principal del sistema escolar
public class VentanaPrincipal extends JFrame {

    // Constructor que crea la ventana y sus componentes
    public VentanaPrincipal() {
        setTitle("Sistema Escolar");// Título de la ventana
        setSize(420, 360); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra el programa al salir

        // Panel principal con botones en forma vertical
        JPanel panel = new JPanel(new GridLayout(5, 1, 15, 15));
        panel.setBackground(new Color(255, 215, 235));
        panel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));

        // Etiqueta del título
        JLabel titulo = new JLabel("Menu Principal", JLabel.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(new Color(170, 40, 110));

        // Botones del menú
        JButton btnProfesor = crearBoton("︎Profesores");
        JButton btnAlumno = crearBoton("Alumnos");
        JButton btnAsignacion = crearBoton("Asignación Tutor–Alumno");
        JButton btnSalir = crearBoton("Salir");

        // Abre la ventana de profesores
        btnProfesor.addActionListener(e ->
                new VentanaProfesor().setVisible(true)
        );

        // Abre la ventana de alumnos
        btnAlumno.addActionListener(e ->
                new VentanaAlumno().setVisible(true)
        );
        
        // Abre la ventana de asignaciones
        btnAsignacion.addActionListener(e ->
                new VentanaAsignacion().setVisible(true)
        );

        // Pregunta si desea salir del sistema
        btnSalir.addActionListener(e -> {
            int op = JOptionPane.showConfirmDialog(
                    this,
                    "¿Seguro que deseas salir?",
                    "Salir",
                    JOptionPane.YES_NO_OPTION
            );
            if (op == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        
        // Se agregan los componentes al panel
        panel.add(titulo);
        panel.add(btnProfesor);
        panel.add(btnAlumno);
        panel.add(btnAsignacion);
        panel.add(btnSalir);

        // Se agrega el panel a la ventana
        add(panel);
    }

    // Método que crea y da estilo a los botones
    private JButton crearBoton(String texto) {
        JButton b = new JButton(texto);
        b.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b.setBackground(new Color(255, 170, 210));
        b.setForeground(new Color(90, 0, 60));
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createLineBorder(
                new Color(200, 80, 140), 2, true));
        return b;
    }
}
