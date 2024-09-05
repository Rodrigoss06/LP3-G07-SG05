package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String nombre;
    private String apelPaterno;
    private String apelMaterno;
    private String email;
    private int numeroDocumento;
    private List<Curso> cursosAsignados;

    public Profesor(String nombre, String apelPaterno, String apelMaterno, String email, int numeroDocumento) {
        this.nombre = nombre;
        this.apelPaterno = apelPaterno;
        this.apelMaterno = apelMaterno;
        this.email = email;
        this.numeroDocumento = numeroDocumento;
        this.cursosAsignados = new ArrayList<>();
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

    public List<Curso> getCursosAsignados() {
        return cursosAsignados;
    }

    public void setCursosAsignados(List<Curso> cursosAsignados) {
        this.cursosAsignados = cursosAsignados;
    }

    public void asignarCurso(Curso curso) {
        this.cursosAsignados.add(curso);
    }

    public void mostrarCursosAsignados() {
        System.out.println("Cursos asignados a " + nombre + " " + apelPaterno + " " + apelMaterno + ":");
        for (Curso curso : cursosAsignados) {
            curso.mostrarDetalles();
        }
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", apelPaterno='" + apelPaterno + '\'' +
                ", apelMaterno='" + apelMaterno + '\'' +
                ", email='" + email + '\'' +
                ", numeroDocumento=" + numeroDocumento +
                ", cursosAsignados=" + cursosAsignados +
                '}';
    }
}