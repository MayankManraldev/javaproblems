package program.corejava.array;

import java.util.Arrays;

public class LeftRotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int length = arr.length;
        int start = length-3;
        int end =length - 1;

        reverseArray(start, end, arr);
        reverseArray(0,start-1, arr);
        reverseArray(0,end,arr);
        System.out.println(Arrays.toString(arr));
    }

    static void reverseArray(int start,int end, int arr[]){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
