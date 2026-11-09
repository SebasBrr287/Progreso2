package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.Juego;
import arreglos.tienda.modelo.AppStore;
import java.util.Scanner;

public class MainTienda {
    static void main(){
Scanner scanner = new Scanner(System.in);
        AppStore tienda = new AppStore();
        int op = 0;

        do {
            System.out.println("Gestión de tienda");
            System.out.println("1. Agregar juegos");
            System.out.println("2. Visualizar");
            System.out.println("3. Comprar");
            System.out.println("4. Vender");
            System.out.println("5. Consultar");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                op = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada
            } else {
                System.out.println("\n Error: Ingrese un numero valido.");
                scanner.nextLine(); // Limpiar entrada incorrecta
                continue;
            }

            switch (op) {
                case 1:
                    System.out.println("\n Registar nuevo Juego");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Memoria: ");
                    int memoria = scanner.nextInt();
                    System.out.print("Precio: ");
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
                        System.out.println("\nJuego agregado correctamente!");
                    } catch (Exception e) {
                        System.out.println("\nNo se pudo agregar el juego capacidad maxima alcanzada o datos invalidos.");
                    }
                    break;
                    
                case 2:
                    System.out.println("\nLISTA DE JUEGOS DISPONIBLES ");
                    System.out.println(tienda.sacarJuegos());
                    break;
                    
                case 3:
                    System.out.println("\nCOMPRAR LICENCIAS ");
                    System.out.print("Ingrese el nombre del juego: ");
                    String juegoCompra = scanner.nextLine();
                    System.out.print("Cantidad de licencias a agregar: ");
                    int cantCompra = scanner.nextInt();
                    scanner.nextLine();

                    boolean comprado = tienda.comprar(juegoCompra, cantCompra);
                    if (comprado) {
                        System.out.println("\n Stock actualizado correctamente.");
                    } else {
                        System.out.println("\n No se encontro el juego o la cantidad es invalida.");
                    }
                    break;
                    
                case 4:
                    System.out.println("\n VENDER LICENCIAS");
                    System.out.print("Ingrese el nombre del juego a vender: ");
                    String juegoVenta = scanner.nextLine();
                    System.out.print("Cantidad de licencias a vender: ");
                    int cantVenta = scanner.nextInt();
                    scanner.nextLine();

                    double totalVenta = tienda.vender(juegoVenta, cantVenta);
                    if (totalVenta > 0) {
                        System.out.println("\n Venta realizada con exito.");
                        System.out.println("Total a pagar por el cliente: $" + totalVenta);
                    } else {
                        System.out.println("\n Venta fallida Verifique el nombre o las licencias disponibles.");
                    }
                    break;
                    
                case 5:
                    System.out.println("\n CONSULTAR JUEGO");
                    System.out.print("Ingrese el nombre del juego que desea buscar: ");
                    String juegoBusqueda = scanner.nextLine();
                    
                    Juego encontrado = tienda.buscarJuego(juegoBusqueda);
                    if (encontrado != null) {
                        System.out.println("\nEncontrado : " + encontrado);
                    } else {
                        System.out.println("\n El juego no se encuentra registrado.");
                    }
                    break;
                    
                case 6:
                    System.out.println("\n Saliendo del sistema de la tienda... ¡Hasta luego!");
                    break;
                    
                default:
                    System.out.println("\n Opcion invalida. Por favor, ingrese un numero del 1 al 6.");
            }

        } while (op != 6);
        
        scanner.close();
    }
    }
