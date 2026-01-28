import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir datos
        System.out.print("Ingresa tu edad: ");
        int edad = sc.nextInt();

        System.out.print("¿Eres estudiante? (true/false): ");
        boolean esEstudiante = sc.nextBoolean();

        int tarifa;

        // Validaciones con if-else
        if (edad < 0 || edad > 120) {
            System.out.println("Edad inválida");
            return; // termina el programa
        } else if (edad < 12) {
            tarifa = 50;
        } else if (edad >= 12 && edad <= 17) {
            if (esEstudiante) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        } else { // edad >= 18
            if (esEstudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }

        // Imprimir resultados
        System.out.println("Edad ingresada: " + edad);
        System.out.println("Es estudiante: " + esEstudiante);
        System.out.println("Tarifa final: " + tarifa);

        sc.close();
    }
}