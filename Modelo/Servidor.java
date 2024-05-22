package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import Vista.CLIENTE;
import Vista.JFrameServidor;

public class Servidor {

public static void main(String[] args) {



Socket sc = null;
DataInputStream in;
DataOutputStream out;
ServerSocket servidor = null;
final int PUERTO = 5000;

try {
        servidor = new ServerSocket(PUERTO);
        JOptionPane.showMessageDialog(null, "Se ha iniciado el servidor");
while(true){
sc = servidor.accept();

in = new DataInputStream(sc.getInputStream());
out = new DataOutputStream(sc.getOutputStream());

String mensaje = in.readUTF();
System.out.println(mensaje);
out.writeUTF("Hola servidor");
sc.close();
System.out.println("chao");

}//Fin while

} catch (IOException e) {
        e.printStackTrace();
}//Fin catch

        //JFrameServidor vista = new JFrameServidor();
        //vista.setVisible(true);
}
}
