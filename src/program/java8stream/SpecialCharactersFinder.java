package program.java8stream;

import java.util.List;

import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class SpecialCharactersFinder {

    public static void main(String[] args) {

        String input = "Hello, World! 123 #Java$Stream";
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);

        List<Character> specialChar = input.chars()
                .mapToObj(c -> (char) c)
                .filter(a -> p.matcher(a.toString()).find())
                .collect(Collectors.toList());

        System.out.println("List of Special Character Present using Regex"+specialChar);

        List<Character> specialCharacters = input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !(Character.isLetterOrDigit(c) || Character.isWhitespace(c)))
                .collect(Collectors.toList());


        System.out.println("List of Special Character Present using java 8 " + specialCharacters);

    }

}