package clientserver5dinf;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aless
 */
//AL SERVER SERVE SOLO LA PORTA AL CLIENT SERVE L'IP E LA PORTA
public class GestoreClient {
    
    public static void main(String[] args) {
        
        try {
            Client cli= new Client(InetAddress.getLocalHost(), 2000);
            System.out.println("Client connesso");
            String str= cli.leggi();
            CountDown cd= new CountDown(10);//Integer.getInteger(str)
            cd.start();
            System.out.println("Server: Messaggio metodo leggi(): "+str);
            cli.scrivi("sinc");
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestoreClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

