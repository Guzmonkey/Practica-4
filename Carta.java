import javax.swing.*;
import java.awt.*;

public class Carta {
    private int valor;
    private String palo;
    private String ruta;
    private boolean visible;
    private ImageIcon icono;

    public Carta(String palo, int valor) {
        this.palo = palo;
        this.valor = valor;
        this.ruta = "C:/Users/guspa/OneDrive/Documents/NetBeansProjects/MainCartas/src/main/java//gushdezzz/imagenesCartas/" + palo + valor + ".png";
        this.visible = true;
        this.icono = new ImageIcon(ruta);
        System.out.println(ruta);
    }

    public void setPalo() {
        this.palo = palo;
        if (this.visible == true) {
            this.ruta = "C:/Users/guspa/OneDrive/Documents/NetBeansProjects/MainCartas/src/main/java//gushdezzz/imagenesCartas/" + palo + valor + ".png";
        } else {
            this.ruta = "C:/Users/guspa/OneDrive/Documents/NetBeansProjects/MainCartas/src/main/java//gushdezzz/imagenesCartas/volteada.png";
        }
        this.icono = new ImageIcon(ruta);
    }

    public String getPalo() {
        return this.palo;
    }

    public void setValor() {
        this.valor = valor;
        if (this.visible == true) {
            this.ruta = "C:/Users/guspa/OneDrive/Documents/NetBeansProjects/MainCartas/src/main/java//gushdezzz/imagenesCartas/" + palo + valor + ".png";
        } else {
            this.ruta = "C:/Users/guspa/OneDrive/Documents/NetBeansProjects/MainCartas/src/main/java//gushdezzz/imagenesCartas/volteada.png";
        }
        this.icono = new ImageIcon(ruta);
    }

    public int getValor() {
        return this.valor;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public void setVisible() {
        this.visible = visible;
        if (this.visible == true) {
            this.ruta = "C:/Users/guspa/OneDrive/Documents/NetBeansProjects/MainCartas/src/main/java//gushdezzz/imagenesCartas/" + palo + valor + ".png";
        } else {
            this.ruta = "C:/Users/guspa/OneDrive/Documents/NetBeansProjects/MainCartas/src/main/java//gushdezzz/imagenesCartas/volteada.png";
        }
        this.icono = new ImageIcon(ruta);
    }

    public ImageIcon getIcon() {
        return this.icono;
    }

    public static void main(String[] args) {
        // Crear una nueva instancia de Carta
        Carta carta = new Carta("bastos", 1);

        // Crear el JFrame
        JFrame ventana = new JFrame("Imagen carta");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Escalar la imagen al tamaño deseado
        Image imagenEscalada = carta.getIcon().getImage().getScaledInstance(260, 398, Image.SCALE_SMOOTH);

        // Crear un JLabel con la imagen escalada
        JLabel etiqueta = new JLabel(new ImageIcon(imagenEscalada));

        // Agregar la etiqueta al JFrame
        ventana.getContentPane().add(etiqueta);

        // Ajustar el tamaño del JFrame al tamaño de la imagen escalada
        ventana.pack();

        // Hacer visible el JFrame
        ventana.setVisible(true);
    }
}
