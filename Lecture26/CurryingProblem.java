import java.util.function.BiFunction;

public class CurryingProblem
{
  public static void main(String[] args) {

    BiFunction<Double,Double,Double> converter = (conversionRate, value) -> conversionRate * value;

    double tenKmToMiles = converter.apply(0.6213712, 10.0);
    double twentyKmToMiles = converter.apply(0.6213712, 20.0);
    double fortyfiveKmToMiles = converter.apply(0.6213712, 45.0);

    System.out.println("10 km -> miles: " + tenKmToMiles);
    System.out.println("20 km -> miles: " + twentyKmToMiles);
    System.out.println("45 km -> miles: " + fortyfiveKmToMiles);

    System.out.println("--------------------");
    double tenKgToOz = converter.apply(35.27396195, 10.0);
    double twentyKgToOz = converter.apply(35.27396195, 20.0);
    double fortyfiveKgToOz = converter.apply(35.27396195, 45.0);

    System.out.println("10 kg -> oz: " + tenKgToOz);
    System.out.println("20 km -> oz: " + twentyKgToOz);
    System.out.println("45 km -> oz: " + fortyfiveKgToOz);
  }
}