//Clase que modela la baraja espanola
//Librerias necesarias para el codigo 
import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    //Variables de la clase
    //NivelDeAcceso ArrayList<TipoDeDato> Nombre
    private ArrayList<Cartas> barajaCartas;

    public Baraja(){
        barajaCartas = new ArrayList<>();
    }

    //Metodo para crear la baraja
    public void crearBaraja(){
        String[] tipos = {"oros", "espadas", "bastos", "copas"};
        boolean flag;
        for (int i = 0; i < 13; i++){
            for(String tipo : tipos){
                flag = true;
                barajaCartas.add(new Cartas(tipo, i+1));
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
        for (Cartas carta : barajaCartas){
            carta.mostrar();
        }
    }
    
    //Metodo para regresar el ArrayList de la baraja
    public ArrayList<Cartas> getBarajaCartas(){
        return barajaCartas;
    }
}
    
    //Metodo para regresar el ArrayList de la baraja
    public ArrayList<Carta> getBarajaCartas(){
        return barajaCartas;
    }
}
