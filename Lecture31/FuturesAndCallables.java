import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class ComputationTask implements Callable<Long> {
  @Override
  public Long call() throws Exception {
    long sum = 0;
    for (long i = 1; i < 1000; ++i) {
      sum += i;
    }
    try { Thread.sleep((long)(10*Math.random())); }
    catch (Exception e) {}
    return sum;
  }
}

public class FuturesAndCallables {
  private static final int NTHREDS = 10;

  public static void main(String[] args) throws InterruptedException {

    Thread.sleep(5000);

    ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
    List<Future<Long>> futures = new ArrayList();

    for (int i = 0; i < 20000; ++i) {
      Callable<Long> worker = new ComputationTask();
      Future<Long> result = executor.submit(worker); 
      futures.add(result);
    }
    
    long sum = 0;
    System.out.println("# of futures:"+futures.size());

    for(Future<Long> future : futures) {
      try {
        sum += future.get();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
    
    System.out.println("Total sum: "+ sum);
    executor.shutdown();
  }
}