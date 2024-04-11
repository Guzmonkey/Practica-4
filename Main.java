import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creamos una instancia del juego
        Juego juego = new Juego();

        // Repartimos las cartas
        juego.repartirCartas();
        
        // Mostramos las cartas de cada jugador
        juego.mostrarCartasJug();

        // Ordenar las cartas de los jugadores en un Array
        juego.ordenarCartasDeJugadores();

        // Mostrar quien tiene el 5 de monedas
        juego.encontrarJugador5DeMonesdas();

        // Reorganizamos los jugadores
        juego.reoganizarJugadores();

        // Mostramos los jugadores ordenados
        juego.imprimirCartasDeJugadoresOrdenadas();

        // Jugar Cinquillo
        juego.jugarCinquillo2();

        // Mostrar las cartas jugadas
        juego.mostrarCartasJugadas();

        for (int i = 0; i < 15; i++) {
            juego.jugarCinquillo2();    
            juego.mostrarCartasJugadas();   
        }
    }
}
