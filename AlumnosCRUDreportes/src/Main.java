import java.util.Scanner;

public class Main {
    static Alumno[] alumnos = new Alumno[25];
    static int numAlumnos = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID (solo activos)");
            System.out.println("3) Actualizar promedio por ID (solo activos)");
            System.out.println("4) Baja lógica por ID");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1: registrarAlumno(sc); break;
                case 2: buscarAlumno(sc); break;
                case 3: actualizarPromedio(sc); break;
                case 4: bajaLogica(sc); break;
                case 5: listarActivos(); break;
                case 6: reportes(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida");
            }
        } while(opcion != 0);
    }
    static void registrarAlumno(Scanner sc) {
        if (numAlumnos >= alumnos.length) {
            System.out.println("No hay espacio disponible en el sistema.");
            return;
        }

        System.out.print("Ingrese ID: ");
        int id = sc.nextInt(); sc.nextLine();
        if (id <= 0 || existeId(id)) {
            System.out.println("El ID no es válido o ya está registrado.");
            return;
        }

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese promedio: ");
        double promedio = sc.nextDouble(); sc.nextLine();
        if (!(promedio >= 0 && promedio <= 10)) {
            System.out.println("El promedio debe estar entre 0 y 10.");
            return;
        }

        alumnos[numAlumnos++] = new Alumno(id, nombre, promedio);
        System.out.println("Registro exitoso del alumno.");
    }


    static boolean existeId(int id) {
        for (int i = 0; i < numAlumnos; i++) {
            if (alumnos[i].id == id) return true;
        }
        return false;
    }

    static void buscarAlumno(Scanner sc) {
        System.out.print("ID a buscar: ");
        int id = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < numAlumnos; i++) {
            if (alumnos[i].id == id && alumnos[i].activo) {
                System.out.println("Encontrado: " + alumnos[i].id + " - " + alumnos[i].nombre + " - " + alumnos[i].promedio);
                return;
            }
        }
        System.out.println("El alumno no existe o está dado de baja.");
    }

    static void actualizarPromedio(Scanner sc) {
        System.out.print("ID a actualizar: ");
        int id = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < numAlumnos; i++) {
            if (alumnos[i].id == id && alumnos[i].activo) {
                System.out.print("Nuevo promedio: ");
                double nuevo = sc.nextDouble(); sc.nextLine();
                if (nuevo < 0 || nuevo > 10) {
                    System.out.println("Promedio inválido.");
                    return;
                }
                alumnos[i].promedio = nuevo;
                System.out.println("Promedio actualizado.");
                return;
            }
        }
        System.out.println("No encontrado o inactivo.");
    }

    static void bajaLogica(Scanner sc) {
        System.out.print("ID a dar de baja: ");
        int id = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < numAlumnos; i++) {
            if (alumnos[i].id == id && alumnos[i].activo) {
                alumnos[i].activo = false;
                System.out.println("Alumno dado de baja.");
                return;
            }
        }
        System.out.println("No encontrado o ya inactivo.");
    }

    static void listarActivos() {
        System.out.println("Alumnos activos:");
        for (int i = 0; i < numAlumnos; i++) {
            if (alumnos[i].activo) {
                System.out.println(alumnos[i].id + " - " + alumnos[i].nombre + " - " + alumnos[i].promedio);
            }
        }
    }

    static void reportes() {
        double suma = 0;
        int activos = 0;
        Alumno mayor = null, menor = null;
        int conOcho = 0;

        for (int i = 0; i < numAlumnos; i++) {
            if (alumnos[i].activo) {
                suma += alumnos[i].promedio;
                activos++;
                if (mayor == null || alumnos[i].promedio > mayor.promedio) mayor = alumnos[i];
                if (menor == null || alumnos[i].promedio < menor.promedio) menor = alumnos[i];
                if (alumnos[i].promedio >= 8.0) conOcho++;
            }
        }

        if (activos == 0) {
            System.out.println("No hay alumnos activos.");
            return;
        }

        System.out.println("Promedio general: " + (suma / activos));
        System.out.println("Mayor promedio: " + mayor.id + " - " + mayor.nombre + " - " + mayor.promedio);
        System.out.println("Menor promedio: " + menor.id + " - " + menor.nombre + " - " + menor.promedio);
        System.out.println("Alumnos con promedio >= 8.0: " + conOcho);
    }
}
