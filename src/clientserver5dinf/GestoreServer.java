package clientserver5dinf;

/**
 *
 * @author aless
 */

//instanzia la classe server e i sui metodi
public class GestoreServer {
    
    public static void main(String[] args) {
        Server srv= new Server(2000);
        
        if(srv!=null){
           srv.inAscolto();
           srv.scrivi("5");
           System.out.println("Client: "+srv.leggi());
        }
    }
    
}
