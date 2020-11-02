public class DiceGame
{
  private Die[] dice;

  public DiceGame() {
    dice = new Die[] {new Die(), new Die()};
  }

  public int getScore() {
    int result;
    result = (int)(Math.random() * 6) + 1;  
    dice[0].setFaceValue(result);
    result = (int)(Math.random() * 6) + 1;  
    dice[1].setFaceValue(result);
    int score = dice[0].getFaceValue() + dice[1].getFaceValue();
    return score;
  }
}