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

public class FuncComposition
{
  public static void main(String[] args) {

    ExtendedBiFunction<Double,Double,Double> converter = (conversionRate, value) -> conversionRate * value;
    
    // Function<Double,Double> kgToOz = converter.curry1(35.27396195);
    // Function<Double,Double> ozToLb = converter.curry1(0.0625);

    // Function<Double,Double> kgToLb = value -> ozToLb.apply(kgToOz.apply(value));
  
    // double tenKgToLb = kgToLb.apply(10.0);
    // double twentyKgToLb = kgToLb.apply(20.0);
    // double fortyfiveKgToLb = kgToLb.apply(45.0);

    // System.out.println("10 kg -> lb: " + tenKgToLb);
    // System.out.println("20 km -> lb: " + twentyKgToLb);
    // System.out.println("45 km -> lb: " + fortyfiveKgToLb);

    // /**
    Function<Double,Double> kgToOz = converter.curry1(35.27396195);
    Function<Double,Double> ozToLb = converter.curry1(0.0625);

    Function<Double,Double> kgToLb = kgToOz.andThen(ozToLb);
  
    double tenKgToLb = kgToLb.apply(10.0);
    double twentyKgToLb = kgToLb.apply(20.0);
    double fortyfiveKgToLb = kgToLb.apply(45.0);

    System.out.println("10 kg -> lb: " + tenKgToLb);
    System.out.println("20 km -> lb: " + twentyKgToLb);
    System.out.println("45 km -> lb: " + fortyfiveKgToLb);
    // */

  }
}