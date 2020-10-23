public class ExecTime
{
  private final double toSeg = 1000000000.0;
  private long startTime;
  private long stopTime;
  private long accumulatedTime;
  private int samples;
  private String message;
  private String unit = "ms";

  public ExecTime() {
    startTime = 0;
    stopTime = 0;
    accumulatedTime = 0;
    samples = 0;
    message = "";
  }

  public ExecTime(String msg, String unit) {
    startTime = 0;
    stopTime = 0;
    accumulatedTime = 0;
    samples = 0;
    message = msg;
    this.unit = unit;
  }

  public void start() {
    if (unit.equals("ms"))
      this.startTime = System.currentTimeMillis();
    else
      this.startTime = System.nanoTime();
  }

  public void stop() {
    if (unit.equals("ms"))
      this.stopTime = System.currentTimeMillis();
    else
      this.stopTime = System.nanoTime();
  }

  public void register() {
    accumulatedTime += (stopTime-startTime);
    samples += 1;
  }

  public void report() {
    if (samples > 0)
      System.out.println(message+": "+ accumulatedTime/samples/toSeg + unit + " average of "+samples+" samples");
    else
      System.out.println(message+": "+ (stopTime-startTime)+unit);
  }

  public void report(String msg) {
    if (samples > 0)
      System.out.println(msg+": "+ accumulatedTime/samples/toSeg + unit+" average of "+samples+" samples");
    else
      System.out.println(msg+": "+ (stopTime-startTime)+unit);
  }

  public double average() {
    if (samples > 0)
      return accumulatedTime/samples/toSeg;
    return (stopTime-startTime)/toSeg;
  }

  /**
   * @return the number of samples
   */
  public int getSamples() {
    return samples;
  }
}