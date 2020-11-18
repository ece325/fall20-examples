import java.util.function.*;

@FunctionalInterface
interface ExtendedBiFunction<T, U, R> extends BiFunction<T, U, R> 
{
  default Function<U, R> curry1(T t) {
    return u -> apply(t, u);
  }

  default Function<T, R> curry2(U u) {
    return t -> apply(t, u);
  }
}

public class CurryingSolution
{
  public static void main(String[] args) {

    ExtendedBiFunction<Double,Double,Double> converter = (conversionRate, value) -> conversionRate * value;
    
    Function<Double,Double> kmToMiles = converter.curry1(0.6213712);

    double tenKmToMiles = kmToMiles.apply(10.0);
    double twentyKmToMiles = kmToMiles.apply(20.0);
    double fortyfiveKmToMiles = kmToMiles.apply(45.0);

    System.out.println("10 km -> miles: " + tenKmToMiles);
    System.out.println("20 km -> miles: " + twentyKmToMiles);
    System.out.println("45 km -> miles: " + fortyfiveKmToMiles);

    System.out.println("--------------------");
    Function<Double,Double> kgToOz = converter.curry1(35.27396195);

    double tenKgToOz = kgToOz.apply(10.0);
    double twentyKgToOz = kgToOz.apply(20.0);
    double fortyfiveKgToOz = kgToOz.apply(45.0);

    System.out.println("10 kg -> oz: " + tenKgToOz);
    System.out.println("20 km -> oz: " + twentyKgToOz);
    System.out.println("45 km -> oz: " + fortyfiveKgToOz);
  }
}