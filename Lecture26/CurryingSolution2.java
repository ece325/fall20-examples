import java.util.function.*;


public class CurryingSolution2
{
  public static void main(String[] args) {

    BiFunction<Double,Double,Double> converter = (conversionRate, value) -> conversionRate * value;
    
    Function<Double,Double> kmToMiles = value -> converter.apply(0.6213712, value);

    double tenKmToMiles = kmToMiles.apply(10.0);
    double twentyKmToMiles = kmToMiles.apply(20.0);
    double fortyfiveKmToMiles = kmToMiles.apply(45.0);

    System.out.println("10 km -> miles: " + tenKmToMiles);
    System.out.println("20 km -> miles: " + twentyKmToMiles);
    System.out.println("45 km -> miles: " + fortyfiveKmToMiles);

    System.out.println("--------------------");
    Function<Double,Double> kgToOz = value -> converter.apply(35.27396195, value);

    double tenKgToOz = kgToOz.apply(10.0);
    double twentyKgToOz = kgToOz.apply(20.0);
    double fortyfiveKgToOz = kgToOz.apply(45.0);

    System.out.println("10 kg -> oz: " + tenKgToOz);
    System.out.println("20 km -> oz: " + twentyKgToOz);
    System.out.println("45 km -> oz: " + fortyfiveKgToOz);
  }
}