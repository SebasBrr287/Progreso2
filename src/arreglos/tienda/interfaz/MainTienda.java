package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.Juego;
import arreglos.tienda.modelo.AppStore;
import java.util.Scanner;

public class MainTienda {
    static void main(){
Scanner scanner = new Scanner(System.in);
        AppStore tienda = new AppStore();
        int opcion = 0;

        do {
            System.out.println("\n=======================================");
            System.out.println("      SISTEMA DE GESTION - APPSTORE    ");
            System.out.println("=======================================");
            System.out.println("1. Agregar juegos");
            System.out.println("2. Visualizar");
            System.out.println("3. Comprar (Aumentar licencias)");
            System.out.println("4. Vender (Disminuir licencias)");
            System.out.println("5. Consultar (Buscar juego)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion (1-6): ");
            
            // Validación básica de entrada numérica
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada
            } else {
                System.out.println("\n[!] Error: Ingrese un numero valido.");
                scanner.nextLine(); // Limpiar entrada incorrecta
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR NUEVO JUEGO ---");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Memoria (GB): ");
                    int memoria = scanner.nextInt();
                    System.out.print("Precio ($): ");
                    double precio = scanner.nextDouble();
                    System.out.print("Licencias iniciales disponibles: ");
                    int licencias = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    Juego nuevoJuego = new Juego(nombre, categoria, memoria, precio, licencias);
                    
                    // Como el arreglo tiene un límite (Max = 4) y `indice` empieza en -1 tras cargar 2 datos, 
                    // verificamos si hay espacio (indice < Max - 1).
                    // Nota: En tu AppStore, el metodo agregarJuego usa indice < Max - 1.
                    try {
                        tienda.agregarJuego(nuevoJuego);
                        System.out.println("\n[Éxito] ¡Juego agregado correctamente!");
                    } catch (Exception e) {
                        System.out.println("\n[!] No se pudo agregar el juego (capacidad maxima alcanzada o datos invalidos).");
                    }
                    break;
                    
                case 2:
                    System.out.println("\n--- LISTA DE JUEGOS DISPONIBLES ---");
                    // Nota: Tu método sacarJuegos recorre hasta `i < indice`. 
                    // Ojo: si `indice` apunta al último elemento añadido, para recorrerlo por completo 
                    // debería ser `i <= indice`. Aquí te mostramos lo que retorna tu método actual:
                    System.out.println(tienda.sacarJuegos());
                    break;
                    
                case 3:
                    System.out.println("\n--- COMPRAR LICENCIAS (STOCK) ---");
                    System.out.print("Ingrese el nombre del juego: ");
                    String juegoCompra = scanner.nextLine();
                    System.out.print("Cantidad de licencias a comprar/agregar: ");
                    int cantCompra = scanner.nextInt();
                    scanner.nextLine();

                    boolean comprado = tienda.comprar(juegoCompra, cantCompra);
                    if (comprado) {
                        System.out.println("\n[Éxito] Stock actualizado correctamente.");
                    } else {
                        System.out.println("\n[!] No se encontro el juego o la cantidad es invalida.");
                    }
                    break;
                    
                case 4:
                    System.out.println("\n--- VENDER LICENCIAS ---");
                    System.out.print("Ingrese el nombre del juego a vender: ");
                    String juegoVenta = scanner.nextLine();
                    System.out.print("Cantidad de licencias a vender: ");
                    int cantVenta = scanner.nextInt();
                    scanner.nextLine();

                    double totalVenta = tienda.vender(juegoVenta, cantVenta);
                    if (totalVenta > 0) {
                        System.out.println("\n[Éxito] Venta realizada con exito.");
                        System.out.println("Total a pagar por el cliente: $" + totalVenta);
                    } else {
                        System.out.println("\n[!] Venta fallida (Verifique el nombre o las licencias disponibles).");
                    }
                    break;
                    
                case 5:
                    System.out.println("\n--- CONSULTAR JUEGO ---");
                    System.out.print("Ingrese el nombre del juego que desea buscar: ");
                    String juegoBusqueda = scanner.nextLine();
                    
                    Juego encontrado = tienda.buscarJuego(juegoBusqueda);
                    if (encontrado != null) {
                        System.out.println("\n[Encontrado]: " + encontrado);
                    } else {
                        System.out.println("\n[!] El juego no se encuentra registrado.");
                    }
                    break;
                    
                case 6:
                    System.out.println("\nSaliendo del sistema de la tienda... ¡Hasta luego!");
                    break;
                    
                default:
                    System.out.println("\n[!] Opcion invalida. Por favor, ingrese un numero del 1 al 6.");
            }

        } while (opcion != 6);
        
        scanner.close();
    }
    }
}
