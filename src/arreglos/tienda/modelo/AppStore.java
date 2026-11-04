package arreglos.tienda.modelo;

public class AppStore {

    private static final int Max = 4;
     private Juego juegos[];
     private int indice;

     public AppStore(){

         juegos = new Juego[Max];
         indice = -1;
         cargarDatos();
     }

     private void cargarDatos(){
         juegos[++indice] = new Juego("Fifa2026","Deportes",15,45,50);
         juegos[++indice] = new Juego("Roblox","Acción",23,59,80);
     }

    public Juego[] getJuegos(){
         return juegos;
    }

     // Toda clase que tenga un arreglo o colección debe tener 2 funciones: 1.Agregar datos y 2.Buscar datos

     public void agregarJuego(Juego j){
         if (j != null && indice < Max -1){
             juegos[++indice] = j;

         }

     }

    public Juego buscarJuego(String nombre) {
        for (int i = 0; i < indice; i++){
            if(juegos[i].getNombre().equalsIgnoreCase(nombre)){
                return juegos[i];
            }
        }
        return null;
    }

    public boolean comprar(String nombre,int cantidad){
         Juego j1 = buscarJuego(nombre);
         if (j1 != null){
             return j1.comprar(cantidad);
         }
         return false;
    }

    public double vender(String nombre,int cantidad){
        Juego j1 = buscarJuego(nombre);
        if (j1 != null){
             if (j1.vender(cantidad)){
                 return cantidad * j1.getPrecio();
             }
        }
        return 0;
    }

    public String sacarJuegos(){
         String juegoS = "";
        for (int i = 0; i < indice; i++) {
            juegoS += juegos[i];
            juegoS += "\n";
        }
        return !juegoS.trim().isBlank()?juegoS:"No hy juegos a mostar";
    }
}
