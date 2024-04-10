package guzmonkey.juegocartas;
//Clase que modela una carta de la baraja espanola
public class Carta {
    //Variables de la clase 
    private int valor;
    private String clase;
    private boolean esVisible;

    //Constructor de la clase Carta
    public Carta(int valor, String clase, boolean esVisible){
        this.valor = valor;
        this.clase = clase;
        this.esVisible = esVisible;
    }

    //Getters y Setters del valor
    public int getValor(){
        return valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    //Getters y Setters de la clase
    public String getClase(){
        return clase;
    }

    public void setClase(String clase){
        this.clase = clase;
    }

    //Getters y Setters de la clase
    public boolean getEsVisible(){
        return esVisible;
    }

    //Metodo para hacer visisble o no
    public void setEsVisible(boolean esVisible){
        this.esVisible = esVisible;
    }

    //Metodo para mostrar en terminal
    public void mostrar(){
        if (esVisible){
            System.out.println("[" + valor + "/" + clase + "]");
        }else{
            System.out.print("[?/?] ");
        }
    }
}