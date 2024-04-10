package guzmonkey.juegocartas;
///Librerias necesarias
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class Juego {
    // Declaracion de variables
    private Baraja baraja;
    private ArrayList<Carta> cartas;
    private ArrayList<Carta> player1Hand;
    private ArrayList<Carta> player2Hand;
    private ArrayList<Carta> player3Hand;
    private ArrayList<Carta> player4Hand;
    private ArrayList<Carta>[] cartasJugadas;
    private int numJugadores;
    private int turnoJugdar;
    
    public Juego(){
        // Inicializamos varaibles
        baraja = new Baraja();
        baraja.crearBaraja();
        baraja.revolverBaraja();
        player1Hand = new ArrayList<>();
        player2Hand = new ArrayList<>();
        player3Hand = new ArrayList<>();
        player4Hand = new ArrayList<>();
    }
    /* 
        Metodo para repartir cartas
    */
    public void repartirCartas(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Ingrese el numero de jugadores: ");
            numJugadores = sc.nextInt();
            switch(numJugadores){
                case 2: 
                    cartas = baraja.getBarajaCartas();
                    player1Hand.addAll(cartas.subList(0, 24));
                    player2Hand.addAll(cartas.subList(24, 48));
                    break;
                case 3:
                    cartas = baraja.getBarajaCartas();
                    player1Hand.addAll(cartas.subList(0,16));
                    player2Hand.addAll(cartas.subList(16, 32));
                    player3Hand.addAll(cartas.subList(32, 48));
                   break;
                case 4:
                    cartas = baraja.getBarajaCartas();
                    player1Hand.addAll(cartas.subList(0,12));
                    player2Hand.addAll(cartas.subList(12, 24));
                    player3Hand.addAll(cartas.subList(24, 36));
                    player4Hand.addAll(cartas.subList(36,48));
                    break;
                default: 
                    System.out.println("Ese numero de jugadores no es valido!");
            }       break;
        }while(numJugadores < 2 || numJugadores > 4);
    }
    /* 
        Metodo para mostrar cartas de los jugadores
    */
    public void mostrarCartasJugadores(){
        for (int i = 0; i < numJugadores; i++ ){
            System.out.println("Cartas del jugador " + (i+1) + ":");
            ArrayList<Carta> cartasJugador = null;
            switch(i){
                case 0: 
                    cartasJugador = player1Hand;
                    break;
                case 1:
                    cartasJugador = player2Hand;
                    break;
                case 2:
                    cartasJugador = player3Hand;
                    break;
                case 3: 
                    cartasJugador = player4Hand;
                    break;
                default:
                    break;
            }
            if(cartasJugador != null){
                for(Carta carta: cartasJugador){
                }
            }
        }
    }
    /* 
        Metodo para jugar cinquillo
    */ 
    public void jugarCinquillo(){
    ArrayList<Carta>[] cartaJugada = new ArrayList[numJugadores];
    int[] valoresCartasJugadas = new int[numJugadores];
    int[] turnos = new int[numJugadores];
    for(int i = 0; i < numJugadores; i++){
        turnos[i] = i;
    }
    do{
        
        
    }while(!baraja.getBarajaCartas().isEmpty());
    
    }
    /* 
        Metodo para que el usuario eliga una carta
    */
    public int elegirCarta(int jugadores){
        int cartaElegida;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoja el numero de la carta que desea jugar: (1- "+ cartasJugadas[numJugadores].size()+ "");
        cartaElegida = sc.nextInt();
        do{
            if(cartaElegida < -1 || cartaElegida > cartasJugadas[numJugadores].size()){
                System.out.println("No se puede elegir esa opcion!");
            }
        }while(cartaElegida < -1 ||cartaElegida > cartasJugadas[numJugadores].size());
        return cartaElegida;
    }
}
