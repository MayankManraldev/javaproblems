package program.corejava.basic;

import java.util.*;

public class DiagonalDifference {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>(Arrays.asList(Arrays.asList(1),Arrays.asList(11, 2, 4),Arrays.asList(4, 5, 6), Arrays.asList(10, 8, -12)));
        diagonalDifference(arr);
    }


    public static int diagonalDifference(List<List<Integer>> arr) {
        int d1 = 0, d2 = 0;
        if(arr.size()!=arr.get(0).size()){
            arr.remove(0);
        }
        int n=arr.size();
        for(int i=0;i<n;i++){
            d1+=arr.get(i).get(i);
            d2+=arr.get(i).get(n-i-1);
        }
        return Math.abs(d1-d2);

    }
}
