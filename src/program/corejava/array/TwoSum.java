package program.corejava.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {12, 34, 5, 45, 67, 78, 78, 55};
        int sum=17;
        System.out.println(Arrays.toString(twoSum2(arr, 112)));
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

    private static int[] twoSum2(int[] arr,int sum) {
        Arrays.sort(arr);
        int l=0,r= arr.length-1;
        while(l<r){
            if(arr[l]+arr[r]==sum){
                return new int[] {arr[l],arr[r]};
            } else if (arr[l]+arr[r]>sum) {
                r--;
            }else{
                l++;
            }
        }
        return null;
    }
}
