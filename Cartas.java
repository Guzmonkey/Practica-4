package com.mycompany.practica4;
public class Cartas {
    private String palo;
    private int valor;
    public void CartasDiseño(String palo, int valor){
        this.palo = palo;
        this.valor = valor;
    }
    public void setValor(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return valor;
    }
    public void setPalo(String palo){
        this.palo = palo;
    }
    public String getPalo(){
        return palo;
    }
    @Override
      public String toString() {
        return valor + " de " + palo;
    }
}