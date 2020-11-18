import java.util.*;
import java.util.stream.*;

public class InfiniteStreams
{
  public static void main(String[] args) {
    // Generate
    Stream.generate(Math::random).limit(5).forEach(System.out::println); 

    // Iterator
    Stream<Integer> powerOf2Stream = Stream.iterate(2, i -> i * 2);
    powerOf2Stream.limit(5).forEach(System.out::println);
  }
}