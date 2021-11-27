package brickbreakergame;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;//it has no borders or colors, but we can give it a color and borders to make it appear the way we want
import java.awt.event.KeyListener;//used to alert any user interaction from the keyboard
import java.awt.event.ActionListener;//Used to alert whenever a user clicks on an object
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Timer;
import java.awt.Rectangle;
import java.awt.Graphics2D;

public class GamePlay extends JPanel implements KeyListener,ActionListener {

    private boolean plaay = false;
    private int score = 0;
    private int totalBricks =147;//when the score be 147 the game will ends and the player wins 
    private Timer timer;
    private final int delay = 5;//responsible for the speed of the ball
    
    private int player1 = 250;//position of paddle and will be in the middle
    
    private int ballposX = 120;//posinio of ball in x axies
    private int ballposY = 400;//posinio of ball in y axies
    
    private int ballXdir = -1;//move tha ball to oppisite dir in x axies(left or right)
    private int ballYdir = -2;//move tha ball to oppisite dir in y axies(top or bottom)
    
    
    private MapGenerator MAP;//object to call the constructor
    
    //Constrctor
    public GamePlay(){
    MAP = new MapGenerator();  
    addKeyListener(this);
    setFocusable(true);
    /*
    helps you to decide whether or not to focus the 
    traversal keys and it only accepts Boolean parameters
    */
    setFocusTraversalKeysEnabled(false);
    timer = new Timer(delay, this);
    timer.start();
    }
    
    //to draw many griphic shapes like ball
    
    public void paint(Graphics g){
    //background
    g.setColor(Color.gray);//background color is gray
    g.fillRect(1, 1, 692, 592);//like padding and margin
    
    //drawing map
    MAP.draw((Graphics2D)g);//passing the object
    
    
    //borders   
    g.setColor(Color.white);    
    g.fillRect(0, 0, 3, 592);    
    g.fillRect(0, 0, 692, 3); 
    g.fillRect(692, 0, 3, 592); 

    //scores
    g.setColor(Color.white);
    g.setFont(new Font("serif", Font.BOLD, 20));
    g.drawString(""+score, 590, 30);
     
    //paddle
    g.setColor(Color.pink);
    g.fillRect(player1, 550, 180, 10);//the height of paddle is 180 and width 10
    
    //the ball
    g.setColor(Color.orange);
    g.fillOval(ballposX, ballposY, 25, 25);//the numbers for the ball size
    
    
    /*
    we need to ensure that if all the bricks are broken 
    and none are left, the game should terminate and plyer wins
    */
    if (totalBricks<=0){
     plaay= false;
      ballXdir = 0;
      ballYdir = 0;
      g.setColor(Color.black);
      g.setFont(new Font("serif", Font.BOLD, 30));
      g.drawString("Congratulations, you won! ", 190, 300);
      
      g.setFont(new Font("serif", Font.BOLD, 20 ));
      g.drawString("Press Enter to play again.", 190, 350);
    
    }
    
    // when you lose the game
    if(ballposY>570){
      plaay= false;
      ballXdir = 0;
      ballYdir = 0;
      g.setColor(Color.black);
      g.setFont(new Font("serif", Font.BOLD, 30));
      g.drawString("Game Over, your scores: ", 190, 300);
      
      g.setFont(new Font("serif", Font.BOLD, 20 ));
      g.drawString("Press Enter to play again.", 190, 350);
    }
    
    g.dispose();
    }
    
     @Override
     /*
     we invoke the method when you click on a specific object
     To detect the intersection of 2 objects within the window 
     of the game, we've created a structure using if -else and
     for loop to find the course of action according to the 
     position and direction of the ball.
     */
    public void actionPerformed(ActionEvent e) {
        timer.start();
        //to be the ball moving
        if(plaay){
        //to make the ball fall on the paddle and not outside it 
        if(new Rectangle(ballposX, ballposY, 20,20).intersects(new Rectangle(player1,550,180,8))){   
        ballYdir= -ballYdir;
        } 
        B: for(int i= 0; i<MAP.map.length; i++){
          for(int j= 0; j<MAP.map[0].length; j++){
            if(MAP.map[i][j]>0){
              int brickx= j* MAP.brickWidth + 80;
              int bricky= i* MAP.brickHeight + 50;
              int brickWidth = MAP.brickWidth;
              int brickHeight = MAP.brickHeight;
              
              Rectangle Rect = new Rectangle(brickx,bricky,brickWidth, brickHeight);
              Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
              Rectangle brickRect = Rect;
              
              if(ballRect.intersects(brickRect)){
              MAP.setBrickValue(0, i, j);
              totalBricks--;//the total bricks will decrease if the a box is broken
              score+=1;//the score will increment by 1 for each box broken
              
              //when ball hit right or left of brick
              if(ballposX + 19 <= brickRect.x || ballposX +1 >=  brickRect.x + brickRect.width ){
                ballXdir = -ballXdir;
              }
              //when ball hits top or bottom of brick
              else {
                ballYdir = -ballYdir;
              }
              
              break B;
              
              }
            }
          
          }
        
        
        }
        
        ballposX +=ballXdir;
        ballposY +=ballYdir;
        //for the left border
        if(ballposX<0){
        ballXdir= -ballXdir;
        }
        //for the top border
        if(ballposY<0){
        ballYdir= -ballYdir;
        }
        //for the right border
        if(ballposX>670){
        ballXdir= -ballXdir;
        }
        
        }
       //to redraw all the components again.
        repaint();
    }
    /*
    The function is called after the character that 
    the user has clicked on the keyboard is printed
    */
    
    /*
    We can keep these override methods as it is since 
    we don’t have any functions that will require this 
    implementation. However, removing will cause an error
    due to disruption of the method structure.
    */
    @Override
    public void keyTyped(KeyEvent e) {}
    
   /*
    The function is called after the user removes his 
    finger from the button he clicked on the keyboard
    */
    
    /*
    We can keep these override methods as it is since 
    we don’t have any functions that will require this 
    implementation. However, removing will cause an error
    due to disruption of the method structure.
    */
    @Override
    public void keyReleased(KeyEvent e) {}
    
    
    /*
    The function is called when the user clicks on any key on 
    the keyboard and before he takes his finger off it
    */
    @Override
    public void keyPressed(KeyEvent e) {
      
        /*
        we have created an if-else loop to detect the use
        of the key that is used to enable motion,
        it's ensured that if the keyPressed
        method detects that right key is being pressed, 
        then the object moves to the right, Same for the 
        left key. if enter is being pressed, the game will restart itself
        */
        if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
         
            if(player1>=600){
             player1=600;
            } 
            else{
            moveToRight();
            }
      } 
      
      
      if(e.getKeyCode()== KeyEvent.VK_LEFT) {
      
        if(player1<10){
             player1=10;
            } 
            else{
            moveToLeft();
            }
      }
      //these statments when the user press enter to play again
      if(e.getKeyCode()== KeyEvent.VK_ENTER){
       if(!plaay){
         plaay = true;
         ballposX = 120;
         ballposY = 400;
         ballXdir = -1;
         ballYdir = -2;
         player1 = 250;
         score = 0;
         totalBricks =147;
         
         MAP = new MapGenerator();
         repaint();
       }
      }
 }
    
   public void  moveToRight(){
       plaay=true;
       player1+=20;
   }
    
    public void  moveToLeft(){
       plaay=true;
       player1-=20;
   } 
        
}
