package program.java8stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsPrograms {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 14, 5, 16, 6, 7, 7, 9, 8};
        List<String> collected = Arrays.stream(arr).mapToObj(n -> n + "").filter(a -> a.startsWith("1")).collect(Collectors.toList());
        System.out.println("get List of number start with A" + collected);


        List<String> lst = Arrays.asList("Mayank", "Garisha", "jsd");
        String s = lst.stream().max(Comparator.comparing(o -> o.length()))
                .get();

        System.out.println("Highest Length String is " + s);

        String str = "mayankmanral";
        System.out.println("first non repeating character is " + firstNonRepeatingChar(str));

        List collect = Arrays.stream(arr).boxed().filter(value -> value % 2 == 0).collect(Collectors.toList());
        System.out.println("List of Even No Present in Arrays "+collect);

        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        System.out.println("Count occurrence of each word" + result);

        List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 2, 1, 4, 5);
        System.out.println("single value in list "+lonelyInteger(list));

        System.out.println("Sum of all Even Number are "+sumOfAllEvenNo.apply(list));
    }

    private static String firstNonRepeatingChar(String str) {
        return Arrays.stream(str.toLowerCase().split("")).
                collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() == 1L)
                    .map(entry -> entry.getKey())
                    .findFirst().get();

    }

    static Function<List<Integer>,Integer> sumOfAllEvenNo=
            lst->lst.stream()
                    .filter(a->a%2==0)
                    .collect(Collectors.summingInt(Integer::intValue));

    public static int lonelyInteger(List<Integer> a) {
        return a.stream()
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(map->map.getValue()==1).map(b->b.getKey()).findFirst().get();

    }
}
