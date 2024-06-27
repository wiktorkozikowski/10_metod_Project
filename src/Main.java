import java.util.function.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Function<Double, String> doubleToString = d -> "Double value: " + d;
        List<Double> doubleList = Arrays.asList(4.5, 3.2, 7.8);
        List<String> doubleToStringList = doubleList.stream()
                .map(doubleToString)
                .collect(Collectors.toList());
        System.out.println("Double to String: " + doubleToStringList);

        IntFunction<String> intToString = i -> "Int value: " + i;
        List<Integer> intList = Arrays.asList(10, 20, 30);
        List<String> intToStringList = intList.stream()
                .map(intToString::apply)
                .collect(Collectors.toList());
        System.out.println("Int to String: " + intToStringList);

        LongFunction<String> longToString = l -> "Long value: " + l;
        List<Long> longList = Arrays.asList(100L, 200L, 300L);
        List<String> longToStringList = longList.stream()
                .map(longToString::apply)
                .collect(Collectors.toList());
        System.out.println("Long to String: " + longToStringList);

        Consumer<Double> doublePrinter = d -> System.out.println("Double consumed: " + d);
        doubleList.forEach(doublePrinter);

        Consumer<Integer> intPrinter = i -> System.out.println("Int consumed: " + i);
        intList.forEach(intPrinter);

        Consumer<Long> longPrinter = l -> System.out.println("Long consumed: " + l);
        longList.forEach(longPrinter);

        DoubleSupplier randomDoubleSupplier = Math::random;
        List<Double> suppliedDoubles = Arrays.asList(randomDoubleSupplier.getAsDouble(), randomDoubleSupplier.getAsDouble());
        System.out.println("Supplied doubles: " + suppliedDoubles);

        IntSupplier intSupplier = () -> 42;
        List<Integer> suppliedInts = Arrays.asList(intSupplier.getAsInt(), intSupplier.getAsInt());
        System.out.println("Supplied ints: " + suppliedInts);

        LongSupplier longSupplier = () -> 123456789L;
        List<Long> suppliedLongs = Arrays.asList(longSupplier.getAsLong(), longSupplier.getAsLong());
        System.out.println("Supplied longs: " + suppliedLongs);

        DoublePredicate isPositive = d -> d > 0;
        List<Boolean> positiveResults = doubleList.stream()
                .map(isPositive::test)
                .collect(Collectors.toList());
        System.out.println("Is positive: " + positiveResults);
    }
}
