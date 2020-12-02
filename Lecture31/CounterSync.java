/**
 * CounterSync
 */
class Counter {
  private int counter = 0;

  public synchronized int inc() { return ++counter; }
  
  public synchronized int dec() { return --counter; }

  public int get() { return counter; }
}

public class CounterSync
{  
  static Counter counter = new Counter();

  public static void main(String[] args) throws InterruptedException {
    int n = 5000;
    Thread t1 = new Thread(() -> { for(int i=0;i<n;++i) 
                                     System.out.println("t1:"+ counter.inc());
                                 });
    Thread t2 = new Thread(() -> { for(int i=0;i<n;++i) 
                                     System.out.println("t2:"+ counter.dec());
                                 });
    
    t1.start();
    t2.start();
               
    t1.join();
    t2.join();

    System.out.println("Counter value: "+counter.get());
  }
}