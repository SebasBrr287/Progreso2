package arreglos.tienda.modelo;

public class Juego {
    private String nombre;
    private String categoria;
    private int memoria;
    private double precio;
    private int licenciasDisponibles;
    private int licenciasVendidas;


    public Juego(String nombre, String categoria, int memoria, double precio, int licenciasDisponibles) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.memoria = memoria;
        this.precio = precio;
        this.licenciasDisponibles = licenciasDisponibles;

        licenciasVendidas = 0;
    }


}
