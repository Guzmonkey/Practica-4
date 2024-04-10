package guzmonkey.juegocartas;
//Clase que modela la baraja espanola

//Librerias necesarias para el codigo 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Baraja {
    //Variables de la clase
    //NivelDeAcceso ArrayList<TipoDeDato> Nombre
    private ArrayList<Carta> barajaCartas;

    public Baraja(){
        barajaCartas = new ArrayList<>();
    }

    //Metodo para crear la baraja
    public void crearBaraja() {
        String[] tipos = {"moneda", "espadas", "palos", "copas"};
        for (String tipo : tipos) {
            for (int j = 0; j < 12; j++) {
                barajaCartas.add(new Carta(j + 1, tipo, true));
            }
        }
    }

    //Metodo para revolver la baraja
    public void revolverBaraja(){
        Collections.shuffle(barajaCartas);
    }

    public void mostrarBaraja(){
        //Mostramos todas las cartas de la baraja
        //for (tipoDeDato Variable : nombreDelArrayList) - for-each 
        for (Carta carta : barajaCartas){
            carta.mostrar();
        }
    }
    
    //Metodo para regresar el ArrayList de la baraja
    public ArrayList<Carta> getBarajaCartas(){
        return barajaCartas;
    }
}