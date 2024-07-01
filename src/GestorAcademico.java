import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private HashMap<Integer, ArrayList<Estudiante>> estudiantesPorCurso = new HashMap<>();


    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
            System.out.println("Estudiante matriculado: " + estudiante.getNombre() + " " + estudiante.getApellido());
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            estudiantesPorCurso.put(curso.getId(), new ArrayList<>());
            System.out.println("Curso agregado: " + curso.getNombre());
        }
    }
    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        if (estudiantesPorCurso.containsKey(idCurso)) {
            ArrayList<Estudiante> inscritos = estudiantesPorCurso.get(idCurso);
            if (inscritos.contains(estudiante)) {
                throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
            } else {
                inscritos.add(estudiante);
                estudiantesPorCurso.put(idCurso, inscritos);
            }
        } else {
            throw new IllegalArgumentException("ID de curso no válido.");
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        if (estudiantesPorCurso.containsKey(idCurso)) {
            ArrayList<Estudiante> inscritos = estudiantesPorCurso.get(idCurso);
            boolean removed = inscritos.removeIf(estudiante -> estudiante.getId() == idEstudiante);
            if (!removed) {
                throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
            } else {
                estudiantesPorCurso.put(idCurso, inscritos);
            }
        } else {
            throw new IllegalArgumentException("ID de curso no válido.");
        }
    }
}
