package brickbreakergame;
import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        // java frame properties
        JFrame frame= new JFrame();
        GamePlay play= new GamePlay();//object
        frame.setBounds(350, 150, 700, 600);//Specifies the size and location of the JFrame that will appear when the program is run
        frame.setTitle("Let's Play!");//title for JFrame
        frame.setResizable(false);//change the window size
        /*
        makes the window visible. We pass the value true if we want it to appear,
        and the value is false if we don't want it to appear.
        */
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//make the exit button of the JFrame close the program
        frame.add(play);//we add the object play to the frame
          
     }
}
  
