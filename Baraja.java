package gushdezzz.maincartas;
import java.util.ArrayList;
public class Baraja {
    private ArrayList<Carta> mazo;
    public void crearBaraja(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 11; j++){
                switch(i){
                    case 1: 
                        mazo.add(new Carta("bastos", j));
                        break;
                    case 2:
                        mazo.add(new Carta("copas", j));
                        break;
                    case 3:
                        mazo.add(new Carta("espadas", j));
                        break;
                    case 4:
                        mazo.add(new Carta("oro", j));
                        break;
                }
            }
        }
    }
    
    public ArrayList<Carta> getMazo(){
        return this.mazo;
    }
}
