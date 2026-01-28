import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Mostrar menú
        System.out.println("Menú de operaciones:");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");

        // Pedir datos
        System.out.print("Elige una opción (1-4): ");
        int opcion = sc.nextInt();

        System.out.print("Ingresa el valor de a: ");
        double a = sc.nextDouble();

        System.out.print("Ingresa el valor de b: ");
        double b = sc.nextDouble();

        double resultado;

        // Switch para elegir operación
        switch (opcion) {
            case 1:
                resultado = a + b;
                System.out.println("Operación elegida: Suma");
                System.out.println("Valores ingresados: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 2:
                resultado = a - b;
                System.out.println("Operación elegida: Resta");
                System.out.println("Valores ingresados: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 3:
                resultado = a * b;
                System.out.println("Operación elegida: Multiplicación");
                System.out.println("Valores ingresados: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 4:
                if (b == 0) {
                    System.out.println("Operación elegida: División");
                    System.out.println("Valores ingresados: a = " + a + ", b = " + b);
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resultado = a / b;
                    System.out.println("Operación elegida: División");
                    System.out.println("Valores ingresados: a = " + a + ", b = " + b);
                    System.out.println("Resultado: " + resultado);
                }
                break;

            default:
                System.out.println("Opción inválida");
                break;
        }

        sc.close();
    }
}