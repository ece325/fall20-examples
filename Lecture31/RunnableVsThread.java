import java.util.concurrent.*;

class DemoRunnable implements Runnable
{
  public void run() {
    System.out.println("DemoRunnable executed");
  }
} 

class DemoThread extends Thread
{
  public void run() {
    System.out.println("DemoThread executed");
  }
}

public class RunnableVsThread
{
  public static void main(String[] args) {

    Thread t = new Thread(new DemoRunnable());
    t.start();
    
    new Thread(new DemoRunnable()).start();
    
    new DemoThread().start();
    
    new Thread(() -> System.out.println("Lambda executed")).start();
    
    Runnable task = () -> System.out.println("Runnable+Lambda executed");
    new Thread(task).start();
    
    new Thread(new Runnable(){
      public void run() { System.out.println("Anonymous Runnable executed"); }
    }).start();
    
  }
}