package program.java8stream;

import java.util.stream.Collectors;


public class RemoveCharacterFromString {


    public static void main(String[] args) {

        String str = "java interview";

        char ch = 'a';

        String result = removeCharacter(str, ch);

        System.out.println("Original String: " + str);

        System.out.println("String after removing '" + ch + "': " + result);

    }
    public static String removeCharacter(String str, char ch) {

        if (str == null || str.isEmpty()) {
            return str;
        }

        String result = str.chars().filter(c -> c != ch).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());

        return result;

    }

}