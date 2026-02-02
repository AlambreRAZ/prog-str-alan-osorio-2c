import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int numeroSecreto = rand.nextInt(100) + 1; // 1 a 100
        int intentos = 0;
        int maxIntentos = 7;
        boolean gano = false;
        int fueraDeRango = 0;
        int noNumericos = 0;
        System.out.println(" Adivina el número (1 a 100)");
        while (intentos < maxIntentos && !gano) {
            System.out.println("Intento " + (intentos + 1) + " de " + maxIntentos);
            System.out.print("Ingresa un número: ");
            if (!sc.hasNextInt()) { // valida si NO es número
                System.out.println(" Entrada no numérica.");
                noNumericos++;
                sc.next(); // limpia la entrada incorrecta
                continue;
            }
            int intento = sc.nextInt();
            if (intento < 1 || intento > 100) {
                System.out.println("Número fuera de rango (1 a 100).");
                fueraDeRango++;
                continue;
            }
            intentos++;
            if (intento == numeroSecreto) {
                System.out.println("¡Ganaste!");
                gano = true;
            } else if (intento < numeroSecreto) {
                System.out.println("El número secreto es MAYOR.");
            } else {
                System.out.println("El número secreto es MENOR.");
            }
        }
        if (!gano) {
            System.out.println("Perdiste. El número secreto era: " + numeroSecreto);
        }
        System.out.println("\n Estadísticas:");
        System.out.println("Veces fuera de rango: " + fueraDeRango);
        System.out.println("Entradas no numéricas: " + noNumericos);
    }
}
