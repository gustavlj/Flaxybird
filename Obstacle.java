/**

Represents an obstacle.
Obstacle has a left position which is continously updated.
An Array with same length as game get represents which "pixels" are blocked.

*/
public class Obstacle {
  int leftPos;
  boolean [] blocks;

  // obstacles start at rightmost position, and is filled on creation
  public Obstacle(int gameLenght, int gameHeight) {
    leftPos = gameLenght;
    blocks = new boolean [gameHeight];
    fillObstacle();
  }

  private void fillObstacle() {
    // fills array with "true", basically making it a wall
    for (int i = 0; i < blocks.length; i++) { blocks[i] = true; }

    // creates a hole (false values) of "range" size somewhere in the wall
    int range = 8;
    int holeStart = (int)(Math.random() * (blocks.length-range));
    for (int i = holeStart; i < (holeStart + range); i++) { blocks[i] = false; }
  }

  public boolean getBlocks(int pos) { return blocks[pos]; } // returns if this obstacle blocks arg height
  public void moveLeft() { leftPos --; } // moves obstacle to the left
  public int getLeftPos() { return leftPos;}
}
