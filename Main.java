
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        // Declaramos variables
        int jugadores;
        Scanner sc = new Scanner(System.in);
        // Pédimos el numero de jugadores
        System.out.println("Ingrese el numero de jugadores:");
        jugadores = sc.nextInt();
        // Utilizamos otras clases
        Juego cinquillo = new Juego(jugadores);
        cinquillo.Jugar(jugadores);
    }
}
