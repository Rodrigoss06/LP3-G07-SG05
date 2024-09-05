package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class SistemaGestion {

    private List<Estudiante> estudiantes;
    private List<Profesor> profesores;
    private List<Curso> cursos;
    private List<Categoria> categorias;

    public SistemaGestion() {
        this.estudiantes = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }

    public Estudiante buscarEstudiantePorCodigo(int codigo) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigoAlumno() == codigo) {
                return estudiante;
            }
        }
        return null;
    }

    public void agregarProfesor(Profesor profesor) {
        this.profesores.add(profesor);
    }

    public Profesor buscarProfesorPorDocumento(int numeroDocumento) {
        for (Profesor profesor : profesores) {
            if (profesor.getNumeroDocumento() == numeroDocumento) {
                return profesor;
            }
        }
        return null;
    }

    public void agregarCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public Curso buscarCursoPorSeccion(String seccion) {
        for (Curso curso : cursos) {
            Curso.Grupo grupo = curso.getGrupo(seccion);
            if (grupo != null) {
                return curso;
            }
        }
        return null;
    }

    public Boolean matricularEnCurso(Curso curso, String seccion, Estudiante estudiante) {
        Curso.Grupo grupo = curso.getGrupo(seccion);
        if (grupo != null) {
            if (grupo.cuposDisponibles()) {
                grupo.agregarEstudiante(estudiante);
                System.out.println("Inscripción completada.");
                return true;
            } else {
                System.out.println("No hay cupos disponibles.");
                return false;
            }
        } else {
            System.out.println("No existe el grupo.");
            return false;
        }
    }

    public Boolean asignarProfesorACurso(Curso curso, String seccion, Profesor profesor) {
        Curso.Grupo grupo = curso.getGrupo(seccion);
        if (grupo != null) {
            if (!profesor.getCursosAsignados().contains(curso)) {
                profesor.asignarCurso(curso);
                System.out.println("Profesor asignado al curso.");
                return true;
            } else {
                System.out.println("El profesor ya está asignado a este curso.");
                return false;
            }
        } else {
            System.out.println("No existe el grupo.");
            return false;
        }
    }

    public void agregarCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }

    public Categoria buscarCategoriaPorNombre(String nombreCategoria) {
        for (Categoria categoria : categorias) {
            if (categoria.getNombreCategoria().equalsIgnoreCase(nombreCategoria)) {
                return categoria;
            }
        }
        return null;
    }

    public void agregarCursoACategoria(Categoria categoria, Curso curso) {
        categoria.agregarCurso(curso);
    }

    public void mostrarEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }

    public void mostrarProfesores() {
        for (Profesor profesor : profesores) {
            System.out.println(profesor);
        }
    }

    public void mostrarCursos() {
        for (Curso curso : cursos) {
            curso.mostrarDetalles();
        }
    }

    public void mostrarCategorias() {
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }

    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();

        Categoria matematicas = new Categoria("Matemáticas", new ArrayList<>());
        Categoria programacion = new Categoria("Programación", new ArrayList<>());
        sistema.agregarCategoria(matematicas);
        sistema.agregarCategoria(programacion);

        Curso.Grupo grupo1 = new Curso.Grupo("Aula 101", 30, "Lunes", "10:00", "08:00", "30", "Dr. Pérez", "A", "Teórica", 30, "Presencial");
        Curso.Grupo grupo2 = new Curso.Grupo("Aula 102", 25, "Martes", "12:00", "10:00", "25", "Dra. Gómez", "B", "Teórica", 25, "Presencial");
        Curso.Grupo grupo3 = new Curso.Grupo("Laboratorio 1", 20, "Miércoles", "14:00", "12:00", "20", "Ing. Díaz", "A", "Práctica", 20, "Presencial");

        Curso.Grupo grupo4 = new Curso.Grupo("Aula 103", 40, "Jueves", "16:00", "14:00", "40", "Prof. López", "A", "Teórica", 40, "Presencial");
        Curso.Grupo grupo5 = new Curso.Grupo("Laboratorio 2", 15, "Viernes", "18:00", "16:00", "15", "Ing. Torres", "B", "Práctica", 15, "Presencial");

        Curso curso1 = new Curso(new ArrayList<>(List.of(grupo1, grupo2, grupo3))); // Curso con 3 grupos
        Curso curso2 = new Curso(new ArrayList<>(List.of(grupo4, grupo5))); // Curso con 2 grupos
        sistema.agregarCurso(curso1);
        sistema.agregarCurso(curso2);

        sistema.agregarCursoACategoria(matematicas, curso1);
        sistema.agregarCursoACategoria(programacion, curso2);

        Estudiante estudiante1 = new Estudiante("Juan", "Pérez", "Gómez", 12345, "juan@example.com", 987654321);
        Estudiante estudiante2 = new Estudiante("Ana", "Martínez", "López", 67890, "ana@example.com", 123456789);
        sistema.agregarEstudiante(estudiante1);
        sistema.agregarEstudiante(estudiante2);

        Profesor profesor1 = new Profesor("Carlos", "Hernández", "Ramírez", "carlos@example.com", 11223344);
        Profesor profesor2 = new Profesor("Laura", "González", "Díaz", "laura@example.com", 22334455);
        sistema.agregarProfesor(profesor1);
        sistema.agregarProfesor(profesor2);

        sistema.asignarProfesorACurso(curso1, "A", profesor1);
        sistema.asignarProfesorACurso(curso2, "B", profesor2);

        sistema.matricularEnCurso(curso1, "A", estudiante1);
        sistema.matricularEnCurso(curso2, "B", estudiante2);

        sistema.mostrarEstudiantes();
        sistema.mostrarProfesores();
        sistema.mostrarCursos();
        sistema.mostrarCategorias();
    }
}