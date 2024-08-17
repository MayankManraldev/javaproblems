package program.corejava.basic;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PrimeNumbers {
    public static void main(String[] args) {
        int limit = 100;
        System.out.println("Prime numbers using for Loop between 1 and " + limit + " are:");
        allPrimeNumbers(limit);
        System.out.println();

        System.out.println("Prime numbers using Stream API between 1 and 100: ");
        IntStream.rangeClosed(2, 100)
                .filter(isPrime::test)
                .boxed()
                .forEach(a -> System.out.print(a + " "));
        System.out.println();

        System.out.println("Non Prime numbers using Stream API between 1 and 100: ");
        IntStream.rangeClosed(2, 100)
                .filter(isNotPrime::test)
                .boxed()
                .forEach(a -> System.out.print(a + " "));
    }

    private static void allPrimeNumbers(int limit) {
        for (int num = 2; num <= limit; num++) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(num + " ");
            }
        }
    }

    static Predicate<Integer> isPrime = number -> number > 1 &&
            IntStream.rangeClosed(2, (int) Math.sqrt(number))
                    .noneMatch(n -> number % n == 0);

    static Predicate<Integer> isNotPrime = number -> number > 1 &&
            !IntStream.rangeClosed(2, (int) Math.sqrt(number))
                    .noneMatch(n -> number % n == 0);

}
