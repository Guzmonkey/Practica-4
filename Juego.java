package guzmonkey.juegocartas;
//Librerias necesarias
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class Juego {
    //Variables del programa
    //Creamos una baraja
    private Baraja baraja;
    //Creamos los ArrayList donde se guardaran las cartas de los jugadores
    private ArrayList<Carta> cartasJug1;
    private ArrayList<Carta> cartasJug2;
    private ArrayList<Carta> cartasJug3;
    private ArrayList<Carta> cartasJug4;
    //Variable que almacena el numero de jugadores
    private int jugadores;
    private ArrayList<Carta> cartasDeJugadores;
    private ArrayList<Carta>[] cartasDeJugadoresTemp;

    private ArrayList<Carta> cartasMonedas;
    private ArrayList<Carta> cartasEspadas;
    private ArrayList<Carta> cartasPalos;
    private ArrayList<Carta> cartasCopas;


    //Constructor del juego
    public Juego(){
        //Crea la instancia de la baraja
        baraja = new Baraja();
        //Crea la baraja
        baraja.crearBaraja();
        //Revulve la baraja
        baraja.revolverBaraja();
        //Crea los ArrayList donde se almacenaran las cartas de los jugadores
        cartasJug1 = new ArrayList<>();
        cartasJug2 = new ArrayList<>();
        cartasJug3 = new ArrayList<>();
        cartasJug4 = new ArrayList<>();
        cartasDeJugadores = new ArrayList<>();
    }

    //Metodo para repartir las cartas
    public void repartirCartas(){
        //Creamos un nuevo scanner
        //Scanner nombre = new Scanner (entrada)
        Scanner scanner = new Scanner(System.in);
        //Ciclo do-while que se ejecutara mientras el usuario ingrese una cantidad de jugadores invalida
        do {
            System.out.println("Ingresa el numero de jugadores");
            jugadores = scanner.nextInt();
            //Repartimos las cartas desde la baraja
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

    //Metodo para mostrar las cartas
    public void mostrarCartasJug() {
        //Ciclo for para iterar por el numero de jugadores
        for (int i = 0; i < jugadores; i++) {
            //Imprimimos el mensaje "Cartas del jugador i + 1:"
            System.out.println("Cartas del jugador " + (i + 1) + ":");
            //Creamos una variable temporal en la cual agregaremos las cartas del jugador i
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
            //Imprimimos las cartas del jugador con un ciclo for-each
            if (cartasJugador != null) {
                for (Carta carta : cartasJugador) {
                    carta.mostrar();
                }
            }
        }
    }

    public int encontrarJugadorConCarta5DeMonedas() {
        // Itera sobre cada jugador
        for (int i = 0; i < jugadores; i++) {
            // Crea una lista temporal para las cartas del jugador actual
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
            // Verifica si el jugador tiene la carta 5 de monedas
            if (cartasJugador != null) {
                for (Carta carta : cartasJugador) {
                    if (carta.getValor() == 5 && carta.getClase().equals("moneda")) {
                        // Si encuentra la carta, devuelve el número del jugador
                        return i + 1;
                    }
                }
            }
        }
        // Si no se encuentra la carta, devuelve -1
        return -1;
    }
    
    public ArrayList<Carta>[] obtenerCartasDeJugadoresOrdenadas() {
        // Crea un array de ArrayList para almacenar las cartas de los jugadores
        ArrayList<Carta>[] cartasDeJugadoresOrdenadas = new ArrayList[jugadores];
        // Busca el jugador que tiene la carta 5 de monedas
        int jugadorConCarta5DeMonedas = encontrarJugadorConCarta5DeMonedas();
        // Si se encontró el jugador con la carta 5 de monedas
        if (jugadorConCarta5DeMonedas != -1) {
            // Asigna las cartas del jugador con la carta 5 de monedas al primer elemento del array
            switch (jugadorConCarta5DeMonedas) {
                case 1:
                    cartasDeJugadoresOrdenadas[0] = cartasJug1;
                    break;
                case 2:
                    cartasDeJugadoresOrdenadas[0] = cartasJug2;
                    break;
                case 3:
                    cartasDeJugadoresOrdenadas[0] = cartasJug3;
                    break;
                case 4:
                    cartasDeJugadoresOrdenadas[0] = cartasJug4;
                    break;
                default:
                    break;
            }
            // Agrega las cartas de los otros jugadores al array en orden
            int index = 1;
            for (int i = 1; i <= jugadores; i++) {
                if (i != jugadorConCarta5DeMonedas) {
                    switch (i) {
                        case 1:
                            cartasDeJugadoresOrdenadas[index++] = cartasJug1;
                            break;
                        case 2:
                            cartasDeJugadoresOrdenadas[index++] = cartasJug2;
                            break;
                        case 3:
                            cartasDeJugadoresOrdenadas[index++] = cartasJug3;
                            break;
                        case 4:
                            cartasDeJugadoresOrdenadas[index++] = cartasJug4;
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return cartasDeJugadoresOrdenadas;
    }

    public void imprimirCartasDeJugadoresOrdenadas() {
        // Obtener las cartas de los jugadores ordenadas
        ArrayList<Carta>[] cartasDeJugadoresOrdenadas = obtenerCartasDeJugadoresOrdenadas();
        
        // Imprimir las cartas de los jugadores ordenadas
        for (int i = 0; i < jugadores; i++) {
            System.out.println("Cartas del jugador " + (i + 1) + ":");
            if (cartasDeJugadoresOrdenadas[i] != null) {
                for (Carta carta : cartasDeJugadoresOrdenadas[i]) {
                    carta.mostrar();
                }
            }
        }
    }

    public void jugarCinquillo() {
        // Inicializa un array para almacenar las cartas jugadas por cada jugador
        ArrayList<Carta>[] cartasJugadas = new ArrayList[jugadores];
        // Inicializa un array para almacenar los valores de las cartas jugadas por cada jugador
        int[] valoresCartasJugadas = new int[jugadores];
        
        // Inicializa un array para almacenar el turno de cada jugador
        int[] turnos = new int[jugadores];
        for (int i = 0; i < jugadores; i++) {
            turnos[i] = i;
        }
        
        // Inicializa el jugador que comienza la ronda como el que tiene la carta 5 de monedas
        int jugadorComienza = encontrarJugadorConCarta5DeMonedas() - 1;
        int jugadorActual = jugadorComienza;
        
        // Itera mientras haya cartas en la baraja
        while (!baraja.getBarajaCartas().isEmpty()) {
            // El jugador actual toma una carta de la baraja
            Carta carta = baraja.getBarajaCartas().remove(0);
            System.out.println("El jugador " + (jugadorActual + 1) + " toma una carta.");
            // Agrega la carta a las cartas jugadas por el jugador actual
            if (cartasJugadas[jugadorActual] == null) {
                cartasJugadas[jugadorActual] = new ArrayList<>();
            }
            cartasJugadas[jugadorActual].add(carta);
            // Almacena el valor de la carta jugada
            valoresCartasJugadas[jugadorActual] = carta.getValor();
            
            // Cambia al siguiente jugador
            jugadorActual = (jugadorActual + 1) % jugadores;
        }
        
        // Muestra las cartas jugadas por cada jugador
        for (int i = 0; i < jugadores; i++) {
            System.out.println("Cartas del jugador " + (i + 1) + ":");
            if (cartasJugadas[i] != null) {
                for (Carta carta : cartasJugadas[i]) {
                    carta.mostrar();
                }
            }
        }
        
        // Determina quién ganó la ronda
        int maxValor = -1;
        int jugadorGanador = -1;
        for (int i = 0; i < jugadores; i++) {
            if (valoresCartasJugadas[i] > maxValor) {
                maxValor = valoresCartasJugadas[i];
                jugadorGanador = i + 1;
            }
        }
        System.out.println("El jugador " + jugadorGanador + " gana la ronda con una carta de valor " + maxValor + ".");
    }   
}