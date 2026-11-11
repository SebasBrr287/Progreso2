package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.Juego;
import arreglos.tienda.modelo.*;
import arreglos.tienda.utilitario.Validacion;

import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    public static void main(String[] args) {
        int opc;
        do {
            menu();
            opc = Validacion.leerEnteroEnRango("Ingrese una opcion", 1, 7);
            switch (opc) {
                case 1: {
                    System.out.println("\n--- Ingresar Juego ---");
                    ingresarJuegos();
                }
                break;
                case 2: {
                    System.out.println("\n--- Mostrar Juegos ---");
                    System.out.println(tienda.sacarJuegos());
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

    // Método de ejemplo para ingresar juegos utilizando las validaciones correctamente
    public static void ingresarJuegos() {
        System.out.println("*******Ingreso de datos********");

        // Usamos leerString para texto
        String nombre = Validacion.leerString("Ingrese el nombre");
        String categoria = Validacion.leerString("Ingrese la categoria");
        System.out.print("Ingrese el tamaño: ");
        int tamanio = Integer.parseInt(sc.nextLine());

        System.out.print("Ingrese el precio: ");
        double precio = Double.parseDouble(sc.nextLine());

        System.out.print("Ingrese el stock inicial: ");
        int licenciasDisponibles = Integer.parseInt(sc.nextLine());
        System.out.println("¡Juego registrado con éxito!");
    }

   /*
    public static void mostrarJuegos(){
        /*
        Codigo si mi clase Appstore no tiene el metodo sacarJuegos para mostrar todos los juegos

        Juego juegos[] = tienda.getJuegos();
        if (tienda.getIndice()!= -1){
        for (int i = 0; i <= tienda.getIndice();i++) {
            System.out.println(juegos[i]);
        }
        }else{
            System.out.println("No hay juegos para mostar");
        }
    }
         */

}


