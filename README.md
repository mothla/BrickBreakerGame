# Brick Breaker Game
A project for IT214 course, presented to Ms.Meshaiel Alsheail, the software development process of brick breaker game. 

In the Brick Breaker Game, a player is required to break the wall of bricks by deflecting a bouncing ball with a paddle that can be moved horizontally by the player. We used NetBeans IDE to create this project.

## Idea of the game
The player controls a paddle at the bottom of the window to bounce a ball that breaks blocks at the top of the window, each time the player breaks blocks the score increase by 1 that done with help of these statements:

```java
if(ballRect.intersects(brickRect)){
       MAP.setBrickValue(0, i, j);
       totalBricks--;//the total bricks will decrease if the a box is broken
       score+=1;//the score will increment by 1 for each box broken
}
```

## Design Pattern
We have use this pattern:

<img width="550" alt="origional shape" src="https://user-images.githubusercontent.com/94991403/143684034-95de047a-12a9-449f-9ffc-afb8ea779053.png">

If you wnat to use (Pyramidal Design Pattern) write these statements in [MapGenerator](https://github.com/mothla/BrickBreakerGame/blob/main/src/brickbreakergame/MapGenerator.java) file:

```java

public MapGenerator() {
    map = new int[][] {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
        {0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
        {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
        {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0},
        {0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0}}; 
      
    brickWidth = 540/map[0].length;//length of column
    brickHeight = 300/ map.length; //length of row
    }
```
Output sample :

<img width="550" alt="another shape" src="https://user-images.githubusercontent.com/94991403/143684577-35cdf3ab-ba3e-4e1f-b32c-440055cbd8ea.png">

Another design pattern :

```java
public MapGenerator() {
    map = new int[][] {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
        {0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
        {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
        {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0},
        {0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
        {0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
        {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
        {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0},
        {0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
        {0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
        {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
        {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0},
        {0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0}}; /* 1 detect that this particular 
    brick have not been intersected with the ball because this has to be show on on the panel */
          
      
    brickWidth = 540/map[0].length;//length of column
    brickHeight = 250/ map.length; //length of row
    }
   ```
   Output sample :
   
   <img width="550" alt="Screen Shot 2021-12-11 at 1 36 51 AM" src="https://user-images.githubusercontent.com/94991403/145650434-c0b2268f-b86a-4f86-a89a-5787507307da.png">


## How to play?
Use the Left & Right keys to play the game.

## Reference
 [YouTube video](https://youtu.be/K9qMm3JbOH0)
