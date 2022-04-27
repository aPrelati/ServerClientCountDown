package clientserver5dinf;

/**
 *
 * @author aless
 */
public class CountDown extends Thread{
    
    private int tempo;
    
    public CountDown(int t){
        this.tempo=t;
    }
    
    public void run(){
        for(int i = tempo; i>0;i--){
            System.out.println(i);
            
            try {
                sleep(1000);
            }
            catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }
    }
}
