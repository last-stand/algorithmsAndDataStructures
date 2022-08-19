package hackerRank;

import java.util.HashSet;
import java.util.Set;
/*
* https://www.youtube.com/watch?v=QklRZiNypg0
 */
public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        String s = "abcbesdftacdqwertyuiopasdfghdfg";
        Set<Character> charSet = new HashSet<>();
        int maxLength = 0;
        char repeatedChar = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (charSet.contains(repeatedChar)) {
                charSet.remove(s.charAt(i));
                i++;
                continue;
            }
            for (int j = i; j < s.length(); j++) {
                if (charSet.contains(s.charAt(j))) {
                    repeatedChar = s.charAt(j);
                    break;
                }
                charSet.add(s.charAt(j));
            }
            maxLength = charSet.size() > maxLength ? charSet.size() : maxLength;
            charSet.remove(s.charAt(i));
        }
        System.out.println(maxLength);
    }
}
