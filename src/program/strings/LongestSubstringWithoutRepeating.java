package program.strings;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;

public class LongestSubstringWithoutRepeating {
    public static String longestSubstringWithoutRepeating(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        AtomicInteger start = new AtomicInteger(0);
        AtomicInteger maxLength = new AtomicInteger(0);
        AtomicInteger maxStart = new AtomicInteger(0);

        IntStream.range(0, s.length())
                .forEach(end -> {
                    char c = s.charAt(end);
                    if (charIndexMap.containsKey(c)) {
                        start.set(Math.max(start.get(), charIndexMap.get(c) + 1));
                    }
                    charIndexMap.put(c, end);
                    int currentLength = end - start.get() + 1;
                    if (currentLength > maxLength.get()) {
                        maxLength.set(currentLength);
                        maxStart.set(start.get());
                    }
                });


        return s.substring(maxStart.get(), maxStart.get() + maxLength.get());
    }

    public static void main(String[] args) {
        String s = "jdjflzloiuytrellsndlnns";
        System.out.println(longestSubstringWithoutRepeating(s));  // Output: "zloiuytre"
    }
}
