
package gushdezzz.juegocartas;
import java.util.ArrayList;
public class Tablero {
    private ArrayList<Cartas> escaleraBastos;
    private ArrayList<Cartas> escaleraCopas;
    private ArrayList<Cartas> escaleraEspadas;
    private ArrayList<Cartas> escaleraOros;
    
    public Tablero(){
        this.escaleraBastos = new ArrayList<>();
        this.escaleraCopas = new ArrayList<>();
        this.escaleraEspadas = new ArrayList<>();
        this.escaleraOros = new ArrayList<>();
    }

    public ArrayList<Cartas> getEscaleraBastos() {
        return escaleraBastos;
    }

    public ArrayList<Cartas> getEscaleraCopas() {
        return escaleraCopas;
    }

    public ArrayList<Cartas> getEscaleraEspadas() {
        return escaleraEspadas;
    }

    public ArrayList<Cartas> getEscaleraOros() {
        return escaleraOros;
    }

}
