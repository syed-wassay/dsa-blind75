import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
        System.out.println(isAnagramOptimized(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        Map<String, Integer> countOfAlphabetsForS = new HashMap<>(); // hashmap to hold chars in string s as keys and their occurance as values
        Map<String, Integer> countOfAlphabetsForT = new HashMap<>(); // hashmap to hold chars in string t as keys and their occurance as values
        
        if (s.length() != t.length()) { // if the length of both the strings is not equal return false because they should have the same chars and same occurances for those chars but order can be different
            return false;
        }

        for (int i = 0; i < s.length(); i++) { // populate the hashmaps
            if (countOfAlphabetsForS.containsKey(String.valueOf(s.charAt(i)))) {
                countOfAlphabetsForS.replace(String.valueOf(s.charAt(i)), countOfAlphabetsForS.get(String.valueOf(s.charAt(i))) + 1);
            }
            else {
                countOfAlphabetsForS.put(String.valueOf(s.charAt(i)), 1);
            }

            if (countOfAlphabetsForT.containsKey(String.valueOf(t.charAt(i)))) {
                countOfAlphabetsForT.replace(String.valueOf(t.charAt(i)), countOfAlphabetsForT.get(String.valueOf(t.charAt(i))) + 1);
            }
            else {
                countOfAlphabetsForT.put(String.valueOf(t.charAt(i)), 1);
            }
        }

        if (!countOfAlphabetsForS.equals(countOfAlphabetsForT)) { // if hashmap of string s is not equal the hashmap ofmstring t return false
            return false;
        }

        return true; // if the hashmap is same return true
    }

    public static boolean isAnagramOptimized(String s, String t) {
        int[] charFrequency = new int[26]; // since there are 26 alphabets we will create an array of size 26 with all zeroes to represent the frequency of each alphabet

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i ++) {
            /*  
            idea is that if both string s and t have the same alphabets with same frequency so we can increment the value for an alphabet at index i
            even if the alphabets at index i are different for s and t but because they have same alphabets and same freqency the addition and subtraction operations
            will eventually cancel each other out and leave us with an array of all zeroes 
            */
            charFrequency[s.charAt(i) - 'a'] = charFrequency[s.charAt(i) - 'a'] + 1;
            charFrequency[t.charAt(i) - 'a'] = charFrequency[t.charAt(i) - 'a'] - 1;
            // s.charAt(i) - 'a' is to get the ascii value for the char given that the given string only contains small case chars and nothing else
        }

        for (int freqency : charFrequency) {
            if (freqency != 0) {
                return false;
            }
        }

        return true;

    }
}
