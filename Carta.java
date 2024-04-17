package gushdezzz.maincartas;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Scanner;
import java.awt.Image;

public class Carta {
    
    private String figura;
    private int valor;
    private String ruta;
    private boolean visible;
    private ImageIcon icono;
    
    public Carta(String figura, int valor){
        this.figura = figura;
        this.valor = valor;
        this.ruta = "C:\\Users\\guspa\\OneDrive\\Desktop\\Cosas importantes\\Cuarto semestre\\Programacion orientada a objetos\\Laboratorio\\imagenesCartas\\" + figura + valor + ".png";
        this.visible = true;
        this.icono = new ImageIcon(ruta);
    }
    
    public String getRuta(){
        return this.ruta;
    }
    
    public void setFigura(String figura){
        this.figura = figura;
        if (this.visible == true){
            this.ruta = "C:\\Users\\guspa\\OneDrive\\Desktop\\Cosas importantes\\Cuarto semestre\\Programacion orientada a objetos\\Laboratorio\\imagenesCartas\\" + figura + valor + ".png";
        }else{
            this.ruta = "C:\\Users\\guspa\\OneDrive\\Desktop\\Cosas importantes\\Cuarto semestre\\Programacion orientada a objetos\\Laboratorio\\imagenesCartas\\volteada.png";
        }
        this.icono = new ImageIcon(ruta);
    }
    
    public String getFigura(){
        return this.figura;
    }
    
    public void setValor(int valor){
        this.valor = valor;
        if (this.visible == true){
            this.ruta = "C:\\Users\\guspa\\OneDrive\\Desktop\\Cosas importantes\\Cuarto semestre\\Programacion orientada a objetos\\Laboratorio\\imagenesCartas\\" + figura + valor + ".png";
        }else{
            this.ruta = "C:\\Users\\guspa\\OneDrive\\Desktop\\Cosas importantes\\Cuarto semestre\\Programacion orientada a objetos\\Laboratorio\\imagenesCartas\\volteada.png";
        }
        this.icono = new ImageIcon(ruta);
    }
    
    public int getValor(){
        return this.valor;
    }
    
    public void setVisible(boolean visible){
        this.visible = visible;
        if (this.visible == true){
            this.ruta = "C:\\Users\\guspa\\OneDrive\\Desktop\\Cosas importantes\\Cuarto semestre\\Programacion orientada a objetos\\Laboratorio\\imagenesCartas\\" + figura + valor + ".png";
        }else{
            this.ruta = "C:\\Users\\guspa\\OneDrive\\Desktop\\Cosas importantes\\Cuarto semestre\\Programacion orientada a objetos\\Laboratorio\\imagenesCartas\\volteada.png";
        }
        this.icono = new ImageIcon(ruta);
    }
    
    public boolean getVisible(){
        return this.visible;
    }
    
    public ImageIcon getIcono(){
        return this.icono;
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la figura: ");
        String figura = scanner.next();
        System.out.println("Ingrese el valor: ");
        int valor = scanner.nextInt();
        Carta carta = new Carta(figura, valor);
        JFrame ventana = new JFrame("Imagen de la carta");
        ventana.setSize(110, 146);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel etiqueta = new JLabel(new ImageIcon(carta.getIcono().getImage().getScaledInstance(108, 144, Image.SCALE_DEFAULT)));
        ventana.add(etiqueta);
        ventana.setVisible(true);
    }
}
