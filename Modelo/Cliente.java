package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Vista.CLIENTE;

public class Cliente {
    public static void main(String[] args) {



final String HOST="192.168.0.1";
final int PUERTO = 5000;
DataInputStream in;
DataOutputStream out;

try {
    Socket sc = new Socket(HOST, PUERTO);
    in = new DataInputStream(sc.getInputStream());
    out = new DataOutputStream(sc.getOutputStream());
    //JFrameCliente vista = new JFrameCliente();
    //vista.setVisible(true);

    out.writeUTF("Cliente");

    String mensaje = in.readUTF();
    System.out.print(mensaje);

    sc.close();

} catch (IOException e) { 
    e.printStackTrace();
}



      
    }
}
