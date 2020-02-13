
import java.util.logging.Level;
import java.util.logging.Logger;


public class Timers implements Runnable{
public boolean  working=true;
   static public int timer=0;
  static public boolean running=true;  
    @Override
    public void run() {
        while(working){
      while(running){
        try {
            
            timer++;
            Thread.sleep(1000);
        }
//g.drawString("Collide", 10, 50);
        catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
}}
    
    
    }

    
    
    
}
