package Vista;

import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameCliente extends JFrame{

private ImageIcon imagen;
private Icon icono;    
private JLabel LabelIma, LabelIma2, LabelIma3, LabelIma4, LabelIma5, LabelIma6;
private JPanel PanelAzul;

public JFrameCliente(){
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

    JButton Reservar; 
    Reservar = new JButton("Reservar");
    Reservar.setForeground(Color.white);
    Reservar.setBounds(80, 45, 220, 40);
    Reservar.setContentAreaFilled(false);
    Reservar.setBorderPainted(false);
    Reservar.setFocusPainted(false);
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
    
}//Fin de la clase
