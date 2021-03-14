/**

Creates Game object.
Creates thread which listens to return key inputs.
Updates game until game is lost.

*/

class Main {
  public static void main(String[] args) throws InterruptedException{
    Game game = new Game(200, 25); // length (number of characters), height (number of characters)

    while(game.keepGoing()) {
      Thread.sleep(15); // sleeps for 15 milliseconds before update
      game.update();
    }
    System.out.println("You got " + game.getPoints() + " points, but now you are dead.");
  }
}
