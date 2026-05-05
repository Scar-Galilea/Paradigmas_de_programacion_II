package Sistema;
import java.sql.*;

public class Consultas_BD_Alumno {

    public void insertar(Alumno alum) throws SQLException {
        String sql = "INSERT INTO alumno (nombre, apellido, matricula, correo) VALUES (?, ?, ?, ?)";

        Connection con = Conexion_BD.conexion();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, alum.getNombre());
        ps.setString(2, alum.getApellido());
        ps.setString(3, alum.getMatricula());
        ps.setString(4, alum.getCorreo());

        ps.executeUpdate();
    }

    // 🔹 MOSTRAR ALUMNOS (PARA INTERFAZ)
    public String leerDatos() throws AlumnosVacioException {
        StringBuilder datos = new StringBuilder();
        String sql = "SELECT * FROM alumno";

        try {
            VerificarAlumnosVacia();
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                datos.append("ID: ").append(rs.getInt("id_alumno")).append("\n");
                datos.append("Nombre: ").append(rs.getString("nombre")).append("\n");
                datos.append("Apellido: ").append(rs.getString("apellido")).append("\n");
                datos.append("Matrícula: ").append(rs.getString("matricula")).append("\n");
                datos.append("Correo: ").append(rs.getString("correo")).append("\n");
                datos.append("------------------------------\n");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return datos.toString();
    }

    // 🔹 SOLO NOMBRES (ASIGNACIÓN)
    public String leerAlumnoName() throws AlumnosVacioException {
        StringBuilder datos = new StringBuilder();
        String sql = "SELECT * FROM alumno";

        try {
            VerificarAlumnosVacia();
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                datos.append(rs.getInt("id_alumno"))
                     .append(" - ")
                     .append(rs.getString("nombre"))
                     .append(" ")
                     .append(rs.getString("apellido"))
                     .append("\n");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return datos.toString();
    }

    public void ActualizarDato(Alumno alum) throws AlumnosVacioException {
        String sql = "UPDATE alumno SET nombre = ?, apellido = ?, matricula = ?, correo = ? WHERE id_alumno = ?";

        try {
            VerificarAlumnosVacia();
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, alum.getNombre());
            ps.setString(2, alum.getApellido());
            ps.setString(3, alum.getMatricula());
            ps.setString(4, alum.getCorreo());
            ps.setInt(5, alum.getIdAlumno());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void EliminarDato(Alumno alum) throws AlumnosVacioException {
        String sql = "DELETE FROM alumno WHERE id_alumno = ?";

        try {
            VerificarAlumnosVacia();
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, alum.getIdAlumno());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void VerificarAlumnosVacia() throws AlumnosVacioException {
        String sql = "SELECT * FROM alumno";

        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new AlumnosVacioException("No hay alumnos registrados.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
