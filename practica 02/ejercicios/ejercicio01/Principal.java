package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class principal {

    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        inicializarDatos(sistema);

        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    sistema.mostrarCategorias();
                    break;
                case 2:
                    sistema.mostrarCursos();
                    break;
                case 3:
                    sistema.mostrarEstudiantes();
                    break;
                case 4:
                    sistema.mostrarProfesores();
                    break;
                case 5:
                    matricularEstudiante(sistema, scanner);
                    break;
                case 6:
                    asignarProfesor(sistema, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- Menú del Sistema de Gestión de Cursos Universitarios ---");
        System.out.println("1. Mostrar Categorías");
        System.out.println("2. Mostrar Cursos");
        System.out.println("3. Mostrar Estudiantes");
        System.out.println("4. Mostrar Profesores");
        System.out.println("5. Matricular Estudiante en un Curso");
        System.out.println("6. Asignar Profesor a un Curso");
        System.out.println("0. Salir");
    }

    public static void inicializarDatos(SistemaGestion sistema) {
        Categoria matematicas = new Categoria("Matemáticas", new ArrayList<>());
        Categoria programacion = new Categoria("Programación", new ArrayList<>());
        sistema.agregarCategoria(matematicas);
        sistema.agregarCategoria(programacion);

        Curso.Grupo grupo1 = new Curso.Grupo("Aula 101", 30, "Lunes", "10:00", "08:00", "30", "Dr. Pérez", "A", "Teórica", 30, "Presencial");
        Curso.Grupo grupo2 = new Curso.Grupo("Aula 102", 24, "Martes", "12:00", "10:00", "25", "Dra. Gómez", "B", "Teórica", 25, "Presencial");
        Curso curso1 = new Curso(new ArrayList<>(List.of(grupo1, grupo2)));
        sistema.agregarCurso(curso1);
        sistema.agregarCursoACategoria(matematicas, curso1);

        Estudiante estudiante1 = new Estudiante("Juan", "Pérez", "Gómez", 12345, "juan@example.com", 987654321);
        sistema.agregarEstudiante(estudiante1);

        Profesor profesor1 = new Profesor("Carlos", "Hernández", "Ramírez", "carlos@example.com", 11223344);
        sistema.agregarProfesor(profesor1);
    }

    public static void matricularEstudiante(SistemaGestion sistema, Scanner scanner) {
        System.out.println("\nIngrese el código del estudiante: ");
        int codigoEstudiante = scanner.nextInt();
        scanner.nextLine();

        Estudiante estudiante = sistema.buscarEstudiantePorCodigo(codigoEstudiante);
        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.println("Ingrese la sección del curso: ");
        String seccion = scanner.nextLine();

        Curso curso = sistema.buscarCursoPorSeccion(seccion);
        if (curso == null) {
            System.out.println("Curso no encontrado.");
            return;
        }

        sistema.matricularEnCurso(curso, seccion, estudiante);
    }

    public static void asignarProfesor(SistemaGestion sistema, Scanner scanner) {
        System.out.println("\nIngrese el número de documento del profesor: ");
        int numeroDocumento = scanner.nextInt();
        scanner.nextLine();

        Profesor profesor = sistema.buscarProfesorPorDocumento(numeroDocumento);
        if (profesor == null) {
            System.out.println("Profesor no encontrado.");
            return;
        }

        System.out.println("Ingrese la sección del curso: ");
        String seccion = scanner.nextLine();

        Curso curso = sistema.buscarCursoPorSeccion(seccion);
        if (curso == null) {
            System.out.println("Curso no encontrado.");
            return;
        }

        sistema.asignarProfesorACurso(curso, seccion, profesor);
    }
}
