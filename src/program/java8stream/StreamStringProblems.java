package program.java8stream;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamStringProblems {
    public static void main(String[] args) {
        String s ="aabbbcccc";
        //output :- a2b3c4
        Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().forEach(a->System.out.print(a.getKey()+""+a.getValue()));
        System.out.println();

        String str = "12345abc";

        String numericPart = str.chars()
                .filter(Character::isDigit)
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());

        String alphabeticPart = str.chars()
                .filter(Character::isAlphabetic)
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());

        System.out.println("Numeric part: " + numericPart);
        System.out.println("Alphabetic part: " + alphabeticPart);
    }
}
