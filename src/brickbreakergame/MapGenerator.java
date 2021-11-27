package brickbreakergame;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;
    
    public MapGenerator() {
    map = new int[][] {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}}; /* 1 detect that this particular 
    brick have not been intersected with the ball because this has to be showon on the panel */
          
      
    brickWidth = 540/map[0].length;//length of column
    brickHeight = 180/ map.length; //length of row
    }
    /*
    width and height of the bricks that will appear
    on the screen with respect to the array elements.
    */
   
    
   public void draw(Graphics2D g) {
      for(int i= 0; i<map.length; i++){
      for (int j= 0; j<map[0].length; j++){
         if(map[i][j]>0){
         
         g.setColor(Color.WHITE);
         g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight );
         
         //this is just to show separate brick, game can still run without it
         g.setStroke(new BasicStroke(3));
         g.setColor(Color.gray);
         g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight );
         
         
         }
          
          
          
        }
      }
   }
   
  /*
   this function that will give us a value when the ball intersects
   the brick, the total number of bricks is 100 when the function
   value attains zero, the game will terminate and display a
   ‘Congratulations, you won!’ message.
   */
  public void setBrickValue(int value, int row, int col){
    map[row][col]= value;
  
  } 
   
}
