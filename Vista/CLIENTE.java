package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
private JLabel LabelIma, LabelIma2, LabelIma3, LabelIma4, LabelIma5, LabelIma6, LabelIma7, LabelIma8;
private JLabel LabEstrella, LabEstrella2, LabEstrella3;
private JLabel Lab1, Lab2, Lab3, Lab4, Lab5, Lab6, Lab7, Lab8, Lab9, Lab10, Lab11, Lab12, Lab13, Lab14, Lab15; 
private JPanel PanelAzul, PanelBlanco, PanelBlanco1, PanelBlanco2;
public String mensaje;
public static JTextArea textArea;
    public static DataOutputStream out;
    public static void main(String[] args) {
      CLIENTE cliente = new CLIENTE();
      cliente.setVisible(true);
      
      final String HOST = "192.168.0.13";  // Cambia esta IP por la del servidor
      final int PUERTO = 1234;
      DataInputStream in;
      DataOutputStream out;
      
      // Crear la ventana principal
      JFrame frame = new JFrame("Consultar disponibilidad");
      frame.setSize(400, 300);
      frame.setLayout(new BorderLayout());
      
      // Crear un área de texto para mostrar los mensajes
      JTextArea textArea = new JTextArea();
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
          DataOutputStream finalOut = out;
          sendButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  try {
                      String mensaje = textField.getText();
                      finalOut.writeUTF(mensaje);
                      textArea.append("Cliente: " + mensaje + "\n");
                      textField.setText("");
                  } catch (IOException ex) {
                      textArea.append("Error al enviar mensaje: " + ex.getMessage() + "\n");
                  }
              }
          });
          
      } catch (IOException eee) {
          textArea.append("Error al conectar: " + eee.getMessage() + "\n");
          eee.printStackTrace();
      }
  
    }

