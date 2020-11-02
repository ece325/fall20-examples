public class DiceGame
{
  private Die[] dice;

  public DiceGame() {
    dice = new Die[] {new Die(), new Die()};
  }

  public Die getDie(int index) {
    return dice[index];
  }

  public int getDiceValue() {
    return getDie(0).getFaceValue() + getDie(1).getFaceValue();
  }

  public int rollDice() {
    getDie(0).roll();
    getDie(1).roll();
    return getDiceValue();
  }
}