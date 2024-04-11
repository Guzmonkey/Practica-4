// Librerias necesarias
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Scanner;
import java.awt.Image;

public class Cartas {
    // Declaramos variables
    private String figura;
    private int valor;
    private String ruta;
    private boolean visible;
    private ImageIcon icono;
    /* 
        Constructor de la clase Cartas
    */
    public Cartas(String figura, int valor){
        this.figura = figura;
        this.valor = valor;
        this.ruta = "C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\juegoCartas\\src\\main\\java\\gushdezzz\\juegocartas\\imagenes\\folder\\" + figura + valor + ".jpg";
        this.visible = true;
        this.icono = new ImageIcon(ruta);
    }
    /*
        Sets y gets de la variable Figura
    */
    public void setFigura(String figura){
        this.figura = figura;
        if (this.visible == true){
            this.ruta = "C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\juegoCartas\\src\\main\\java\\gushdezzz\\juegocartas\\imagenes\\folder\\" + figura + valor + ".jpg";
        }else{
            this.ruta = "C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\juegoCartas\\src\\main\\java\\gushdezzz\\juegocartas\\imagenes\\folder\\volteada.jpg";
        }
        this.icono = new ImageIcon(ruta);
    }
    
    public String getFigura(){
        return this.figura;
    }
    /*
        Sets y gets de la variable Valor
    */
    public void setValor(int valor){
        this.valor = valor;
        if (this.visible == true){
            this.ruta = "C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\juegoCartas\\src\\main\\java\\gushdezzz\\juegocartas\\imagenes\\folder\\" + figura + valor + ".jpg";
        }else{
            this.ruta = "C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\juegoCartas\\src\\main\\java\\gushdezzz\\juegocartas\\imagenes\\folder\\volteada.jpg";
        }
        this.icono = new ImageIcon(ruta);
    }
    
    public int getValor(){
        return this.valor;
    }
    
    /*
        Sets y gets de la variable Visible
    */
    public void setVisible(boolean visible){
        this.visible = visible;
        if (this.visible == true){
            this.ruta = "C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\juegoCartas\\src\\main\\java\\gushdezzz\\juegocartas\\imagenes\\folder\\" + figura + valor + ".jpg";
        }else{
            this.ruta = "C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\juegoCartas\\src\\main\\java\\gushdezzz\\juegocartas\\imagenes\\folder\\volteada.jpg";
        }
        this.icono = new ImageIcon(ruta);
    }
    
    public boolean getVisible(){
        return this.visible;
    }
    
    public ImageIcon getIcono(){
        return this.icono;
    }
    /*
        Metodo para mostrar las cartas en terminal
    */
    public void mostrar(){
        if (visible){
            System.out.println("[" + valor + "/" + figura + "]");
        }else{
            System.out.print("[?/?] ");
        }
    }
    
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese la figura: ");
    String figura = scanner.next();
    System.out.println("Ingrese el valor: ");
    int valor = scanner.nextInt();
    Cartas carta = new Cartas(figura, valor);
    
    ImageIcon imagenIcono = new ImageIcon(carta.getIcono().getImage().getScaledInstance(108, 144, Image.SCALE_DEFAULT));
    JLabel etiqueta = new JLabel(imagenIcono);
    
    JFrame ventana = new JFrame("Imagen de la carta");
    ventana.setSize(210, 210);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.add(etiqueta);
    ventana.setVisible(true);
    }
    
}
