package pair;

import java.util.Objects;

public class Pair<T1, T2>
{
  private T1 first;
  private T2 second;

  public Pair(T1 first, T2 second) {
    this.first = first;
    this.second = second;
  }

  public T1 getFirst() {
    return this.first;
  }

  public void setFirst(T1 first) {
    this.first = first;
  }

  public T2 getSecond() {
    return this.second;
  }

  public void setSecond(T2 second) {
    this.second = second;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<T1,T2> pair = (Pair<T1,T2>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second);
  }

  @Override
  public String toString() {
    return "(" + getFirst() + "," + getSecond() + ")";
  }

}