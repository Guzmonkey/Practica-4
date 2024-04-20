package com.mycompany.cinquillo;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Juego {
    
    private ArrayList<Jugador> jugadores;
    private Baraja baraja;
    private Mesa mesa;
    private JPanel panelPrincipal;
    public JFrame ventana = new JFrame("Juego");
    
    public Juego(int cantidadJugadores){
        jugadores = new ArrayList<>();
        baraja = new Baraja();
        mesa = new Mesa();
        baraja.generarCartas();
        for (int i=0; i<cantidadJugadores; i++){
            jugadores.add(new Jugador("Jugador "+(i+1)));
        }
        panelPrincipal = new JPanel(null);
        panelPrincipal.setBackground(new Color(20, 134, 119));
    }
    
    public JPanel getPanelPrincipal(){
        return this.panelPrincipal;
    }
    
    public void repartirCartas() {
        int numJugadores = this.jugadores.size();
        int cartasPorJugador = baraja.getMazo().size() / numJugadores;
    
        for (int i = 0; i < numJugadores; i++) {
            Jugador jugador = jugadores.get(i);
            for (int j = 0; j < cartasPorJugador; j++) {
                int index = (int) (Math.random() * baraja.getMazo().size());
                jugador.getMano().add(baraja.getMazo().get(index));
                baraja.getMazo().remove(index);
            }
        }
    
        // Distribuir las cartas restantes
        int cartasRestantes = baraja.getMazo().size();
        for (int i = 0; i < cartasRestantes; i++) {
            int jugadorAleatorio = (int) (Math.random() * numJugadores);
            Jugador jugador = jugadores.get(jugadorAleatorio);
            int index = (int) (Math.random() * baraja.getMazo().size());
            jugador.getMano().add(baraja.getMazo().get(index));
            baraja.getMazo().remove(index);
        }
    }
    
    
    public void actualizarPanel(){
        this.panelPrincipal.removeAll();
        JPanel panelSecundario = new JPanel();
        switch (this.jugadores.size()){
            case 2:
                for (int i=0; i<this.jugadores.size(); i++){
                    panelSecundario = this.jugadores.get(i).getPanelMano();
                    switch (i){
                        case 0:
                            panelSecundario.setBounds(15, 500, 1260, 95);
                            break;
                        case 1:
                            panelSecundario.setBounds(15, 0, 1260, 95);
                            break;
                    }
                    this.panelPrincipal.add(panelSecundario);
                }
                break;
            case 3:
                for (int i=0; i<this.jugadores.size(); i++){
                    panelSecundario = this.jugadores.get(i).getPanelMano();
                    switch (i){
                        case 0:
                            panelSecundario.setBounds(450, 450, 464, 192);
                            break;
                        case 1:
                            panelSecundario.setBounds(50, 0, 464, 192);
                            break;
                        case 2:
                            panelSecundario.setBounds(750, 0, 464, 192);
                            break;
                    }
                    this.panelPrincipal.add(panelSecundario);
                }
                break;
            case 4:
                for (int i=0; i<this.jugadores.size(); i++){
                    panelSecundario = this.jugadores.get(i).getPanelMano();
                    switch (i){
                        case 0:
                            panelSecundario.setBounds(525, 440, 320, 192);
                            break;
                        case 1:
                            panelSecundario.setBounds(25, 228, 320, 192);
                            break;
                        case 2:
                            panelSecundario.setBounds(525, 0, 320, 192);
                            break;
                        case 3:
                            panelSecundario.setBounds(930, 228, 320, 192);
                            break;
                    }
                    this.panelPrincipal.add(panelSecundario);
                }
                break;
        }
        
        
        JPanel panelOros = mesa.getPanelOros();
        panelOros.setBounds(320, 385, 740, 240);
        this.panelPrincipal.add(panelOros);
        
        JPanel panelEspadas = mesa.getPanelEspadas();
        panelEspadas.setBounds(320, 335, 740, 240);
        this.panelPrincipal.add(panelEspadas);
        
        JPanel panelCopas = mesa.getPanelCopas();
        panelCopas.setBounds(320, 285, 740, 240);
        this.panelPrincipal.add(panelCopas);
        
        JPanel panelBastos = mesa.getPanelBastos();
        panelBastos.setBounds(320, 235, 740, 240);
        this.panelPrincipal.add(panelBastos);
        
        this.panelPrincipal.revalidate();
        this.panelPrincipal.repaint();
    }
    
    public void actualizarVentana (){
        this.ventana.getContentPane().removeAll();
        this.ventana.getContentPane().add(this.panelPrincipal);
        this.ventana.revalidate();
        this.ventana.repaint();
        this.ventana.pack();
        this.ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
        this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public int buscarPrimerTurno(){
        int turno = 0;
        for (int i=0; i<this.jugadores.size(); i++){
            if (this.jugadores.get(i).buscarCarta(new Carta("oros", 5))){
                turno = i+1;
                for (int j=0; j<this.jugadores.get(i).getMano().size(); j++){
                    if (this.jugadores.get(i).getMano().get(j).getFigura().equals("oros") && this.jugadores.get(i).getMano().get(j).getValor() == 5){
                        this.jugadores.get(i).jugarCarta(j+1);
                    }
                }
            }
        }
        this.mesa.llenarMesa();
        this.mesa.jugarCarta(new Carta("oros", 5));
        return turno;
    }
    
    public static void main(String[] args){ 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de jugadores: ");
        int cantidad = scanner.nextInt();
        int turno;
        int cartaAJugar;
        Juego juego = new Juego(cantidad);
        int ganador = 0;
        juego.repartirCartas();
        turno = juego.buscarPrimerTurno();
        juego.actualizarPanel();
        juego.actualizarVentana();
        do{
            switch (turno){
                case 1:
                    do{
                        if (juego.jugadores.get(turno-1).validarVictoria()){
                            ganador = turno;
                            break;
                        }
                        do{
                           System.out.println("Turno del jugador " + turno + ":");
                           cartaAJugar = scanner.nextInt(); 
                           if (cartaAJugar == 0){
                               break;
                           }
                        }while (cartaAJugar>juego.jugadores.get(turno-1).getMano().size() || !juego.jugadores.get(turno-1).getMano().get(cartaAJugar-1).getVisible());
                        if (cartaAJugar<=juego.jugadores.get(turno-1).getMano().size()+1 && cartaAJugar>0){
                            if (juego.mesa.validarCarta(juego.jugadores.get(turno-1).getMano().get(cartaAJugar-1))){
                                juego.jugadores.get(turno-1).jugarCarta(cartaAJugar);
                                juego.mesa.jugarCarta(juego.jugadores.get(turno-1).getMano().get(cartaAJugar-1));
                                juego.actualizarPanel();
                                juego.actualizarVentana();
                            }else{
                                cartaAJugar = -1;
                            }    
                        }
                    }while (cartaAJugar != 0);
                    turno++;
                    break;
                case 2:
                    do{
                        if (juego.jugadores.get(turno-1).validarVictoria()){
                            ganador = turno;
                            break;
                        }
                        do{
                           System.out.println("Turno del jugador " + turno + ":");
                           cartaAJugar = scanner.nextInt(); 
                           if (cartaAJugar == 0){
                               break;
                           }
                        }while (cartaAJugar>juego.jugadores.get(turno-1).getMano().size() || !juego.jugadores.get(turno-1).getMano().get(cartaAJugar-1).getVisible());
                        if (cartaAJugar<=juego.jugadores.get(turno-1).getMano().size()+1 && cartaAJugar>0){
                            if (juego.mesa.validarCarta(juego.jugadores.get(turno-1).getMano().get(cartaAJugar-1))){
                                juego.jugadores.get(turno-1).jugarCarta(cartaAJugar);
                                juego.mesa.jugarCarta(juego.jugadores.get(turno-1).getMano().get(cartaAJugar-1));
                                juego.actualizarPanel();
                                juego.actualizarVentana();
                            }else{
                                cartaAJugar = -1;
                            }
                        }
                    }while (cartaAJugar != 0);
                    switch (juego.jugadores.size()){
                        case 2:
                            turno = 1;
                            break;
                        case 3:
                            turno++;
                            break;
                        case 4:
                            turno++;
                            break;
                    }
                    break;
                case 3:
                    do{
                        if (juego.jugadores.get(turno-1).validarVictoria()){
                            ganador = turno;
                            break;
                        }
                        do{
                           System.out.println("Turno del jugador " + turno + ":");
                           cartaAJugar = scanner.nextInt();
                           if (cartaAJugar == 0){
                               break;
                           }
                        }while (cartaAJugar>juego.jugadores.get(turno-1).getMano().size() || !juego.jugadores.get(turno-1).getMano().get(cartaAJugar-1).getVisible());
                        if (cartaAJugar<=juego.jugadores.get(turno-1).getMano().size()+1 && cartaAJugar>0){
                            if (juego.mesa.validarCarta(juego.jugadores.get(turno-1).getMano().get(cartaAJugar-1))){
                                juego.jugadores.get(turno-1).jugarCarta(cartaAJugar);
                                juego.mesa.jugarCarta(juego.jugadores.get(turno-1).getMano().get(cartaAJugar-1));
                                juego.actualizarPanel();
                                juego.actualizarVentana();
                            }else{
                                cartaAJugar = -1;
                            }
                        }
                    }while (cartaAJugar != 0);
                    switch (juego.jugadores.size()){
                        case 3:
                            turno = 1;
                            break;
                        case 4:
                            turno++;
                            break;
                    }
                    break;
                case 4:
                    do{
                        if (juego.jugadores.get(turno-1).validarVictoria()){
                            ganador = turno;
                            break;
                        }
                        do{
                           System.out.println("Turno del jugador " + turno + ":");
                           cartaAJugar = scanner.nextInt(); 
                           if (cartaAJugar == 0){
                               break;
                           }
                        }while (cartaAJugar>juego.jugadores.get(turno-1).getMano().size() || !juego.jugadores.get(turno-1).getMano().get(cartaAJugar-1).getVisible());
                        if (cartaAJugar<=juego.jugadores.get(turno-1).getMano().size()+1 && cartaAJugar>0){
                            if (juego.mesa.validarCarta(juego.jugadores.get(turno-1).getMano().get(cartaAJugar-1))){
                                juego.jugadores.get(turno-1).jugarCarta(cartaAJugar);
                                juego.mesa.jugarCarta(juego.jugadores.get(turno-1).getMano().get(cartaAJugar-1));
                                juego.actualizarPanel();
                                juego.actualizarVentana();
                            }else{
                                cartaAJugar = -1;
                            }
                        }
                    }while (cartaAJugar != 0);
                    turno = 1;
                    break;
            }
        }while (ganador == 0);
        
        System.out.println("El ganador fue el jugador" + ganador);
        
    }
    
}