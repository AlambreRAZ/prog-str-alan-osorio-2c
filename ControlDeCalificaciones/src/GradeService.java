/**
 * Clase que contiene la lógica de cálculo de calificaciones y estado del alumno.
 * No realiza operaciones de entrada/salida.
 */
public class GradeService {
    /**
     * Calcula el promedio de tres calificaciones parciales.
     * @param a primera calificación
     * @param b segunda calificación
     * @param c tercera calificación
     * @return promedio de las tres calificaciones
     */
    public double calcularPromedio(double a, double b, double c) {
        return (a + b + c) / 3.0;
    }
    /**
     * Calcula la calificación final ponderada.
     * @param promedio promedio de parciales
     * @param asistencia porcentaje de asistencia
     * @return calificación final
     */
    public double calcularFinal(double promedio, int asistencia) {
        return (promedio * 0.7) + (asistencia * 0.3);
    }
    /**
     * Determina el estado del alumno según reglas de asistencia, proyecto y calificación final.
     * @param finalCalif calificación final
     * @param asistencia porcentaje de asistencia
     * @param entregoProyecto true si entregó proyecto, false si no
     * @return estado del alumno
     */
    public String determinarEstado(double finalCalif, int asistencia, boolean entregoProyecto) {
        if (asistencia < 80) {
            return "REPROBADO por asistencia";
        }
        if (!entregoProyecto) {
            return "REPROBADO por proyecto";
        }
        if (finalCalif >= 70) {
            return "APROBADO";
        } else {
            return "REPROBADO por calificación";
        }
    }
}
