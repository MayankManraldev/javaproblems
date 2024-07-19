package program.corejava.basic;

public class Sumnoofdigit {
    public static void main(String[] args) {
        int no= countno(111223);

        System.out.println(no);
    }
    public static int countno(int n){
        int no=0;
        while(n!=0){
            int t=n%10;
            n=n/10;
            no=no+t;
        }
        return no;
    }
    }


