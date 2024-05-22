package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CLIENTE extends JFrame{

private ImageIcon imagen;
private Icon icono; 
private JLabel LabelIma, LabelIma2, LabelIma3, LabelIma4, LabelIma5, LabelIma6;
private JLabel LabelHabi1;
private JPanel PanelAzul, PanelBlanco, PanelBlanco1, PanelBlanco2;
public String mensaje;
private static JTextArea textArea;
    private static DataOutputStream out;
    public static void main(String[] args) {
      CLIENTE cliente = new CLIENTE();
      cliente.setVisible(true);
        
    }

public CLIENTE(){

    setBounds(0, 0, 900, 650);
    setBackground(new Color(77, 151, 75));
    setLayout(null);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //Fin del JFrame


    LabelIma = new JLabel();//En este se inserta una imagen
    LabelIma.setBounds(115, 45, 40, 40);  
    this.Pintar(this.LabelIma, "Imagenes\\camaa.png");

    LabelIma2 = new JLabel();//En este Label se inserta una imagen
    LabelIma2.setBounds(245, 45, 60, 50);  
    this.Pintar(this.LabelIma2, "Imagenes\\Cancelar.png");

    LabelIma3 = new JLabel();//En este Label se inserta una imagen
    LabelIma3.setBounds(350, 155, 450, 410);  
    this.Pintar(this.LabelIma3, "Imagenes\\Hotel.jpg");

    LabelIma4 = new JLabel();//En este Label se inserta una imagen
    LabelIma4.setBounds(90, 155, 250, 200);  
    this.Pintar(this.LabelIma4, "Imagenes\\Hotel2.jpg");

    LabelIma5 = new JLabel();//En este Label se inserta una imagen
    LabelIma5.setBounds(90, 365, 250, 200);  
    this.Pintar(this.LabelIma5, "Imagenes\\Hotel3.jpg");

    LabelIma6 = new JLabel();//En este Label se inserta una imagen
    LabelIma6.setBounds(5, 5, 160, 160);  
    this.Pintar(this.LabelIma6, "Imagenes\\Deams.jpg");

    //Creacion del panel principal
    JPanel Panel = new JPanel();
    setContentPane(Panel);
    getContentPane();
    Panel.setLayout(null);
    Panel.setBackground(Color.white);
    Panel.add(LabelIma3);
    Panel.add(LabelIma4);
    Panel.add(LabelIma5);
 
    //Panel para poner color arriba
    PanelAzul = new JPanel();
    PanelAzul.setBounds(0, 0, 900, 100);
    PanelAzul.setBackground(new Color(46, 54, 144));
    PanelAzul.setLayout(null);
    Panel.add(PanelAzul);
       
    JPanel PanelHabi = new JPanel();
    //setContentPane(Panel); 
    PanelHabi.setLayout(null);
    PanelHabi.setBackground(Color.white);

    PanelBlanco = new JPanel();
    PanelBlanco.setBounds(95, 60, 700, 170);
    PanelBlanco.setBackground(new Color(206, 246, 242));
    PanelBlanco.setLayout(null);
    PanelBlanco.add(LabelIma6);
    PanelHabi.add(PanelBlanco);

    PanelBlanco1 = new JPanel();
    PanelBlanco1.setBounds(95, 240, 700, 170);
    PanelBlanco1.setBackground(new Color(206, 246, 242));
    PanelBlanco1.setLayout(null);
   // PanelBlanco1.add(LabelIma6);
    PanelHabi.add(PanelBlanco1);
    

    PanelBlanco2 = new JPanel();
    PanelBlanco2.setBounds(95, 420, 700, 170);
    PanelBlanco2.setBackground(new Color(206, 246, 242));
    PanelBlanco2.setLayout(null);
    PanelHabi.add(PanelBlanco2);

    JButton Reservar; 
    Reservar = new JButton("Reservar");
    Reservar.setForeground(Color.white);
    Reservar.setBounds(80, 45, 220, 40);
    Reservar.setContentAreaFilled(false);
    Reservar.setBorderPainted(false);
    Reservar.setFocusPainted(false);
    Reservar.addActionListener(new ActionListener() {
                @Override
        public void actionPerformed(ActionEvent e) {
          Panel.setVisible(false);
          PanelHabi.setVisible(true);
          setContentPane(PanelHabi);
        }
    });
    PanelAzul.add(Reservar);
    PanelAzul.add(LabelIma);

    JButton Cancelar; 
    Cancelar = new JButton("Cancelar");
    Cancelar.setForeground(Color.white);
    Cancelar.setBounds(210, 45, 220, 40);
    Cancelar.setContentAreaFilled(false);
    Cancelar.setBorderPainted(false);
    Cancelar.setFocusPainted(false);
    PanelAzul.add(Cancelar);
    PanelAzul.add(LabelIma2);
    
    
    JButton Consultar; 
    Consultar = new JButton("Consultar disponibilidad");
    Consultar.setForeground(Color.white);
    Consultar.setBounds(80, 45, 220, 40);
    Consultar.setContentAreaFilled(false);
    Consultar.setBorderPainted(false);
    Consultar.setFocusPainted(false);
    Consultar.addActionListener(new ActionListener() {
        @Override
public void actionPerformed(ActionEvent e) {
  Panel.setVisible(false);
  PanelHabi.setVisible(true);
  setContentPane(PanelHabi);
  final String HOST = "192.168.0.11";  // Cambia esta IP por la del servidor
    final int PUERTO = 2000;
    DataInputStream in;    

// Crear la ventana principal
JFrame frame = new JFrame("Consultar disponibilidad");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400, 300);
frame.setLayout(new BorderLayout());

// Crear un área de texto para mostrar los mensajes
textArea = new JTextArea();
textArea.setEditable(false);
frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

// Crear un panel para el campo de texto y el botón
JPanel panel = new JPanel();
panel.setLayout(new BorderLayout());

// Crear el campo de texto para escribir mensajes
JTextField textField = new JTextField();
panel.add(textField, BorderLayout.CENTER);

// Crear el botón para enviar mensajes
JButton sendButton = new JButton("Enviar");
panel.add(sendButton, BorderLayout.EAST);

frame.add(panel, BorderLayout.SOUTH);

// Mostrar la ventana
frame.setVisible(true);

try {
    Socket sc = new Socket(HOST, PUERTO);
    in = new DataInputStream(sc.getInputStream());
    out = new DataOutputStream(sc.getOutputStream());

    // Leer mensajes del servidor en un hilo separado
    Thread serverHandler = new Thread(() -> {
        try {
            while (true) {
                String mensaje = in.readUTF();
                textArea.append("Servidor: " + mensaje + "\n");
            }
        } catch (IOException ee) {
            textArea.append("Error al leer mensaje del servidor: " + ee.getMessage() + "\n");
        }
    });
    serverHandler.start();

    // Añadir un ActionListener al botón de enviar
    sendButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String mensaje = textField.getText();
                out.writeUTF(mensaje);
                textArea.append("Cliente: " + mensaje + "\n");
                textField.setText("");
            } catch (IOException ex) {
                textArea.append("Error al enviar mensaje: " + ex.getMessage() + "\n");
            }
        }
    });

} catch (IOException eee) {
    textArea.append("Error: " + eee.getMessage() + "\n");
    eee.printStackTrace();
}
}
});
      
    setVisible(true);
}//Fin del constructor

private void Pintar (JLabel lbl, String ruta) { //Este metodo se utiliza para ponerle imagenes de fondo a los Labels
	this.imagen = new ImageIcon(ruta);
	this.icono = new ImageIcon(
			this.imagen.getImage().getScaledInstance(
					lbl.getWidth(),
					lbl.getHeight(),
					Image.SCALE_DEFAULT)
			);	
	lbl.setIcon(this.icono);
	this.repaint();
	}//Fin del metodo Pintar  
    
public String getMensaje(){
    return mensaje;
}

}//Fin de la clase
