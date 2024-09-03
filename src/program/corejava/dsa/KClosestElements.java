package program.corejava.dsa;

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = arr.length - 1;

        // Reduce the range to k elements
        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        // Collect the k closest elements
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        KClosestElements solution = new KClosestElements();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        System.out.println("K Closest Elements: " + solution.findClosestElements(arr, k, x)); // Output: [1, 2, 3, 4]
    }
}
