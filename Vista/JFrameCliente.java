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
private JLabel LabelIma;
private JPanel PanelAzul;

public JFrameCliente(){
    setBounds(0, 0, 800, 500);
    setBackground(new Color(77, 151, 75));
    setLayout(null);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //Fin del JFrame

    LabelIma = new JLabel();//En este Label se inserta la imagen de fondo
    LabelIma.setBounds(75, 45, 30, 30);  
    this.Pintar(this.LabelIma, "Imagenes\\cama.png");

    //Creacion del panel principal
    JPanel Panel = new JPanel();
    setContentPane(Panel);
    getContentPane();
    Panel.setLayout(null);
    Panel.setBackground(Color.white);
 
    //Panel para poner color arriba
    PanelAzul = new JPanel();
    PanelAzul.setBounds(0, 0, 800, 100);
    PanelAzul.setBackground(new Color(46, 54, 144));
    PanelAzul.setLayout(null);
    Panel.add(PanelAzul);

    JButton Reservar; 
    Reservar = new JButton("Reservar");
    Reservar.setForeground(Color.white);
    Reservar.setBounds(30, 40, 220, 40);
    Reservar.setContentAreaFilled(false);
    Reservar.setBorderPainted(false);
    Reservar.setFocusPainted(false);
    PanelAzul.add(Reservar);
    PanelAzul.add(LabelIma);

   
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
