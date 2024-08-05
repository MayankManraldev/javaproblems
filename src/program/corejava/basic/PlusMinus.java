package program.corejava.basic;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class PlusMinus {

    public static void plusMinus(List<Integer> arr) {
        int postive = 0, negative = 0, zero = 0, size = arr.size();
        for (int i = 0; i < size; i++) {
            if (arr.get(i) > 0) {
                postive += 1;
            } else if (arr.get(i) < 0) {
                negative += 1;
            } else {
                zero += 1;
            }
        }
        double p = (double) postive / size;
        double n = (double) negative / size;
        double z = (double) zero / size;
        System.out.format("%.6f", p);
        System.out.println();
        System.out.format("%.6f", n);
        System.out.println();
        System.out.format("%.6f", z);


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        PlusMinus.plusMinus(arr);

        bufferedReader.close();
    }

}
