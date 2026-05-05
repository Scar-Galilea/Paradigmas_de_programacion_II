package Sistema;
import java.sql.*;

public class Consultas_BD_Asignacion {

    public void insertar(AsignacionTutorAlumno asig)
        throws SQLIntegrityConstraintViolationException {

        String sql = "INSERT INTO asignacion (id_profesor, id_alumno, fecha_asignacion) VALUES (?,?,?)";

        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, asig.getIdProfesor());
            ps.setInt(2, asig.getIdAlumno());
            ps.setString(3, asig.getFechaAsignacion());

            ps.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            throw e; // se propaga para que la ventana muestre el mensaje 💔
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // 🔹 MOSTRAR ASIGNACIONES
    public String leerDatos() throws AsignacionVaciaException {
    StringBuilder datos = new StringBuilder();

    String sql = """
        SELECT asignacion.id_asignacion,
               alumno.nombre AS nombre_alumno,
               alumno.apellido AS apellido_alumno,
               profesor.nombre AS nombre_profesor,
               profesor.apellido AS apellido_profesor,
               asignacion.fecha_asignacion
        FROM alumno, profesor, asignacion
        WHERE alumno.id_alumno = asignacion.id_alumno
          AND profesor.id_profesor = asignacion.id_profesor
    """;

    try {
        Connection con = Conexion_BD.conexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            throw new AsignacionVaciaException("No hay asignaciones registradas.");
        }

        do {
            datos.append("ID Asignación: ").append(rs.getInt("id_asignacion")).append("\n");
            datos.append("Alumno: ")
                 .append(rs.getString("nombre_alumno")).append(" ")
                 .append(rs.getString("apellido_alumno")).append("\n");
            datos.append("Tutor: ")
                 .append(rs.getString("nombre_profesor")).append(" ")
                 .append(rs.getString("apellido_profesor")).append("\n");
            datos.append("Fecha: ").append(rs.getString("fecha_asignacion")).append("\n");
            datos.append("------------------------------\n");
        } while (rs.next());

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return datos.toString();
}


    public void ActualizarDato(AsignacionTutorAlumno asig) throws SQLIntegrityConstraintViolationException {
        String sql = "UPDATE asignacion SET id_profesor = ?, id_alumno = ?, fecha_asignacion = ? WHERE id_asignacion = ?";

        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, asig.getIdProfesor());
            ps.setInt(2, asig.getIdAlumno());
            ps.setString(3, asig.getFechaAsignacion());
            ps.setInt(4, asig.getIdAsignacion());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void EliminarDato(AsignacionTutorAlumno asig)
            throws AsignacionVaciaException, AsignacionLlenaException {

        String sql = "DELETE FROM asignacion WHERE id_asignacion = ?";

        try {
            VerificarAsignacionVacia();
            VerificarAsignacionLlena();
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, asig.getIdAsignacion());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void VerificarAsignacionVacia() throws AsignacionVaciaException {
        String sql = "SELECT * FROM asignacion";

        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new AsignacionVaciaException("No hay asignaciones registradas.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void VerificarAsignacionLlena() throws AsignacionLlenaException {
        String sql = "SELECT * FROM asignacion";

        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                throw new AsignacionLlenaException("No se puede eliminar una asignación con registros llenos");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void InsertarDato(AsignacionTutorAlumno a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
