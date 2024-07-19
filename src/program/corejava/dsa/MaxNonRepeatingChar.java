package program.corejava.dsa;


public class MaxNonRepeatingChar {
    public static void main(String[] args) {
        String str = "abcdefghijklabsdbdefghijgj", finalStr = new String();
        for(int i=0;i<str.length();i++){
            char[] chars=new char[128];
            String temp=new String();
            for(int j=i;j<str.length();j++){
                char c = str.charAt(j);
                chars[c]++;
                if(chars[c]>1)
                    break;
                else
                    temp=temp+c;
            }
            if(finalStr.length()<temp.length())
                finalStr=temp;
        }
        System.out.println(finalStr);
    }

}
