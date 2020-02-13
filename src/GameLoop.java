
import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class GameLoop extends Applet implements Runnable, KeyListener {
    
    
Timers tm = new Timers();
    int x,y;
    public Image img;
    public Graphics d;
    public boolean up, down, left, right;
    public BufferedImage background,board,imgscore,bg,bg2,bird,enemy ,sword,sword2,fire,arrow,bullet1,bullet2,knife,plane1,plane2,plane3,plane4,fire1,fire2,fire3,fire4,fire5,fire6, f1, f2, f3, f4, f5, f6, b1, b2, b3, b4, b5, b6, dead, gameover, playAgain,playagain1, playagain2,  exit1, exit2,exit,play,play1,play2,noImage ;
    public int counter;
    public boolean gameStart;
     public int enemyX, enemyY, enemyW = 70, enemyH = 40, upenemyX, upenemyY =-100 ,upenemyW = 30, upenemyH = 125  ;
    public int mouseX, mouseY;
    public boolean collide, gamefinish, curserOnPlayagian,curserOnPlay,mouseclick,running = true, GOplayagain, newGame=true;
    public Rectangle r1,r3,r4,r5,r6,rsword,rfire,r7;
    public int timer,score, cal1,cal2;
    int ran,ran2,ran4;
    //font setting
    
    Font font = new Font("Arial", Font.BOLD,30);
    
    
    
    
    @Override
    public void run() {
        
        x = 100;
        y = 100;
     ran =  (int) (Math.random()* 400)+20;
       
 enemyX = 854;
 enemyY = ran;
   ran4 =  (int) (Math.random()* 600)+20;
    upenemyX = ran4;
 
 
         try {
            background = ImageIO.read((getClass().getResource("background.png")));
           // f1 = ImageIO.read((getClass().getResource("f1.png"));
            bird = f1;
            f2 = ImageIO.read((getClass().getResource("f2.png")));
            f3 = ImageIO.read((getClass().getResource("f3.png")));
            f4 = ImageIO.read((getClass().getResource("f4.png")));
         
            f6 = ImageIO.read((getClass().getResource("f6.png")));
        
           b2 = ImageIO.read((getClass().getResource("b2.png")));
           b3 = ImageIO.read((getClass().getResource("b3.png")));
           b4 = ImageIO.read((getClass().getResource("b4.png")));
       
           b6 = ImageIO.read((getClass().getResource("b6.png")));
           dead = ImageIO.read((getClass().getResource("dead.png")));
           gameover = ImageIO.read((getClass().getResource("gameover.png")));
           playagain1 = ImageIO.read((getClass().getResource("playagain1.jpg")));
           playagain2 = ImageIO.read((getClass().getResource("playagain2.jpg")));
           exit1 = ImageIO.read((getClass().getResource("exit1.jpg")));
           exit2 = ImageIO.read((getClass().getResource("exit2.jpg")));
           play1 = ImageIO.read((getClass().getResource("play1.jpg")));
           play2 = ImageIO.read((getClass().getResource("play2.jpg")));
           sword = ImageIO.read((getClass().getResource("sword.png")));
           fire1 = ImageIO.read((getClass().getResource("fire1.png")));
           fire2 = ImageIO.read((getClass().getResource("fire2.png")));
           fire3 = ImageIO.read((getClass().getResource("fire3.png")));
           fire4 = ImageIO.read((getClass().getResource("fire4.png")));
           fire5 = ImageIO.read((getClass().getResource("fire5.png")));
           fire6 = ImageIO.read((getClass().getResource("fire6.png")));
           arrow = ImageIO.read((getClass().getResource("arrow.png")));
        imgscore = ImageIO.read((getClass().getResource("score.png")));
           bullet2 = ImageIO.read((getClass().getResource("bullet2.png")));
           sword2 = ImageIO.read((getClass().getResource("sword2.png")));
           board = ImageIO.read((getClass().getResource("board.png")));
           bg2 = ImageIO.read((getClass().getResource("bg2.jpg")));
         } catch (IOException ex) {
            Logger.getLogger(GameLoop.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         gameAnimation();  
//enemymove();
    }
 
    
   
    
   
    
    
    
    public void gameAnimation(){
    
        
        
        
        
    while(running){
      while(gameStart){
        upenemyY = upenemyY + 2;
       enemyX = enemyX-4;
       if(enemyX<=10){
     int   ran2 =  (int) (Math.random()* 400)+20;
       enemyX = 854;
       enemyY = ran2;
         
       } 
       if(upenemyY>=400){
          ran2 =  (int) (Math.random()* 600)+40;
        
      upenemyY = -100;
       upenemyX = ran2;
       }       
       
        counter++;
        if(counter>=40){
        counter = 0;
        
        }
        if(counter <=10 ){
        
        if(left == true){
        bird = b2;
        
        }
        else
        bird = f2;
        fire = fire1;
        }
        if(counter >=10 && counter <=20 ){
        
        if(left == true){
        bird = b3;
        }
        else
        bird = f3;
        fire = fire2;
        }
        if(counter >=20 && counter <=30 ){
        
        if(left == true){
        bird = b4;
        }
        else
        bird = f4;
        fire = fire3;
        }
        if(counter >=30 && counter <=40 ){
       
        if(left == true){
        bird = b6;
        }
        else
         bird = f6;
        fire = fire5;
        }
        
        
    if(left == true){
        if(x<=-20){ x+=3;} // to restrict move out of frame at left
     x-=2;
     
     
   }
    if(right == true){
   if(x>=720){x-=3;}  // to restrict move out of frame at right
     x+=2;
   }
    if(up == true){
       if(y<=-20){y+=3;}  // to restrict move out of frame at UP
        
     y-=2;
   }
    if(down == true){
       if(y>=400){y-=3;} // to restrict move out of frame at down
        
     y+=2;
   }
    // at collision time
    if(collide){
    dead();
     
       }
    //end collision
  
    
  //  if(){}
    
        
   // repaint();
    try {
            
            Thread.sleep(8);
        } catch (InterruptedException ex) {
          System.out.println("Sleep error....");
        }
   
    }
   //  
       
    } // end while loop
    
    
    } // end of function
    public void dead(){
    
     bird = dead;
     left = false;
     right = false;
     up =  false;
     down = false;
     
     enemyW = 0;
     enemyH = 0;
     enemyX = -100;
     y = y+2;
     if(y>=400){
     gamefinish = true;
     }
    
    
    }
    
    
    public void Starting(){
    collide = false;
    gamefinish = false;
     bird = f1;
     x = 100;
     y = 100;
     enemyW = 70;
     enemyH = 40;
     enemyX = 854;
        enemyY = ran;
        upenemyX = ran4;
                upenemyY = -100;
    gameStart = true;
    tm.timer = 0;
    tm.running = true;
    
    
    }
    
    
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
  
          
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_P){ System.out.print("puseee");}
        
        
    if(e.getKeyCode() == 37){
    left = true;
    
    }
    if(e.getKeyCode() == 38){
    up = true;
    
    }
    if(e.getKeyCode() == 39){
    right = true;
   
    }
    if(e.getKeyCode() == 40){
    down = true;
    
    }
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
   if(e.getKeyCode() == 37){
    left = false;
   
    
    }
   if(e.getKeyCode() == 38){
    up = false;
    
    }
   if(e.getKeyCode() == 39){
    right = false;
   
    }
   if(e.getKeyCode() == 40){
    down = false;
    
    }
   
    }
    
    
    
    public void EnemyPlan(){
 
       
 
    
    }
    
   
}
