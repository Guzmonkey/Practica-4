package gushdezzz.maincartas;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

public class Jugador {
    
    private String nombre;
    private int puntos;
    private ArrayList<Carta> mano;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntos = 0;
        this.mano = new ArrayList<>();
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setPuntos(int puntos){
        this.puntos = puntos;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int puntos(){
        return this.puntos;
    }

    public ArrayList<Carta> getMano() {
        return this.mano;
    }
    
    public boolean buscarCarta(Carta carta){
        boolean bandera = false;
        for (int i=0; i<this.mano.size(); i++) {
            if (this.mano.get(i).getRuta().equals("C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\Practica04Poo\\src\\main\\java\\gushdezzz\\Cartas\\" + carta.getPalo() + carta.getValor() + ".jpg")){
                bandera = true;
            }
        }
        return bandera;
    }
    
    public void jugarCarta(int carta){
        this.mano.get(carta-1).setVisible(false);
    }
    
    public JPanel getPanelMano(){
        JPanel panel = new JPanel(new FlowLayout());
        for (int i=0; i<this.mano.size(); i++) {
            ImageIcon icono = new ImageIcon(this.mano.get(i).getIcon().getImage().getScaledInstance(54, 72, Image.SCALE_DEFAULT));
            JLabel etiqueta = new JLabel(icono);
            JPanel etiquetaPanel = new JPanel(new BorderLayout());
            etiquetaPanel.add(etiqueta, BorderLayout.CENTER);
            JLabel etiquetaIndice = new JLabel(String.valueOf(i+1));
            etiquetaIndice.setHorizontalAlignment(JLabel.CENTER);
            etiquetaIndice.setForeground(Color.BLACK);
            etiquetaIndice.setFont(new Font("Arial", Font.BOLD, 14));
            etiquetaPanel.add(etiquetaIndice, BorderLayout.NORTH);
            etiqueta.setPreferredSize(new Dimension(58, 74));
            panel.setBackground(new Color(53, 148, 100));
            etiqueta.setVisible(true);
            panel.add(etiquetaPanel);
        }
        return panel;
    }
   
}
