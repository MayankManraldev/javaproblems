package program.java8stream;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class FactorialStreams {
    public static BigInteger factorial(int n) {
        return LongStream.rangeClosed(1, n)
                         .mapToObj(BigInteger::valueOf)
                         .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    public static void main(String[] args) {
        int number = 5; // Change this to any number you want to find the factorial of
        System.out.println("Factorial of " + number + " is " + factorial(number));
    }
}
