package com.mycompany.cinquillo;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

public class Mesa {
    
    private ArrayList<Carta> escaleraBastos;
    private ArrayList<Carta> escaleraCopas;
    private ArrayList<Carta> escaleraEspadas;
    private ArrayList<Carta> escaleraOros;
    
    public Mesa(){
        this.escaleraBastos = new ArrayList<>();
        this.escaleraCopas = new ArrayList<>();
        this.escaleraEspadas = new ArrayList<>();
        this.escaleraOros = new ArrayList<>();
    }
    
    public ArrayList<Carta> getEscaleraBastos(){
        return this.escaleraBastos;
    }
    
    public ArrayList<Carta> getEscaleraCopas(){
        return this.escaleraCopas;
    }
    
    public ArrayList<Carta> getEscaleraEspadas(){
        return this.escaleraEspadas;
    }
    
    public ArrayList<Carta> getEscaleraOros(){
        return this.escaleraOros;
    }
    
    public void llenarMesa(){
        for (int i=1; i<11; i++){
            this.escaleraBastos.add(new Carta("bastos", i));
            this.escaleraBastos.get(i-1).setVisible(false);
            this.escaleraCopas.add(new Carta("copas", i));
            this.escaleraCopas.get(i-1).setVisible(false);
            this.escaleraEspadas.add(new Carta("espadas", i));
            this.escaleraEspadas.get(i-1).setVisible(false);
            this.escaleraOros.add(new Carta("oros", i));
            this.escaleraOros.get(i-1).setVisible(false);
            
        }
    }
    
    public boolean validarCarta(Carta carta) {
        boolean bandera = false;
        String figura = carta.getFigura();
        ArrayList<Carta> escalera = null;
    
        switch (figura) {
            case "bastos":
                escalera = this.escaleraBastos;
                break;
            case "copas":
                escalera = this.escaleraCopas;
                break;
            case "espadas":
                escalera = this.escaleraEspadas;
                break;
            case "oros":
                escalera = this.escaleraOros;
                break;
            default:
                return false; // Si la figura no es válida, devolvemos false
        }
    
        if (escalera != null) {
            int valor = carta.getValor();
            int index = valor - 1;
            if (index >= 0 && index < escalera.size()) {
                if (valor == 5) {
                    bandera = !escalera.get(4).getVisible();
                } else if (valor == 1) {
                    bandera = !escalera.get(0).getVisible() && escalera.get(1).getVisible();
                } else if (valor == 10) {
                    bandera = !escalera.get(9).getVisible() && escalera.get(8).getVisible();
                } else {
                    bandera = !escalera.get(index).getVisible() && ((index > 0 && escalera.get(index - 1).getVisible()) || (index < escalera.size() - 1 && escalera.get(index + 1).getVisible()));
                }
            }
        }
    
        return bandera;
    }
    
    
    public void jugarCarta(Carta carta) {
        String figura = carta.getFigura();
        int valor = carta.getValor();
        
        switch (figura) {
            case "bastos":
                if (valor >= 1 && valor <= this.escaleraBastos.size()) {
                    this.escaleraBastos.get(valor - 1).setVisible(true);
                }
                break;
            case "copas":
                if (valor >= 1 && valor <= this.escaleraCopas.size()) {
                    this.escaleraCopas.get(valor - 1).setVisible(true);
                }
                break;
            case "espadas":
                if (valor >= 1 && valor <= this.escaleraEspadas.size()) {
                    this.escaleraEspadas.get(valor - 1).setVisible(true);
                }
                break;
            case "oros":
                if (valor >= 1 && valor <= this.escaleraOros.size()) {
                    this.escaleraOros.get(valor - 1).setVisible(true);
                }
                break;
            default:
                System.out.println("Figura de carta no válida");
                break;
        }
    }
    
    public JPanel getPanelBastos(){
        JPanel panel = new JPanel();
        panel.setVisible(false);
        for (int i=0; i<this.escaleraBastos.size(); i++){
            ImageIcon icono = new ImageIcon(this.escaleraBastos.get(i).getIcono().getImage().getScaledInstance(36, 48, Image.SCALE_DEFAULT));
            JLabel etiqueta = new JLabel(icono);
            etiqueta.setPreferredSize(new Dimension(36, 48));
            panel.setBackground(new Color(20, 134, 119));
            etiqueta.setBounds(100, 100, 36, 48);
            etiqueta.setVisible(true);
            panel.add(etiqueta);
        }
        panel.setVisible(true);
        return panel;
    }
    
    public JPanel getPanelCopas(){
        JPanel panel = new JPanel();
        panel.setVisible(false);
        for (int i=0; i<this.escaleraCopas.size(); i++){
            ImageIcon icono = new ImageIcon(this.escaleraCopas.get(i).getIcono().getImage().getScaledInstance(36, 48, Image.SCALE_DEFAULT));
            JLabel etiqueta = new JLabel(icono);
            etiqueta.setPreferredSize(new Dimension(36, 48));
            panel.setBackground(new Color(20, 134, 119));
            etiqueta.setBounds(100, 100, 36, 48);
            etiqueta.setVisible(true);
            panel.add(etiqueta);
        }
        panel.setVisible(true);
        return panel;
    }
    
    public JPanel getPanelEspadas(){
        JPanel panel = new JPanel();
        panel.setVisible(false);
        for (int i=0; i<this.escaleraEspadas.size(); i++){
            ImageIcon icono = new ImageIcon(this.escaleraEspadas.get(i).getIcono().getImage().getScaledInstance(36, 48, Image.SCALE_DEFAULT));
            JLabel etiqueta = new JLabel(icono);
            etiqueta.setPreferredSize(new Dimension(36, 48));
            panel.setBackground(new Color(20, 134, 119));
            etiqueta.setBounds(100, 100, 36, 48);
            etiqueta.setVisible(true);
            panel.add(etiqueta);
        }
        panel.setVisible(true);
        return panel;
    }
    
    public JPanel getPanelOros(){
        JPanel panel = new JPanel();
        panel.setVisible(false);
        for (int i=0; i<this.escaleraOros.size(); i++){
            ImageIcon icono = new ImageIcon(this.escaleraOros.get(i).getIcono().getImage().getScaledInstance(36, 48, Image.SCALE_DEFAULT));
            JLabel etiqueta = new JLabel(icono);
            etiqueta.setPreferredSize(new Dimension(36, 48));
            panel.setBackground(new Color(20, 134, 119));
            etiqueta.setBounds(100, 100, 36, 48);
            etiqueta.setVisible(true);
            panel.add(etiqueta);
        }
        panel.setVisible(true);
        return panel;
    }
}
