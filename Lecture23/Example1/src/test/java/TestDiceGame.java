import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

 public class TestDiceGame
{
  private static DiceGame game;

  @Test
  public void constructor() {
    game = new DiceGame();
    assertNotEquals(null, game);
  }

  @Test
  public void getScore() {
    int val = game.getScore();
    assertTrue("Value out of range", (2 <=val && val <=12) );
  }
}