package ejercicios;

import java.util.List;

public class Curso {
    static class Grupo {
        private String ambiente;
        private int cantidadMatriculados;
        private String diaSemana;
        private String horaFin;
        private String horaInicio;
        private String matriculadosCupos;
        private String nombreDocente;
        private String seccionGrupo;
        private String tipoAsignatura;
        private int topeSeccionGrupo;
        private String nombreModalidad;

        public Grupo(String ambiente, int cantidadMatriculados, String diaSemana, String horaFin, String horaInicio, String matriculadosCupos, String nombreDocente, String seccionGrupo, String tipoAsignatura, int topeSeccionGrupo, String nombreModalidad) {
            this.ambiente = ambiente;
            this.cantidadMatriculados = cantidadMatriculados;
            this.diaSemana = diaSemana;
            this.horaFin = horaFin;
            this.horaInicio = horaInicio;
            this.matriculadosCupos = matriculadosCupos;
            this.nombreDocente = nombreDocente;
            this.seccionGrupo = seccionGrupo;
            this.tipoAsignatura = tipoAsignatura;
            this.topeSeccionGrupo = topeSeccionGrupo;
            this.nombreModalidad = nombreModalidad;
        }

        @Override
        public String toString() {
            return "Grupo{" +
                    "ambiente='" + ambiente + '\'' +
                    ", cantidadMatriculados=" + cantidadMatriculados +
                    ", diaSemana='" + diaSemana + '\'' +
                    ", horaFin='" + horaFin + '\'' +
                    ", horaInicio='" + horaInicio + '\'' +
                    ", matriculadosCupos='" + matriculadosCupos + '\'' +
                    ", nombreDocente='" + nombreDocente + '\'' +
                    ", seccionGrupo='" + seccionGrupo + '\'' +
                    ", tipoAsignatura='" + tipoAsignatura + '\'' +
                    ", topeSeccionGrupo=" + topeSeccionGrupo +
                    ", nombreModalidad='" + nombreModalidad + '\'' +
                    '}';
        }

        public Boolean cuposDisponibles() {
            return cantidadMatriculados < Integer.parseInt(matriculadosCupos);
        }

        public void agregarEstudiante(Estudiante alumno) {
            if (cuposDisponibles()) {
                this.cantidadMatriculados += 1;
                alumno.matricularAsignatura(this);
                System.out.println("Inscripción completada.");
            } else {
                System.out.println("No hay cupos disponibles.");
            }
        }
    }

    private List<Grupo> grupos;

    public Curso(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public void mostrarDetalles() {
        for (Grupo grupo : grupos) {
            System.out.println(grupo);
        }
    }

    public Grupo getGrupo(String seccion) {
        for (Grupo grupo : grupos) {
            if (grupo.seccionGrupo.equalsIgnoreCase(seccion)) {
                return grupo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "grupos=" + grupos +
                '}';
    }
}