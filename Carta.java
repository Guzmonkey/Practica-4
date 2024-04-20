package com.mycompany.cinquillo;
// Importamos clases necesarias
import javax.swing.ImageIcon;

public class Carta {
    // Declaramos variables
    private String figura;
    private int valor;
    private String ruta;
    private boolean visible;
    private ImageIcon icono;
    //Constructor de la clase carta
    public Carta(String figura, int valor){
        this.figura = figura;
        this.valor = valor;
        this.ruta = "imagenes/" + figura + valor + ".jpg";
        this.visible = true;
        this.icono = new ImageIcon(ruta);
    }
    //Getters y Setters
    public String getRuta(){
        return this.ruta;
    }
    public void setFigura(String figura){
        this.figura = figura;
        if (this.visible == true){
            this.ruta = "imagenes/" + figura + valor + ".jpg";
        }else{
            this.ruta = "imagenes/volteada.jpg";
        }
        this.icono = new ImageIcon(ruta);
    }
    public String getFigura(){
        return this.figura;
    }
    public void setValor(int valor){
        this.valor = valor;
        if (this.visible == true){
            this.ruta = "imagenes/" + figura + valor + ".jpg";
        }else{
            this.ruta = "imagenes/volteada.jpg";
        }
        this.icono = new ImageIcon(ruta);
    }
    public int getValor(){
        return this.valor;
    }
    public void setVisible(boolean visible){
        this.visible = visible;
        if (this.visible == true){
            this.ruta = "imagenes/" + figura + valor + ".jpg";
        }else{
            this.ruta = "imagenes/volteada.jpg";
        }
        this.icono = new ImageIcon(ruta);
    }
    public boolean getVisible(){
        return this.visible;
    }
    public ImageIcon getIcono(){
        return this.icono;
    }
}
