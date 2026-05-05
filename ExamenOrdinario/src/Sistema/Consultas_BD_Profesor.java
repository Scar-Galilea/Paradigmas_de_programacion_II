package Sistema;
import java.sql.*;

public class Consultas_BD_Profesor {

    public void insertar(Profesor profe) throws SQLException {
        String sql = "INSERT INTO profesor (nombre, apellido, correo, telefono) VALUES (?, ?, ?, ?)";

        Connection con = Conexion_BD.conexion();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, profe.getNombre());
        ps.setString(2, profe.getApellido());
        ps.setString(3, profe.getCorreo());
        ps.setInt(4, profe.getTelefono());

        ps.executeUpdate();
    }

    // 🔹 MOSTRAR PROFESORES
    public String leerDatos() throws ProfesorVacioException {
        StringBuilder datos = new StringBuilder();
        String sql = "SELECT * FROM profesor";

        try {
            VerificarProfesorVacia();
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                datos.append("ID: ").append(rs.getInt("id_profesor")).append("\n");
                datos.append("Nombre: ").append(rs.getString("nombre")).append("\n");
                datos.append("Apellido: ").append(rs.getString("apellido")).append("\n");
                datos.append("Correo: ").append(rs.getString("correo")).append("\n");
                datos.append("Teléfono: ").append(rs.getInt("telefono")).append("\n");
                datos.append("------------------------------\n");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return datos.toString();
    }

    // 🔹 SOLO NOMBRES (ASIGNACIÓN)
    public String leerNombre() throws ProfesorVacioException {
        StringBuilder datos = new StringBuilder();
        String sql = "SELECT * FROM profesor";

        try {
            VerificarProfesorVacia();
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                datos.append(rs.getInt("id_profesor"))
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

    public void ActualizarDato(Profesor profe) throws ProfesorVacioException {
        String sql = "UPDATE profesor SET nombre = ?, apellido = ?, correo = ?, telefono = ? WHERE id_profesor = ?";

        try {
            VerificarProfesorVacia();
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, profe.getNombre());
            ps.setString(2, profe.getApellido());
            ps.setString(3, profe.getCorreo());
            ps.setInt(4, profe.getTelefono());
            ps.setInt(5, profe.getIdProfesor());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void EliminarDato(Profesor profe) throws ArchivoProfesorException, ProfesorVacioException {
        String sql = "DELETE FROM profesor WHERE id_profesor = ?";

        try {
            VerificarProfesorVacia();
            VerificarProfesor(profe.getIdProfesor());
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, profe.getIdProfesor());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void VerificarProfesor(int id_profesor) throws ArchivoProfesorException {
        String sql = "SELECT IF (exists(SELECT * FROM asignacion WHERE id_profesor = ?), 0, 1) AS verificacion";

        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_profesor);
            ResultSet rs = ps.executeQuery();

            if (rs.next() && rs.getInt("verificacion") == 0) {
                throw new ArchivoProfesorException("El profesor tiene una asignación, no se puede eliminar");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void VerificarProfesorVacia() throws ProfesorVacioException {
        String sql = "SELECT * FROM profesor";

        try {
            Connection con = Conexion_BD.conexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new ProfesorVacioException("No hay profesores registrados.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
