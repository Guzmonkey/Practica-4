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
    //Array que almacena los ArrayList de las cartas de los jugadores
    private ArrayList<Carta>[] cartasDeJugadores;
    //ArrayList que almacena las cartas de diferentes clases
    private ArrayList<Carta> cartasMonedas;
    private ArrayList<Carta> cartasCopas;
    private ArrayList<Carta> cartasPalos;
    private ArrayList<Carta> cartasEspadas;
    private int jugadorConEl5;

    //Array de cartasJugadoresOrdenados
    private ArrayList<Carta>[] cartasDeJugadoresOrdanados; 

    //Bandera para buscar el ganador
    private boolean ganador;

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
        //Creamos el Array de ArrayList con 4 jugadores
        cartasDeJugadores = new ArrayList[4];
        cartasDeJugadoresOrdanados = new ArrayList[4];

        cartasMonedas = new ArrayList<>();
        cartasCopas = new ArrayList<>();
        cartasEspadas = new ArrayList<>();
        cartasPalos = new ArrayList<>();

        ganador = false;
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

    //Metodo que almacena las cartas de los jugadores en un Array
    public void ordenarCartasDeJugadores(){
        for (int i = 1; i < jugadores; i++) {
            switch (i) {
                case 1:
                    cartasDeJugadores[0] = cartasJug1;
                    break;
                case 2:
                    cartasDeJugadores[1] = cartasJug2;
                    break;
                case 3: 
                    cartasDeJugadores[2] = cartasJug3;
                    break;
                case 4: 
                    cartasDeJugadores[3] = cartasJug4;
                    break;
            }
        }
    }

    public void encontrarJugador5DeMonesdas() {
        // Itera sobre cada jugador
        for (int i = 0; i < jugadores; i++) {
            // Obtiene las cartas del jugador actual
            ArrayList<Carta> cartasJugador = cartasDeJugadores[i];
            // Verifica si el jugador tiene la carta 5 de monedas
            if (cartasJugador != null) {
                for (Carta carta : cartasJugador) {
                    if (carta.getValor() == 5 && carta.getClase().equals("monedas")) {
                        System.out.println("El jugador " + (i + 1) + " tiene la carta 5 de monedas.");
                        jugadorConEl5 = i + 1;
                    }
                }
            }
        }
    }

    public void reoganizarJugadores(){
        switch (jugadorConEl5) {
            case 1:
                cartasDeJugadoresOrdanados[0] = cartasJug1;
                break;
            case 2:
                cartasDeJugadoresOrdanados[0] = cartasJug2;
                break;
            case 3:
                cartasDeJugadoresOrdanados[0] = cartasJug3;
                break;
            case 4:
                cartasDeJugadoresOrdanados[0] = cartasJug4;
                break;
        }

        int indice = 1;
        for (int i = 0; i < jugadores; i++) {
            if (i != jugadorConEl5){
                switch (i) {
                    case 0:
                        cartasDeJugadoresOrdanados[indice++] = cartasJug1;
                        break;
                    case 1:
                        cartasDeJugadoresOrdanados[indice++] = cartasJug2;
                        break;
                    case 2:
                        cartasDeJugadoresOrdanados[indice++] = cartasJug3;
                        break;
                    case 3:
                        cartasDeJugadoresOrdanados[indice++] = cartasJug4;
                        break;
                }
            }
        }
    }

    public void imprimirCartasDeJugadoresOrdenadas() {
        // Imprimir las cartas de los jugadores ordenadas
        for (int i = 0; i < jugadores; i++) {
            System.out.println("Cartas del jugador " + (i + 1) + ":");
            if (cartasDeJugadoresOrdanados[i] != null) {
                for (Carta carta : cartasDeJugadoresOrdanados[i]) {
                    carta.mostrar();
                }
            }
        }
    }   

    //Metodo para jugar al Cinquillo
    public void jugarCinquillo2(){
        //Contador de rondas
        int ronda = 0;
        if (ronda == 0){
            cartasJug1 = cartasDeJugadoresOrdanados[0];
            cartasJug2 = cartasDeJugadoresOrdanados[1];
            cartasJug3 = cartasDeJugadoresOrdanados[2];
            cartasJug4 = cartasDeJugadoresOrdanados[3];
        }
        if (ronda == 0){
            //Jugador 1
            //En la ronda 1 el jugador con la carta de 5 de Monedas debe iniciar
            //Ciclo for para iterar por las cartas del jugador 1
            for (Carta carta : cartasJug1) {
                //Si es igual a 5 y de la clase monedas la anade al ArrayList de monedas y se quita del jugador 1
                if (carta.getValor() == 5 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(carta);
                    cartasJug1.remove(carta);
                    break;
                }     
            }
            //Jugador 2
            for (Carta carta : cartasJug2) {
                if (carta.getValor() == cartasMonedas.get(0).getValor() - 1 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(0, carta);
                    cartasJug2.remove(carta);
                    break;
                } else if (carta.getValor() == cartasMonedas.get(cartasMonedas.size() - 1).getValor() + 1 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(carta);
                    cartasJug2.remove(carta);
                    break;
                } else if (carta.getValor() == 5 && carta.getClase().equals("copas")){
                    cartasCopas.add(carta);
                    cartasJug2.remove(carta);
                    break;
                } else if (carta.getValor() == 5 && carta.getClase().equals("espadas")){
                    cartasEspadas.add(carta);
                    cartasJug2.remove(carta);
                    break;
                } else if (carta.getValor() == 5 && carta.getClase().equals("palos")){
                    cartasPalos.add(carta);
                    cartasJug2.remove(carta);
                    break;
                }
            }
            //Jugador 3
            for (Carta carta : cartasJug3) {
                if (carta.getValor() == cartasMonedas.get(0).getValor() - 1 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(0, carta);
                    cartasJug3.remove(carta);
                    break;
                } else if (carta.getValor() == cartasMonedas.get(cartasMonedas.size() - 1).getValor() + 1 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(carta);
                    cartasJug3.remove(carta);
                    break;
                } else if (!cartasCopas.isEmpty()){
                    if (carta.getValor() == cartasCopas.get(0).getValor() - 1 && carta.getClase().equals("copas")){
                        cartasCopas.add(0, carta);
                        cartasJug3.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasCopas.get(cartasCopas.size() - 1).getValor() + 1 && carta.getClase().equals("copas")){
                        cartasCopas.add(carta);
                        cartasJug3.remove(carta);
                        break;
                    }
                } else if (cartasCopas.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("copas")){
                        cartasCopas.add(carta);
                        cartasJug3.remove(carta);
                        break;
                    }
                } else if (!cartasEspadas.isEmpty()){
                    if (carta.getValor() == cartasEspadas.get(0).getValor() - 1 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(0, carta);
                        cartasJug3.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasEspadas.get(cartasEspadas.size() - 1).getValor() + 1 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(carta);
                        cartasJug3.remove(carta);
                        break;
                    }
                } else if (cartasEspadas.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(carta);
                        cartasJug3.remove(carta);
                        break;
                    }
                } else if (!cartasPalos.isEmpty()){
                    if (carta.getValor() == cartasPalos.get(0).getValor() - 1 && carta.getClase().equals("palos")){
                        cartasPalos.add(0, carta);
                        cartasJug3.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasPalos.get(cartasPalos.size() - 1).getValor() + 1 && carta.getClase().equals("palos")){
                        cartasPalos.add(carta);
                        cartasJug3.remove(carta);
                        break;
                    }
                } else if (cartasPalos.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("palos")){
                        cartasPalos.add(carta);
                        cartasJug3.remove(carta);
                        break;
                    }
                }
            }
            //Jugador 4 
            for (Carta carta : cartasJug4) {
                if (carta.getValor() == cartasMonedas.get(0).getValor() - 1 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(0, carta);
                    cartasJug4.remove(carta);
                    break;
                } else if (carta.getValor() == cartasMonedas.get(cartasMonedas.size() - 1).getValor() + 1 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(carta);
                    cartasJug4.remove(carta);
                    break;
                } else if (!cartasCopas.isEmpty()){
                    if (carta.getValor() == cartasCopas.get(0).getValor() - 1 && carta.getClase().equals("copas")){
                        cartasCopas.add(0, carta);
                        cartasJug4.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasCopas.get(cartasCopas.size() - 1).getValor() + 1 && carta.getClase().equals("copas")){
                        cartasCopas.add(carta);
                        cartasJug4.remove(carta);
                        break;
                    }
                } else if (cartasCopas.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("copas")){
                        cartasCopas.add(carta);
                        cartasJug4.remove(carta);
                        break;
                    }
                } else if (!cartasEspadas.isEmpty()){
                    if (carta.getValor() == cartasEspadas.get(0).getValor() - 1 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(0, carta);
                        cartasJug4.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasEspadas.get(cartasEspadas.size() - 1).getValor() + 1 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(carta);
                        cartasJug4.remove(carta);
                        break;
                    }
                } else if (cartasEspadas.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(carta);
                        cartasJug4.remove(carta);
                        break;
                    }
                } else if (!cartasPalos.isEmpty()){
                    if (carta.getValor() == cartasPalos.get(0).getValor() - 1 && carta.getClase().equals("palos")){
                        cartasPalos.add(0, carta);
                        cartasJug4.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasPalos.get(cartasPalos.size() - 1).getValor() + 1 && carta.getClase().equals("palos")){
                        cartasPalos.add(carta);
                        cartasJug4.remove(carta);
                        break;
                    }
                } else if (cartasPalos.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("palos")){
                        cartasPalos.add(carta);
                        cartasJug4.remove(carta);
                        break;
                    }
                }
            }
            ronda ++;
        } else {
            //Jugador 1
            for (Carta carta : cartasJug1) {
                if (carta.getValor() == cartasMonedas.get(0).getValor() - 1 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(0, carta);
                    cartasJug1.remove(carta);
                    break;
                } else if (carta.getValor() == cartasMonedas.get(cartasMonedas.size() - 1).getValor() + 1 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(carta);
                    cartasJug1.remove(carta);
                    break;
                } else if (!cartasCopas.isEmpty()){
                    if (carta.getValor() == cartasCopas.get(0).getValor() - 1 && carta.getClase().equals("copas")){
                        cartasCopas.add(0, carta);
                        cartasJug1.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasCopas.get(cartasCopas.size() - 1).getValor() + 1 && carta.getClase().equals("copas")){
                        cartasCopas.add(carta);
                        cartasJug1.remove(carta);
                        break;
                    }
                } else if (cartasCopas.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("copas")){
                        cartasCopas.add(carta);
                        cartasJug1.remove(carta);
                        break;
                    }
                } else if (!cartasEspadas.isEmpty()){
                    if (carta.getValor() == cartasEspadas.get(0).getValor() - 1 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(0, carta);
                        cartasJug1.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasEspadas.get(cartasEspadas.size() - 1).getValor() + 1 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(carta);
                        cartasJug1.remove(carta);
                        break;
                    }
                } else if (cartasEspadas.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(carta);
                        cartasJug1.remove(carta);
                        break;
                    }
                } else if (!cartasPalos.isEmpty()){
                    if (carta.getValor() == cartasPalos.get(0).getValor() - 1 && carta.getClase().equals("palos")){
                        cartasPalos.add(0, carta);
                        cartasJug1.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasPalos.get(cartasPalos.size() - 1).getValor() + 1 && carta.getClase().equals("palos")){
                        cartasPalos.add(carta);
                        cartasJug1.remove(carta);
                        break;
                    }
                } else if (cartasPalos.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("palos")){
                        cartasPalos.add(carta);
                        cartasJug1.remove(carta);
                        break;
                    }
                }
            }
            //Jugador 2
            for (Carta carta : cartasJug2) {
                if (carta.getValor() == cartasMonedas.get(0).getValor() - 1 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(0, carta);
                    cartasJug2.remove(carta);
                    break;
                } else if (carta.getValor() == cartasMonedas.get(cartasMonedas.size() - 1).getValor() + 1 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(carta);
                    cartasJug2.remove(carta);
                    break;
                } else if (!cartasCopas.isEmpty()){
                    if (carta.getValor() == cartasCopas.get(0).getValor() - 1 && carta.getClase().equals("copas")){
                        cartasCopas.add(0, carta);
                        cartasJug2.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasCopas.get(cartasCopas.size() - 1).getValor() + 1 && carta.getClase().equals("copas")){
                        cartasCopas.add(carta);
                        cartasJug2.remove(carta);
                        break;
                    }
                } else if (cartasCopas.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("copas")){
                        cartasCopas.add(carta);
                        cartasJug2.remove(carta);
                        break;
                    }
                } else if (!cartasEspadas.isEmpty()){
                    if (carta.getValor() == cartasEspadas.get(0).getValor() - 1 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(0, carta);
                        cartasJug2.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasEspadas.get(cartasEspadas.size() - 1).getValor() + 1 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(carta);
                        cartasJug2.remove(carta);
                        break;
                    }
                } else if (cartasEspadas.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(carta);
                        cartasJug2.remove(carta);
                        break;
                    }
                } else if (!cartasPalos.isEmpty()){
                    if (carta.getValor() == cartasPalos.get(0).getValor() - 1 && carta.getClase().equals("palos")){
                        cartasPalos.add(0, carta);
                        cartasJug2.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasPalos.get(cartasPalos.size() - 1).getValor() + 1 && carta.getClase().equals("palos")){
                        cartasPalos.add(carta);
                        cartasJug2.remove(carta);
                        break;
                    }
                } else if (cartasPalos.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("palos")){
                        cartasPalos.add(carta);
                        cartasJug2.remove(carta);
                        break;
                    }
                }
            }
            //Jugador 3
            for (Carta carta : cartasJug3) {
                if (carta.getValor() == cartasMonedas.get(0).getValor() - 1 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(0, carta);
                    cartasJug3.remove(carta);
                    break;
                } else if (carta.getValor() == cartasMonedas.get(cartasMonedas.size() - 1).getValor() + 1 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(carta);
                    cartasJug3.remove(carta);
                    break;
                } else if (!cartasCopas.isEmpty()){
                    if (carta.getValor() == cartasCopas.get(0).getValor() - 1 && carta.getClase().equals("copas")){
                        cartasCopas.add(0, carta);
                        cartasJug3.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasCopas.get(cartasCopas.size() - 1).getValor() + 1 && carta.getClase().equals("copas")){
                        cartasCopas.add(carta);
                        cartasJug3.remove(carta);
                        break;
                    }
                } else if (cartasCopas.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("copas")){
                        cartasCopas.add(carta);
                        cartasJug3.remove(carta);
                        break;
                    }
                } else if (!cartasEspadas.isEmpty()){
                    if (carta.getValor() == cartasEspadas.get(0).getValor() - 1 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(0, carta);
                        cartasJug3.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasEspadas.get(cartasEspadas.size() - 1).getValor() + 1 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(carta);
                        cartasJug3.remove(carta);
                        break;
                    }
                } else if (cartasEspadas.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(carta);
                        cartasJug3.remove(carta);
                        break;
                    }
                } else if (!cartasPalos.isEmpty()){
                    if (carta.getValor() == cartasPalos.get(0).getValor() - 1 && carta.getClase().equals("palos")){
                        cartasPalos.add(0, carta);
                        cartasJug3.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasPalos.get(cartasPalos.size() - 1).getValor() + 1 && carta.getClase().equals("palos")){
                        cartasPalos.add(carta);
                        cartasJug3.remove(carta);
                        break;
                    }
                } else if (cartasPalos.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("palos")){
                        cartasPalos.add(carta);
                        cartasJug3.remove(carta);
                        break;
                    }
                }
                
            }
            //Jugador 4 
            for (Carta carta : cartasJug4) {
                if (carta.getValor() == cartasMonedas.get(0).getValor() - 1 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(0, carta);
                    cartasJug4.remove(carta);
                    break;
                } else if (carta.getValor() == cartasMonedas.get(cartasMonedas.size() - 1).getValor() + 1 && carta.getClase().equals("monedas")){
                    cartasMonedas.add(carta);
                    cartasJug4.remove(carta);
                    break;
                } else if (!cartasCopas.isEmpty()){
                    if (carta.getValor() == cartasCopas.get(0).getValor() - 1 && carta.getClase().equals("copas")){
                        cartasCopas.add(0, carta);
                        cartasJug4.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasCopas.get(cartasCopas.size() - 1).getValor() + 1 && carta.getClase().equals("copas")){
                        cartasCopas.add(carta);
                        cartasJug4.remove(carta);
                        break;
                    }
                } else if (cartasCopas.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("copas")){
                        cartasCopas.add(carta);
                        cartasJug4.remove(carta);
                        break;
                    }
                } else if (!cartasEspadas.isEmpty()){
                    if (carta.getValor() == cartasEspadas.get(0).getValor() - 1 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(0, carta);
                        cartasJug4.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasEspadas.get(cartasEspadas.size() - 1).getValor() + 1 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(carta);
                        cartasJug4.remove(carta);
                        break;
                    }
                } else if (cartasEspadas.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("espadas")){
                        cartasEspadas.add(carta);
                        cartasJug4.remove(carta);
                        break;
                    }
                } else if (!cartasPalos.isEmpty()){
                    if (carta.getValor() == cartasPalos.get(0).getValor() - 1 && carta.getClase().equals("palos")){
                        cartasPalos.add(0, carta);
                        cartasJug4.remove(carta);
                        break;
                    } else if (carta.getValor() == cartasPalos.get(cartasPalos.size() - 1).getValor() + 1 && carta.getClase().equals("palos")){
                        cartasPalos.add(carta);
                        cartasJug4.remove(carta);
                        break;
                    }
                } else if (cartasPalos.isEmpty()){
                    if (carta.getValor() == 5 && carta.getClase().equals("palos")){
                        cartasPalos.add(carta);
                        cartasJug4.remove(carta);
                        break;
                    }
                }
            }
        }
    }
    
    public void mostrarCartasJugadas(){
        System.out.println("Cartas jugadas de Monedas");
        if (!cartasMonedas.isEmpty()){
            for (Carta carta : cartasMonedas) {
                System.out.println("[" + carta.getValor() + "/" + carta.getClase() + "]");
            }
        } else {
            System.out.println("No hay cartas jugadas");
        }
        System.out.println("Cartas jugadas de Copas");
        if (!cartasCopas.isEmpty()){
            for (Carta carta : cartasCopas) {
            System.out.println("[" + carta.getValor() + "/" + carta.getClase() + "]");
            }
        } else {
            System.out.println("No hay cartas jugadas");
        }
        System.out.println("Cartas jugadas de Espadas");
        if (!cartasEspadas.isEmpty()){
            for (Carta carta : cartasEspadas) {
                System.out.println("[" + carta.getValor() + "/" + carta.getClase() + "]");
            }
        } else {
            System.out.println("No hay cartas jugadas");
        }
        System.out.println("Cartas jugadas de Palos");
        if (!cartasPalos.isEmpty()){
            for (Carta carta : cartasPalos) {
                System.out.println("[" + carta.getValor() + "/" + carta.getClase() + "]");
            }
        } else {
            System.out.println("No hay cartas jugadas");
        }
    }

    public boolean buscarGanador(){
        if (cartasJug1.isEmpty()){
            System.out.println("El jugador 1 ha ganado");
            ganador = true;
            return true;
        } else if (cartasJug2.isEmpty()){
            System.out.println("El jugador 2 ha ganado");
            ganador = true;
            return true;
        } else if (cartasJug3.isEmpty()){
            System.out.println("El jugador 3 ha ganado");
            ganador = true;
            return true;
        } else if (cartasJug4.isEmpty()){
            System.out.println("El jugador 4 ha ganado");
            ganador = true;
            return true;
        } else {
            return false;
        }
    }
}