public CLIENTE(){

    setBounds(0, 0, 900, 650);
    setBackground(new Color(77, 151, 75));
    setLayout(null);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //Fin del JFrame


    LabelIma = new JLabel();//En este se inserta una imagen
    LabelIma.setBounds(65, 45, 40, 40);  
    this.Pintar(this.LabelIma, "Imagenes\\camaa.png");

    LabelIma2 = new JLabel();//En este Label se inserta una imagen
    LabelIma2.setBounds(215, 45, 60, 50);  
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
    LabelIma6.setBounds(5, 5, 200, 160);  
    this.Pintar(this.LabelIma6, "Imagenes\\Deams.jpg");

    LabelIma7 = new JLabel();//En este Label se inserta una imagen
    LabelIma7.setBounds(5, 5, 200, 160);  
    this.Pintar(this.LabelIma7, "Imagenes\\dreams.jpg");

    LabelIma8 = new JLabel();//En este Label se inserta una imagen
    LabelIma8.setBounds(5, 5, 200, 160);  
    this.Pintar(this.LabelIma8, "Imagenes\\suite.jpg");

    LabEstrella = new JLabel();//En este Label se inserta una imagen
    LabEstrella.setBounds(500, 10, 200, 30);  
    this.Pintar(this.LabEstrella, "Imagenes\\3Estrellas.png");

    LabEstrella2 = new JLabel();//En este Label se inserta una imagen
    LabEstrella2.setBounds(500, 10, 200, 30);  
    this.Pintar(this.LabEstrella2, "Imagenes\\4Estrellas.png");

    LabEstrella3 = new JLabel();//En este Label se inserta una imagen
    LabEstrella3.setBounds(500, 10, 200, 30);  
    this.Pintar(this.LabEstrella3, "Imagenes\\5Estrellas.png");

    Lab1 = new JLabel("Habitación Doble");
    Lab1.setBounds(220, 5, 200, 30);
    Font font = new Font("Arial", Font.BOLD, 15);
    Lab1.setFont(font);
    Lab1.setBackground(Color.black);

    Lab2 = new JLabel("Habitación Individual");
    Lab2.setBounds(220, 5, 200, 30);
    Lab2.setFont(font);
    Lab2.setBackground(Color.black);

    Lab3 = new JLabel("Suite");
    Lab3.setBounds(220, 5, 200, 30);
    Lab3.setFont(font);
    Lab3.setBackground(Color.black);

    Lab4 = new JLabel("Precios desde");
    Lab4.setBounds(620, 55, 200, 30);
    Font fonte = new Font("Arial", Font.BOLD, 10);
    Lab4.setFont(fonte);
    Lab4.setBackground(Color.black);

    Lab5 = new JLabel("Precios desde");
    Lab5.setBounds(620, 55, 200, 30);
    Lab5.setFont(fonte);
    Lab5.setBackground(Color.black);

    Lab6 = new JLabel("Precios desde");
    Lab6.setBounds(620, 55, 200, 30);
    Lab6.setFont(fonte);
    Lab6.setBackground(Color.black);

    Lab7 = new JLabel("CRC 70.000");
    Lab7.setBounds(580, 80, 200, 30);
    Font fon = new Font("Arial", Font.BOLD, 20);
    Lab7.setFont(fon);
    Lab7.setForeground(new Color(233, 18, 18));

    Lab8 = new JLabel("CRC 79.500");
    Lab8.setBounds(580, 80, 200, 30);
    Lab8.setFont(fon);
    Lab8.setForeground(new Color(233, 18, 18));

    Lab9 = new JLabel("CRC 120.000");
    Lab9.setBounds(575, 80, 200, 30);
    Lab9.setFont(fon);
    Lab9.setForeground(new Color(233, 18, 18));

    Lab10 = new JLabel("Por noche");
    Lab10.setBounds(633, 100, 200, 30);
    Lab10.setFont(fonte);
    Lab10.setBackground(Color.black);

    Lab11 = new JLabel("Por noche");
    Lab11.setBounds(633, 100, 200, 30);
    Lab11.setFont(fonte);
    Lab11.setBackground(Color.black);

    Lab12 = new JLabel("Por noche");
    Lab12.setBounds(633, 100, 200, 30);
    Lab12.setFont(fonte);
    Lab12.setBackground(Color.black);

    Lab13 = new JLabel("<html><div style='text-align: justify;'>En nuestra acogedora habitación doble, diseñada "+ 
    "para ofrecerte el máximo confort y una estancia inolvidable."+
    " Perfecta para parejas, amigos o cualquier persona que busque un "+
    "espacio elegante \n y funcional, nuestra habitación doble está equipada con todas las comodidades que necesitas.</div></html>");
    Lab13.setBounds(220, 15, 350, 140);
    Font fontee = new Font("Arial", Font.ITALIC, 12);
    Lab13.setFont(fontee);
    Lab13.setBackground(Color.black);

    Lab14 = new JLabel("<html><div style='text-align: justify;'>Nuestra habitación individual con cama matrimonial"+
    "es el refugio perfecto para parejas que buscan comodidad, privacidad y un"+ 
    "ambiente acogedor. Diseñada para maximizar el confort en un espacio compacto. "+
    "Esta habitación es ideal tanto para estancias cortas como largas.</div></html>");
    Lab14.setBounds(220, 15, 350, 140);
    Lab14.setFont(fontee);
    Lab14.setBackground(Color.black);

    Lab15 = new JLabel("<html><div style='text-align: justify;'>Bienvenido a nuestra suite, un espacio lujoso y "+
    "espacioso diseñado para ofrecer el máximo confort y una experiencia inolvidable."+
    "Perfecta para aquellos que buscan un nivel superior de comodidad y servicio,"+ 
    "nuestra suite es ideal para parejas, familias o cualquier persona que desee"+
    "disfrutar de un entorno exclusivo.</div></html>");
    Lab15.setBounds(220, 15, 350, 140);
    Lab15.setFont(fontee);
    Lab15.setBackground(Color.black);

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
    PanelBlanco.add(LabelIma7);
    PanelBlanco.add(LabEstrella);
    PanelHabi.add(PanelBlanco);
    PanelBlanco.add(Lab1);
    PanelBlanco.add(Lab4);
    PanelBlanco.add(Lab7);
    PanelBlanco.add(Lab10);
    PanelBlanco.add(Lab13);

    PanelBlanco1 = new JPanel();
    PanelBlanco1.setBounds(95, 240, 700, 170);
    PanelBlanco1.setBackground(new Color(206, 246, 242));
    PanelBlanco1.setLayout(null);
    PanelBlanco1.add(LabelIma6);
    PanelBlanco1.add(LabEstrella2);
    PanelHabi.add(PanelBlanco1);
    PanelBlanco1.add(Lab2);
    PanelBlanco1.add(Lab5);
    PanelBlanco1.add(Lab8);
    PanelBlanco1.add(Lab11);
    PanelBlanco1.add(Lab14);

    PanelBlanco2 = new JPanel();
    PanelBlanco2.setBounds(95, 420, 700, 170);
    PanelBlanco2.setBackground(new Color(206, 246, 242));
    PanelBlanco2.setLayout(null);
    PanelBlanco2.add(LabelIma8);
    PanelBlanco2.add(LabEstrella3);
    PanelBlanco2.add(Lab3);
    PanelHabi.add(PanelBlanco2);
    PanelBlanco2.add(Lab6);
    PanelBlanco2.add(Lab9);
    PanelBlanco2.add(Lab12);
    PanelBlanco2.add(Lab15);

    JButton Reservar; 
    Reservar = new JButton("Reservar");
    Reservar.setForeground(Color.white);
    Reservar.setBounds(30, 45, 220, 40);
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

    JButton Salir; 
    Salir = new JButton("Regresar");
    Salir.setForeground(Color.black);
    Salir.setBounds(200, 15, 220, 40);
    Salir.setContentAreaFilled(false);
    Salir.setBorderPainted(false);
    Salir.setFocusPainted(false);
    Salir.addActionListener(new ActionListener() {
                @Override
        public void actionPerformed(ActionEvent e) {
          PanelHabi.setVisible(false);
          Panel.setVisible(true);
          setContentPane(Panel);
        }
    });
    PanelHabi.add(Salir);

    JButton Cancelar; 
    Cancelar = new JButton("Cancelar");
    Cancelar.setForeground(Color.white);
    Cancelar.setBounds(180, 45, 220, 40);
    Cancelar.setContentAreaFilled(false);
    Cancelar.setBorderPainted(false);
    Cancelar.setFocusPainted(false);
    Cancelar.addActionListener(new ActionListener() {
        @Override
public void actionPerformed(ActionEvent e) {
   
  
    
}
});
    PanelAzul.add(Cancelar);
    PanelAzul.add(LabelIma2);
    
    JButton Con; 
    Con = new JButton("<html><body>" + 
    "<p style='text-align: center;'>Consultar</p>" + 
    "<p style='text-align: center;'>Reservacion<html></p>");
    Con.setForeground(Color.white);
    Con.setBounds(370, 45, 220, 40);
    Con.setContentAreaFilled(false);
    Con.setBorderPainted(false);
    Con.setFocusPainted(false);

        PanelAzul.add(Con);
      
        JButton ConHo; 
        ConHo = new JButton("<html><body>" + 
        "<p style='text-align: center;'>Consultar</p>" + 
        "<p style='text-align: center;'>Horarios<html></p>");
        ConHo.setForeground(Color.white);
        ConHo.setBounds(520, 45, 220, 40);
        ConHo.setContentAreaFilled(false);
        ConHo.setBorderPainted(false);
        ConHo.setFocusPainted(false);
       
            PanelAzul.add(ConHo);    

    
    JButton Consultar; 
    Consultar = new JButton("Consultar disponibilidad");
    Consultar.setForeground(Color.black);
    Consultar.setBounds(50, 15, 220, 40);
    Consultar.setContentAreaFilled(false);
    Consultar.setBorderPainted(false);
    Consultar.setFocusPainted(false);
    Consultar.addActionListener(new ActionListener() {
        @Override
public void actionPerformed(ActionEvent e) {
 
   
}
});
PanelHabi.add(Consultar);     
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
