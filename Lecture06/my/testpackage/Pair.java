package my.testpackage;

/**
 * A pair of two integer values
 */
public class Pair {
  private int first;
  private int second;

  public Pair(int first, int second) {
    this.first = first;
    this.second = second;
  }

  /**
   * @return the first
   */
  public int getFirst() {
    return first;
  }

  /**
   * @return the second
   */
  public int getSecond() {
    return second;
  }
  
  /**
   * @param first the first to set
   */
  public void setFirst(int first) {
    this.first = first;
  }

  /**
   * @param second the second to set
   */
  public void setSecond(int second) {
    this.second = second;
  }

  public String toString() {
    return "("+first+","+second+")";
  }
}
