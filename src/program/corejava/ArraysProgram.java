package program.corejava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraysProgram {
    public static void main(String[] args) {
        int arr[] = {12, 34, 5, 45, 67, 78, 78, 55};
        System.out.println(Arrays.toString(twoSum(arr, 112)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                return new int[]{map.get(rem), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
