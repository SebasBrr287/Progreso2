package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.Juego;
import arreglos.tienda.modelo.AppStore;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    public static void main(String[] args) {
        int opc;
        do {
            menu();
            opc = leerEnteroEnRango("Ingrese una opcion: ", 1, 7);
            switch (opc) {
                case 1: {
                    System.out.println("\n--- Ingresar Juego ---");
                    // Ejemplo de validación para precio o stock positivos
                    // double precio = leerDoublePositivo("Ingrese el precio del juego: ");
                }
                break;
                case 2: {
                    System.out.println("\n--- Mostrar Juegos ---");
                }
                break;
                case 3: {
                    System.out.println("\n--- Buscar Juego ---");
                }
                break;
                case 4: {
                    System.out.println("\n--- Comprar Juego ---");
                }
                break;
                case 5: {
                    System.out.println("\n--- Vender Juego ---");
                }
                break;
                case 6: {
                    System.out.println("\n--- Juego Más Vendido ---");
                }
                break;
                case 7: {
                    System.out.println("Gracias por usar nuestros servicios");
                }
                break;
            }
            System.out.println();
        } while (opc != 7);
    }

    public static void menu() {
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
    }

    // --- MÉTODOS DE VALIDACIÓN AUXILIARES ---

    /** Lee un número entero asegurando que esté dentro de un rango min y max (ej: menú 1 al 7) */
    public static int leerEnteroEnRango(String mensaje, int min, int max) {
        int valor = 0;
        boolean valido = false;
        do {
            System.out.print(mensaje);
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

    /** Valida que un número entero sea estrictamente positivo (> 0) o mayor o igual a cero (>= 0) */
    public static int leerEnteroPositivo(String mensaje, boolean permitirCero) {
        int valor = 0;
        boolean valido = false;
        do {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(sc.nextLine());
                if (permitirCero ? valor >= 0 : valor > 0) {
                    valido = true;
                } else {
                    System.out.println("Error: El número debe ser " + (permitirCero ? "mayor o igual a 0." : "positivo (> 0)."));
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un valor numérico válido.");
            }
        } while (!valido);
        return valor;
    }

    /** Valida que un número decimal (ej. precios) sea positivo */
    public static double leerDoublePositivo(String mensaje) {
        double valor = 0.0;
        boolean valido = false;
        do {
            System.out.print(mensaje);
            try {
                valor = Double.parseDouble(sc.nextLine());
                if (valor > 0) {
                    valido = true;
                } else {
                    System.out.println("Error: El valor debe ser mayor a 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número decimal válido.");
            }
        } while (!valido);
        return valor;
    }
}


