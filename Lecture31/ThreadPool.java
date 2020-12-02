import java.util.Random;
import java.util.concurrent.*;

class CounterTask implements Runnable {
  private final long countUntil;
  private final int id;

  CounterTask(int id, long countUntil) {
    this.countUntil = countUntil;
    this.id = id;
  }

  @Override
  public void run() {
    long sum = 0;
    for (long i = 1; i < countUntil; ++i) {
      sum += i;
    }
    System.out.println(id+" - sum(" + countUntil + ") = " + sum);
    try { Thread.sleep((long)(1000*Math.random())); }
    catch (Exception e) {}
  }
}

public class ThreadPool {
  private static final int NTHREDS = 3;

  public static void main(String[] args) throws InterruptedException {

    Thread.sleep(5000);

    ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
    for (int i = 0; i < 500; ++i) {
      final Runnable worker = new CounterTask(i, (long)(100000000*Math.random()));
      executor.execute(worker);
    }
    
    // This will make the executor accept no new threads
    // and finish all existing threads in the queue
    executor.shutdown();
    
    // Wait until all threads are finish
    executor.awaitTermination(0, null);
    System.out.println("Finished all threads");
  }
}