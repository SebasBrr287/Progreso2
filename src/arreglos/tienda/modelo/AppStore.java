package arreglos.tienda.modelo;

public class AppStore {

    private static final int Max = 4;
     private Juego juegos[];
     private int indice;

     public AppStore(){

         juegos = new Juego[Max];
         indice = -1;
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

    public Juego bsucarJuego(String nombre) {
        for (int i = 0; i < indice; i++){
            if(juegos[i].getNombre().equalsIgnoreCase(nombre)){
                return juegos[i];
            }
        }
        return null;
    }
}
