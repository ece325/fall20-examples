import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

 public class TestDie
{
  private static Die die;

  @Test
  public void constructor() {
    die = new Die();
    assertNotEquals(null, die);
  }

  @Test
  public void setFaceValue() {
    die.setFaceValue(4);
    assertEquals(4, die.getFaceValue());
  }
}