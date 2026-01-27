import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero = pedirEntero(scanner);
        int resultado = sumarHastaN(numero);

        System.out.println("La suma de los números del 1 hasta " + numero + " es: " + resultado);

        scanner.close();
    }

    public static int pedirEntero(Scanner scanner) {
        System.out.print("Ingrese un número entero: ");
        return scanner.nextInt();
    }

    public static int sumarHastaN(int numero) {
        int suma = 0;

        for (int i = 1; i <= numero; i++) {
            suma += i;
        }

        return suma;
    }
}
