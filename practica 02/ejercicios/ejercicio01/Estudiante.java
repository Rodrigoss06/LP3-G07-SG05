package ejercicios;

import java.util.ArrayList;
import java.util.List;

import ejercicios.Curso.Grupo;

public class Estudiante {
    private String nombre;
    private String apelPaterno;
    private String apelMaterno;
    private int codigoAlumno;
    private String email;
    private int numeroDocumento;
    private List<Grupo> asignaturasMatriculadas;
    private int creditosDisponibles;

    public Estudiante(String nombre, String apelPaterno, String apelMaterno, int codigoAlumno, String email, int numeroDocumento) {
        this.nombre = nombre;
        this.apelPaterno = apelPaterno;
        this.apelMaterno = apelMaterno;
        this.codigoAlumno = codigoAlumno;
        this.email = email;
        this.numeroDocumento = numeroDocumento;
        this.asignaturasMatriculadas = new ArrayList<>(); // Inicializa la lista de asignaturas
        this.creditosDisponibles = 30; // Ejemplo de créditos disponibles
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelPaterno() {
        return apelPaterno;
    }

    public void setApelPaterno(String apelPaterno) {
        this.apelPaterno = apelPaterno;
    }

    public String getApelMaterno() {
        return apelMaterno;
    }

    public void setApelMaterno(String apelMaterno) {
        this.apelMaterno = apelMaterno;
    }

    public int getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(int codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void matricularAsignatura(Grupo curso) {
        if (this.creditosDisponibles > 3) {
            this.asignaturasMatriculadas.add(curso);
            this.creditosDisponibles -= 3; // Ejemplo: cada curso consume 3 créditos
            System.out.println("Asignatura matriculada con éxito.");
        } else {
            System.out.println("No cuentas con los créditos suficientes para matricularte en esta asignatura.");
        }
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apelPaterno='" + apelPaterno + '\'' +
                ", apelMaterno='" + apelMaterno + '\'' +
                ", codigoAlumno=" + codigoAlumno +
                ", email='" + email + '\'' +
                ", numeroDocumento=" + numeroDocumento +
                ", asignaturasMatriculadas=" + asignaturasMatriculadas +
                ", creditosDisponibles=" + creditosDisponibles +
                '}';
    }
}