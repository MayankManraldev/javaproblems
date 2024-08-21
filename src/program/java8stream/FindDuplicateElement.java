package program.java8stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElement {
    public static void main(String[] args) {
        int[] arr={1,2,2,3,4,5,6};
        Set<Integer> allItems = new HashSet<>();
        Set<Integer> duplicates = Arrays.stream(arr).boxed()
                .filter(n -> !allItems.add(n))
                .collect(Collectors.toSet());
        System.out.println("All Items are "+allItems);
        System.out.println("Duplicate Items using Set are");
        System.out.println(duplicates);

        List<Integer> duplicateList = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).mapToInt(e -> e.getKey()).boxed().collect(Collectors.toList());
        System.out.println("Duplicate Items using groupingBy are");
        System.out.println(duplicateList);

    }


}

