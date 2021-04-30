/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.ups.sockets;

import ec.edu.ups.sockets.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julia
 */
public class Cliente implements Runnable{
    private int puerto;
    private String mensaje1;
    public Cliente(int puerto, String mensaje1){
       this.puerto = puerto;
       this.mensaje1 = mensaje1;
    }
    @Override
       public void run(){
           
             final String HOST="127.0.0.1";
             
             //DataInputStream in;
             DataOutputStream out;
               try {
             Socket sc = new Socket(HOST, puerto);
            // in = new DataInputStream(sc.getInputStream());
             out = new DataOutputStream(sc.getOutputStream());
             
             out.writeUTF(mensaje1);
            
             
             sc.close();
             
         } catch (IOException ex) {
             Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
         }  
    
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
          
     
}
