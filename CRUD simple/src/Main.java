import java.util.Scanner;

public class Main {
    // Arreglo de Personas
    static Persona[] personas = new Persona[20];
    // Scanner para leer entradas del usuario
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
           mostrarMenu();
            opcion = leerOpcionValida();
            ejecutarOpcion(opcion);
        } while (opcion != 0);

        System.out.println("Programa finalizado.");
        scanner.close();
    }

    // Muestra el menú de opciones
    private static void mostrarMenu() {
        System.out.println("===== MENÚ DE GESTIÓN =====");
        System.out.println("1) Alta ");
        System.out.println("2) Buscar por ID (solo activas)");
        System.out.println("3) Baja lógica por ID");
        System.out.println("4) Listar personas activas");
        System.out.println("5) Actualizar nombre por ID");
        System.out.println("0) Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Lee y valida que la opción sea un número
    private static int leerOpcionValida() {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Ingrese un número: ");
            scanner.next(); // Limpia el buffer
        }
        return scanner.nextInt();
    }

    // Ejecuta la opción seleccionada
    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                altaPersona();
                break;
            case 2:
                buscarPorIdActiva();
                break;
            case 3:
                bajaLogicaPorId();
                break;
            case 4:
                listarActivas();
                break;
            case 5:
                actualizarNombrePorId();
                break;
            case 0:
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

    // Alta de persona con validaciones
    private static void altaPersona() {
        // Validar ID > 0 y no repetido
        System.out.print("Ingrese ID (> 0): ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpia buffer

        if (id <= 0) {
            System.out.println("Error: ID debe ser mayor a 0.");
            return;
        }

        if (idYaExiste(id)) {
            System.out.println("Error: ID ya registrado.");
            return;
        }

        // Validar nombre no vacío
        System.out.print("Ingrese nombre (no vacío): ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("Error: Nombre no puede estar vacío.");
            return;
        }

        // Agregar al arreglo en la primera posición vacía
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = new Persona(id, nombre);
                System.out.println("Persona dada de alta exitosamente.");
                return;
            }
        }

        System.out.println("Error: Límite de 20 personas alcanzado.");
    }

    // Verifica si un ID ya está registrado
    private static boolean idYaExiste(int id) {
        for (Persona p : personas) {
            if (p != null && p.id == id) {
                return true;
            }
        }
        return false;
    }

    // Buscar persona activa por ID
    private static void buscarPorIdActiva() {
        System.out.print("Ingrese ID a buscar: ");
        int id = scanner.nextInt();
        Persona  p = encontrarPersonaPorId(id);

        if (p != null && p.activa) {
            System.out.println("Encontrada: ID=" + p.id + " | Nombre=" + p.nombre);
        } else {
            System.out.println("Persona no encontrada o inactiva.");
        }
    }

    // Encuentra una persona por ID, devuelve null si no existe
    private static Persona encontrarPersonaPorId(int id) {
        for (Persona p : personas) {
            if (p != null && p.id == id) {
                return p;
            }
        }
        return null;
    }

    // Baja lógica
    private static void bajaLogicaPorId() {
        System.out.print("Ingrese ID para baja lógica: ");
        int id = scanner.nextInt();
        Persona p = encontrarPersonaPorId(id);

        if (p != null) {
            p.activa = false;
            System.out.println("Baja lógica realizada correctamente.");
        } else {
            System.out.println("Error: Persona no encontrada.");
        }
    }

    // Listar todas las personas activas
    private static void listarActivas() {
        System.out.println("\n===== PERSONAS ACTIVAS =====");
        boolean hayActivas = false;

        for (Persona p : personas) {
            if (p != null && p.activa) {
                System.out.println("ID: " + p.id + " | Nombre: " + p.nombre);
                hayActivas = true;
            }
        }

        if (!hayActivas) {
            System.out.println("No hay personas activas registradas.");
        }
    }

    // Actualizar nombre de persona activa
    private static void actualizarNombrePorId() {
        System.out.print("Ingrese ID de la persona a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpia buffer

        Persona p = encontrarPersonaPorId(id);

        if (p == null || !p.activa) {
            System.out.println("Error: Persona no encontrada o inactiva.");
            return;
        }

        System.out.print("Ingrese nuevo nombre (no vacío): ");
        String nuevoNombre = scanner.nextLine().trim();

        if (nuevoNombre.isEmpty()) {
            System.out.println("Error: Nombre no puede estar vacío.");
            return;
        }

        p.nombre = nuevoNombre;
        System.out.println("Nombre actualizado exitosamente.");
    }
}