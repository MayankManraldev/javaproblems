package program.corejava.basic;

public class CheckVowels {
    public static void main(String[] args) {
        String str1="Meyank";
        String str2="mnbvc";

        System.out.println(checkVowelsPresent(str1));
        System.out.println(checkVowelsPresent(str2));
    }

    private static boolean checkVowelsPresent(String s) {
        String str=s.toLowerCase();
        if(str.length()==0)
            return true;
        String vowels="aeiou";
        for(char c:str.toCharArray()){
            if(vowels.indexOf(c)!=-1)   //return index present in vowels string else return -1
                return true;
       }
       return false;
    }


}
