package program.java8stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsPrograms {
    public static void main(String[] args) {
        int []arr={1,2,3,3,4,5,6,6,7,7,9,8};
        List collect = Arrays.stream(arr).boxed().filter(value -> value % 2 == 0)
                .peek(System.out::println).collect(Collectors.toList());
        System.out.println(collect);

        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        System.out.println("Count occurence of each word" + result);



    }
}
