package clientserver5dinf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.BindException;

/**
 *
 * @author aless
 */
public class Server {
    
    ServerSocket ss;
    Socket so;
    BufferedReader in;
    BufferedWriter out;
    
    public Server(int porta) {
        try {
            ss= new ServerSocket(porta);
            System.out.println("Il Server è in ascolto");
            //metodo SetSotimeOut e poi lancio il thread
            CountDown cd= new CountDown(10);
            cd.start();
            ss.setSoTimeout(10000);
        }catch(BindException ex){
            
        } 
        catch(IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inAscolto(){
        try {
            so= ss.accept();
            System.out.println("Connessione stabilita");
            in= new BufferedReader(new InputStreamReader(so.getInputStream()));
            out= new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void scrivi(String msg){
        try {
            out.write(msg+"\n");
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String leggi(){
        
        String msg="";
        
        try {
            msg= in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return msg;
    }
    
}
