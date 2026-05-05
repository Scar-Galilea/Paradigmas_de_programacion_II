package Sistema;
public class AsignacionTutorAlumno{

    private int idAsignacion;
    private int idProfesor;
    private int idAlumno;
    private String fechaAsignacion;

    // Constructor vacío
    public AsignacionTutorAlumno() {
    }

    // Constructor con parámetros
    public AsignacionTutorAlumno(int idAsignacion, int idProfesor, int idAlumno, String fechaAsignacion) {
        this.idAsignacion = idAsignacion;
        this.idProfesor = idProfesor;
        this.idAlumno = idAlumno;
        this.fechaAsignacion = fechaAsignacion;
    }

    // Getters y Setters
    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(String fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
}
