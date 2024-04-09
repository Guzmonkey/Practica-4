import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Juego {

    private Baraja baraja;
    private ArrayList<Carta> cartasJug1;
    private ArrayList<Carta> cartasJug2;
    private ArrayList<Carta> cartasJug3;
    private ArrayList<Carta> cartasJug4;
    private int jugadores;

    public Juego(){
        baraja = new Baraja();
        baraja.crearBaraja();
        baraja.revolverBaraja();
        cartasJug1 = new ArrayList<>();
        cartasJug2 = new ArrayList<>();
        cartasJug3 = new ArrayList<>();
        cartasJug4 = new ArrayList<>();
    }

    public void repartirCartas(){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Ingresa el numero de jugadores");
            jugadores = scanner.nextInt();
            switch (jugadores) {
                case 2:
                    cartasJug1.addAll(baraja.getBarajaCartas().subList(0, 24));
                    cartasJug2.addAll(baraja.getBarajaCartas().subList(24, 48));
                    break;
                case 3:
                    cartasJug1.addAll(baraja.getBarajaCartas().subList(0, 16));
                    cartasJug2.addAll(baraja.getBarajaCartas().subList(16, 32));
                    cartasJug3.addAll(baraja.getBarajaCartas().subList(32, 48));
                    break;
                case 4:
                    cartasJug1.addAll(baraja.getBarajaCartas().subList(0, 12));
                    cartasJug2.addAll(baraja.getBarajaCartas().subList(12, 24));
                    cartasJug3.addAll(baraja.getBarajaCartas().subList(24, 36));
                    cartasJug4.addAll(baraja.getBarajaCartas().subList(36, 48));
                    break;
                default:
                    System.out.println("Numero de jugadores invalido");
                    break;
            }

        } while (jugadores < 2 || jugadores > 4);
    }

    // public void mostrarCartasJug(){
    //     switch (jugadores) {
    //         case 2:
    //             System.out.println("Cartas del jugador 1");
    //             for (Carta carta : cartasJug1){
    //                 carta.mostrar();
    //             }
    //             System.out.println("Cartas del jugador 2");
    //             for (Carta carta : cartasJug2){
    //                 carta.mostrar();
    //             }
    //             break;
    //         case 3:
    //             System.out.println("Cartas del jugador 1");
    //             for (Carta carta : cartasJug1){
    //                 carta.mostrar();
    //             }
    //             System.out.println("Cartas del jugador 2");
    //             for (Carta carta : cartasJug2){
    //                 carta.mostrar();
    //             }
    //             System.out.println("Cartas del jugador 3");
    //             for (Carta carta : cartasJug3){
    //                 carta.mostrar();
    //             }
    //             break;
    //         case 4:
    //             System.out.println("Cartas del jugador 1");
    //             for (Carta carta : cartasJug1){
    //                 carta.mostrar();
    //             }
    //             System.out.println("Cartas del jugador 2");
    //             for (Carta carta : cartasJug2){
    //                 carta.mostrar();
    //             }
    //             System.out.println("Cartas del jugador 3");
    //             for (Carta carta : cartasJug3){
    //                 carta.mostrar();
    //             }
    //             System.out.println("Cartas del jugador 4");
    //             for (Carta carta : cartasJug4){
    //                 carta.mostrar();
    //             }
    //             break;
    //     }
    // }

    public void mostrarCartasJug() {
        for (int i = 0; i < jugadores; i++) {
            System.out.println("Cartas del jugador " + (i + 1) + ":");
            ArrayList<Carta> cartasJugador = null;
            switch (i) {
                case 0:
                    cartasJugador = cartasJug1;
                    break;
                case 1:
                    cartasJugador = cartasJug2;
                    break;
                case 2:
                    cartasJugador = cartasJug3;
                    break;
                case 3:
                    cartasJugador = cartasJug4;
                    break;
                default:
                    break;
            }
            if (cartasJugador != null) {
                for (Carta carta : cartasJugador) {
                    carta.mostrar();
                }
            }
        }
    }
    
}