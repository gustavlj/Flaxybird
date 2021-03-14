import java.util.Scanner;

/**

Code runs on separate thread from main,
and uses bird's flax method after every
return key input

*/

class RunBird implements Runnable {
  Bird bird;
  public RunBird (Bird b) { bird = b; }
  public void run() {
    Scanner keyboard = new Scanner(System.in);
    while (bird.alive()) {
      keyboard.nextLine();
      bird.flax();
    }
  }
}
