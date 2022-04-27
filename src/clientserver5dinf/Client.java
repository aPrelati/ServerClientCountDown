package clientserver5dinf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aless
 */
public class Client {
    
    Socket so;
    BufferedReader br;
    BufferedWriter bw;
    

    public Client(InetAddress ip, int porta) {
        
        try {
            so= new Socket(ip, porta);
            br= new BufferedReader(new InputStreamReader(so.getInputStream()));
            bw= new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String leggi(){
        
        String msg="";
        
        try {
            msg= br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return msg;
    }
    //metodo scrivi bw e poi devo instanziare il thread sul server
    
    public void scrivi(String msg){
        try {
            bw.write(msg+"\n");
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
