class LaunchCounter {
  Boolean allOk = false;

  synchronized void decCounterTo0(int n) {
    System.out.println("decCounterTo0 Executing");
    for(; n>0; --n) {
      System.out.println(n);
      try { Thread.sleep(1000); }
      catch (Exception e) {}
    }
    System.out.println("Boom!");
    allOk = true;
    notify();
  }

  synchronized void launch() {
    System.out.println("Launching Executing");
    try { wait(); }
    catch (Exception e) {}
    if (allOk) 
      System.out.println("Ready to launch!");
    else
      System.out.println("Houston we have a problem");
  }
}


public class SleepWait {


  public static void main(String[] args) throws InterruptedException {
    Thread t1, t2;
    LaunchCounter lc = new LaunchCounter();
    
    t1 = new Thread(() -> lc.decCounterTo0(10), "Counter");

    t2 = new Thread(lc::launch, "Launcher");

    t2.start();
    t1.start();

    t1.join();
    t2.join();
  }
}