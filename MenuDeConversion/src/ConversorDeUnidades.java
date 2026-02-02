import java.util.Scanner;
public class ConversorDeUnidades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        // Contadores
        int cAF = 0;
        int fAC = 0;
        int kmAMillas = 0;
        int millasAKm = 0;
        do {
            System.out.println(" MENÚ DE CONVERSIÓN");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");
            System.out.print("Elige una opción: ");

            if (!sc.hasNextInt()) {
                System.out.println("Opción no numérica.");
                sc.next();
                continue;
            }
            opcion = sc.nextInt();

            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción inválida. Debe ser entre 1 y 5.");
                continue;
            }
            switch (opcion) {
                case 1:
                    System.out.print("Ingresa grados Celsius: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Entrada no numérica.");
                        sc.next();
                        break;
                    }
                    double c = sc.nextDouble();
                    double f = (c * 9 / 5) + 32;
                    System.out.println("Resultado: " + f + " °F");
                    cAF++;
                    break;
                case 2:
                    System.out.print("Ingresa grados Fahrenheit: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Entrada no numérica.");
                        sc.next();
                        break;
                    }
                    double f2 = sc.nextDouble();
                    double c2 = (f2 - 32) * 5 / 9;
                    System.out.println("Resultado: " + c2 + " °C");
                    fAC++;
                    break;
                case 3:
                    System.out.print("Ingresa kilómetros: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Entrada no numérica.");
                        sc.next();
                        break;
                    }
                    double km = sc.nextDouble();
                    double millas = km * 0.621371;
                    System.out.println("Resultado: " + millas + " millas");
                    kmAMillas++;
                    break;
                case 4:
                    System.out.print("Ingresa millas: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Entrada no numérica.");
                        sc.next();
                        break;
                    }
                    double mill = sc.nextDouble();
                    double km2 = mill / 0.621371;
                    System.out.println("Resultado: " + km2 + " km");
                    millasAKm++;
                    break;
                case 5:
                    salir = true;
                    break;
            }
        } while (!salir);
        int total = cAF + fAC + kmAMillas + millasAKm;
        System.out.println("RESUMEN");
        System.out.println("Total de conversiones: " + total);
        System.out.println("°C a °F: " + cAF);
        System.out.println("°F a °C: " + fAC);
        System.out.println("Km a Millas: " + kmAMillas);
        System.out.println("Millas a Km: " + millasAKm);
        System.out.println("Programa terminado.");
    }
}
