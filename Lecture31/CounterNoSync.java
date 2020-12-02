public class CounterNoSync
{  
  static int counter = 0;

  public static void main(String[] args) throws InterruptedException {
    int n = 5000;
    Thread t1 = new Thread(() -> { for(int i=0;i<n;++i) 
                                     System.out.println("t1:"+ ++counter);
                                 });
    Thread t2 = new Thread(() -> { for(int i=0;i<n;++i) 
                                     System.out.println("t2:"+ --counter);
                                 });
    
    t1.start();
    t2.start();
               
    t1.join();
    t2.join();

    System.out.println("Counter value: "+counter);
  }
}