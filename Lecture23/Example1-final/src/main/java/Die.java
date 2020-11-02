public class Die
{
  private int faceValue;

  /**
   * @return the faceValue
   */
  public int getFaceValue() {
    return faceValue;
  }

  /**
   * @param faceValue the faceValue to set
   */
  public void setFaceValue(int faceValue) {
    this.faceValue = faceValue;
  }

  public void roll() {
    setFaceValue((int)(Math.random() * 6) + 1);
  }

}