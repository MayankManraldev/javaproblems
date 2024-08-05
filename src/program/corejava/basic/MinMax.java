package program.corejava.basic;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class MinMax {
    public static void miniMaxSum(List<Integer> arr, int n) {
        Collections.sort(arr);
        int size = arr.size();
        long max = 0, min = 0;
        for (int i = 0; i < n; i++) {
            min += arr.get(i);
        }
        for (int i = size - 1; i > size - (n + 1); i--) {
            max += arr.get(i);
        }
        System.out.println("Minimum " + n + " sum and Maximum " + n + " sum are " + min + " " + max);

    }

    public static void miniMaxSumUsingStream(List<Integer> arr, int n) {
        int max = arr.stream().sorted(Comparator.reverseOrder()).limit(n).mapToInt(Integer::intValue).sum();
        int min = arr.stream().sorted().limit(n).mapToInt(Integer::intValue).sum();
        System.out.println("Minimum " + n + " sum and Maximum " + n + " sum are " + min + " " + max);

    }

    public static void main(String[] args) throws IOException {
        List<Integer> arr = Arrays.asList(1, 34, 2, 3, 43, 4, 5, 6, 7, 8, 9, 10);
        MinMax.miniMaxSum(arr, 4);
        MinMax.miniMaxSumUsingStream(arr, 4);

    }
}
