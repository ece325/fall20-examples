import java.util.*;

abstract class Observer {
  protected Subject subject;
  public abstract void update();
}

class Subject {
  private List<Observer> observers = new ArrayList<>();
  private int state;

  public void register(Observer o) {
      observers.add(o);
  }

  public int getState() {
      return state;
  }

  public void setState(int value) {
      this.state = value;
      convert();
  }

  private void convert() {
      for (Observer observer : observers) {
          observer.update();
      }
  }
}

class HexObserver extends Observer 
{
  public HexObserver(Subject subject) {
      this.subject = subject;
  }

  public void update() {
      System.out.print(" hex:" + Integer.toHexString(subject.getState()));
  }
}

class OctObserver extends Observer {
  public OctObserver(Subject subject) {
      this.subject = subject;
  }

  public void update() {
      System.out.print(" oct:" + Integer.toOctalString(subject.getState()));
  }
}

class BinObserver extends Observer {
  public BinObserver(Subject subject) {
      this.subject = subject;
  }

  public void update() {
      System.out.print(" bin:" + Integer.toBinaryString(subject.getState()));
  }
}

public class Solution {
  public static void main( String[] args ) {
      Subject sub = new Subject();

      sub.register(new HexObserver(sub));
      sub.register(new OctObserver(sub));
      
      int num = 356;
      System.out.println("\n-------\n"+num+":");
      sub.setState(num);
      
      // num = 726;
      // sub.register(new BinObserver(sub));
      // System.out.println("\n-------\n"+num+":");
      // sub.setState(num);
    }
}