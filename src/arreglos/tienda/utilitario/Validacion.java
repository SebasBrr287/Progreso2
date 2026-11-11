package arreglos.tienda.utilitario;

import java.util.Scanner;

public class Validacion {
    private static Scanner sc = new Scanner(System.in);

    // 1. Validación de Texto
    public static String leerString(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje + " : ");
            texto = sc.nextLine();
            if (texto == null || texto.trim().isEmpty()) {
                System.out.println("Error: El texto no puede estar vacío.");
            }
        } while (texto == null || texto.trim().isEmpty());
        return texto.trim();
    }

    // 2. Validación de Entero en Rango
    public static int leerEnteroEnRango(String mensaje, int min, int max) {
        int valor = 0;
        boolean valido = false;
        do {
            System.out.print(mensaje + " : ");
            String entrada = sc.nextLine();
            try {
                valor = Integer.parseInt(entrada);
                if (valor >= min && valor <= max) {
                    valido = true;
                } else {
                    System.out.println("Error: El número debe estar entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
            }
        } while (!valido);
        return valor;
    }

    // 3. Validación de Número Decimal Positivo
    public static double leerDoublePositivo(String mensaje) {
        double valor = 0.0;
        boolean valido = false;
        do {
            System.out.print(mensaje + " : ");
            String entrada = sc.nextLine();
            try {
                valor = Double.parseDouble(entrada);
                if (valor > 0) {
                    valido = true;
                } else {
                    System.out.println("Error: El valor debe ser mayor a 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        } while (!valido);
        return valor;
    }

}


