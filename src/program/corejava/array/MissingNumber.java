package program.corejava.array;


public class MissingNumber {
    public static int missingNumber(int []a, int N) {

        int xor1 = 0, xor2 = 0;

        for (int i = 0; i < N - 1; i++) {
            xor2 = xor2 ^ a[i]; // XOR of array elements
            xor1 = xor1 ^ (i + 1); //XOR up to [1...N-1]
        }
        xor1 = xor1 ^ N; //XOR up to [1...N]

        return (xor1 ^ xor2); // the missing number
    }

    public static int missingNumberBySum(int []a, int n) {

        int sum = (n*(n+1))/2;
        int allElementSum=0;

        for (int i = 0; i < a.length; i++) {
            allElementSum+=a[i];
        }

        return sum-allElementSum; // the missing number
    }
    public static int missingNumberByLoop(int []a, int n) {

        for (int i = 0; i < a.length; i++) {
            if(a[i]!=i+1){
                return i+1;
            }
        }

        return 0; // the missing number
    }

    public static void main(String args[]) {
        int N = 5;
        int a[] = {1, 2,3, 4, 6};

        int ans = missingNumberByLoop(a, N);
        System.out.println("The missing number is: " + ans);
    }
}

