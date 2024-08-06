package program.java8stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateElement {
    public static void main(String[] args) {
        int[] arr={1,2,2,3,4,5,6};
        Set<Integer> allItems = new HashSet<>();
        Set<Integer> duplicates = Arrays.stream(arr).boxed()
                .filter(n -> !allItems.add(n))
                .collect(Collectors.toSet());
        System.out.println(duplicates);
    }


}

