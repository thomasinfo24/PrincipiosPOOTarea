public class Main {
    public static void main(String[] args) {
        // Crear una instancia de GestorAcademico
        GestorAcademico gestor = new GestorAcademico();

        // creando instancias de Estudiante con atributos
        Estudiante estudiante1 = new Estudiante(1, "pedro", "lopez", "2010-02-03", "matriculado");
        Estudiante estudiante2 = new Estudiante(2, "Ana", "García", "2009-02-11", "matriculado");
        // creando instancias de curso con atributos
        Curso curso1 = new Curso(1, "progra", "creacion de algoritmos", 10, "2.1");
        Curso curso2 = new Curso(2, "compu", "conceptos basicos de computtacion", 10, "2.0");

        // matriculando estudiantes utilizando el gestor académico
        gestor.matricularEstudiante(estudiante1);
        gestor.matricularEstudiante(estudiante2);

        // agregando cursos utilizando el gestor académico
        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);

        try {
            gestor.inscribirEstudianteCurso(estudiante1, 1);
            gestor.inscribirEstudianteCurso(estudiante2, 1);
            gestor.inscribirEstudianteCurso(estudiante1, 2);

            gestor.desinscribirEstudianteCurso(1, 1);
            gestor.desinscribirEstudianteCurso(2, 1);
        } catch (EstudianteYaInscritoException | EstudianteNoInscritoEnCursoException e) {
            System.err.println(e.getMessage());
        }
    }
}
