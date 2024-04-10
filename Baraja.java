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

    /*Metodo para crear la baraja
    public void crearBaraja(){
        for (int i = 0; i < 4; i++) {
            if (i == 0){
                for (int j = 0; j < 12; j++) {
                    barajCartas.add(new Carta(j + 1, "moneda", false));
                }
            } else if (i == 1){
                for (int j = 0; j < 12; j++) {
                    barajCartas.add(new Carta(j + 1, "espadas", false));
                }
            } else if (i == 2){
                for (int j = 0; j < 12; j++) {
                    barajCartas.add(new Carta(j + 1, "palos", false));
                }
            }else{
                for (int j = 0; j < 12; j++) {
                    barajCartas.add(new Carta(j + 1, "copas", false));
                }
            }
        }
    }
    */

    //Metodo mejorado
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