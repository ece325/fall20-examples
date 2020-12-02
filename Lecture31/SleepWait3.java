public class SleepWait3 {
  public final static Object lock = new Object();
  static Boolean allOk = false;

  static class DecrementCounter extends Thread {  
    public void run() {
      int n = 10;
      System.out.println("decCounterTo0 Executing");
      synchronized (lock) {
        for(; n>0; --n) {
          System.out.println(n);
          try { 
            Thread.sleep(1000); 
          }
          catch (Exception e) {
            System.out.println(e);
          }
        }
        System.out.println("Boom!");
        allOk = true;
        lock.notify();
      }
    }
  }
  
  static class Launcher extends Thread {
    public void run() {
      System.out.println("Launching Executing");
      synchronized (lock) {
        try { 
          lock.wait(); 
        }
        catch (Exception e) {
          System.out.println(e);
        }
        if (allOk) 
        System.out.println("Ready to launch!");
        else
        System.out.println("Houston we have a problem");
      }
    }
  }
  
  public static void main(String[] args) {
    try {
      Thread t1 = new DecrementCounter();      
      Thread t2 = new Launcher();
      
      t2.start();
      t1.start();
      
      t1.join();
      t2.join();
    }
    catch (Exception e) {}
  }
}