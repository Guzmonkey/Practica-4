package com.mycompany.practica4;
import java.util.Scanner;
import java.util.*;

import java.util.ArrayList;
public class Juego {
    ArrayList<Cartas> cartas;
    ArrayList<Cartas> player1Hand;
    ArrayList<Cartas> player2Hand;
    ArrayList<Cartas> player3Hand;
    ArrayList<Cartas> player4Hand;
    ArrayList<Cartas> player5Hand;
    ArrayList<Cartas> player6Hand;
    ArrayList<Cartas> playedCartas;
    int players;
    int[] sidePlayers;
    boolean winner;
    int opt;
    Scanner sc = new Scanner(System.in);
    
    public static List<String> crearBaraja(){
        ArrayList<String> cartas = new ArrayList<>();
        String[] palo = {"Oro", "Copas", "Espadas", "Bastos"};
        String[] valor = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        return cartas;
    }   
    
   public void repartirCartas(int players){
       
   }
}