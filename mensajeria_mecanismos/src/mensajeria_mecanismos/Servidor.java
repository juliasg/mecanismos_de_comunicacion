/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mensajeria_mecanismos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julia
 */
public class Servidor extends Observable implements Runnable {
private int puerto;
public Servidor (int puerto){
    this.puerto = puerto;
    
    
}


    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc=null;
        DataInputStream in;
        //DataOutputStream out;
       
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("servidor iniciado");
            
            while (true){
               
                sc = servidor.accept();   //soket del clientes, aqui recibo la peticio del cliente 
                
                 System.out.println("cliente conectado");
                //puentes para comunicarnos entres servidor y cliente 
                //output del servidor al cliente 
                // input para leer para recibir mensaje del cliente 
                in = new DataInputStream(sc.getInputStream());
                //out = new DataOutputStream(sc.getOutputStream());
                //espera que el cliente mande algo 
                String mensaje =in.readUTF();
                System.out.println(mensaje);
                //va a cambiar algo
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                //out.writeUTF("desde el servidor");
                //cerrar el cliente socket
                sc.close();
                System.out.println("cliente desconectado");
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}