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

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getMemoria() {
        return memoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getLicenciasDisponibles() {
        return licenciasDisponibles;
    }

    public int getLicenciasVendidas() {
        return licenciasVendidas;
    }

    public void setNombre(String nombre) {

        if (nombre != null && !nombre.trim().isBlank())
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        if (categoria != null && !categoria.trim().isBlank())
        this.categoria = categoria;
    }

    public void setMemoria(int memoria) {
        if (memoria >0){
            this.memoria = memoria;
        }

    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        }
    }

}
