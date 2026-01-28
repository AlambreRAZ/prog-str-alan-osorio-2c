import java.util.Scanner;

/**
 * Clase principal que muestra un menú en consola para realizar
 * diferentes operaciones matemáticas y conversiones.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- MENÚ -----");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular área de un círculo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    calcularIMC(scanner);
                    break;
                case 2:
                    calcularAreaRectangulo(scanner);
                    break;
                case 3:
                    convertirCelsiusAFahrenheit(scanner);
                    break;
                case 4:
                    calcularAreaCirculo(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta otra vez.");
            }

            System.out.println();

        } while (opcion != 5);

        scanner.close();
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC) a partir del peso y la altura.
     *
     * @param scanner objeto Scanner para leer datos del usuario
     */
    public static void calcularIMC(Scanner scanner) {
        System.out.print("Ingrese su peso en kg: ");
        double peso = scanner.nextDouble();

        System.out.print("Ingrese su altura en metros: ");
        double altura = scanner.nextDouble();

        double imc = peso / (altura * altura);
        System.out.println("Su IMC es: " + imc);
    }

    /**
     * Calcula el área de un rectángulo usando base y altura.
     *
     * @param scanner objeto Scanner para leer datos del usuario
     */
    public static void calcularAreaRectangulo(Scanner scanner) {
        System.out.print("Ingrese la base: ");
        double base = scanner.nextDouble();

        System.out.print("Ingrese la altura: ");
        double altura = scanner.nextDouble();

        double area = base * altura;
        System.out.println("El área del rectángulo es: " + area);
    }

    /**
     * Convierte una temperatura de grados Celsius a Fahrenheit.
     *
     * @param scanner objeto Scanner para leer datos del usuario
     */
    public static void convertirCelsiusAFahrenheit(Scanner scanner) {
        System.out.print("Ingrese grados Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = (celsius * 1.8) + 32;
        System.out.println("Equivale a: " + fahrenheit + " °F");
    }

    /**
     * Calcula el área de un círculo usando el radio.
     *
     * @param scanner objeto Scanner para leer datos del usuario
     */
    public static void calcularAreaCirculo(Scanner scanner) {
        System.out.print("Ingrese el radio: ");
        double radio = scanner.nextDouble();

        double area = Math.PI * radio * radio;
        System.out.println("El área del círculo es: " + area);
    }
}
