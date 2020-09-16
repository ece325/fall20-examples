public class Program1 
{
  static 
  int b(double n, int k)
  { return (int)n%k; }

  static long a(double m) {
    int w = 4;
    int x = b(m,w);
    int y = b(m,w*25);
    if (x==0) {
      if (y!=0) {
        return 1;
      }
    } else {
      if (b(m,w*w*25)==0) {
        return 1;
      } else {
        return 0;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] ps = {2015,2016,2017,2018,2019,2020,2021,2022};
    for (int p : ps) {
      System.out.println(p+"? "+(a(p)==1));
    }
    
  }
}