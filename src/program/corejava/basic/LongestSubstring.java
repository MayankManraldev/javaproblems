package program.corejava.basic;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static String longestSubstringWithoutRepeating(String str) {
        int length = str.length();
        int start = 0;
        String result = new String();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, i);
            if ((i - start) + 1 > result.length()) {
                result = str.substring(start, i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "hakskldnlcvssdsdjf";
        System.out.println("The longest substring without repeating characters is: " + longestSubstringWithoutRepeating(s));
    }
}
