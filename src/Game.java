

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;






public class Game extends GameLoop implements MouseMotionListener{
   
    
    
    
    
     Thread t = new Thread(this);
   Timers tm = new Timers();
   Thread time = new Thread(tm); 
   public void init(){
   
    setSize(854,480);
    
    
    t.start();
        
    img = createImage(854,480);
    d = img.getGraphics();
    addKeyListener(this);
    addMouseMotionListener(this);
    addMouseListener(new Mouse());
    
   // GameLoop gm =new GameLoop();
   // Enemy
    
    //Thread p1 = new Thread(this);
    
  //  p1.start();
    
    }
    
    
public void paint(Graphics g){

    d.clearRect(0, 0, 854, 480);
d.drawImage(background, 0, 0, this);
d.drawImage(sword, 0, 0, this);
d.drawImage(fire, 0, 415, this);
d.drawImage(fire, 40, 415, this);
d.drawImage(fire, 80, 415, this);
d.drawImage(fire, 120, 415, this);
d.drawImage(fire, 160, 415, this);
d.drawImage(fire, 200, 415, this);
d.drawImage(fire, 240, 415, this);
d.drawImage(fire, 280, 415, this);
d.drawImage(fire, 320, 415, this);
d.drawImage(fire, 360, 415, this);
d.drawImage(fire, 400, 415, this);
d.drawImage(fire, 440, 415, this);
d.drawImage(fire, 480, 415, this);
d.drawImage(fire, 520, 415, this);
d.drawImage(fire, 560, 415, this);
d.drawImage(fire, 600, 415, this);
d.drawImage(fire, 640, 415, this);
d.drawImage(fire, 680, 415, this);
d.drawImage(fire, 720, 415, this);
d.drawImage(fire, 760, 415, this);
d.drawImage(fire, 800, 415, this);
d.drawImage(fire, 840, 415, this);
d.drawImage(fire, 510, 90, this);
d.drawImage(fire, 550, 90, this);
d.drawImage(sword2, 500, 180, this);
if(collide){
    tm.running = false;
   //  score = tm.timer;
   // tm.timer=0;
}
d.drawImage(board,705,-10,this);
Font font = new Font("Arial", Font.PLAIN,40);
d.setFont(font);
d.setColor(Color.WHITE);
if(tm.timer<=9){
d.drawString("0"+tm.timer,755,45);
}
else
    d.drawString(""+tm.timer,755,45);
    
repaint();
play = play1;
bg = bg2;

//d.drawImage(exit1, 290, 300, this);
 if(mouseX >= 227 && mouseX <= 481 && mouseY>=200 && mouseY<=268){
play = play2;
  
}

 if(mouseclick){
 play = noImage;
bg = noImage;
// gameStart = true;
 }
 
d.drawImage(bg, 0, 0, this);
d.drawImage(play, 227, 200, this);


g.setFont(font);

g.setColor(Color.blue);
  Rectangle r2 = new Rectangle(x+30,y+30,70,50);  // bird rect

 
  
  

 
  r1 = new Rectangle(enemyX, enemyY,enemyW,enemyH);
// d.fillRect(r1.x, r1.y, r1.width, r1.height);
 r3 = new Rectangle(enemyX, ran,enemyW,enemyH);
 
 r4 = new Rectangle(upenemyX, upenemyY,upenemyW,upenemyH);
 r5 = new Rectangle(ran4, upenemyY,upenemyW,upenemyH);
 rsword = new Rectangle(0, 0,75,480);
 
 r7 = new Rectangle(520,100,130,190);
//d.fillRect(r7.x, r7.y, r7.width, r7.height); 



 rfire = new Rectangle(0, 450,854,80);
// int ran =  (int) (Math.random()* 440)+20; 
 

enemy = bullet2;
//d.fillRect(r2.x, r2.y, r2.width, r2.height);
d.drawImage(bird, x, y, this);
d.drawImage(enemy, r3.x, r3.y, this);
 
//d.fillRect(r4.x, r4.y, r4.width, r4.height);
 d.drawImage(enemy, r1.x, r1.y, this); 
enemy = arrow;
 
 d.drawImage(enemy, r4.x, r4.y, this);
d.drawImage(enemy, r5.x, r5.y, this);
 
 
// d.fillRect(r5.x, r5.y, r5.width, r5.height);

//int ran =  (int) (Math.random()* 854)+20;
// int ran2 =  (int) (Math.random()* 440)+20;
///d.fillRect(45, 78, r1.width, r1.height);
//d.fillRect(123, 345, r1.width, r1.height);
if(r1.intersects(r2) || r3.intersects(r2) || r4.intersects(r2) || r5.intersects(r2) || rsword.intersects(r2) || rfire.intersects(r2) || r7.intersects(r2)){
   collide = true;

    }        

if(gamefinish){
        d.drawImage(bg2, 0, 0, this);
        d.drawImage(gameover, 200, 50, this);

        d.drawImage(imgscore, 170, 125, this);
   // d.drawString("YOUR SCORE: "+tm.timer, 100,300);
        if(tm.timer<=59){
        
        d.drawString("00:"+tm.timer, 360,170);     
        }
        else if(tm.timer>=60){ 
             cal1 = tm.timer/60;
             cal2 = tm.timer%60;
            if(cal1<=9){d.drawString("0"+cal1+":"+cal2, 360,170);}
            else{
             d.drawString(cal1+":"+cal2, 360,170);
        }}
            gameStart = false;
            playAgain = playagain1;
            
            if(mouseX >= 227 && mouseX <= 481 && mouseY>=200 && mouseY<=268){
                playAgain = playagain2;
            }
            d.drawImage(playAgain, 227, 200, this);
            exit = exit1;
            if(mouseX >= 290 && mouseX <= 417 && mouseY>=300 && mouseY<=360){
                exit = exit2;
            }
            
            d.drawImage(exit, 290, 300, this);
        
     
       }



 g.drawImage(img, 0, 0, this);
 
}  // END OF PAINT

public void update(Graphics g){
paint(g);

}   


    @Override
    public void mouseDragged(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) {
           mouseX = e.getX();
           mouseY = e.getY();
   
    }

    

   
    public class Mouse extends MouseAdapter{
    
        public void mousePressed(MouseEvent e){
         if(newGame){
            if(mouseX >= 227 && mouseX <= 481 && mouseY>=200 && mouseY<=268){
            mouseclick = true;
            gameStart = true;
            newGame = false;
            time.start();
             }}
          
          if(gamefinish){
          if(mouseX >= 227 && mouseX <= 481 && mouseY>=200 && mouseY<=268){
       
              Starting();
              
              
              
        // collide = false;
       //  gameStart = true;
          
          }
          if(mouseX >= 290 && mouseX <= 417 && mouseY>=300 && mouseY<=360){
       System.exit(0);
        }
          
          }
          
            
           }
    public void mouseReleased(MouseEvent e){
    
    }
    
    }
    
    
      

}