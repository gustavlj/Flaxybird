import java.util.ArrayList;

/**

Game class creates, keeps track of and affects objects
Update method (called from main) moves objects
and checks for collisions
Prints screen after each update

*/

class Game {
  Bird bird;
  ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();
  int birdLeftPos = 30; // where bird appears on screen
  int length;
  int height;
  int numberOfUpdates; // counts number of updates to trigger events
  int points; // for keeping score

  public Game(int length, int height) {
    this.length = length;
    this.height = height;

    bird = new Bird(this);
    new Thread(new RunBird(bird)).start();
  }

  public void update() {
    if (numberOfUpdates % 50 == 0) { obstacleList.add(new Obstacle(length, height)); } // creates new obstacles
    for (Obstacle obstacle : obstacleList) { obstacle.moveLeft(); } // moves obtacles left
    if (numberOfUpdates % 5 == 0) { bird.sink(); } // lowers bird
    if (numberOfUpdates % 50 == 0) { points ++; } // increases points

    // note: obstacles are never removed (only moved off screen), can ArrayList become too big?

    for (Obstacle obstacle : obstacleList) { // checks if bird collides with any obstacle
      if (obstacle.getLeftPos() == birdLeftPos) {
        if (obstacle.getBlocks(bird.getHeight())) { bird.die(); }
      }
    }
    printGame(); // prints game
    numberOfUpdates ++;
  }
  public void printGame() {
    String screen = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"; // enough \ns to clear screen
    screen += ("Points: " + points + "\n"); // adds points just above the game

    String gameLines = "";
    for (int y = 0 ; y < height; y++ ){ // go through each line
      String line = "";
      for (int x = 0; x < length; x++ ){ // go through each character
        boolean blocked = false; // it is not blocked unless there is obstacle there
        for (Obstacle obstacle : obstacleList) { if (obstacle.getLeftPos() == x && obstacle.getBlocks(y)) { blocked = true; }}

        // add appropriate print; free, blocked or bird (represented by "O" )
        if (x == birdLeftPos && y == bird.getHeight()) { line += "O"; }
        else if (blocked) { line += "I"; }
        else { line += " "; }
      }
      gameLines = line + gameLines; // adds new line first, because lines are printed up -> down
    }
    System.out.println(screen + gameLines);
  }
  public int getHeight() { return height; } // helps bird not fly outside of map
  public boolean keepGoing() { return bird.alive(); } // instructs main while loop to keep going
  public int getPoints() { return points; }
}
