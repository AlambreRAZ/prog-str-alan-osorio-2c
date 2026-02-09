import java.util.Scanner;

/**
 * Clase principal que revisa la entrada de datos y la impresion del reporte
 */
public class App {

    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;
        do {
            System.out.print(msg);
            texto = sc.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        do {
            System.out.print(msg);
            while (!sc.hasNextDouble()) {
                System.out.println(("Error: ingrese un numero valido"));
           sc.next();
            }
            valor = sc.nextDouble();
        } while (valor < min || valor > max);
        sc.nextLine(); //limpiar buffer
        return valor;
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        do {
            System.out.print(msg);
            while (!sc.hasNext()){
                System.out.println("Error: ingrese un numero entero");
                sc.next();
            }
            valor = sc.nextInt();
        } while (valor < min || valor > max);
        sc.nextLine(); //limpiar buffer
        return valor;
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        System.out.print(msg);
        while (!sc.hasNextBoolean()) {
            System.out.println("Error: ingrese true o false.");
            sc.next();
        }
        boolean valor =sc.nextBoolean();
        sc.nextLine(); //limpiar buffer
        return valor;
    }

    public static void imprimirReporte(String nombre, double p1, double p2, double p3,
                                       double promedio, int asistencia, boolean entregoProyecto,
                                       double finalCalif, String estado) {
        System.out.println("----- REPORTE FINAL -----");
        System.out.println("Alumno: " + nombre);
        System.out.println("Parcial 1: " + p1);
        System.out.println("Parcial 2: " + p2);
        System.out.println("Parcial 3: " + p3);
        System.out.println("Promedio parciales: " + promedio);
        System.out.println("Asistencia: " + asistencia);
        System.out.println("Entregó proyecto: " + entregoProyecto);
        System.out.println("Calificación final: " + finalCalif);
        System.out.println("Estado: " + estado);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService service = new GradeService();

        String nombre = leerTextoNoVacio(sc, "Nombre del alumno: ");
        double p1 = leerDoubleEnRango(sc, "Parcial 1 (0-100): ", 0, 100);
        double p2 = leerDoubleEnRango(sc, "Parcial 2 (0-100): ", 0, 100);
        double p3 = leerDoubleEnRango(sc, "Parcial 3 (0-100): ", 0, 100);
        int asistencia = leerIntEnRango(sc, "Asistencia (0-100): ", 0, 100);
        boolean entregoProyecto = leerBoolean(sc, "¿Entregó proyecto? (true/false): ");

        double promedio = service.calcularPromedio(p1, p2, p3);
        double finalCalif = service.calcularFinal(promedio, asistencia);
        String estado = service.determinarEstado(finalCalif, asistencia, entregoProyecto);

        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto, finalCalif, estado);

        sc.close();
    }
}
