package ejercicios;

import java.util.List;

public class Categoria {
    private String nombreCategoria;
    private List<Curso> cursos;

    public Categoria(String nombreCategoria, List<Curso> cursos) {
        this.nombreCategoria = nombreCategoria;
        this.cursos = cursos;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void agregarCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public void mostrarCursos() {
        System.out.println("Categoría: " + nombreCategoria);
        for (Curso curso : cursos) {
            curso.mostrarDetalles();
        }
    }

    public Curso buscarCursoPorGrupo(String seccion) {
        for (Curso curso : cursos) {
            Curso.Grupo grupo = curso.getGrupo(seccion);
            if (grupo != null) {
                return curso;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nombreCategoria='" + nombreCategoria + '\'' +
                ", cursos=" + cursos +
                '}';
    }
}
