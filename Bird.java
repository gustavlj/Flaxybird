/**

Represents a bird ("O" in game)
Birds can sink, fly and die.

*/

class Bird {

  Game game;
  volatile int height;
  volatile boolean alive = true;

  public Bird(Game g) {
    game = g;
    height = (int)(g.getHeight()/2); // let bird start in the air
  }

  public boolean alive() { return alive; } // check if bird is still alive
  public int getHeight() { return height; } // get bird height
  public void flax() { if (height < game.getHeight()-1) { height += 3; }} // increase bird height
  public void sink() { if (height > 1) { height --; }} // decrease bird height
  public void die() { alive = false; } // kill bird
}
