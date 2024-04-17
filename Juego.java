package gushdezzz.maincartas;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Juego {
    
    private ArrayList<Jugador> jugadores;
    private ArrayList<JPanel> panelesSecundarios;
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
        panelPrincipal.setBackground(new Color(53, 148, 100));
    }
    
    public JPanel getPanelPrincipal(){
        return this.panelPrincipal;
    }
    
    public void repartirCartas(){
        int index;
        switch (this.jugadores.size()){
            case 2:
                for (int i=0; i<20; i++){
                    index = (int) (Math.random()*(baraja.getMazo().size()));
                    jugadores.get(0).getMano().add(baraja.getMazo().get(index));
                    baraja.getMazo().remove(index);
                    index = (int) (Math.random()*(baraja.getMazo().size()));
                    jugadores.get(1).getMano().add(baraja.getMazo().get(index));
                    baraja.getMazo().remove(index);
                }
                break;
            case 3:
                for (int i=0; i<14; i++){
                    index = (int) (Math.random()*(baraja.getMazo().size()));
                    jugadores.get(0).getMano().add(baraja.getMazo().get(index));
                    baraja.getMazo().remove(index);
                    if (i<13){
                        index = (int) (Math.random()*(baraja.getMazo().size()));
                        jugadores.get(1).getMano().add(baraja.getMazo().get(index));
                        baraja.getMazo().remove(index);
                    }
                    if (i<13){
                        index = (int) (Math.random()*(baraja.getMazo().size()));
                        jugadores.get(2).getMano().add(baraja.getMazo().get(index));
                        baraja.getMazo().remove(index);
                    }
                }
                break;
            case 4:
                for (int i=0; i<10; i++){
                    index = (int) (Math.random()*(baraja.getMazo().size()));
                    jugadores.get(0).getMano().add(baraja.getMazo().get(index));
                    baraja.getMazo().remove(index);
                    index = (int) (Math.random()*(baraja.getMazo().size()));
                    jugadores.get(1).getMano().add(baraja.getMazo().get(index));
                    baraja.getMazo().remove(index);
                    index = (int) (Math.random()*(baraja.getMazo().size()));
                    jugadores.get(2).getMano().add(baraja.getMazo().get(index));
                    baraja.getMazo().remove(index);
                    index = (int) (Math.random()*(baraja.getMazo().size()));
                    jugadores.get(3).getMano().add(baraja.getMazo().get(index));
                    baraja.getMazo().remove(index);
                }
                break;
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
                            panelSecundario.setBounds(50, 605, 1260, 95);
                            break;
                        case 1:
                            panelSecundario.setBounds(50, 0, 1260, 95);
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
                            panelSecundario.setBounds(450, 488, 464, 192);
                            break;
                        case 1:
                            panelSecundario.setBounds(50, 0, 464, 192);
                            break;
                        case 2:
                            panelSecundario.setBounds(850, 0, 464, 192);
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
                            panelSecundario.setBounds(525, 488, 320, 192);
                            break;
                        case 1:
                            panelSecundario.setBounds(25, 228, 320, 192);
                            break;
                        case 2:
                            panelSecundario.setBounds(525, 0, 320, 192);
                            break;
                        case 3:
                            panelSecundario.setBounds(1025, 228, 320, 192);
                            break;
                    }
                    this.panelPrincipal.add(panelSecundario);
                }
                break;
        }
        
        
        JPanel panelOro = mesa.getPanelOro();
        panelOro.setBounds(320, 385, 740, 240);
        this.panelPrincipal.add(panelOro);
        
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
    
   public void actualizarVentana() {
    // Eliminar todos los componentes del ContentPane
    this.ventana.getContentPane().removeAll();
    
    // Agregar el panel principal del juego
    this.ventana.getContentPane().add(this.panelPrincipal);
    
    // Agregar otros componentes necesarios, como paneles adicionales, botones, etc.
    // Agregar otras líneas de código aquí si hay otros componentes que deben agregarse
    
    // Resto del código para configurar la ventana
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
            if (this.jugadores.get(i).buscarCarta(new Carta("oro", 5))){
                turno = i+1;
                for (int j=0; j<this.jugadores.get(i).getMano().size(); j++){
                    if (this.jugadores.get(i).getMano().get(j).getFigura().equals("oro") && this.jugadores.get(i).getMano().get(j).getValor() == 5){
                        this.jugadores.get(i).jugarCarta(j+1);
                    }
                }
            }
        }
        this.mesa.llenarMesa();
        this.mesa.jugarCarta(new Carta("oro", 5));
        return turno;
    }
    
    public static void main(String[] args){ 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cantidad de jugadores: ");
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
                    if (juego.jugadores.get(turno - 1).validarVictoria()) {
                ganador = turno;
            }

                    do{      
                        do{
                           System.out.println("Jugador " + turno + ":");
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
                        do{
                           System.out.println("Jugador " + turno + ":");
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
                    if (juego.jugadores.get(turno - 1).validarVictoria()) {
                ganador = turno;
            }

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
                           System.out.println("Jugador " + turno + ":");
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
                            if (juego.jugadores.get(turno-1).validarVictoria()){
                            ganador = turno;
                            break;
                        }
                        }
                    }while (cartaAJugar != 0);
                    if (juego.jugadores.get(turno - 1).validarVictoria()) {
                ganador = turno;
            }

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
                           System.out.println("Jugador " + turno + ":");
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
                            if (juego.jugadores.get(turno-1).validarVictoria()){
                            ganador = turno;
                            break;
                        }
                        }
                        if (juego.jugadores.get(turno - 1).validarVictoria()) {
                ganador = turno;
            }

                    }while (cartaAJugar != 0);
                    turno = 1;
                    break;
            }
        }while (ganador == 0);
        
        System.out.println("JUGADOR " + ganador + " HA GANADO");
        
    }
}
