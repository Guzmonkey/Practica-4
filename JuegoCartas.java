package guzmonkey.juegocartas;
public class JuegoCartas {
    public static void main(String[] args) {
         // Creamos una instancia del juego
        Juego juego = new Juego();
        
        // Repartimos las cartas
        juego.repartirCartas();
        
        // Mostramos las cartas de cada jugador
        juego.mostrarCartasJug();
        
        // Buscamos el jugador que tiene la carta 5 de monedas
        int jugadorConCarta5DeMonedas = juego.encontrarJugadorConCarta5DeMonedas();
        
        // Verificamos si se encontró la carta y mostramos el resultado
        if (jugadorConCarta5DeMonedas != -1) {
            System.out.println("La carta 5 de monedas fue encontrada en el jugador " + jugadorConCarta5DeMonedas);
        } else {
            System.out.println("La carta 5 de monedas no fue encontrada en ningún jugador.");
        }

        juego.obtenerCartasDeJugadoresOrdenadas();
        juego.jugarCinquillo();
    }
}
