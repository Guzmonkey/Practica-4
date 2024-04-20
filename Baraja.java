package com.mycompany.cinquillo;
// Importamos la clase ArrayList
import java.util.ArrayList;
public class Baraja {
    // Declaracion de variables
    private ArrayList<Carta> mazo;
    /*
    * Constructor de la clase Baraja
    */
    public Baraja(){
        mazo = new ArrayList<>();
    }
    /*
    * Metodo que permite generar cartas 
    */
    public void generarCartas(){
        for (int i=1; i<5; i++){
            for (int j=1; j<11; j++){
                switch (i){
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
                        mazo.add(new Carta("oros", j));
                        break;
                }
            }
        }
    }
    /*
    * Metodo get
    */
    public ArrayList<Carta> getMazo(){
        return this.mazo;
    }
    
}
